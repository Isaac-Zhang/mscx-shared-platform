package com.sxzhongf.sharedcenter.service;

import com.sxzhongf.sharedcenter.dao.share.ShareMapper;
import com.sxzhongf.sharedcenter.domain.dto.content.ShareDTO;
import com.sxzhongf.sharedcenter.domain.dto.user.UserDTO;
import com.sxzhongf.sharedcenter.domain.entity.share.Share;
import com.sxzhongf.sharedcenter.feignclients.IUserCenterFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ShareService for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2019/7/11
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareService {
    private final ShareMapper shareMapper;
    //    private final RestTemplate restTemplate;
//    private final DiscoveryClient discoveryClient;
    //使用Feign替换RestTemplate
    private final IUserCenterFeignClient userCenterFeignClient;

    public ShareDTO findById(Long id) {
        // 获取分享详情
        Share share = shareMapper.selectByPrimaryKey(id);
        log.info("ShareService#findById Share : {}", share);

        // 获取发布人ID
        Long userId = share.getUserId();

        // 获取用户中心所有实例的信息
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-center");
//        // http://localhost:8081/users/{id}
////        String targetUri = instances.stream()
////                                    //数据转换
////                                    .map(i -> i.getUri().toString() + "/users/{id}")
////                                    //此处只有一个实例，先使用第一个直接获取，后续需要更改为list
////                                    .findFirst()
////                                    .orElseThrow(() -> new IllegalArgumentException("当前没有实例"));
//
//        // 自定义客户端负载均衡能力
//        // 获取所有用户中心服务的实例列表
//        List<String> targetUris = instances.stream().map(i -> i.getUri().toString() + "/users/{id}").collect(Collectors.toList());
//
//        //获取随机实例
//        int i = ThreadLocalRandom.current().nextInt(targetUris.size());
//
//        //调用用户微服务 /users/{userId}
//        log.info("请求的目标地址：{}", targetUris.get(i));

//        ResponseEntity<UserDTO> userEntity = restTemplate.getForEntity(
//                "http://user-center/users/{userId}",
//                UserDTO.class, userId
//        );
//        UserDTO userDTO = new UserDTO();
//        if (null != userEntity) {
//            userDTO = userEntity.getBody();
//            log.info("ShareService#findById userDTO: {}", userDTO);
//        }
        //使用 FeignClient 来替换掉RestTemplate调用
        UserDTO userDTO = this.userCenterFeignClient.findById(userId);

        ShareDTO shareDTO = new ShareDTO();
//      shareDTO = ShareDTO.builder()
//                                    .id(share.getId())
//                                    .userId(share.getUserId())
//                                     //... 太多了，累人
//                                    .build();

        //上述太累，
        //使用String 工具类 来装配对象
        BeanUtils.copyProperties(share, shareDTO);
        shareDTO.setWxNickName(userDTO.getWxNickname());
        return shareDTO;
    }

//    public static void main(String[] args) {
//        RestTemplate restTemplate = new RestTemplate();
//        // 用HTTP GET 方法请求，并且返回一个对象
//        String forObject = restTemplate.getForObject(
//                "http://localhost:8081/users/{id}",
//                String.class, 1
//        );
//        System.out.println(forObject);
//
//        ResponseEntity<String> forEntity = restTemplate.getForEntity(
//                "http://localhost:8081/users/{id}",
//                String.class, 1
//        );
//        System.out.println(forEntity.getBody());
//        System.out.println(forEntity.getStatusCode());
//    }
}
