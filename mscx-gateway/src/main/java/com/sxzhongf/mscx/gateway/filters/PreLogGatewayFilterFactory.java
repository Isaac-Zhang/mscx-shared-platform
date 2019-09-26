package com.sxzhongf.mscx.gateway.filters;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

/***
 * 自定义打印日志过滤器工厂
 *
 * @Company GeekPlus
 * @Project mscx-shared-platform
 * @Author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
 * @Date 2019/9/26
 */
@Slf4j
@Component
public class PreLogGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {

    @Override
    public GatewayFilter apply(NameValueConfig config) {

        return ((exchange, chain) -> {
            log.info("Request entering...");
            val name = config.getName();
            val value = config.getValue();
            log.info("Get custom key={},value={}", name, value);
            ServerHttpRequest requestModified = exchange.getRequest()
                .mutate()
                // 修改request
                //...
                .build();
            ServerWebExchange serverWebExchange = exchange.mutate()
                .request(requestModified).build();
            return chain.filter(serverWebExchange);
        });
    }
}
