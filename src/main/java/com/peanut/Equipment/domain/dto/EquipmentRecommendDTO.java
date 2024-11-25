package com.peanut.Equipment.domain.dto;

import com.peanut.Equipment.domain.entity.EquipmentRecommend;
import com.peanut.Equipment.enums.RecommendTypeEnum;
import com.peanut.Equipment.enums.StageEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "装备推荐信息DTO - EquipmentRecommendDTO")
public class EquipmentRecommendDTO extends EquipmentRecommend {
	/**
	 * 英雄id
	 */
	@Schema(description = "英雄id")
	@NotNull(message = "英雄id不能为空")
	private Long heroId;

	/**
	 * 装备id
	 */
	@Schema(description = "装备id")
	@NotNull(message = "装备id不能为空")
	private Long equipmentId;

	/**
	 * 推荐类型 1-顺风出装 2-逆风出装
	 */
	@Schema(description = "推荐类型 1-顺风出装 2-逆风出装")
	@NotBlank(message = "推荐类型不能为空")
	private RecommendTypeEnum recommendType;

	/**
	 * 出装顺序 1-出门装 2-核心装 3-神装
	 */
	@Schema(description = "出装顺序 1-出门装 2-核心装 3-神装")
	@NotBlank(message = "出装顺序不能为空")
	private StageEnum stage;
}
