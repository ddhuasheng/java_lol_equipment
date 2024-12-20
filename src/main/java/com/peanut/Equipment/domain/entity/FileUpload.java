package com.peanut.Equipment.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文件上传表
 * @TableName lol_file_upload
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value ="lol_file_upload")
@Schema(description = "文件上传实体类 - FileUpload")
public class FileUpload extends BaseEntity {
    /**
     * 文件名
     */
    @Schema(description = "文件原名称")
    private String name;

    /**
     * 文件路径
     */
    @Schema(description = "文件唯一名称")
    private String filename;
}