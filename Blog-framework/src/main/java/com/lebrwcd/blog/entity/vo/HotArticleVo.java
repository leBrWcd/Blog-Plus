package com.lebrwcd.blog.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description 热门文章返回对象
 *
 * @author lebrwcd
 * @version 1.0
 * @date 2023/5/7
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotArticleVo {

    /**
     * 主键
     */
    private Long id;

    /**
     * 标题
     */
    @ApiModelProperty(notes = "标题")
    private String title;
    /**
     * 状态（0已发布，1草稿）
     */
    @ApiModelProperty(notes = "状态（0已发布，1草稿）")
    private String status;
    /**
     * 访问量
     */
    @ApiModelProperty(notes = "访问量")
    private Long viewCount;

}
