/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : studentinfo

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 16/03/2020 22:38:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (7, '优秀学生');
INSERT INTO `category` VALUES (8, '家庭变故');
INSERT INTO `category` VALUES (9, '心理问题');
INSERT INTO `category` VALUES (10, '经济困难');
INSERT INTO `category` VALUES (11, '普通');

-- ----------------------------
-- Table structure for clazz
-- ----------------------------
DROP TABLE IF EXISTS `clazz`;
CREATE TABLE `clazz`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `grade` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '年级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of clazz
-- ----------------------------
INSERT INTO `clazz` VALUES (5, '计科181', '2018');
INSERT INTO `clazz` VALUES (6, '软工181', '2018');
INSERT INTO `clazz` VALUES (7, '数据191', '2019');
INSERT INTO `clazz` VALUES (8, '物联191', '2019');
INSERT INTO `clazz` VALUES (9, '通信191', '2019');
INSERT INTO `clazz` VALUES (10, '计科201', '2020');

-- ----------------------------
-- Table structure for college
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of college
-- ----------------------------
INSERT INTO `college` VALUES (8, '信息科学技术学院');
INSERT INTO `college` VALUES (9, '化工学院');
INSERT INTO `college` VALUES (10, '经济与管理学院');
INSERT INTO `college` VALUES (11, '艺术学院');
INSERT INTO `college` VALUES (12, '大数据学院');
INSERT INTO `college` VALUES (13, '数理学院');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (4, '物理系');
INSERT INTO `department` VALUES (5, '数学系');
INSERT INTO `department` VALUES (6, '音乐系');
INSERT INTO `department` VALUES (7, '光电信息工程系');
INSERT INTO `department` VALUES (8, '金融系');
INSERT INTO `department` VALUES (9, '土木工程系');

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES (5, '计算机科学与技术');
INSERT INTO `major` VALUES (6, '数据科学');
INSERT INTO `major` VALUES (7, '应用化学');
INSERT INTO `major` VALUES (8, '物理学');
INSERT INTO `major` VALUES (9, '艺术管理');
INSERT INTO `major` VALUES (10, '软件工程');
INSERT INTO `major` VALUES (11, '经济学');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `sno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `category` int(10) UNSIGNED NOT NULL COMMENT '类别',
  `desc_category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类别描述',
  `clazz` int(10) UNSIGNED NOT NULL COMMENT '班级',
  `department` int(10) UNSIGNED NOT NULL COMMENT '系',
  `major` int(10) UNSIGNED NOT NULL COMMENT '专业',
  `college` int(10) UNSIGNED NOT NULL COMMENT '学院',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系电话',
  `idcard` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地址',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注',
  `photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '照片链接地址',
  PRIMARY KEY (`sno`) USING BTREE,
  INDEX `student_ibfk_1`(`clazz`) USING BTREE,
  INDEX `student_ibfk_2`(`department`) USING BTREE,
  INDEX `student_ibfk_3`(`major`) USING BTREE,
  INDEX `student_ibfk_4`(`college`) USING BTREE,
  INDEX `student_ibfk_5`(`category`) USING BTREE,
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`clazz`) REFERENCES `clazz` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_ibfk_2` FOREIGN KEY (`department`) REFERENCES `department` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_ibfk_3` FOREIGN KEY (`major`) REFERENCES `major` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_ibfk_4` FOREIGN KEY (`college`) REFERENCES `college` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_ibfk_5` FOREIGN KEY (`category`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('0001', '张三', '女', 7, '无', 5, 4, 5, 8, '12345678900', '123456789012345678', '地球', '无123', 'https://www.mapletown.xyz/0001.jpg');
INSERT INTO `student` VALUES ('0002', '李四', '女', 10, '家庭经济困难', 9, 7, 10, 8, '123455678901', '123456789012345679', '地球', '这是一条备注', 'https://www.mapletown.xyz/0002.jpg');
INSERT INTO `student` VALUES ('0003', '小明', '男', 11, '无', 10, 9, 11, 13, '12345678902', '123456789012345671', '火星', '这也是备注', 'https://www.mapletown.xyz/0003.jpg');
INSERT INTO `student` VALUES ('0004', '王五', '男', 9, '无', 8, 5, 9, 11, '12345678909', '123456789012345569', 'aaaaaaaa', '无', 'https://www.mapletown.xyz/0004.jpg');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `tno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信openid',
  `clazz_id` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '行政班级',
  PRIMARY KEY (`tno`) USING BTREE,
  INDEX `clazz`(`clazz_id`) USING BTREE,
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`clazz_id`) REFERENCES `clazz` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('001', '教师1', 'o2e8K4yEtbmY_nBYYlA-3man8HBY', 9);
INSERT INTO `teacher` VALUES ('002', '教师2', NULL, 6);
INSERT INTO `teacher` VALUES ('003', '教师3', NULL, 5);
INSERT INTO `teacher` VALUES ('004', '教师4', NULL, 8);
INSERT INTO `teacher` VALUES ('005', '教师5', NULL, NULL);
INSERT INTO `teacher` VALUES ('006', '教师6', NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '$2a$10$ghOI399AZRpJdXkLbs3gCOWz/3m.xG6SempIutia8ZCN0nKTrw9am');

-- ----------------------------
-- Table structure for status
-- ----------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `status` int(10) NOT NULL COMMENT '状态，1为审核，0为完成审核',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of status
-- ----------------------------
INSERT INTO `status` VALUES (1, 1);

SET FOREIGN_KEY_CHECKS = 1;
