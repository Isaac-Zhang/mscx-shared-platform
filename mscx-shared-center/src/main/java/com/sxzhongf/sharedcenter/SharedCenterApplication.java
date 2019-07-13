package com.sxzhongf.sharedcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * SharedCenterApplication for 内容共享微服务启动类
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2019/7/11
 */
@MapperScan("com.sxzhongf")
@SpringBootApplication
public class SharedCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(SharedCenterApplication.class, args);
    }

    /**
     * 在Spring 容器中，创建一个对象，类型是{@link RestTemplate}
     * 名称/ID 为 restTemplate
     * <bean id ="restTemplate" class="XXX.RestTemplate" />
     * {@link LoadBalanced} 为RestTemplate整合Ribbon调用
     *
     * @return restTemplate
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
