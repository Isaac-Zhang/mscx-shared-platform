package com.sxzhongf.distributed.transaction.feignclients;

import com.sxzhongf.distributed.transaction.domain.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
}
