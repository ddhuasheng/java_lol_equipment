package com.peanut.equipment;

import cn.hutool.core.io.FileUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.peanut.Equipment.domain.entity.Equipment;
import com.peanut.Equipment.service.EquipmentService;
import com.peanut.Equipment.service.FileUploadService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.*;

@SpringBootTest
public class EquipmentTest {

	@Resource
	private FileUploadService fileUploadService;
	@Resource
	private EquipmentService equipmentService;

	/*
	 * 添加装备
	 * */
	@Test
	public void test() {
		String path = "E:\\java\\test_img\\Equipment";
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

	/*
	 * 批量添加装备
	 * */
	@Test
	public void test2() {
		String path = "E:\\java\\test_img\\Equipment";
		File file = FileUtil.file(path);
		ArrayList<com.peanut.Equipment.domain.entity.Equipment> equipmentList = new ArrayList<>();
		try {
			for (File listFile : Objects.requireNonNull(file.listFiles())) {
				String mainName = FileUtil.mainName(listFile.getName());
				Long fileId = fileUploadService.upload(listFile);
				com.peanut.Equipment.domain.entity.Equipment equipment = new com.peanut.Equipment.domain.entity.Equipment();
				equipment.setName(mainName);
				equipment.setImgFileId(fileId);
				equipmentList.add(equipment);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		equipmentService.saveBatch(equipmentList, 8);
	}

	/*
	 * 测试装备 单个查询
	 * */
	@Test
	public void test3() {
		// getById
		Equipment equipment = equipmentService.getById(1856977117099651074L);
		System.out.println(equipment);

		// getOne, 如果结果又多个会抛出异常
		QueryWrapper<Equipment> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("name", "公理圆弧");
		Equipment one = equipmentService.getOne(queryWrapper);
		System.out.println("Equipment found: {}" + one);

		// getOne false, 如果有多个结果不会抛出异常, 并且查询出第一个
		QueryWrapper<Equipment> queryWrapper1 = new QueryWrapper<>();
		queryWrapper1.like("name", "兰德里");
		Equipment one1 = equipmentService.getOne(queryWrapper1, false);
		System.out.println("Equipment found false: {}" + one1);

		// getMap
		QueryWrapper<Equipment> queryWrapper2 = new QueryWrapper<>();
		queryWrapper2.eq("name", "无用大棒");
		Map<String, Object> map = equipmentService.getMap(queryWrapper2);
		System.out.println("Equipment found map: {}" + map);

		/*getObj
		QueryWrapper<Equipment> queryWrapper3 = new QueryWrapper<>();
		queryWrapper3.eq("name", "凛冬之临");
		Object EquipmentName = equipmentService.getObj(queryWrapper3, obj -> ((Equipment) obj).getName());
		System.out.println("Equipment found equipmentId: {}" + EquipmentName);*/
	}

	/*
	 * 查询装备列表
	 * */
	@Test
	public void test4() {
		// 无参list查询
		List<Equipment> list = equipmentService.list();
		// list.forEach(System.out::println);
		System.out.println("Equipment size: " + list.size());

		// 带参list查询
		QueryWrapper<Equipment> queryWrapper = new QueryWrapper<>();
		queryWrapper.between("id", 1856977117300977670L, 1856977117300977692L);
		List<Equipment> list1 = equipmentService.list(queryWrapper);
		// list1.forEach(System.out::println);

		// listByIds查询
		List<Long> ids = list1.stream().map(Equipment::getId).toList();
		List<Equipment> equipment = equipmentService.listByIds(ids);
		// equipment.forEach(System.out::println);

		// listByMap查询
		Map<String, Object> map = new HashMap<>();
		map.put("name", "兰德里的折磨");
		List<Equipment> equipment1 = equipmentService.listByMap(map);
		System.out.println("equipment found: {} " + equipment1);

		// listMaps查询
		List<Map<String, Object>> maps = equipmentService.listMaps();
		for (Map<String, Object> mapItem : maps) {
			System.out.print(mapItem.get("name") + ",");
		}
	}

	/*
	 * 查询装备分页
	 * */
	@Test
	public void test5() {
		// page查询
		IPage<Equipment> page = new Page<>(1, 10);
		IPage<Equipment> equipmentPage = equipmentService.page(page);
		List<Equipment> equipmentList = equipmentPage.getRecords();
		equipmentList.forEach(System.out::println);
		System.out.println("equipment total: " + equipmentPage.getTotal());

		// 带参page查询
		QueryWrapper<Equipment> queryWrapper = new QueryWrapper<>();
		queryWrapper.gt("id", 1856977117300977692L);
		IPage<Equipment> equipmentPage1 = equipmentService.page(page, queryWrapper);
		List<Equipment> equipmentList1 = equipmentPage1.getRecords();
		equipmentList1.forEach(e -> System.out.println(e.getName()));

		// pageMaps
		IPage<Map<String, Object>> equipmentMaps = equipmentService.pageMaps(new Page<>(1, 10));
		List<Map<String, Object>> records = equipmentMaps.getRecords();

		records.forEach(map -> {
			System.out.println(map.get("id"));
		});

		long count = equipmentService.count();
		System.out.println("count is: " + count);
	}

	/*
	* 删除 保存 更新
	* */
	@Test
	public void test6() {
		Equipment equipment = new Equipment();
		equipment.setName("测试装备");
		equipment.setImgFileId(21L);
		boolean save = equipmentService.save(equipment);
		if (save) {
			System.out.println("save success");
		} else {
			System.out.println("save fail");
		}
	}
}
