package com.peanut.equipment;

import cn.hutool.core.io.FileUtil;
import com.peanut.Equipment.common.MinioUtil;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;


@SpringBootTest
public class MinioTest {

	@Resource
	private MinioUtil minioUtil;

	@Test
	public void test() throws IOException {
		File file = new File("D:\\java\\code\\尚硅谷Java项目之尚庭公寓\\2.资料\\7.images\\房间-厨房-1.jpg");
		String name = file.getName();
		String mainName = FileUtil.mainName(name);
		String extName = FileUtil.extName(name);
		String filename = mainName + '_' + UUID.randomUUID() + "." + extName;
		String type = Files.probeContentType(file.toPath());
		BufferedInputStream inputStream = FileUtil.getInputStream(file);
		long size = FileUtil.size(file);
		minioUtil.uploadFile(inputStream, size, filename, type);
	}
}
