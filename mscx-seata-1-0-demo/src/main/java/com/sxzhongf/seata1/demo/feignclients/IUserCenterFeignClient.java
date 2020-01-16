package com.sxzhongf.seata1.demo.feignclients;

import com.sxzhongf.seata1.demo.domain.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "user-center")
public interface IUserCenterFeignClient {

    @PostMapping("/users/create")
    void createUser(UserDTO userDTO);
}
