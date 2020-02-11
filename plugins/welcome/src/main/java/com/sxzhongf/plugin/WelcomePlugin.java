package com.sxzhongf.plugin;

import com.sxzhongf.plugin.api.IGreeting;
import org.apache.commons.lang.StringUtils;
import org.pf4j.Extension;
import org.pf4j.Plugin;
import org.pf4j.PluginWrapper;
import org.pf4j.RuntimeMode;

/**
 * WelcomePlugin for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/2/11
 **/
public class WelcomePlugin extends Plugin {
    /**
     * Constructor to be used by plugin manager for plugin instantiation.
     * Your plugins have to provide constructor with this exact signature to
     * be successfully loaded by manager.
     *
     * @param wrapper
     */
    public WelcomePlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public void start() {
        System.out.println("WelcomePlugin.start()");
        // for testing the development mode
        if (RuntimeMode.DEVELOPMENT.equals(wrapper.getRuntimeMode())) {
            System.out.println(StringUtils.upperCase("WelcomePlugin"));
        }
    }

    @Override
    public void stop() {
        System.out.println("WelcomePlugin.stop()");
    }

    @Extension
    public static class WelcomeGreeting implements IGreeting {

        @Override
        public String getGreeting() {
            return "Welcome";
        }

    }
}
