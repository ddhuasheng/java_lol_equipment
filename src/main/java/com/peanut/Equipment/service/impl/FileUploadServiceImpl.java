package com.peanut.Equipment.service.impl;

import cn.hutool.core.io.FileUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peanut.Equipment.domain.entity.FileUpload;
import com.peanut.Equipment.exception.BizException;
import com.peanut.Equipment.service.FileUploadService;
import com.peanut.Equipment.mapper.FileUploadMapper;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
* @author 86139
* @description 针对表【lol_file_upload(文件上传表)】的数据库操作Service实现
* @createDate 2024-11-10 15:16:09
*/
@Service
@Slf4j
public class FileUploadServiceImpl extends ServiceImpl<FileUploadMapper, FileUpload>
    implements FileUploadService {

    @Value("${file.dir}")
    private String fileDir;

    @Override
    public Long upload(MultipartFile file) {
        String originalFileName = file.getOriginalFilename();
        String mainName = FileUtil.mainName(originalFileName);
        String extName = FileUtil.extName(originalFileName);

        String fileName = mainName + "_" + UUID.randomUUID() + "." + extName;
        String absolutePath = fileDir + fileName;

        try {
            FileUtil.writeBytes(file.getBytes(), absolutePath);
        } catch (IOException e) {
            log.error("文件上传失败: {}", e.getMessage());
            throw BizException.of("文件上传失败");
        }

        FileUpload fileUpload = new FileUpload();
        fileUpload.setName(originalFileName);
        fileUpload.setPath(absolutePath);

        save(fileUpload);

        return fileUpload.getId();
    }

    @Override
    public Long upload(File file) {
        String name = file.getName();
        String mainName = FileUtil.mainName(name);
        String extName = FileUtil.extName(name);

        String fileName = mainName + "_" + UUID.randomUUID() + "." + extName;
        String absolutePath = fileDir + fileName;

        FileUtil.writeBytes(FileUtil.readBytes(file), absolutePath);
        FileUpload fileUpload = new FileUpload();
        fileUpload.setPath(absolutePath);
        fileUpload.setName(name);
        save(fileUpload);
        return fileUpload.getId();
    }

    @Override
    public void download(Long fileId, HttpServletResponse response) {
        FileUpload fileUpload = getById(fileId);

        if (fileUpload == null) {
            throw BizException.of("文件不存在");
        }

        File file = FileUtil.file(fileUpload.getPath());

        // 把文件输出到响应流
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        // 返回文件名
        response.setHeader("Content-Disposition", "attachment;filename=" + fileUpload.getName());
        // 获取输出流
        try(
                ServletOutputStream outputStream = response.getOutputStream();
                ) {
            // 写入文件字节
            outputStream.write(FileUtil.readBytes(file));
        } catch (IOException e) {
            throw BizException.of("文件下载失败");
        }

    }


}




