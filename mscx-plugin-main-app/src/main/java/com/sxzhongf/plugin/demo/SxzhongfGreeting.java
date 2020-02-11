package com.sxzhongf.plugin.demo;

import com.sxzhongf.plugin.api.IGreeting;

/**
 * SxzhongfGreeting for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/2/10
 **/
public class SxzhongfGreeting implements IGreeting {
    @Override
    public String getGreeting() {
        return "Sxzhongf";
    }
}
