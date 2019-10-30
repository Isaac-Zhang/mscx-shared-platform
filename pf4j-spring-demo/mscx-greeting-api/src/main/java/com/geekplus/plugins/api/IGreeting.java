package com.geekplus.plugins.api;


import org.pf4j.ExtensionPoint;

/***
 * 定义插件扩展接口
 *
 * @Company GeekPlus
 * @Project mscx-shared-platform
 * @Author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
 * @Date 2019/10/30
 */
public interface IGreeting extends ExtensionPoint {

    String sayGreeting();
}
