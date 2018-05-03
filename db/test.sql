CREATE DATABASE test;
USE test;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `depId` int(11) NOT NULL AUTO_INCREMENT,
  `depName` varchar(255) NOT NULL,
  PRIMARY KEY (`depId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '软件部');
INSERT INTO `department` VALUES ('2', '教师部');
INSERT INTO `department` VALUES ('3', '学生部');
INSERT INTO `department` VALUES ('4', '财务部');
INSERT INTO `department` VALUES ('6', '人事部');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `empId` int(11) NOT NULL AUTO_INCREMENT,
  `empName` varchar(255) NOT NULL,
  `depId` int(11) NOT NULL,
  PRIMARY KEY (`empId`),
  KEY `depId` (`depId`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`depId`) REFERENCES `department` (`depId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', 'zhangsna', '1');
INSERT INTO `employee` VALUES ('2', '李四', '2');
INSERT INTO `employee` VALUES ('3', 'wanger', '3');
INSERT INTO `employee` VALUES ('4', 'haha', '3');
INSERT INTO `employee` VALUES ('5', '王二麻子', '6');

-- ----------------------------
-- Table structure for groups
-- ----------------------------
DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
  `groupId` int(11) NOT NULL AUTO_INCREMENT,
  `groupName` varchar(255) NOT NULL,
  PRIMARY KEY (`groupId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of groups
-- ----------------------------
INSERT INTO `groups` VALUES ('1', '第一组');
INSERT INTO `groups` VALUES ('2', '第二组');
INSERT INTO `groups` VALUES ('3', '第三组');
INSERT INTO `groups` VALUES ('5', 'disizu');

-- ----------------------------
-- Table structure for group_user
-- ----------------------------
DROP TABLE IF EXISTS `group_user`;
CREATE TABLE `group_user` (
  `group_user_id` int(11) NOT NULL AUTO_INCREMENT,
  `groupId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`group_user_id`),
  KEY `groupId` (`groupId`),
  KEY `userId` (`userId`),
  CONSTRAINT `group_user_ibfk_1` FOREIGN KEY (`groupId`) REFERENCES `groups` (`groupId`),
  CONSTRAINT `group_user_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `user2` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group_user
-- ----------------------------
INSERT INTO `group_user` VALUES ('1', '1', '1');
INSERT INTO `group_user` VALUES ('2', '1', '3');
INSERT INTO `group_user` VALUES ('3', '2', '2');
INSERT INTO `group_user` VALUES ('4', '2', '3');

-- ----------------------------
-- Table structure for idcard
-- ----------------------------
DROP TABLE IF EXISTS `idcard`;
CREATE TABLE `idcard` (
  `card_id` int(11) NOT NULL AUTO_INCREMENT,
  `card_num` varchar(255) NOT NULL,
  PRIMARY KEY (`card_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of idcard
-- ----------------------------
INSERT INTO `idcard` VALUES ('4', '66666');
INSERT INTO `idcard` VALUES ('5', '77777');
INSERT INTO `idcard` VALUES ('6', '88888');
INSERT INTO `idcard` VALUES ('15', '99999');
INSERT INTO `idcard` VALUES ('16', '111111');
INSERT INTO `idcard` VALUES ('21', '000000');
INSERT INTO `idcard` VALUES ('22', '000000');
INSERT INTO `idcard` VALUES ('27', '22222222');

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `person_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `card_id` int(11) NOT NULL,
  PRIMARY KEY (`person_id`),
  UNIQUE KEY `card_id` (`card_id`),
  CONSTRAINT `person_ibfk_1` FOREIGN KEY (`card_id`) REFERENCES `idcard` (`card_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('17', 'zhangsan', '22', '4');
INSERT INTO `person` VALUES ('18', 'lisi', '33', '5');
INSERT INTO `person` VALUES ('19', 'wanger', '55', '6');
INSERT INTO `person` VALUES ('21', 'kaka', '77', '15');
INSERT INTO `person` VALUES ('22', 'haha', '43', '16');
INSERT INTO `person` VALUES ('24', 'ccccc', '12', '21');
INSERT INTO `person` VALUES ('25', 'ccccc', '12', '22');
INSERT INTO `person` VALUES ('29', 'xxxx', '21', '27');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `birth` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1019 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1000', 'zhangsna', '123', '12', '2017-10-11 16:23:35');
INSERT INTO `user` VALUES ('1001', '111111', 'wwwwwww', '120', '2017-10-16 17:10:41');
INSERT INTO `user` VALUES ('1002', 'lisi', '123456', '120', '1222-10-10 00:00:00');
INSERT INTO `user` VALUES ('1003', 'lisi1111', '123456', '120', '1999-10-10 00:00:00');
INSERT INTO `user` VALUES ('1006', 'lisi444', '123456', '120', '1999-10-10 00:00:00');
INSERT INTO `user` VALUES ('1007', 'lisi6666', '123456', '120', '1970-01-01 00:00:00');
INSERT INTO `user` VALUES ('1008', 'lisi7777', '123456', '120', '1970-01-01 00:00:00');
INSERT INTO `user` VALUES ('1009', 'lisi9999', '123456', '120', '1970-01-01 00:00:00');
INSERT INTO `user` VALUES ('1012', 'xxxx', 'xxxxxxxx', '123', '1970-01-02 00:00:00');
INSERT INTO `user` VALUES ('1013', '绿麻子', 'zhangxiang', '11', '2017-10-19 00:15:30');
INSERT INTO `user` VALUES ('1015', 'itjob', '123', '12', '1970-01-03 15:33:19');
INSERT INTO `user` VALUES ('1016', '卡卡西', '鸣人', '12', '2017-10-19 11:04:34');
INSERT INTO `user` VALUES ('1017', '123456', '123', '12', '1970-01-14 00:00:00');
INSERT INTO `user` VALUES ('1018', '123456', '123', '12', '1970-01-14 00:00:00');

-- ----------------------------
-- Table structure for user2
-- ----------------------------
DROP TABLE IF EXISTS `user2`;
CREATE TABLE `user2` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user2
-- ----------------------------
INSERT INTO `user2` VALUES ('1', 'zhangsna');
INSERT INTO `user2` VALUES ('2', 'lisi');
INSERT INTO `user2` VALUES ('3', 'waner');
INSERT INTO `user2` VALUES ('4', '王麻子');
INSERT INTO `user2` VALUES ('5', '绿麻子');
INSERT INTO `user2` VALUES ('6', '王麻子');
INSERT INTO `user2` VALUES ('7', '绿麻子');
