package com.sxzhongf.camel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/***
 * todo
 *
 * @Company GeekPlus
 * @Project mscx-shared-platform
 * @Author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
 * @Date 2019/10/23
 */
@Component("myBean")
public class MyBean {
    @Value("${greeting}")
    private String say;

    public String saySomething() {
        return say;
    }
}
