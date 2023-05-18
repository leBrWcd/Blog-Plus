package com.lebrwcd.blog.entity.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Description 文章实体类
 *
 * @author lebrwcd
 * @version 1.0
 * @date 2023/5/5
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("文章实体类")
@TableName("blog_article")
public class Article {

    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 标题
     */
    @ApiModelProperty(notes = "标题")
    private String title;

    /**
     * 文章内容
     */
    @ApiModelProperty(notes = "文章内容")
    private String content;

    /**
     * 文章类型:1 文章 2草稿
     */
    @ApiModelProperty(notes = "文章类型（1 文章 2草稿）")
    private String type;

    /**
     * 文章摘要
     */
    @ApiModelProperty(notes = "文章摘要")
    private String summary;

    /**
     * 所属分类id
     */
    @ApiModelProperty(notes = "所属分类id")
    private Long categoryId;

    /**
     * 所属分类名称
     */
    @TableField(exist = false)
    @ApiModelProperty(notes = "所属分类名称")
    private String categoryName;

    /**
     * 缩略图
     */
    @ApiModelProperty(notes = "缩略图")
    private String thumbnail;

    /**
     * 是否置顶（0否，1是）
     */
    @ApiModelProperty(notes = "是否置顶（0否，1是）")
    private String isTop;

    /**
     * 状态（0已发布，1草稿）
     */
    @ApiModelProperty(notes = "状态（0已发布，1草稿）")
    private String status;

    /**
     * 评论数
     */
    @ApiModelProperty(notes = "评论数")
    private Integer commentCount;

    /**
     * 访问量
     */
    @ApiModelProperty(notes = "访问量")
    private Long viewCount;

    /**
     * 是否允许评论 1是，0否
     */
    @ApiModelProperty(notes = "是否允许评论 1是，0否")
    private String isComment;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private Long updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 逻辑删除标志（0代表未删除，1代表已删除）
     */
    @TableLogic(delval = "1",value = "0")
    private Integer delFlag;
}
