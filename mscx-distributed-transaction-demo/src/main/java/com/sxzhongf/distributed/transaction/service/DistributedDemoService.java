package com.sxzhongf.distributed.transaction.service;

import com.sxzhongf.distributed.transaction.domain.dto.UserDTO;
import com.sxzhongf.distributed.transaction.feignclients.ISharedCenterFeignClient;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class DistributedDemoService {

    private final ISharedCenterFeignClient sharedCenterFeignClient;

    @GlobalTransactional(name = "dtd-get-user", rollbackFor = Exception.class)
    public UserDTO getById(Long uid) {
        log.info("分布式事务开始---->,{}" + uid);
        return this.sharedCenterFeignClient.findById(uid);
    }
}
