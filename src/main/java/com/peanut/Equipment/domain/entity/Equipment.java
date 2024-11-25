package com.peanut.Equipment.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 装备表
 * @TableName lol_equipment
 */
@Schema(description = "装备实体表 - Equipment")
@TableName(value ="lol_equipment")
@Data
public class Equipment extends BaseEntity {
    /**
     * 装备名称
     */
    @Schema(description = "装备名称")
    private String name;

    /**
     * 图标id
     */
    @Schema(description = "图标id")
    private Long imgFileId;
}