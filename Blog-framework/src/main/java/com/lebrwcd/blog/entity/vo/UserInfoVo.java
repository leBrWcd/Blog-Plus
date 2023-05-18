package com.lebrwcd.blog.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Description 返回给业务端的用户信息
 *
 * @author lebrwcd
 * @version 1.0
 * @date 2023/5/15
 */
@Data
@Accessors(chain = true)
public class UserInfoVo {
    /**
     * 主键
     */
    private Long id;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String avatar;

    private String sex;

    private String email;


}