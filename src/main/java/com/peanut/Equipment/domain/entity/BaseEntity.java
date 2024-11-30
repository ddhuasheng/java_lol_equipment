package com.peanut.Equipment.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/*
* 基础字段
* */
@Data
@Schema(description = "基础实体字段 - BaseEntity")
public class BaseEntity implements Serializable {
    /**
     * id
     * 配置雪花算法
     */
    @Schema(description = "id")
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 版本
     * 配置乐观锁
     */
    @Schema(description = "版本")
    @Version
    private Integer version;

    /**
     * 删除标记
     * 配置逻辑删除
     */
    @Schema(description = "删除标记")
    @TableLogic(
            value = "0",
            delval = "id"
    )
    @TableField(
            value = "delete_flag",
            fill = FieldFill.INSERT,
            select = false
    )
    private Long deleteFlag;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    @TableField(
            fill = FieldFill.INSERT
    )
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @Schema(description = "更新时间")
    @TableField(
            fill = FieldFill.INSERT_UPDATE
    )
    private LocalDateTime updateTime;
}
