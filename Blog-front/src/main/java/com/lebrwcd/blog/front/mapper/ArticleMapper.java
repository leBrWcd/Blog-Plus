package com.lebrwcd.blog.front.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lebrwcd.blog.front.entity.model.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * Description 文章映射接口
 *
 * @author lebrwcd
 * @version 1.0
 * @date 2023/5/5
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
}
