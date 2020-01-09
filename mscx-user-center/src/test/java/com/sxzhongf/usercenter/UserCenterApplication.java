package com.sxzhongf.usercenter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * UserCenterApplication for test
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2019/7/10
 */
@SpringBootApplication
@Data
@Slf4j
public class UserCenterApplication {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserCenterApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(UserCenterApplication.class, args);
    }
}
