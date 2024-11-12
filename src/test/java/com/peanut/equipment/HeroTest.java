package com.peanut.equipment;

import cn.hutool.core.io.FileUtil;
import com.peanut.Equipment.domain.entity.FileUpload;
import com.peanut.Equipment.domain.entity.Hero;
import com.peanut.Equipment.domain.entity.HeroSkill;
import com.peanut.Equipment.service.FileUploadService;
import com.peanut.Equipment.service.HeroService;
import com.peanut.Equipment.service.HeroSkillService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.Objects;

@SpringBootTest
public class HeroTest {

	@Resource
	private FileUploadService fileUploadService;
	@Resource
	private HeroService heroService;
	@Resource
	private HeroSkillService heroSkillService;

	/*
	* 添加英雄和英雄技能
	* */
	@Test
	public void test() {
		String path = "E:\\java\\test_img\\hero";
		File fileDir = FileUtil.file(path);

		for(File file : Objects.requireNonNull(fileDir.listFiles())) {
			Hero hero = new Hero();
			for(File file1 : Objects.requireNonNull(file.listFiles())) {
				if (file1.isFile()) {
					Long heroImgId = fileUploadService.upload(file1);
					hero.setImgFileId(heroImgId);
					hero.setName(file.getName());
					heroService.save(hero);
				}
			}

			for (File file1 : Objects.requireNonNull(file.listFiles())) {
				if (file1.isDirectory()) {
					for (File file2 : Objects.requireNonNull(file1.listFiles())) {
						Long skillImgId = fileUploadService.upload(file2);
						HeroSkill heroSkill = new HeroSkill();
						heroSkill.setImgFileId(skillImgId);
						heroSkill.setHeroId(hero.getId());
						heroSkill.setName(FileUtil.mainName(file2.getName()));
						heroSkillService.save(heroSkill);
					}
				}
			}
		}
	}
}
