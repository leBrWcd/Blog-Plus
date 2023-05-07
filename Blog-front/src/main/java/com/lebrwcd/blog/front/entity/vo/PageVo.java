package com.lebrwcd.blog.front.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Description 分页Vo
 *
 * @author lebrwcd
 * @version 1.0
 * @date 2023/5/7
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageVo {
    private List rows;
    private Long total;
}
