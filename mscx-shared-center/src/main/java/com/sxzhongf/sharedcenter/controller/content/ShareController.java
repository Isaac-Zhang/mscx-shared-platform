package com.sxzhongf.sharedcenter.controller.content;

import com.sxzhongf.sharedcenter.domain.dto.content.ShareDTO;
import com.sxzhongf.sharedcenter.domain.entity.share.Share;
import com.sxzhongf.sharedcenter.service.ShareService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    @ApiOperation("创建分享内容--测试分布式事务")
    public Share create(@RequestParam String title) {
        log.info("分布式事务测试---新增内容：{}", title);
        return this.shareService.create(title);
    }
}
