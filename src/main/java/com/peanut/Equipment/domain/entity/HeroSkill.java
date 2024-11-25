package com.peanut.Equipment.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 英雄技能表
 * @TableName lol_hero_skill
 */
@Schema(description = "英雄技能实体表 - HeroSkill")
@TableName(value ="lol_hero_skill")
@Data
public class HeroSkill extends BaseEntity {
    /**
     * 技能名称
     */
    @Schema(description = "技能名称")
    private String name;

    /**
     * 图标id
     */
    @Schema(description = "图标id")
    private Long imgFileId;

    /**
     * 英雄id
     */
    @Schema(description = "英雄id")
    private Long heroId;
}