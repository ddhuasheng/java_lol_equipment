package com.peanut.Equipment.exception;

import com.peanut.Equipment.enums.BizCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class BizException extends RuntimeException{
    // 错误编码
    private int code;
    // 错误信息
    private String message;

    public static BizException of(int code, String message) {
        BizException bizException = new BizException();
        bizException.setCode(code);
        bizException.setMessage(message);
        return bizException;
    }

    public static BizException of(String message) {
        BizException bizException = new BizException();
        bizException.setMessage(message);
        bizException.setCode(BizCodeEnum.UNKNOWN_ERROR.getCode());
        return bizException;
    }
}
