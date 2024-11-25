package com.peanut.Equipment.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 英雄表
 * @TableName lol_hero
 */
@Schema(description = "英雄实体表 - Hero")
@TableName(value ="lol_hero")
@Data
public class Hero extends BaseEntity {
    /**
     * 英雄名
     */
    @Schema(description = "英雄名")
    private String name;

    /**
     * 英雄头像
     */
    @Schema(description = "英雄头像")
    private Long imgFileId;
}