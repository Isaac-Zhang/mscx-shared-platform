package com.sxzhongf.usercenter.controller;

import com.sxzhongf.usercenter.dao.user.UserMapper;
import com.sxzhongf.usercenter.domain.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * TestController for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2019/7/11
 */
@RestController
public class TestController {
    private final UserMapper userMapper;

    @Autowired
    public TestController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("/insert")
    public User testInsertUser() {
        User user = new User();
        user.setAvatarUrl("aaa");
        user.setBonus(100);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        // insert() 会插入数据表中所有的值
        // userMapper.insert(user);
        // insertSelective()插入你填写的字段，为null的不做处理
        userMapper.insertSelective(user);
        return user;
    }

}
