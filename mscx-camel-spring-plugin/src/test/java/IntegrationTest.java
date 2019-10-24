import org.junit.Assert;

/***
 * todo
 *
 * @Company GeekPlus
 * @Project mscx-shared-platform
 * @Author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
 * @Date 2019/10/23
 */
import org.apache.camel.spring.Main;
import org.junit.Test;

public class IntegrationTest extends Assert {

    @Test
    public void testCamelRulesDeployCorrectlyInSpring() throws Exception {
        // let's boot up the Spring application context for 2 seconds to check that it works OK
        Main.main("-duration", "2s", "-o", "target/site/cameldoc");
    }
}

