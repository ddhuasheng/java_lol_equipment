package com.peanut.Equipment.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 文件上传表
 * @TableName lol_file_upload
 */
@TableName(value ="lol_file_upload")
@Data
public class FileUpload extends BaseEntity {
    /**
     * 文件名
     */
    private String name;

    /**
     * 文件路径
     */
    private String path;
}