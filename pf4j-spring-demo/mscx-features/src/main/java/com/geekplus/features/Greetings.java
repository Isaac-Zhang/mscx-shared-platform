package com.geekplus.features;

import com.geekplus.plugins.api.IGreeting;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/***
 * todo
 *
 * @Company GeekPlus
 * @Project mscx-shared-platform
 * @Author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
 * @Date 2019/10/30
 */
//@Component
public class Greetings {

    @Autowired
    private List<IGreeting> greetingList;

    public void printGreetings() {
        System.out.println(String.format("Found %d extensions for extension point '%s'", greetingList.size(),
            IGreeting.class.getName()));
        for (IGreeting greeting : greetingList) {
            System.out.println(">>> " + greeting.sayGreeting());
        }
    }

}
