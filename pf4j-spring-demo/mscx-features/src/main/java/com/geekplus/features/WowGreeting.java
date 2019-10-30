package com.geekplus.features;

import com.geekplus.plugins.api.IGreeting;
import org.pf4j.Extension;

/***
 * todo
 *
 * @Company GeekPlus
 * @Project mscx-shared-platform
 * @Author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
 * @Date 2019/10/30
 */
@Extension
public class WowGreeting implements IGreeting {

    @Override
    public String sayGreeting() {
        return String.valueOf("wow, come on!");
    }
}
