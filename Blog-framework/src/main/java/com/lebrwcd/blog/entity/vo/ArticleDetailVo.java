package com.lebrwcd.blog.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Description 文章详情对象
 *
 * @author lebrwcd
 * @version 1.0
 * @date 2023/5/7
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDetailVo {

    private Long id;

    @ApiModelProperty(notes = "标题")
    private String title;

    @ApiModelProperty(notes = "文章内容")
    private String content;

    @ApiModelProperty(notes = "文章类型（1 文章 2草稿）")
    private String type;

    @ApiModelProperty(notes = "所属分类id")
    private Long categoryId;

    @TableField(exist = false)
    @ApiModelProperty(notes = "所属分类名称")
    private String categoryName;

    @ApiModelProperty(notes = "访问量")
    private Long viewCount;

    @ApiModelProperty(notes = "是否允许评论 1是，0否")
    private String isComment;

    private Date createTime;



}
