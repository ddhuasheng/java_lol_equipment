package com.peanut.Equipment.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 装备表
 * @TableName lol_equipment
 */
@TableName(value ="lol_equipment")
@Data
public class Equipment extends BaseEntity {
    /**
     * 装备名称
     */
    private String name;

    /**
     * 图标id
     */
    private Long imgFileId;

}