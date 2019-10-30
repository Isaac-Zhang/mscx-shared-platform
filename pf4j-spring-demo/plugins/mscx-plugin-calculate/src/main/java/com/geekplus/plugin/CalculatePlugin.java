package com.geekplus.plugin;

import com.geekplus.plugins.api.IGreeting;
import org.pf4j.Extension;
import org.pf4j.PluginWrapper;
import org.pf4j.spring.SpringPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/***
 * todo
 *
 * @Company GeekPlus
 * @Project mscx-shared-platform
 * @Author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
 * @Date 2019/10/30
 */
public class CalculatePlugin extends SpringPlugin {

    public CalculatePlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public void start() {
        System.out.println("CalculatePlugin.start()");
    }

    @Override
    public void stop() {
        System.out.println("CalculatePlugin.stop()");
        super.stop(); // to close applicationContext
    }

    @Override
    protected ApplicationContext createApplicationContext() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.setClassLoader(getWrapper().getPluginClassLoader());
        applicationContext.register(SpringConfiguration.class);
        applicationContext.refresh();

        return applicationContext;
    }

    @Extension(ordinal=1)
    public static class HelloGreeting implements IGreeting {

        @Autowired
        private ICalculate calculate;

        @Override
        public String sayGreeting() {
            return calculate.calculate();
        }

    }
}
