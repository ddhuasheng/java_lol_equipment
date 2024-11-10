package com.peanut.Equipment.enums;

import lombok.Getter;

/*
 * 业务编码
 * */
@Getter
public enum BizCodeEnum {
    SUCCESS(200, "success"),
    UNKNOWN_ERROR(500, "unknownError"),
    ;

    private final int code;
    private final String message;

    BizCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
