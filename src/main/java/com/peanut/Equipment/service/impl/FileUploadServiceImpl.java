package com.peanut.Equipment.service.impl;

import cn.hutool.core.io.FileUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peanut.Equipment.common.MinioUtil;
import com.peanut.Equipment.domain.entity.FileUpload;
import com.peanut.Equipment.enums.BizCodeEnum;
import com.peanut.Equipment.exception.BizException;
import com.peanut.Equipment.service.FileUploadService;
import com.peanut.Equipment.mapper.FileUploadMapper;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
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

    @Override
    public FileUpload upload(MultipartFile file) {
        String originalFileName = file.getOriginalFilename();
        String mainName = FileUtil.mainName(originalFileName);
        String extName = FileUtil.extName(originalFileName);

        String fileName = mainName + "_" + UUID.randomUUID() + "." + extName;

        MinioUtil.upload(file, fileName, file.getContentType());

        FileUpload fileUpload = new FileUpload();
        fileUpload.setName(originalFileName);
        fileUpload.setFilename(fileName);

        save(fileUpload);

        return fileUpload;
    }

    @Override
    public Long upload(File file) {
        String name = file.getName();
        String mainName = FileUtil.mainName(name);
        String extName = FileUtil.extName(name);
        String filename = mainName + '_' + UUID.randomUUID() + "." + extName;
        try {
            String type = Files.probeContentType(file.toPath());
            BufferedInputStream inputStream = FileUtil.getInputStream(file);
            long size = FileUtil.size(file);

            MinioUtil.uploadFile(inputStream, size, filename, type);
        } catch (IOException e) {
            log.error("获取文件类型出错: {}", e.getMessage());
            throw BizException.of("获取文件类型出错");
        }

        FileUpload fileUpload = new FileUpload();
        fileUpload.setFilename(filename);
        fileUpload.setName(name);
        save(fileUpload);
        return fileUpload.getId();
    }

    @Override
    public String upload1(MultipartFile file) {
        return MinioUtil.getPreviewPath(upload(file).getFilename());
    }

    @Override
    public void download(Long fileId, HttpServletResponse response) {
        FileUpload fileUpload = getById(fileId);

        if (fileUpload == null) {
            throw BizException.of("文件不存在");
        }

        // 把文件输出到响应流
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        // 返回文件名
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileUpload.getName()));
        // 获取输出流
        try {
            InputStream inputStream = MinioUtil.download(fileUpload.getFilename());

            ServletOutputStream outputStream = response.getOutputStream();
            // 写入文件字节
            outputStream.write(inputStream.readAllBytes());
        } catch (IOException e) {
            throw BizException.of("文件下载失败");
        }

    }

    @Override
    public void remove(Long id) {
        FileUpload fileUpload = getById(id);
        if (fileUpload == null) {
            log.error("文件不存在: {}", id);
            throw BizException.of(BizCodeEnum.BAD_REQUEST,"文件不存在");
        }

        MinioUtil.remove(fileUpload.getFilename());
        removeById(id);
    }


}




