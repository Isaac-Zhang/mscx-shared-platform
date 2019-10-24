package com.sxzhongf.camel.spring;

import org.apache.camel.main.Main;
import org.apache.camel.builder.RouteBuilder;

/***
 * todo
 *
 * @Company GeekPlus
 * @Project mscx-shared-platform
 * @Author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
 * @Date 2019/10/23
 */
public class CamelRouteBuilder extends RouteBuilder {

    /**
     * Allow this route to be run as an application
     */
    public static void main(String[] args) throws Exception {
        new Main().run(args);
    }

    @Override
    public void configure() {
        // populate the message queue with some messages
        from("file:src/data?noop=true").
            to("jms:test.MyQueue");

        from("jms:test.MyQueue").
            to("file://target/test");

        // set up a listener on the file component
        from("file://target/test?noop=true").
            bean(new SomeBean());
    }

    public static class SomeBean {

        public void someMethod(String body) {
            System.out.println("Received: " + body);
        }
    }
}
