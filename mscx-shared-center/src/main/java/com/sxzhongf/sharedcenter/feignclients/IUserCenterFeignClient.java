package com.sxzhongf.sharedcenter.feignclients;

import com.sxzhongf.sharedcenter.domain.dto.user.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * IUserCenterFeignClient for 定义 user-center feign client
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2019/7/15
 */
@FeignClient(name = "user-center")
public interface IUserCenterFeignClient {

    /**
     * Feign client 会将请求转换为
     * http://user-center/users/{userId}
     *
     * @param userId 用户id
     * @return 返回用户对象
     */
    @GetMapping(path = "/users/{userId}")
    public UserDTO findById(@PathVariable Long userId);
}
