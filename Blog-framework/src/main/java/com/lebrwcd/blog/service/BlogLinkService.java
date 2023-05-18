package com.lebrwcd.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lebrwcd.blog.common.ResponseResult;
import com.lebrwcd.blog.entity.model.BlogLink;


/**
 * 友链(BlogLink)表服务接口
 *
 * @author makejava
 * @since 2023-05-07 21:18:40
 */
public interface BlogLinkService extends IService<BlogLink> {

    /**
     * 查询所有通过审核的友链
     * @return
     */
    ResponseResult getAllLink();
}

