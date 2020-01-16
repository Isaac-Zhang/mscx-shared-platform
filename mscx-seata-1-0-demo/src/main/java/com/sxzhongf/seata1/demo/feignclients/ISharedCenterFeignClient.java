package com.sxzhongf.seata1.demo.feignclients;

import com.sxzhongf.seata1.demo.domain.dto.ShareDTO;
import com.sxzhongf.seata1.demo.domain.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "shared-center")
public interface ISharedCenterFeignClient {
    /**
     * Feign client 会将请求转换为 http://shared-center/share/{userId}
     *
     * @param userId 用户id
     * @return 返回用户对象
     */
    @GetMapping(path = "/share/{userId}")
    UserDTO findById(@PathVariable Long userId);

    @PostMapping(path = "/share/create")
    ShareDTO create(@RequestParam String title);
}
