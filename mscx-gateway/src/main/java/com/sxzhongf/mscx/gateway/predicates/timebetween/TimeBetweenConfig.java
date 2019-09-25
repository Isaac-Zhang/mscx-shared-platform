package com.sxzhongf.mscx.gateway.predicates.timebetween;

import java.time.LocalTime;
import javax.validation.constraints.NotNull;
import lombok.Data;

/***
 * timebetween 配置类
 *
 * @Company GeekPlus
 * @Project mscx-shared-platform
 * @Author <a href="mailto:zhangpan@geekplus.com.cn">Isaac.Zhang | 若初</a>
 * @Date 2019/9/25
 */
@Data
public class TimeBetweenConfig {

    private LocalTime start;
    private LocalTime end;

}
