package com.sxzhongf.spring.boot.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@EnableAdminServer
public class AdminUIApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(AdminUIApplication.class)
                .run(args);
    }
}
