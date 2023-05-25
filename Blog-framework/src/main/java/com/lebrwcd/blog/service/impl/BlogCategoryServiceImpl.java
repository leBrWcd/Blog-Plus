package com.lebrwcd.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lebrwcd.blog.common.constant.SystemConstants;
import com.lebrwcd.blog.service.BlogCategoryService;
import com.lebrwcd.blog.entity.model.Article;
import com.lebrwcd.blog.entity.model.BlogCategory;
import com.lebrwcd.blog.entity.vo.CategoryVo;
import com.lebrwcd.blog.mapper.ArticleMapper;
import com.lebrwcd.blog.mapper.BlogCategoryMapper;
import com.lebrwcd.blog.common.ResponseResult;
import com.lebrwcd.blog.common.utils.CopyBeanUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 分类表(BlogCategory)表服务实现类
 *
 * @author makejava
 * @since 2023-05-07 15:30:56
 */
@Service("blogCategoryService")
public class BlogCategoryServiceImpl extends ServiceImpl<BlogCategoryMapper, BlogCategory> implements BlogCategoryService {


    @Resource
    private BlogCategoryMapper blogCategoryMapper;

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public ResponseResult getCategoryList() {

        // 1.查询已发布文章，获取其文章分类id
        List<Article> articleList = articleMapper.getPublishArticle();
        // 2.对id去重
        Set<Long> idsList = articleList.stream()
                .map(article -> article.getCategoryId())
                .collect(Collectors.toSet());
        // 3.查询分类列表
        List<BlogCategory> categoryList = baseMapper.selectBatchIds(idsList);

        List<BlogCategory> categories = categoryList.stream()
                .filter(category -> SystemConstants.STATUS_NORMAL.equals(category.getStatus()))
                .collect(Collectors.toList());

        // 4.封装成Vo
        List<CategoryVo> categoryVos = CopyBeanUtil.copyBeanList(categories, CategoryVo.class);

        return ResponseResult.okResult(categoryVos);
    }
}

