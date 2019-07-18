package com.sxzhongf.sharedcenter.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.sxzhongf.sharedcenter.domain.dto.user.UserDTO;
import com.sxzhongf.sharedcenter.feignclients.test.ITestBaiduFeignClient;
import com.sxzhongf.sharedcenter.service.test.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2019/7/15
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/q")
    public UserDTO query(UserDTO userDTO) {
        return testService.query(userDTO);
    }

    @Autowired
    private ITestBaiduFeignClient testBaiduFeignClient;

    @GetMapping("baidu")
    public String getBaidu() {
        return this.testBaiduFeignClient.getBaidu();
    }

    @GetMapping("/test-hot")
    @SentinelResource("hot")
    public String testHot(@RequestParam(required = false) String a,
                          @RequestParam(required = false) String b) {
        return a + " " + b;
    }
}
