package com.lebrwcd.blog.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Description 文章分页Vo
 *
 * @author lebrwcd
 * @version 1.0
 * @date 2023/5/7
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleListVo {

    private Long id;
    //标题
    private String title;
    //文章摘要
    private String summary;
    //所属分类名
    private String categoryName;
    //缩略图
    private String thumbnail;


    //访问量
    private Long viewCount;

    private Date createTime;

}
