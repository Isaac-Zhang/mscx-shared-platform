package com.sxzhongf.sharedcenter.feignclients.test;

import com.sxzhongf.sharedcenter.configuration.UserCenterFeignConfiguration;
import com.sxzhongf.sharedcenter.domain.dto.user.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ITestUserCenterFeignClient for 专为测试所准备
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2019/7/15
 */
@FeignClient(name = "user-center")
public interface ITestUserCenterFeignClient {

    @GetMapping("/users/q")
    public UserDTO query(@SpringQueryMap UserDTO userDTO);
}
