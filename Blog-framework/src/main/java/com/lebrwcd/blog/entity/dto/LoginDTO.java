package com.lebrwcd.blog.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description 登录数据传输对象
 *
 * @author lebrwcd
 * @version 1.0
 * @date 2023/5/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

    private String username;

    private String password;

}
