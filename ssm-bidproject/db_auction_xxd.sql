/*
Navicat MySQL Data Transfer

Source Server         : sa
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : db_auction_xxd

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2021-01-19 19:56:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_bid_xxd`
-- ----------------------------
DROP TABLE IF EXISTS `t_bid_xxd`;
CREATE TABLE `t_bid_xxd` (
  `BidId_xxd` int NOT NULL AUTO_INCREMENT,
  `userId_xxd` int NOT NULL,
  `GoodsId_xxd` int NOT NULL,
  `BidTime_xxd` datetime NOT NULL,
  `BidPrice_xxd` int NOT NULL,
  PRIMARY KEY (`BidId_xxd`),
  KEY `userId_xxd` (`userId_xxd`),
  KEY `GoodsId_xxd` (`GoodsId_xxd`),
  CONSTRAINT `t_bid_xxd_ibfk_1` FOREIGN KEY (`userId_xxd`) REFERENCES `t_user_xxd` (`UserId_xxd`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_bid_xxd_ibfk_2` FOREIGN KEY (`GoodsId_xxd`) REFERENCES `t_goods_xxd` (`GoodsId_xxd`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_bid_xxd
-- ----------------------------
INSERT INTO `t_bid_xxd` VALUES ('23', '1', '13', '2020-06-09 11:33:49', '600');
INSERT INTO `t_bid_xxd` VALUES ('26', '11', '14', '2020-06-12 15:16:52', '6500');
INSERT INTO `t_bid_xxd` VALUES ('27', '12', '20', '2020-06-12 15:22:35', '67000');
INSERT INTO `t_bid_xxd` VALUES ('28', '12', '14', '2020-06-12 15:23:10', '6666');
INSERT INTO `t_bid_xxd` VALUES ('29', '12', '27', '2020-06-13 11:02:19', '6666');
INSERT INTO `t_bid_xxd` VALUES ('30', '12', '13', '2020-06-14 10:04:10', '650');
INSERT INTO `t_bid_xxd` VALUES ('31', '12', '19', '2020-06-14 10:04:26', '610');
INSERT INTO `t_bid_xxd` VALUES ('32', '12', '21', '2020-06-14 10:04:45', '70000');
INSERT INTO `t_bid_xxd` VALUES ('33', '1', '33', '2020-06-14 10:10:56', '100000');
INSERT INTO `t_bid_xxd` VALUES ('34', '11', '13', '2020-06-14 10:23:24', '666');
INSERT INTO `t_bid_xxd` VALUES ('35', '11', '19', '2020-06-14 10:23:39', '612');
INSERT INTO `t_bid_xxd` VALUES ('36', '11', '20', '2020-06-14 10:23:47', '67100');
INSERT INTO `t_bid_xxd` VALUES ('37', '11', '21', '2020-06-14 10:23:59', '70001');
INSERT INTO `t_bid_xxd` VALUES ('38', '3', '14', '2020-06-14 10:26:05', '6777');
INSERT INTO `t_bid_xxd` VALUES ('39', '3', '20', '2020-06-14 10:26:18', '67111');
INSERT INTO `t_bid_xxd` VALUES ('40', '5', '13', '2020-06-14 10:27:35', '667');
INSERT INTO `t_bid_xxd` VALUES ('41', '5', '14', '2020-06-14 10:27:42', '6778');
INSERT INTO `t_bid_xxd` VALUES ('42', '5', '19', '2020-06-14 10:27:48', '615');
INSERT INTO `t_bid_xxd` VALUES ('43', '15', '14', '2020-06-18 09:05:31', '50000');

-- ----------------------------
-- Table structure for `t_goods_xxd`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_xxd`;
CREATE TABLE `t_goods_xxd` (
  `GoodsId_xxd` int NOT NULL AUTO_INCREMENT,
  `UserId_xxd` int NOT NULL,
  `GoodsName_xxd` varchar(40) NOT NULL,
  `GoodsPrice_xxd` int NOT NULL,
  `GoodsPic_xxd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `GoodsSTime_xxd` date NOT NULL,
  `GoodsETime_xxd` date NOT NULL,
  `GoodsDesc_xxd` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`GoodsId_xxd`),
  KEY `UserId_xxd` (`UserId_xxd`),
  CONSTRAINT `t_goods_xxd_ibfk_1` FOREIGN KEY (`UserId_xxd`) REFERENCES `t_user_xxd` (`UserId_xxd`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_goods_xxd
-- ----------------------------
INSERT INTO `t_goods_xxd` VALUES ('13', '3', '玉器', '500', 'E:\\IMG\\yu2.jpg', '2018-04-27', '2018-05-07', '好看d');
INSERT INTO `t_goods_xxd` VALUES ('14', '3', '梵高油画', '6000', 'E:\\IMG\\yh4.jpg', '2018-04-27', '2018-05-07', '艺术价值高');
INSERT INTO `t_goods_xxd` VALUES ('19', '3', '玉器', '600', 'E:\\IMG\\yu3.jpg', '2018-04-27', '2018-05-07', '摆件');
INSERT INTO `t_goods_xxd` VALUES ('20', '11', '蒙娜丽莎的微笑', '66666', 'E:\\IMG\\smaile.jpg', '2020-06-12', '2022-01-01', '世界著名画作');
INSERT INTO `t_goods_xxd` VALUES ('21', '12', '金银珠宝', '66666', 'E:\\IMG\\jyzb.jpg', '2018-04-27', '2018-05-07', '真金制造');
INSERT INTO `t_goods_xxd` VALUES ('23', '12', '清朝年间观世音', '88888', 'E:\\IMG\\jyzb1.jpg', '2020-05-22', '2021-06-24', '观世音菩萨，祈福保佑！');
INSERT INTO `t_goods_xxd` VALUES ('24', '1', '将军油画', '8888', 'E:\\IMG\\yh21.jpg', '2020-06-12', '2020-05-10', '世界著名油画');
INSERT INTO `t_goods_xxd` VALUES ('25', '1', '翡翠玉佩', '1888', 'E:\\IMG\\yu01.jpg', '2020-01-10', '2022-02-12', '精品良制');
INSERT INTO `t_goods_xxd` VALUES ('26', '1', '璀璨宝壶', '6666', 'E:\\IMG\\jyzb.jpg', '2020-01-12', '2022-11-13', '摆放在家里，高大尚！');
INSERT INTO `t_goods_xxd` VALUES ('27', '1', '万马奔腾油画', '5555', 'E:\\IMG\\yh12.jpg', '2020-01-01', '2022-01-01', '具有很高的艺术收藏价值！');
INSERT INTO `t_goods_xxd` VALUES ('29', '1', '白衣女油画', '8888', 'E:\\IMG\\yh0.jpg', '2020-02-21', '2020-01-01', '值得收藏');
INSERT INTO `t_goods_xxd` VALUES ('31', '1', '汉堡', '12', 'E:\\IMG\\kc.PNG', '2018-04-27', '2018-05-07', '12');
INSERT INTO `t_goods_xxd` VALUES ('32', '12', '唐宫仕女图', '6665', 'E:\\IMG\\tgsnt.jpg', '2020-05-27', '2020-08-07', '收藏价值高');
INSERT INTO `t_goods_xxd` VALUES ('33', '12', '清明上河图', '99999', 'E:\\IMG\\picqmsht.jpg', '2020-05-27', '2020-08-07', '著名画作');

-- ----------------------------
-- Table structure for `t_user_xxd`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_xxd`;
CREATE TABLE `t_user_xxd` (
  `UserId_xxd` int NOT NULL AUTO_INCREMENT,
  `UserName_xxd` varchar(50) NOT NULL,
  `pwd_xxd` varchar(50) NOT NULL,
  `tel_xxd` varchar(50) NOT NULL,
  `email_xxd` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `address_xxd` varchar(50) NOT NULL,
  `Credit_xxd` int NOT NULL,
  PRIMARY KEY (`UserId_xxd`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_user_xxd
-- ----------------------------
INSERT INTO `t_user_xxd` VALUES ('1', '123', '1', '13875576918', '', '123', '0');
INSERT INTO `t_user_xxd` VALUES ('3', '1', '1', '123456789', '1111', '湖南长沙工业职院', '0');
INSERT INTO `t_user_xxd` VALUES ('5', '张三', '123', '123', '123', '123', '0');
INSERT INTO `t_user_xxd` VALUES ('6', '王五', '123', '13875576918', '2856854@qq.com', '翻斗公园', '0');
INSERT INTO `t_user_xxd` VALUES ('10', '赵六', '1', '1', '1', '1', '0');
INSERT INTO `t_user_xxd` VALUES ('11', '张其乐', '1', '1', '1', '1', '0');
INSERT INTO `t_user_xxd` VALUES ('12', '胡三汉', '1', '66666', '55555', '北京天安门广场', '0');
INSERT INTO `t_user_xxd` VALUES ('15', '胡二', '1', '112332123', '1', '湖南工业职院', '0');
INSERT INTO `t_user_xxd` VALUES ('16', '石总', '123', '123456', '123', '123', '0');
