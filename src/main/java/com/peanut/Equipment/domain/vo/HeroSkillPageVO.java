package com.peanut.Equipment.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "英雄技能分页VO - HeroPageVO")
public class HeroSkillPageVO extends BaseVO {
	/*
	 * 英雄技能名
	 * */
	@Schema(description = "英雄技能名")
	private String name;
	/*
	 * 英雄技能头像
	 * */
	@Schema(description = "英雄技能头像")
	private Long imgFileId;
	/**
	 * 英雄id
	 */
	@Schema(description = "英雄id")
	private Long heroId;
}
