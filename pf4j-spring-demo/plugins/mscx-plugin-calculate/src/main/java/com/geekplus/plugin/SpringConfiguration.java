package com.geekplus.plugin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * todo
 *
 * @Company GeekPlus
 * @Project mscx-shared-platform
 * @Author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
 * @Date 2019/10/30
 */
@Configuration
public class SpringConfiguration {
    @Bean
    public ICalculate calculate() {
        return new CalculateImpl();
    }

}
