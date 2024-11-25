package com.peanut.Equipment.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "登录DTO - LoginDTO")
public class LoginDTO {
	/*
	 * 唯一key值
	 * */
	@NotBlank(message = "key不能为空")
	@Schema(description = "唯一key值")
	private String key;

	/*
	 * 验证码
	 * */
	@NotBlank(message = "验证码不能为空")
	@Schema(description = "验证码")
	private String code;

	/*
	 * 用户名
	 * */
	@NotBlank(message = "用户名不能为空")
	@Schema(description = "用户名")
	private String username;

	/*
	 * 密码
	 * */
	@Schema(description = "密码")
	@NotBlank(message = "密码不能为空")
	private String password;
}
