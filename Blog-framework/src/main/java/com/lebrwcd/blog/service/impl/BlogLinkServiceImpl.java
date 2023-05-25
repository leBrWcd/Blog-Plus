package com.lebrwcd.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lebrwcd.blog.common.ResponseResult;
import com.lebrwcd.blog.common.constant.SystemConstants;
import com.lebrwcd.blog.common.utils.CopyBeanUtil;
import com.lebrwcd.blog.entity.model.BlogLink;
import com.lebrwcd.blog.entity.vo.LinkVo;
import com.lebrwcd.blog.mapper.BlogLinkMapper;
import com.lebrwcd.blog.service.BlogLinkService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 友链(BlogLink)表服务实现类
 *
 * @author makejava
 * @since 2023-05-07 21:18:40
 */
@Service
public class BlogLinkServiceImpl extends ServiceImpl<BlogLinkMapper, BlogLink> implements BlogLinkService {

    @Override
    public ResponseResult getAllLink() {

        LambdaQueryWrapper<BlogLink> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(BlogLink::getStatus, SystemConstants.LINK_APPROVED_STATUS);
        List<BlogLink> blogLinks = baseMapper.selectList(wrapper);

        List<LinkVo> linkVos = CopyBeanUtil.copyBeanList(blogLinks, LinkVo.class);
        return ResponseResult.okResult(linkVos);
    }
}

