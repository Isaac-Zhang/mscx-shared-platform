package com.sxzhongf.sharedcenter.feignclients.fallback;

import com.sxzhongf.sharedcenter.domain.dto.user.UserDTO;
import com.sxzhongf.sharedcenter.feignclients.IUserCenterFeignClient;
import org.springframework.stereotype.Component;

/**
 * UserCenterFeignClientFallback for 为UserCenterFeign Client整合fallback method
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2019/7/18
 */
@Component
public class UserCenterFeignClientFallback implements IUserCenterFeignClient {
    @Override
    public UserDTO findById(Long userId) {
        UserDTO userDTO = new UserDTO();
        userDTO.setWxNickname("默认用户");
        return userDTO;
    }
}
