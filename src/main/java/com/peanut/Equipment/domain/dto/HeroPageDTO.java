package com.peanut.Equipment.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "英雄分页DTO - HeroPageDTO")
@Data
public class HeroPageDTO extends BasePageDTO {
	/*
	* 英雄名
	* */
	@Schema(description = "英雄名")
	private String name;
}
