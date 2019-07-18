package com.sxzhongf.sharedcenter.sentinal;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;

/**
 * SharedCenterBlockHandler for 处理 {@link RedisProperties.Sentinel} fallback 类
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2019/7/18
 */
@Slf4j
public class SharedCenterBlockHandler {

    /**
     * testSentinelResource BlockException method
     */
    public static String blockException(String a, BlockException e) {
        log.error("限流了,{}", e);
        return "blockHandler 对应《限流规则》";
    }
}
