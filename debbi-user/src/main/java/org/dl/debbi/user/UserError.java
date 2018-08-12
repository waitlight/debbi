package org.dl.debbi.user;

import org.dl.debbi.common.error.ErrorType;

public enum UserError implements ErrorType {

    invalid_principal(144101),              // 非法用户名
    invalid_user(144102),                   // 非法用户
    register_fail(144601),                  // 注册失败
    conflict_principal(140901),             // 用户名重复
    invalid_user_info(144101),              // 错误的用户信息参数
    ;

    private int code;

    UserError(int code) {
        this.code = code;
    }


    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name();
    }
}