package com.peanut.Equipment.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "验证码VO - CaptchaVo")
public class CaptchaVo {
	/*
	* 验证码图片
	* */
	@Schema(description = "验证码图片")
	private String data;
	/*
	 * 唯一key值
	 * */
	@Schema(description = "唯一key值")
	private String key;
}
