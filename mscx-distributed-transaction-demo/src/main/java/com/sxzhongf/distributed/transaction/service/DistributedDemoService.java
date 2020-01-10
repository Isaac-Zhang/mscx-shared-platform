package com.sxzhongf.distributed.transaction.service;

import com.sxzhongf.distributed.transaction.domain.dto.UserDTO;
import com.sxzhongf.distributed.transaction.feignclients.ISharedCenterFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class DistributedDemoService {

    private final ISharedCenterFeignClient sharedCenterFeignClient;

    public UserDTO getById(Long uid){
        return this.sharedCenterFeignClient.findById(uid);
    }
}
