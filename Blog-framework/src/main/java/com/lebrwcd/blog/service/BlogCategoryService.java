package com.lebrwcd.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lebrwcd.blog.entity.model.BlogCategory;
import com.lebrwcd.blog.common.ResponseResult;


/**
 * 分类表(BlogCategory)表服务接口
 *
 * @author makejava
 * @since 2023-05-07 15:30:56
 */
public interface BlogCategoryService extends IService<BlogCategory> {

    ResponseResult getCategoryList();
}

