package com.lebrwcd.blog.front.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lebrwcd.blog.front.entity.model.BlogCategory;
import com.blog.ResponseResult;


/**
 * 分类表(BlogCategory)表服务接口
 *
 * @author makejava
 * @since 2023-05-07 15:30:56
 */
public interface BlogCategoryService extends IService<BlogCategory> {

    ResponseResult getCategoryList();
}

