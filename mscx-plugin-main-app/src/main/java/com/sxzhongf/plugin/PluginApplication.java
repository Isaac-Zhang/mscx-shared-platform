package com.sxzhongf.plugin;

import com.sxzhongf.plugin.api.IGreeting;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.pf4j.DefaultExtensionFinder;
import org.pf4j.DefaultPluginManager;
import org.pf4j.ExtensionFinder;
import org.pf4j.PluginManager;

import java.util.List;
import java.util.Set;

/**
 * PluginApplication for boot class
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/2/10
 **/
//@Slf4j
public class PluginApplication {

    private static final Logger log = Logger.getLogger(PluginApplication.class);

    public static void main(String[] args) {

        printLogo();

        // create plugin manager
        final PluginManager pluginManager = new DefaultPluginManager() {
            protected ExtensionFinder createExtensionFinder() {
                DefaultExtensionFinder extensionFinder = (DefaultExtensionFinder) super.createExtensionFinder();
                //to activate default service 'SxzhongfGreeting' extension
                extensionFinder.addServiceProviderExtensionFinder();
                return extensionFinder;
            }
        };

        // load the plugins
        pluginManager.loadPlugins();
        // enable a disabled plugin
        // pluginManager.enablePlugin("hello-plugin");

        // start/active/resolved the plugins
        pluginManager.startPlugins();

        //retrieves the extensions for greeting extension point
        List<IGreeting> extensions = pluginManager.getExtensions(IGreeting.class);

//        log.info("Found {} extensions for extension point {}", extensions.size(), IGreeting.class.getName());
        log.info(String.format("Found %s extensions for extension point %s", extensions.size(), IGreeting.class.getName()));
        for (IGreeting gr : extensions) {
            log.warn(">>> " + gr.getGreeting());
        }

        // print extensions from classpath (non plugin)
        log.info(StringUtils.repeat("-", 50));
        log.info("Extensions added by classpath:");
        Set<String> extensionClassNames = pluginManager.getExtensionClassNames(null);
        for (String extension : extensionClassNames) {
            System.out.println("   " + extension);
        }

        log.info(StringUtils.repeat("-", 50));
        log.info("Extension classes by classpath:");
        List<Class<? extends IGreeting>> extensionClasses = pluginManager.getExtensionClasses(IGreeting.class);
        for (Class<? extends IGreeting> gr : extensionClasses) {
            log.warn(String.format("   Class:%s", gr));
        }


    }

    private static void printLogo() {
        System.out.println(StringUtils.repeat("#", 40));
        System.out.println(StringUtils.center("GEEKPLUS-PLUGIN-DEMO", 40));
        System.out.println(StringUtils.repeat("#", 40));
    }
}
