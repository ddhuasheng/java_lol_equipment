package com.peanut.Equipment.controller;

import com.peanut.Equipment.domain.vo.ResultVO;
import com.peanut.Equipment.service.FileUploadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/v1/file")
@Tag(name = "文件管理")
public class fileController {
    @Resource
    private FileUploadService fileUploadService;

    @Operation(summary = "文件上传 - 返回文件id")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResultVO<Long> upload(@RequestPart MultipartFile file) {
        long fileId = fileUploadService.upload(file);

        return ResultVO.success(fileId);
    }

    @Operation(summary = "文件上传 - 返回文件预览地址")
    @PostMapping(value = "/upload1", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResultVO<String> upload1(@RequestPart MultipartFile file) {
        String url = fileUploadService.upload1(file);
        return ResultVO.success(url);
    }

    @Operation(summary = "文件下载")
    @GetMapping("/download/{fileId}")
    public void download(@PathVariable Long fileId, HttpServletResponse response) {
        fileUploadService.download(fileId, response);

    }

}
