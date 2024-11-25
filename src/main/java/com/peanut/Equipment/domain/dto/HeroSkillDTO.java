package com.peanut.Equipment.domain.dto;

import com.peanut.Equipment.domain.entity.HeroSkill;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "英雄技能DTO - HeroSkillDTO")
public class HeroSkillDTO extends HeroSkill {
	/**
	 * 英雄技能名
	 */
	@Schema(description = "英雄技能名")
	@NotBlank(message = "英雄技能名为必传项")
	private String name;

	/**
	 * 英雄技能图标
	 */
	@Schema(description = "英雄技能图标id")
	@NotNull(message = "英雄技能图标id为必传项")
	private Long imgFileId;


	/**
	 * 英雄id
	 */
	@Schema(description = "英雄id")
	@NotNull(message = "英雄id为必传项")
	private Long heroId;
}
