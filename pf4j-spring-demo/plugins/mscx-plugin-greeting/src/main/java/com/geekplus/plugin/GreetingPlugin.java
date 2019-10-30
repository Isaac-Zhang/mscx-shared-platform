package com.geekplus.plugin;

import com.geekplus.plugins.api.IGreeting;
import org.apache.commons.lang.StringUtils;
import org.pf4j.Extension;
import org.pf4j.Plugin;
import org.pf4j.PluginWrapper;
import org.pf4j.RuntimeMode;

/***
 * 实现插件功能
 *
 * @Company GeekPlus
 * @Project mscx-shared-platform
 * @Author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
 * @Date 2019/10/30
 */
public class GreetingPlugin extends Plugin {

    /**
     * Constructor to be used by plugin manager for plugin instantiation. Your plugins have to provide constructor with
     * this exact signature to be successfully loaded by manager.
     *
     * @param wrapper
     */
    public GreetingPlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public void start() {
        System.out.println("GreetingPlugin.start()");
        // for testing the development mode
        if (RuntimeMode.DEVELOPMENT.equals(wrapper.getRuntimeMode())) {
            System.out.println(StringUtils.upperCase("GreetingPlugin"));
        }
    }

    @Override
    public void stop() {
        System.out.println("GreetingPlugin.stop()");
    }

    @Extension
    public static class WelcomeGreeting implements IGreeting {

        @Override
        public String sayGreeting() {
            return "Hello,Geekplus!";
        }

    }

}
