package com.lebrwcd.blog.front.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.ResponseResult;
import com.lebrwcd.blog.front.entity.model.Article;

/**
 * Description 文章服务接口
 *
 * @author lebrwcd
 * @version 1.0
 * @date 2023/5/5
 */
public interface ArticleService extends IService<Article>  {
    /**
     * 热门文章接口
     * @return 前10篇热门文章
     */
    ResponseResult hotArticle();

    /**
     * 分页查询文章列表
     * @param pageNum
     * @param pageSize
     * @param categoryId
     * @return
     */
    ResponseResult selectPage(Integer pageNum, Integer pageSize, Integer categoryId);
}
