package com.peanut.Equipment.domain.dto;

import com.peanut.Equipment.domain.entity.Equipment;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "装备信息DTO - EquipmentDTO")
public class EquipmentDTO extends Equipment {
	/**
	 * 装备名称
	 */
	@Schema(description = "装备名称")
	@NotBlank(message = "装备名称为必传项")
	private String name;

	/**
	 * 图标id
	 */
	@Schema(description = "图标id")
	@NotNull(message = "图标id为必传项")
	private Long imgFileId;
}
