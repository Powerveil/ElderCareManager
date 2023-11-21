package com.ruoyi.system.domain.query;

import lombok.Data;

import java.util.Objects;

/**
 * @author Powerveil
 * @Date 2023/11/18 17:56
 * 设计之初是为了方便内部的调用
 */
@Data
public class UserQuery {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户账号
     */
    private String userName = "";

    /**
     * 手机号码
     */
    private String phonenumber  = "";

    /**
     * 判断是否所有值都是空
     * @return
     */
    public boolean isEmpty() {
        return Objects.isNull(userId)
                && Objects.isNull(userName)
                && Objects.isNull(phonenumber);

    }
}
