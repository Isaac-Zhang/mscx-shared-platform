package com.sxzhongf.mscx.gateway.predicates.timebetween;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import lombok.val;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

/***
 * 实现规定时间内允许访问[断言]
 * 继承自 : {@link AbstractRoutePredicateFactory}
 *
 * @Company GeekPlus
 * @Project mscx-shared-platform
 * @Author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
 * @Date 2019/9/25
 */
@Component
public class TimeBetweenRoutePredicateFactory extends AbstractRoutePredicateFactory<TimeBetweenConfig> {

    public static final String START_KEY = "start";
    public static final String END_KEY = "end";

    public TimeBetweenRoutePredicateFactory() {
        super(TimeBetweenConfig.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(TimeBetweenConfig config) {
        LocalTime start = config.getStart();
        LocalTime end = config.getEnd();
        return exchange -> {
            LocalTime now = LocalTime.now();
            return now.isAfter(start) && now.isBefore(end);
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(START_KEY, END_KEY);
    }

    public static void main(String[] args) {
        val dateTimeFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        System.out.println(dateTimeFormatter.format(LocalTime.now()));

    }
}
