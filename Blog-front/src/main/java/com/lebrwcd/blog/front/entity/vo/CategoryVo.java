package com.lebrwcd.blog.front.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description 文章分类查询对象
 *
 * @author lebrwcd
 * @version 1.0
 * @date 2023/5/7
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryVo {

    private Long id;

    private String name;

}
