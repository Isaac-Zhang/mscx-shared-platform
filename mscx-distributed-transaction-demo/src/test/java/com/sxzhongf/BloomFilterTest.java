package com.sxzhongf;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * BloomFilterTest for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/1/16
 **/
public class BloomFilterTest {

    @Test
    public void testBloomFilter() {
        // 布隆过滤器的误判率受3个因素影响
        // 1. 期望的数量和实际数量差距过大，会造成误判率大幅提高
        // 2. 实际的最佳hash函数数量
        // 3. 期望的误判比率
        BloomFilter bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.forName("utf-8")),
                100000
//                10000
//                50000
//                80000
                //,0.0001
        );

        for (int i = 0; i < 100000; i++) {
            bloomFilter.put(String.valueOf(i));
        }

        AtomicInteger counter = new AtomicInteger();
        for (int i = 0; i < 10000; i++) {
            boolean exist = bloomFilter.mightContain("isaac" + i);
            if (exist)
                counter.incrementAndGet();
        }

        System.out.printf("错误总数：" + counter.get());

    }
}
