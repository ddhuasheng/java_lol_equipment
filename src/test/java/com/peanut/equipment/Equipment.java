package com.peanut.equipment;

import cn.hutool.core.io.FileUtil;
import com.peanut.Equipment.service.EquipmentService;
import com.peanut.Equipment.service.FileUploadService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.Objects;

@SpringBootTest
public class Equipment {

    @Resource
    private FileUploadService fileUploadService;
    @Resource
    private EquipmentService equipmentService;

    @Test
    public void test() {
        String path = "E:\\java\\test_img";
        File file = FileUtil.file(path);
        try {
            for (File listFile : Objects.requireNonNull(file.listFiles())) {
                String mainName = FileUtil.mainName(listFile.getName());
                Long fileId = fileUploadService.upload(listFile);
                com.peanut.Equipment.domain.entity.Equipment equipment = new com.peanut.Equipment.domain.entity.Equipment();
                equipment.setName(mainName);
                equipment.setImgFileId(fileId);
                equipmentService.save(equipment);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
