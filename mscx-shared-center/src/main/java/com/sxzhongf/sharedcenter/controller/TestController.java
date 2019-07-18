package com.sxzhongf.sharedcenter.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.context.ContextUtil;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.sxzhongf.sharedcenter.domain.dto.user.UserDTO;
import com.sxzhongf.sharedcenter.feignclients.test.ITestBaiduFeignClient;
import com.sxzhongf.sharedcenter.sentinal.SharedCenterBlockHandler;
import com.sxzhongf.sharedcenter.service.test.TestService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
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

    @GetMapping("/test-sentinel-api")
    public String testSentinelAPI(@RequestParam(required = false) String a) {

        String resourceName = "test-sentinel-api";

        ContextUtil.enter(resourceName, "user-center-service");
        // 定义一个sentinel 保护的资源，名称是test-sentinel-api
        Entry entry = null;
        try {

            entry = SphU.entry(resourceName);
            // ...被保护的业务逻辑处理
            if (StringUtils.isEmpty(a)) {
                // Sentinel 默认只会统计BlockException & BlockException的子类，如果想统计其他异常信息，添加Tracer
                throw new IllegalArgumentException("A is not empty.");
            }
            return a;
            // block Exception: 如果被保护的资源被限流或者降级了，就会抛异常出去
        } catch (BlockException e) {
            log.error("限流，或者降级了,{}", e);
            return "限流，或者降级了";
        } catch (IllegalArgumentException argEx) {
            // 统计当前异常发生次数 / 占比
            Tracer.trace(argEx);
            return "非法参数信息";
        } finally {
            if (entry != null) {
                entry.exit();
            }
            ContextUtil.exit();
        }

    }

    @GetMapping("/test-sentinel-resource")
    @SentinelResource(
            value = "test-sentinel-api",
            blockHandler = "blockException",
            blockHandlerClass = SharedCenterBlockHandler.class,
            fallback= "fallback")
    public String testSentinelResource(@RequestParam(required = false) String a) {
        // ...被保护的业务逻辑处理
        if (StringUtils.isEmpty(a)) {
            // Sentinel 默认只会统计BlockException & BlockException的子类，如果想统计其他异常信息，添加Tracer
            throw new IllegalArgumentException("A is not empty.");
        }
        return a;
    }


    /**
     * testSentinelResource fallback method
     * {@link SentinelResource} #fallback 在< 1.6的版本中，不能补货BlockException
     */
    public String fallback(String a) {
        return "fallback 对应《降级规则》";
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
