package com.sxzhongf.sharedcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
}
