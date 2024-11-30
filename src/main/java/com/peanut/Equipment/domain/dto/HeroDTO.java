package com.peanut.Equipment.domain.dto;

import com.peanut.Equipment.domain.entity.Hero;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "英雄DTO - HeroDTO")
public class HeroDTO extends Hero {
	/**
	 * 英雄名
	 */
	@Schema(description = "英雄名")
	@NotBlank(message = "英雄名为必传项")
	private String name;

	/**
	 * 英雄头像
	 */
	@Schema(description = "英雄头像")
	@NotNull(message = "英雄头像为必传项")
	private Long imgFileId;
}
