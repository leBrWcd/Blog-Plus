package com.lebrwcd.blog.common.constant;

import lombok.Data;

/**
 * Description 系统常量
 *
 * @author lebrwcd
 * @version 1.0
 * @date 2023/5/7
 */
@Data
public class SystemConstants {

    /**
     *  文章是草稿
     */
    public static final int ARTICLE_STATUS_DRAFT = 1;
    /**
     *  文章是正常分布状态
     */
    public static final int ARTICLE_STATUS_NORMAL = 0;

    public static final String STATUS_NORMAL = "0";

    public static final String STATUS_ERROR = "1";


    public static final String DEL_FLAG = "1";

    public static final String LINK_APPROVED_STATUS = "0";
}
