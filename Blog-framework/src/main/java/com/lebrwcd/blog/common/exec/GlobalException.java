package com.lebrwcd.blog.common.exec;

import com.lebrwcd.blog.common.enums.HttpCodeEnum;

/**
 * Description 统一异常处理
 *
 * @author lebrwcd
 * @version 1.0
 * @date 2023/5/22
 */
public class GlobalException extends RuntimeException{

    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public GlobalException() {
        super();
    }

    public GlobalException(HttpCodeEnum codeEnum) {
        super(codeEnum.getMsg());
        this.code = codeEnum.getCode();
        this.msg = codeEnum.getMsg();
    }
}
