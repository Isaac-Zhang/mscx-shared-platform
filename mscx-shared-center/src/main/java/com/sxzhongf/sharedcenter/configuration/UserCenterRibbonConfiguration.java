package com.sxzhongf.sharedcenter.configuration;

import com.sxzhongf.ribbonconfig.RibbonConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;

/**
 * UserCenterRibbonConfiguration for 自定义实现User-center service ribbon client
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2019/7/13
 */
@Configuration
//@RibbonClient(name = "user-center", configuration = RibbonConfiguration.class) //作用域为 user-center
@RibbonClients(defaultConfiguration = RibbonConfiguration.class) //作用域为全局
//注释掉上面2行代码，测试使用 配置文件的方式来配置ribbon规则
public class UserCenterRibbonConfiguration {

}
