package com.lebrwcd.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lebrwcd.blog.entity.model.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Description 文章映射接口
 *
 * @author lebrwcd
 * @version 1.0
 * @date 2023/5/5
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    /**
     * 热门文章
     * @return
     */
    List<Article> getHotArticle();

    /**
     * 已发布的文章
     * @return
     */
    List<Article> getPublishArticle();
}
