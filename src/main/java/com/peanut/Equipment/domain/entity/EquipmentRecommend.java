package com.peanut.Equipment.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 出装推荐表
 * @TableName lol_equipment_recommend
 */
@TableName(value ="lol_equipment_recommend")
@Data
public class EquipmentRecommend extends BaseEntity {
    /**
     * 英雄id
     */
    private Long heroId;

    /**
     * 装备id
     */
    private Long equipmentId;

    /**
     * 推荐类型 1-顺风出装 2-逆风出装
     */
    private Integer recommendType;

    /**
     * 出装顺序 1-出门装 2-核心装 3-神装
     */
    private Integer stage;
}