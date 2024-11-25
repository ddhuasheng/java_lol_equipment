package com.peanut.Equipment.domain.vo;

import com.peanut.Equipment.domain.entity.HeroSkill;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "英雄技能VO - HeroSkillVO")
public class HeroSkillVO extends HeroSkill {
	/**
	 * 英雄技能名
	 */
	@Schema(description = "英雄技能名")
	private String name;

	/**
	 * 英雄技能图标
	 */
	@Schema(description = "英雄技能图标id")
	private Long imgFileId;


	/**
	 * 英雄id
	 */
	@Schema(description = "英雄id")
	private Long heroId;
}
