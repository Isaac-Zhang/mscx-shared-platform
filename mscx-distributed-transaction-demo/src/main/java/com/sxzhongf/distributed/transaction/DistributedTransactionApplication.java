package com.sxzhongf.distributed.transaction;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class DistributedTransactionApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(DistributedTransactionApplication.class)
                .build()
                .run(args);
    }
}
