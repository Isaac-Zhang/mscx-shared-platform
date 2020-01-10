package com.sxzhongf.distributed.transaction.controller;

import com.sxzhongf.distributed.transaction.domain.dto.UserDTO;
import com.sxzhongf.distributed.transaction.domain.entity.order.PocOrder;
import com.sxzhongf.distributed.transaction.service.DistributedDemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/distributed")
public class DistributedDemoController {

    private final DistributedDemoService distributedDemoService;

    @GetMapping("/get")
    public UserDTO find(@RequestParam Long uid) {
        val user = this.distributedDemoService.getById(uid);
        log.info("DistributedDemoController#find 查询到的对象：" + user);
        return user;
    }

    @PostMapping("/create")
    public String create(@RequestBody PocOrder order) {
        log.info("分布式事务测试---创建order:{}", order);
        distributedDemoService.create(order);
        return "";
    }

    @PostMapping("/createLocal")
    public String createLocal(@RequestBody PocOrder order) {
        log.info("分布式事务测试---创建order:{}", order);
        distributedDemoService.createLocalTransaction(order);
        return "";
    }
}
