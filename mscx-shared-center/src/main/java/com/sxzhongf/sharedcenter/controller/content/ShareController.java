package com.sxzhongf.sharedcenter.controller.content;

import com.sxzhongf.sharedcenter.domain.dto.content.ShareDTO;
import com.sxzhongf.sharedcenter.service.ShareService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ShareController for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2019/7/11
 */
@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/share")
@Api(tags = "内容中心")
public class ShareController {

    private final ShareService shareService;

    @GetMapping("/{id}")
    @ApiOperation("根据Id获取共享内容")
    public ShareDTO findById(@PathVariable Long id) {
        return this.shareService.findById(id);
    }
}
