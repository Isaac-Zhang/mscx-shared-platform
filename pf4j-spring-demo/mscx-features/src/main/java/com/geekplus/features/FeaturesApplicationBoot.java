package com.geekplus.features;

import com.geekplus.plugins.api.IGreeting;
import java.io.File;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.pf4j.DefaultPluginManager;
import org.pf4j.PluginManager;
import org.pf4j.spring.SpringPluginManager;
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
public class FeaturesApplicationBoot {

    public static void main(String[] args) {
        // print logo
        printLogo();

        // retrieves the spring application context
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        // retrieves automatically the extensions for the Greeting.class extension point
        Greetings greetings = applicationContext.getBean(Greetings.class);
        greetings.printGreetings();

        // stop plugins
//        PluginManager pluginManager = applicationContext.getBean(PluginManager.class);
//        PluginManager pluginManager =  new SpringPluginManager(new File("C:/work/plugins").toPath());
        PluginManager pluginManager =  new DefaultPluginManager(new File("/mscx-features/plugins").toPath());

//        // start and load all plugins of application
//        pluginManager.loadPlugins();
//        pluginManager.startPlugins();
//        // retrieves manually the extensions for the Greeting.class extension point
//        List<IGreeting> greetings = pluginManager.getExtensions(IGreeting.class);
//        System.out.println("greetings.size() = " + greetings.size());

        pluginManager.stopPlugins();
    }

    private static void printLogo() {
        System.out.println(StringUtils.repeat("#", 40));
        System.out.println(StringUtils.center("PF4J-SPRING", 40));
        System.out.println(StringUtils.repeat("#", 40));
    }
}
