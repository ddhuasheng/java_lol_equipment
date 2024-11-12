package com.peanut.Equipment.controller;

import com.peanut.Equipment.domain.vo.ResultVO;
import com.peanut.Equipment.service.FileUploadService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class fileController {
    @Resource
    private FileUploadService fileUploadService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResultVO<Long> upload(@RequestPart MultipartFile file) {
        long fileId = fileUploadService.upload(file);

        return ResultVO.success(fileId);
    }

    @PostMapping(value = "/upload1", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResultVO<String> upload1(@RequestPart MultipartFile file) {
        String url = fileUploadService.upload1(file);
        return ResultVO.success(url);
    }

    @GetMapping("/download/{fileId}")
    public void download(@PathVariable Long fileId, HttpServletResponse response) {
        fileUploadService.download(fileId, response);

    }

}
