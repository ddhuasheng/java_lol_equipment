package com.peanut.Equipment.domain.vo;

import com.peanut.Equipment.enums.BizCodeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "通用返回vo类 - ResultVO")
@Data
public class ResultVO<T> {
    @Schema(description = "操作是否成功")
    private Boolean success;
    @Schema(description = "返回code")
    private BizCodeEnum code;
    @Schema(description = "返回数据")
    private T data;


    public static <T> ResultVO<T> success(T data) {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setSuccess(true);
        resultVO.setData(data);
        resultVO.setCode(BizCodeEnum.SUCCESS);
        return resultVO;
    }

    public static <T> ResultVO<T> success() {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setSuccess(true);
        resultVO.setCode(BizCodeEnum.SUCCESS);
        return resultVO;
    }

    public static <T> ResultVO<T> fail(BizCodeEnum code, T data) {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setSuccess(false);
        resultVO.setData(data);
        resultVO.setCode(code);
        return resultVO;
    }

    public static <T> ResultVO<T> fail(BizCodeEnum code) {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setSuccess(false);
        resultVO.setCode(code);
        return resultVO;
    }
}
