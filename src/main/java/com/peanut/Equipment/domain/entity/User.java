package com.peanut.Equipment.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value ="lol_user")
@Schema(description = "用户实体表")
public class User extends BaseEntity {
	/*
	* 用户名
	* */
	@Schema(description = "用户名")
	private String username;
	/*
	* 密码
	* */
	@Schema(description = "密码")
	private String password;
}
