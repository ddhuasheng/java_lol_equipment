package com.peanut.Equipment.domain.vo;

import com.peanut.Equipment.enums.RecommendTypeEnum;
import com.peanut.Equipment.enums.StageEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "装备推荐分页VO - EquipmentRecommendPageVO")
public class EquipmentRecommendPageVO extends BaseVO {
	/**
	 * 英雄id
	 */
	@Schema(description = "英雄id")
	private Long heroId;

	/**
	 * 装备id
	 */
	@Schema(description = "装备id")
	private Long equipmentId;

	/**
	 * 推荐类型 1-顺风出装 2-逆风出装
	 */
	@Schema(description = "推荐类型 1-顺风出装 2-逆风出装")
	private RecommendTypeEnum recommendType;

	/**
	 * 出装顺序 1-出门装 2-核心装 3-神装
	 */
	@Schema(description = "出装顺序 1-出门装 2-核心装 3-神装")
	private StageEnum stage;
}
