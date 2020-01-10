//package com.sxzhongf.sharedcenter.configuration;
//
//import com.alibaba.nacos.api.exception.NacosException;
//import com.alibaba.nacos.api.naming.NamingService;
//import com.alibaba.nacos.api.naming.pojo.Instance;
//import com.netflix.client.config.IClientConfig;
//import com.netflix.loadbalancer.*;
//import lombok.NoArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
//import com.alibaba.cloud.nacos.ribbon.NacosServer;
//
///**
// * NacosWeightRule4Ribbon for 自定义Ribbon Rule，使用Nacos权重值来 提升命中哪个service的概率
// *
// * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
// * @since 2019/7/13
// */
//@Slf4j
//public class NacosWeightRule4Ribbon extends AbstractLoadBalancerRule {
//
//    @Autowired
//    private NacosDiscoveryProperties nacosDiscoveryProperties;
//
//    @Override
//    public void initWithNiwsConfig(IClientConfig clientConfig) {
//        // 读取配置文件，并初始化 NacosWeightRule4Ribbon
//    }
//
//    @Override
//    public Server choose(Object key) {
//
//        try {
//            // ILoadBalancer 是Ribbon的入口，基本上我们想要的元素都可以在这个对象中找到
//            BaseLoadBalancer loadBalancer = (BaseLoadBalancer) this.getLoadBalancer();
//            log.info("NacosWeightRule4Ribbon lb = {}", loadBalancer);
//            // 想要请求的微服务名称
//            String name = loadBalancer.getName();
//
//            // 实现负载均衡算法
//            // 可得到服务发现相关的API(nacos内部实现)
//            NamingService namingService = nacosDiscoveryProperties.namingServiceInstance();
//
//            // nacos client 通过基于权重的负载均衡算法，选择一个实例
//            Instance instance = namingService.selectOneHealthyInstance(name);
//            log.info("port = {}, weight = {}, instance = {}", instance.getPort(), instance.getWeight(), instance);
//            return new NacosServer(instance);
//        } catch (NacosException e) {
//            log.error("NacosWeightRule4Ribbon {}", e.getMessage());
//        }
//        return null;
//    }
//}
