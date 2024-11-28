package com.peanut.Equipment.exception;

import com.peanut.Equipment.enums.BizCodeEnum;
import lombok.Data;

@Data
public class BizException extends RuntimeException{
    // 错误编码
    private BizCodeEnum code;
    // 错误信息
    private String message;

    public static BizException of(BizCodeEnum code, String message) {
        BizException bizException = new BizException();
        bizException.setCode(code);
        bizException.setMessage(message);
        return bizException;
    }


    public static BizException of(BizCodeEnum code, String message, String ...args) {
        BizException bizException = new BizException();
        bizException.setCode(code);
        bizException.setMessage(message.formatted((Object) args));
        return bizException;
    }

    public static BizException of(String message) {
        BizException bizException = new BizException();
        bizException.setMessage(message);
        bizException.setCode(BizCodeEnum.UNKNOWN_ERROR);
        return bizException;
    }
}
