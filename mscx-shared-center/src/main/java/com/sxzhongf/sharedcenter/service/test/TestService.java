package com.sxzhongf.sharedcenter.service.test;

import com.sxzhongf.sharedcenter.domain.dto.user.UserDTO;
import com.sxzhongf.sharedcenter.feignclients.test.ITestUserCenterFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TestService for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2019/7/15
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestService {

    //为测试准备
    private final ITestUserCenterFeignClient testUserCenterFeignClient;

    public UserDTO query(UserDTO userDTO) {
        return this.testUserCenterFeignClient.query(userDTO);
    }
}
