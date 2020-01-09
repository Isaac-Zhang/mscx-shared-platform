package com.sxzhongf.sharedcenter.feignclients.test;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ITestBaiduFeignClient for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2019/7/16
 */
@FeignClient(name = "xxxxx", url = "http://www.baidu.com")
public interface ITestBaiduFeignClient {

    @GetMapping("")
    public String getBaidu();
}
