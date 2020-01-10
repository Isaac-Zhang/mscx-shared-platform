//package com.sxzhongf.sharedcenter.configuration;
//
//import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
//import com.alibaba.cloud.nacos.ribbon.NacosServer;
//import com.alibaba.nacos.api.exception.NacosException;
//import com.alibaba.nacos.api.naming.NamingService;
//import com.alibaba.nacos.api.naming.pojo.Instance;
//import com.alibaba.nacos.client.naming.core.Balancer;
//import com.netflix.client.config.IClientConfig;
//import com.netflix.loadbalancer.AbstractLoadBalancerRule;
//import com.netflix.loadbalancer.BaseLoadBalancer;
//import com.netflix.loadbalancer.Server;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.CollectionUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
///**
// * NacosSameClusterWeightRule for TODO
// *
// * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
// * @since 2019/7/13
// */
//@Slf4j
//public class NacosSameClusterWeightRule extends AbstractLoadBalancerRule {
//
//    @Autowired
//    private NacosDiscoveryProperties nacosDiscoveryProperties;
//
//    @Override
//    public void initWithNiwsConfig(IClientConfig clientConfig) {
//
//    }
//
//    /**
//     * <ul>
//     * <li>1. 找到指定服务的所有实例 A</li>
//     * <li>2. 过滤出相同集群下的所有实例 B</li>
//     * <li>3. 如果B为空，则使用 A</li>
//     * <li>4. 基于权重的负载均衡算法，返回一个实例 A</li>
//     * </ul>
//     */
//    @Override
//    public Server choose(Object key) {
//
//        try {
//            // 获取到配置文件中的集群名称 BJ
//            String clusterName = nacosDiscoveryProperties.getClusterName();
//
//            BaseLoadBalancer loadBalancer = (BaseLoadBalancer) this.getLoadBalancer();
//            String serviceName = loadBalancer.getName();
//
//            //获取服务发现的相关API
//            NamingService namingService = nacosDiscoveryProperties.namingServiceInstance();
//            // 1. 找到指定服务的所有实例 A
//            List<Instance> instances = namingService.selectInstances(serviceName, true);
//            // 2. 过滤出相同集群下的所有实例 B
//            List<Instance> sameClusterInstances = instances.stream()
////                                                           .filter(instance -> "v1".equals(instance.getMetadata().get("version")))
//                .filter(instance -> Objects.equals(instance.getClusterName(), clusterName))
//                .collect(Collectors.toList());
//            // 3. 如果B为空，则使用 A
//            List<Instance> instancesChoosen = new ArrayList<>();
//            if (CollectionUtils.isEmpty(sameClusterInstances)) {
//                instancesChoosen = instances;
//                log.warn("发生跨集群调用，name = {},clusterName = {}", serviceName, clusterName);
//            } else {
//                instancesChoosen = sameClusterInstances;
//            }
//
//            // 4. 基于权重的负载均衡算法，返回一个实例 A
//            Instance instance = ExtendBalancer.getHostByRandomWeightOverride(instancesChoosen);
//            log.info("choose instance is : port = {}, instance = {}", instance.getPort(), instance);
//
//            return new NacosServer(instance);
//        } catch (NacosException e) {
//            e.printStackTrace();
//            log.error(e.getErrMsg());
//        }
//        return null;
//    }
//}
//
//class ExtendBalancer extends Balancer {
//
//    public static Instance getHostByRandomWeightOverride(List<Instance> hosts) {
//        return getHostByRandomWeight(hosts);
//    }
//}
