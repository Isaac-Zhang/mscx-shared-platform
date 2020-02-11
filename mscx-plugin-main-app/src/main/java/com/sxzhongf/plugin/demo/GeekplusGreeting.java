package com.sxzhongf.plugin.demo;

import com.sxzhongf.plugin.api.IGreeting;

/**
 * GeekplusGreeting for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/2/10
 **/
public class GeekplusGreeting implements IGreeting {
    @Override
    public String getGreeting() {
        return "Geekplus";
    }
}
