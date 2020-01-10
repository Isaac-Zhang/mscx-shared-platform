package com.sxzhongf.distributed.transaction.controller;

import com.sxzhongf.distributed.transaction.domain.dto.UserDTO;
import com.sxzhongf.distributed.transaction.service.DistributedDemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/distributed")
public class DistributedDemoController {

    private final DistributedDemoService distributedDemoService;

    @GetMapping("/get")
    public UserDTO find(@RequestParam Long uid){
        val user = this.distributedDemoService.getById(uid);
        log.info("DistributedDemoController#find 查询到的对象："+user);
        return user;
    }
}
