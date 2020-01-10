package com.sxzhongf.distributed.transaction.feignclients;

import com.sxzhongf.distributed.transaction.domain.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "user-center")
public interface IUserCenterFeignClient {

    @PostMapping("/users/create")
    void createUser(UserDTO userDTO);
}
