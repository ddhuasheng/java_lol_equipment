/*
 Navicat Premium Data Transfer

 Source Server         : hs
 Source Server Type    : MySQL
 Source Server Version : 80403
 Source Host           : localhost:3306
 Source Schema         : lol_demo

 Target Server Type    : MySQL
 Target Server Version : 80403
 File Encoding         : 65001

 Date: 29/11/2024 19:30:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for lol_equipment
-- ----------------------------
DROP TABLE IF EXISTS `lol_equipment`;
CREATE TABLE `lol_equipment`  (
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '装备名称',
  `img_file_id` bigint NOT NULL COMMENT '图标id',
  `id` bigint NOT NULL COMMENT 'id',
  `version` int NOT NULL DEFAULT 0 COMMENT '版本',
  `delete_flag` bigint NOT NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '装备表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for lol_equipment_recommend
-- ----------------------------
DROP TABLE IF EXISTS `lol_equipment_recommend`;
CREATE TABLE `lol_equipment_recommend`  (
  `recommend_type` int NOT NULL COMMENT '推荐类型 1-顺风出装 2-逆风出装',
  `stage` int NOT NULL COMMENT '出装顺序 1-出门装 2-核心装 3-神装',
  `equipment_id` bigint NOT NULL COMMENT '装备id',
  `hero_id` bigint NOT NULL COMMENT '英雄id',
  `id` bigint NOT NULL COMMENT 'id',
  `version` int NOT NULL DEFAULT 0 COMMENT '版本',
  `delete_flag` bigint NOT NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '出装推荐表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for lol_file_upload
-- ----------------------------
DROP TABLE IF EXISTS `lol_file_upload`;
CREATE TABLE `lol_file_upload`  (
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件原名称',
  `filename` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件唯一名称',
  `id` bigint NOT NULL COMMENT 'id',
  `version` int NOT NULL DEFAULT 0 COMMENT '版本',
  `delete_flag` bigint NOT NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '文件上传表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for lol_hero
-- ----------------------------
DROP TABLE IF EXISTS `lol_hero`;
CREATE TABLE `lol_hero`  (
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '英雄名',
  `img_file_id` bigint NOT NULL COMMENT '图标id',
  `id` bigint NOT NULL COMMENT 'id',
  `version` int NOT NULL DEFAULT 0 COMMENT '版本',
  `delete_flag` bigint NOT NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '英雄表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for lol_hero_skill
-- ----------------------------
DROP TABLE IF EXISTS `lol_hero_skill`;
CREATE TABLE `lol_hero_skill`  (
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '技能名称',
  `img_file_id` bigint NOT NULL COMMENT '图标id',
  `hero_id` bigint NOT NULL COMMENT '英雄id',
  `id` bigint NOT NULL COMMENT 'id',
  `version` int NOT NULL DEFAULT 0 COMMENT '版本',
  `delete_flag` bigint NOT NULL DEFAULT 0 COMMENT '删除标记',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '英雄技能表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for lol_user
-- ----------------------------
DROP TABLE IF EXISTS `lol_user`;
CREATE TABLE `lol_user`  (
  `id` bigint NOT NULL COMMENT '主键id',
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `delete_flag` bigint NOT NULL DEFAULT 0 COMMENT '删除标记',
  `version` int NOT NULL COMMENT '版本',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
