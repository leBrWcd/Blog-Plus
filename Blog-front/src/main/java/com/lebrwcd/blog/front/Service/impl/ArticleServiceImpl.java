package com.lebrwcd.blog.front.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.constant.SystemConstants;
import com.lebrwcd.blog.front.Service.ArticleService;
import com.lebrwcd.blog.front.Service.BlogCategoryService;
import com.lebrwcd.blog.front.entity.vo.ArticleListVo;
import com.lebrwcd.blog.front.entity.vo.PageVo;
import com.lebrwcd.blog.front.mapper.ArticleMapper;
import com.blog.ResponseResult;
import com.blog.utils.CopyBeanUtil;
import com.lebrwcd.blog.front.entity.model.Article;
import com.lebrwcd.blog.front.entity.vo.HotArticleVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.stream.Collectors;

/**
 * Description 文章业务实现类
 *
 * @author lebrwcd
 * @version 1.0
 * @date 2023/5/5
 */
@Service
@Slf4j
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private BlogCategoryService categoryService;

    @Override
    public ResponseResult hotArticle() {

        // 热门文章，可设置Redis缓存

        List<Article> articleList = articleMapper.getHotArticle();
        if (articleList.isEmpty()) {
            return null;
        }
        List<HotArticleVo> voList = CopyBeanUtil.copyBeanList(articleList, HotArticleVo.class);
        return ResponseResult.okResult(voList);
    }

    @Override
    public ResponseResult selectPage(Integer pageNum, Integer pageSize, Integer categoryId) {

        // 1.设置分页参数
        Page<Article> page = new Page<>(pageNum,pageSize);

        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();

        // 有分页id，证明是点击了文章分类做的文章分页查询，没有默认所有文章分页查询
        if (categoryId != 0) {
            wrapper.eq(Article::getCategoryId,categoryId);
        }
        wrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        wrapper.ne(Article::getDelFlag,SystemConstants.DEL_FLAG);
        // 根据是否置顶进行排序
        wrapper.orderByDesc(Article::getIsTop);

        page = baseMapper.selectPage(page,wrapper);

        List<Article> list = new ArrayList<>();

        if (page.getRecords().size() >= 1) {
            // 封装分页对象
            list = page.getRecords();
            // 设置分类名称
            list.forEach( e -> {
                String categoryName = categoryService.getById(e.getCategoryId()).getName();
                e.setCategoryName(categoryName);
            });
        }
        //封装查询结果
        List<ArticleListVo> articleListVos = CopyBeanUtil.copyBeanList(list, ArticleListVo.class);

        PageVo pageVo = new PageVo(articleListVos,page.getTotal());
        return ResponseResult.okResult(pageVo);
    }
}
