package com.lebrwcd.blog.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description 友链Vo
 *
 * @author lebrwcd
 * @version 1.0
 * @date 2023/5/7
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkVo {

    private Long id;

    private String name;

    private String logo;

    private String description;
    //网站地址
    private String address;

}
