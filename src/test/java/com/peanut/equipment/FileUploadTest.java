package com.peanut.equipment;

import com.peanut.Equipment.service.FileUploadService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class FileUploadTest {

	@Resource
	private FileUploadService	fileUploadService;

	/*
	* 删除
	* */
	@Test
	public void test() {
		Map<String, Object> map = new HashMap<>();
		map.put("createTime", LocalDateTime.of(2024, 11, 14, 11, 8, 1));
		fileUploadService.removeByMap(map);
	}
}
