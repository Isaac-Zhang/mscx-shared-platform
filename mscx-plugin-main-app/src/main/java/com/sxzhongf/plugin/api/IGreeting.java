package com.sxzhongf.plugin.api;

import org.pf4j.ExtensionPoint;

/**
 * IGreeting for providing api interface
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/2/10
 **/
public interface IGreeting extends ExtensionPoint {

    String getGreeting();
}
