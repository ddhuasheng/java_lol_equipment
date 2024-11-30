package com.peanut.Equipment.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "英雄分页DTO - HeroPageDTO")
public class HeroPageDTO extends BasePageDTO {
	/*
	* 英雄名
	* */
	@Schema(description = "英雄名")
	private String name;
}
