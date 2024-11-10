package com.peanut.Equipment.domain.vo;

import com.peanut.Equipment.enums.BizCodeEnum;
import lombok.Data;

import javax.xml.transform.Result;

@Data
public class ResultVO<T> {
    private Boolean success;
    private String msg;
    private int code;
    private T data;


    public static <T> ResultVO<T> success(T data) {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setSuccess(true);
        resultVO.setData(data);
        resultVO.setCode(BizCodeEnum.SUCCESS.getCode());
        return resultVO;
    }

    public static <T> ResultVO<T> success() {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setSuccess(true);
        resultVO.setCode(BizCodeEnum.SUCCESS.getCode());
        return resultVO;
    }

    public static <T> ResultVO<T> fail(T data) {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setSuccess(false);
        resultVO.setData(data);
        resultVO.setCode(BizCodeEnum.UNKNOWN_ERROR.getCode());
        return resultVO;
    }

    public static <T> ResultVO<T> fail() {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setSuccess(false);
        resultVO.setCode(BizCodeEnum.UNKNOWN_ERROR.getCode());
        return resultVO;
    }
}
