package com.sxzhongf.distributed.transaction;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan(basePackages = "com.sxzhongf")
public class DistributedTransactionApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(DistributedTransactionApplication.class)
                .build()
                .run(args);
    }
}
