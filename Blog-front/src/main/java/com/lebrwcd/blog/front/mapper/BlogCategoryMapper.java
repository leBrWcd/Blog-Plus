package com.lebrwcd.blog.front.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lebrwcd.blog.front.entity.model.BlogCategory;

import java.util.List;


/**
 * 分类表(BlogCategory)表数据库访问层
 *
 * @author makejava
 * @since 2023-05-07 15:30:56
 */
public interface BlogCategoryMapper extends BaseMapper<BlogCategory> {

    /**
     * 查询分类列表
     * @return
     */
    List<BlogCategory> getList();
}

