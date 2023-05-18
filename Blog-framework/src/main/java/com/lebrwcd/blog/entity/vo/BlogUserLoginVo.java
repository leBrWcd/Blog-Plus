package com.lebrwcd.blog.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description TODO
 *
 * @author lebrwcd
 * @version 1.0
 * @date 2023/5/15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogUserLoginVo {

    /**
     * token
     */
    private String token;
    /**
     * 用户信息
     */
    private UserInfoVo userInfo;
}
