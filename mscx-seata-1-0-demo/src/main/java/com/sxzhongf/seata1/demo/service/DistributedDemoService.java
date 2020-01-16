package com.sxzhongf.seata1.demo.service;

import com.sxzhongf.seata1.demo.domain.dto.UserDTO;
import com.sxzhongf.seata1.demo.domain.entity.order.PocOrder;
import com.sxzhongf.seata1.demo.feignclients.ISharedCenterFeignClient;
import com.sxzhongf.seata1.demo.feignclients.IUserCenterFeignClient;
import com.sxzhongf.seata1.demo.order.PocOrderMapper;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class DistributedDemoService {

    private final ISharedCenterFeignClient sharedCenterFeignClient;
    private final IUserCenterFeignClient userCenterFeignClient;
    private final PocOrderMapper pocOrderMapper;

    @GlobalTransactional(name = "dtd-get-user", rollbackFor = Exception.class)
    public UserDTO getById(Long uid) {
        log.info("分布式事务开始---->,{}" + uid);
        return this.sharedCenterFeignClient.findById(uid);
    }

    @GlobalTransactional(name = "dtd-create", rollbackFor = Exception.class)
//    @GlobalLock 读已提交的数据，并且本身不需要事务管理的时候，可以使用这个注解来减少rpc网络调用，提高性能
    public PocOrder create(PocOrder order) {
        log.info("------->创建订单分布式事务开始:{}", order);
        this.pocOrderMapper.insertSelective(order);
        val user = UserDTO.builder()
                .wxId("wxId-" + ThreadLocalRandom.current())
                .wxNickname("NickName-" + ThreadLocalRandom.current())
                .roles("admin")
                .bonus(1)
                .build();
        log.info("------->插入用户:{}", user);
        this.userCenterFeignClient.createUser(
                user
        );

        log.info("------->插入内容:读书啊啊啊");
        this.sharedCenterFeignClient.create("读书啊啊啊");
        log.info("------->创建订单结束");
        return order;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public PocOrder createLocalTransaction(PocOrder order) {
        log.info("------->创建订单本地事务开始:{}", order);
        this.pocOrderMapper.insertSelective(order);
        return order;
    }
}
