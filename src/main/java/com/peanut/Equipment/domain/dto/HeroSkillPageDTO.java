package com.peanut.Equipment.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "英雄技能分页DTO - HeroPageDTO")
public class HeroSkillPageDTO extends BasePageDTO {
	/*
	 * 英雄技能名
	 * */
	@Schema(description = "英雄技能名")
	private String name;
}
