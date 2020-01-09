package com.sxzhongf.sharedcenter.configuration;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.DynamicServerListLoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * NacosFinalRule for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2019/7/13
 */
@Slf4j
public class NacosFinalRule extends AbstractLoadBalancerRule {

    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }

    @Override
    public Server choose(Object key) {
        // 负载均衡规则：优先选择同集群下，符合metadata的实例
        // 如果没有，就选择所有集群下，符合metadata的实例

        // 1. 查询所有实例 A
        // 2. 筛选元数据匹配的实例 B
        // 3. 筛选出同cluster下元数据匹配的实例 C
        // 4. 如果C为空，就用B
        // 5. 随机选择实例

        try {
            String clusterName = this.nacosDiscoveryProperties.getClusterName();
            String targetVersion = this.nacosDiscoveryProperties.getMetadata().get("target-version");
            DynamicServerListLoadBalancer loadBalancer = (DynamicServerListLoadBalancer) this.getLoadBalancer();

            String serviceName = loadBalancer.getName();
            NamingService namingService = this.nacosDiscoveryProperties.namingServiceInstance();
            // 获取所有可用实例
            List<Instance> instances = namingService.selectInstances(serviceName, true);
            List<Instance> metadataVersionMatchInstances = instances;
            if (StringUtils.isNoneBlank(targetVersion)) {
                metadataVersionMatchInstances = instances.stream()
                    .filter(instance -> Objects.equals(targetVersion, instance.getMetadata().get("version")))
                    .collect(Collectors.toList());
                if (CollectionUtils.isEmpty(metadataVersionMatchInstances)) {
                    log.warn("未找到元数据匹配的目标实例！请检查配置。targetVersion = {}, instance = {}", targetVersion, instances);
                    return null;
                }
            }

            List<Instance> clusterMetadataMatchInstances = metadataVersionMatchInstances;
            // 如果配置了集群名称，需要筛选同集群下元数据匹配的实例
            if (StringUtils.isNoneBlank(clusterName)) {
                clusterMetadataMatchInstances =
                    metadataVersionMatchInstances.stream()
                        .filter(instance -> Objects.equals(clusterName, instance.getClusterName()))
                        .collect(Collectors.toList());
                if (CollectionUtils.isEmpty(clusterMetadataMatchInstances)) {
                    log.warn("发生跨集群调用，name = {},clusterName = {}", serviceName, clusterName);
                    clusterMetadataMatchInstances = metadataVersionMatchInstances;
                }
            }

            Instance instance = ExtendBalancer.getHostByRandomWeightOverride(clusterMetadataMatchInstances);
            return new NacosServer(instance);

        } catch (NacosException e) {
            e.printStackTrace();
            log.error("自定义Ribbon Rule Error: {}", e.getErrMsg());
        }

        return null;
    }
}

