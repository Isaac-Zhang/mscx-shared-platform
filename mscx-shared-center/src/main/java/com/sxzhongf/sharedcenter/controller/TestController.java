package com.sxzhongf.sharedcenter.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.sxzhongf.sharedcenter.domain.dto.user.UserDTO;
import com.sxzhongf.sharedcenter.feignclients.test.ITestBaiduFeignClient;
import com.sxzhongf.sharedcenter.service.test.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired(required = false)
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

    @GetMapping("/test-code-flow-rule")
    public String testCodeQPSRule() {
        initFlowQpsRule("/share/1");
        return "success";
    }

    /**
     * 代码添加流控规则 -> QPS
     *
     * @param resourceName 需要限制的资源名称
     */
    private void initFlowQpsRule(String resourceName) {
        List<FlowRule> ruleList = new ArrayList<>();
        FlowRule rule = new FlowRule(resourceName);
        // set limit qps to 20
        rule.setCount(20);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setLimitApp("default");
        ruleList.add(rule);
        FlowRuleManager.loadRules(ruleList);
    }
}
