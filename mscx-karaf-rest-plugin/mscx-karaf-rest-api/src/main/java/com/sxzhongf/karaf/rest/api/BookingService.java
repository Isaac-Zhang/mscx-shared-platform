package com.sxzhongf.karaf.rest.api;

import java.util.Collection;

/***
 * todo
 *
 * @Company GeekPlus
 * @Project mscx-shared-platform
 * @Author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
 * @Date 2019/10/24
 */
public interface BookingService {

    Collection<Booking> list();

    Booking get(Long id);

    void add(Booking booking);

    void update(Booking booking);

    void remove(Long id);
}
