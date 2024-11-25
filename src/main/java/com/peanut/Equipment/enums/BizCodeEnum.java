package com.peanut.Equipment.enums;

import lombok.Getter;

/*
 * 业务编码
 * */
@Getter
public enum BizCodeEnum {
    SUCCESS(200, "Success"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
    UNKNOWN_ERROR(500, "Unknown Error"),
    BAD_GATEWAY(502, "Bad Gateway")
    ;

    private final int code;
    private final String message;

    BizCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
