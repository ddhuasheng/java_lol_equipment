package com.peanut.Equipment.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/*
* 基础字段
* */
@Data
public class BaseEntity implements Serializable {
    /**
     * id
     * 配置雪花算法
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 版本
     * 配置乐观锁
     */
    @Version
    private Integer version;

    /**
     * 删除标记
     * 配置逻辑删除
     */
    @TableLogic(
            value = "0",
            delval = "id"
    )
    @TableField(
            value = "delete_flag",
            fill = FieldFill.INSERT
    )
    private Long deleteFlag;

    /**
     * 创建时间
     */
    @TableField(
            fill = FieldFill.INSERT
    )
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(
            fill = FieldFill.INSERT_UPDATE
    )
    private LocalDateTime updateTime;
}
