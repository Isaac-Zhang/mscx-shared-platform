package com.sxzhongf.usercenter.service.user;

import com.sxzhongf.usercenter.dao.user.UserMapper;
import com.sxzhongf.usercenter.domain.entity.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2019/7/11
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserMapper userMapper;

    /**
     * 根据用户id获取用户
     *
     * @param id 用户id
     * @return 用户信息
     */
    public User findById(Long id) {
        return this.userMapper.selectByPrimaryKey(id);
    }

}
