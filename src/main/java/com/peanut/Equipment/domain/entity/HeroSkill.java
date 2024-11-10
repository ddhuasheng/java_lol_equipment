package com.peanut.Equipment.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 英雄技能表
 * @TableName lol_hero_skill
 */
@TableName(value ="lol_hero_skill")
@Data
public class HeroSkill extends BaseEntity {
    /**
     * 技能名称
     */
    private String name;

    /**
     * 图标id
     */
    private Long imgFileId;

    /**
     * 英雄id
     */
    private Long heroId;
}