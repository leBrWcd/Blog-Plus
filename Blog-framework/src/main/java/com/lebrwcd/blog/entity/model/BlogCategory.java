package com.lebrwcd.blog.entity.model;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 分类表(BlogCategory)表实体类
 *
 * @author makejava
 * @since 2023-05-07 15:30:56
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("文章分类")
@TableName("blog_category")
public class BlogCategory  {
    @TableId
    private Long id;

    /**
     * 分类名
     */
    @ApiModelProperty(notes = "分类名")
    private String name;

    /**
     * 父分类id，如果没有父分类为-1
     */
    @ApiModelProperty(notes = "父分类id")
    private Long pid;
    /**
     * 描述
     */
    @ApiModelProperty(notes = "描述")
    private String description;

    /**
     * 描述
     */
    @ApiModelProperty(notes = "状态0:正常,1禁用")
    private String status;
    
    private Long createBy;
    
    private Date createTime;
    
    private Long updateBy;
    
    private Date updateTime;

    /**
     * 描述
     */
    @ApiModelProperty(notes = "删除标志（0代表未删除，1代表已删除）")
    private Integer delFlag;



}

