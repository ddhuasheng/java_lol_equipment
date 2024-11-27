package com.peanut.Equipment.service;

import com.peanut.Equipment.domain.entity.FileUpload;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author 86139
 * @description 针对表【lol_file_upload(文件上传表)】的数据库操作Service
 * @createDate 2024-11-10 15:16:09
 */
public interface FileUploadService extends IService<FileUpload> {
  /*
   * 文件上传返回文件id
   * */
  FileUpload upload(MultipartFile file);

  /*
   * 文件上传测试类
   * */
  Long upload(File file);

  /*
  * 文件上传返回url
  * */
  String upload1(MultipartFile file);

  /*
   * 文件下载
   * */
  void download(Long fileId, HttpServletResponse response);

  /*
   * 文件删除
   * */
  void remove(Long id);
}
