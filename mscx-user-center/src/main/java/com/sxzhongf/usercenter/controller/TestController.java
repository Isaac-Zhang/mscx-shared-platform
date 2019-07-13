package com.sxzhongf.usercenter.controller;

import com.sxzhongf.usercenter.dao.user.UserMapper;
import com.sxzhongf.usercenter.domain.entity.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * TestController for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2019/7/11
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired)) //处理IDEA注入警告的方式推荐lombok实现
public class TestController {

    /**
     * @RequiredArgsConstructor(onConstructor = @__(@Autowired))
     * //处理IDEA注入警告的方式推荐lombok实现
     */
    private final UserMapper userMapper;

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

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * [
     * {
     * serviceId: "shared-center",
     * host: "172.16.81.73",
     * port: 8010,
     * secure: false,
     * metadata: {
     * nacos.instanceId: "172.16.81.73#8010#DEFAULT#DEFAULT_GROUP@@shared-center",
     * nacos.weight: "1.0",
     * nacos.cluster: "DEFAULT",
     * nacos.healthy: "true",
     * preserved.register.source: "SPRING_CLOUD"
     * },
     * uri: "http://172.16.81.73:8010",
     * scheme: null,
     * instanceId: null
     * }
     * ]
     */
    @GetMapping("/discovery")
    public List<ServiceInstance> getDiscovertClients() {
        List<ServiceInstance> instances = this.discoveryClient.getInstances("shared-center");
        return instances;
    }

    /**
     * [
     * "user-center",
     * "shared-center"
     * ]
     */
    @GetMapping("/services")
    public List<String> getServices() {
        List<String> services = this.discoveryClient.getServices();
        return services;
    }
}
