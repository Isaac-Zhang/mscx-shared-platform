package com.sxzhongf.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/***
 * todo
 *
 * @Company GeekPlus
 * @Project mscx-shared-platform
 * @Author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
 * @Date 2019/10/23
 */
@Component
public class MyCamelRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer:hello?period={{timer.period}}").routeId("hello").routeGroup("hello-group")
            .transform().method("myBean", "saySomething")
            .filter(simple("${body} contains 'foo'"))
            .to("log:foo")
            .end()
            .to("stream:out");
    }
}
