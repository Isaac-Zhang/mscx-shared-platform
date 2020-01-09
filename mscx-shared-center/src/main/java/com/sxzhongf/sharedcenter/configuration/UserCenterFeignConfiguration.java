package com.sxzhongf.sharedcenter.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * UserCenterFeignConfiguration for 自定义user-center服务请求中，feign的配置信息 {@link @Configuration}
 * 不能添加该注解，否则会和ribbon一样，出现上下文重叠问题，造成配置全局共享 如要添加该注解，需要将该类放在主程序启动扫描不到的包下
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2019/7/15
 */
public class UserCenterFeignConfiguration {

    @Bean
    public Logger.Level level() {
        // 配置feign 日志级别，记录请求和响应的header、body以及元数据
        return Logger.Level.FULL;
    }
}
