package com.sxzhongf.sharedcenter.feignclients.fallback;

import com.sxzhongf.sharedcenter.domain.dto.user.UserDTO;
import com.sxzhongf.sharedcenter.feignclients.IUserCenterFeignClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * UserCenterFeignClientFallback for 为UserCenterFeign Client整合fallback method
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2019/7/18
 */
@Slf4j
@Component
public class UserCenterFeignClientFallbackFactory implements FallbackFactory<IUserCenterFeignClient> {

    @Override
    public IUserCenterFeignClient create(Throwable cause) {
        return new IUserCenterFeignClient() {
            @Override
            public UserDTO findById(Long userId) {
                log.warn("远程调用被限流/降级，{}", cause);
                UserDTO userDTO = new UserDTO();
                userDTO.setWxNickname("默认用户");
                return userDTO;
            }
        };
    }
}
