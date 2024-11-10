package com.peanut.Equipment.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 英雄表
 * @TableName lol_hero
 */
@TableName(value ="lol_hero")
@Data
public class Hero extends BaseEntity {
    /**
     * 英雄名
     */
    private String name;

    /**
     * 英雄头像
     */
    private Long imgFileId;
}