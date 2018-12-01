/*
 Navicat Premium Data Transfer

 Source Server         : 老杨
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : testcopy

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 01/12/2018 21:35:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for info
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info`  (
  `id` int(7) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(800) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of info
-- ----------------------------
INSERT INTO `info` VALUES (1779035, 'Filter', 'Filter 技术是servlet 2.3 [1]  新增加的功能。servlet2.3是sun公司 [2]  于2000年10月发布的，它的开发者包括许多个人和公司团体，充分体现了sun公司所倡导的代码开放性原则。在众多参与者的共同努力下，servlet2.3比以往功能都强大了许多，而且性能也有了大幅提高。     ', '2018-12-01 20:33:00');
INSERT INTO `info` VALUES (1781015, '装载规则', '装载规则，即货物在集装箱或箱式火车等容器中以何种方式装载，多用于外贸或承重能力设置物流货代等行业。常见的装载规则有：货物方向设置规则、最大堆码层数、承重能力设置规则、悬空处理规则等。', '2018-12-01 20:43:00');
INSERT INTO `info` VALUES (1781063, '服务器', '服务器，也称伺服器，是提供计算服务的设备。由于服务器需要响应服务请求，并进行处理，因此一般来说服务器应具备承担服务并且保障服务的能力。\r\n服务器的构成包括处理器、硬盘、内存、系统总线等，和通用的计算机架构类似，但是由于需要提供高可靠的服务，因此在处理能力、稳定性、可靠性、安全性、可扩展性、可管理性等方面要求较高。\r\n在网络环境下，根据服务器提供的服务类型不同，分为文件服务器、数据库服务器、应用程序服务器、WEB服务器等。 ', '2018-12-01 20:44:00');
INSERT INTO `info` VALUES (1781112, '引用计数', '引用计数是计算机编程语言中的一种内存管理技术，是指将资源（可以是对象、内存或磁盘空间等等）的被引用次数保存起来，当被引用次数变为零时就将其释放的过程。使用引用计数技术可以实现自动资源管理的目的。同时引用计数还可以指使用引用计数技术回收未使用资源的垃圾回收算法。', '2018-12-01 20:44:00');
INSERT INTO `info` VALUES (1781152, '总线', '总线（Bus）是计算机各种功能部件之间传送信息的公共通信干线，它是由导线组成的传输线束， 按照计算机所传输的信息种类，计算机的总线可以划分为数据总线、地址总线和控制总线，分别用来传输数据、数据地址和控制信号。总线是一种内部结构，它是cpu、内存、输入、输出设备传递信息的公用通道，主机的各个部件通过总线相连接，外部设备通过相应的接口电路再与总线相连接，从而形成了计算机硬件系统。在计算机系统中，各个部件之间传送信息的公共通路叫总线，微型计算机是以总线结构来连接各个功能部件的。  ', '2018-12-01 20:45:00');
INSERT INTO `info` VALUES (1781292, '微型计算机', '微型计算机简称“微型机”、“微机”，由于其具备人脑的某些功能，所以也称其为“微电脑”。微型计算机是由大规模集成电路组成的、体积较小的电子计算机。它是以微处理器为基础，配以内存储器及输入输出(I/0)接口电路和相应的辅助电路而构成的裸机。', '2018-12-01 20:48:00');
INSERT INTO `info` VALUES (1781341, '微处理器', '微处理器由一片或少数几片大规模集成电路组成的中央处理器。这些电路执行控制部件和算术逻辑部件的功能。\r\n微处理器能完成取指令、执行指令，以及与外界存储器和逻辑部件交换信息等操作，是微型计算机的运算控制部分。它可与存储器和外围电路芯片组成微型计算机。', '2018-12-01 20:48:00');
INSERT INTO `info` VALUES (1781386, '软盘', '软盘（Floppy Disk）是个人计算机（PC）中最早使用的可移介质。软盘的读写是通过软盘驱动器完成的。软盘驱动器设计能接收可移动式软盘，目前常用的就是容量为1.44MB的3.5英寸软盘。\r\n软盘存取速度慢，容量也小，但可装可卸、携带方便。作为一种可移贮存方法，它是用于那些需要被物理移动的小文件的理想选择。\r\n软盘在早期计算机上必备的一个硬件，也是计算机上面最早使用的可移介质。软盘英文缩写是FIoppy Disk，它作为一种可移储存硬件适用于一些需要被物理移动的小文件，软盘的读写是用过软驱也就是软盘驱动器来完成的。', '2018-12-01 20:49:00');
INSERT INTO `info` VALUES (1781479, '扇区', '磁盘上的每个磁道被等分为若干个弧段，这些弧段便是磁盘的扇区。硬盘的读写以扇区为基本单位。', '2018-12-01 20:51:00');

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login`  (
  `tel` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time` datetime(2) NULL COMMENT '错误登陆的时间',
  `count` int(3) NULL DEFAULT NULL,
  PRIMARY KEY (`tel`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('13000000000', '2018-12-01 20:02:50.00', 0);
INSERT INTO `login` VALUES ('13260905990', '2018-12-01 20:02:59.00', 0);
INSERT INTO `login` VALUES ('13260906133', '2018-12-01 17:08:00.00', 0);
INSERT INTO `login` VALUES ('13260906172', '2018-12-01 20:42:43.00', 0);
INSERT INTO `login` VALUES ('13260906173', '2018-12-01 17:07:54.00', 7);
INSERT INTO `login` VALUES ('13260906175', '2018-12-01 20:09:36.00', 0);
INSERT INTO `login` VALUES ('13260906178', '2018-12-01 16:51:54.00', 0);
INSERT INTO `login` VALUES ('18652952310', '2018-12-01 17:10:39.00', 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tel` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('98f6bcd4621d373cade4e832627b4f6', '13260906172');
INSERT INTO `user` VALUES ('81dc9bdb52d04dc20036dbd8313ed055', '13260906122');
INSERT INTO `user` VALUES ('98f6bcd4621d373cade4e832627b4f6', '13260905990');
INSERT INTO `user` VALUES ('98f6bcd4621d373cade4e832627b4f6', '13260906173');
INSERT INTO `user` VALUES ('98f6bcd4621d373cade4e832627b4f6', '18652952310');
INSERT INTO `user` VALUES ('98f6bcd4621d373cade4e832627b4f6', '13260906175');

-- ----------------------------
-- Table structure for validate
-- ----------------------------
DROP TABLE IF EXISTS `validate`;
CREATE TABLE `validate`  (
  `tel` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `yzm` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '存入点击获取手机验证码所获得的验证码',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '存入点击获取手机验证码按钮时当时的时间，一分钟后如果点击验证按钮时间减去time超过了一分钟禁止登陆',
  PRIMARY KEY (`tel`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of validate
-- ----------------------------
INSERT INTO `validate` VALUES ('13260905990', '431998', '2018-12-01 13:26:00');
INSERT INTO `validate` VALUES ('13260906170', '452709', '2018-12-01 14:35:41');
INSERT INTO `validate` VALUES ('13260906172', '556974', '2018-12-01 20:04:32');
INSERT INTO `validate` VALUES ('13260906173', '187235', '2018-12-01 15:31:07');
INSERT INTO `validate` VALUES ('13260906175', '131586', '2018-12-01 20:05:39');
INSERT INTO `validate` VALUES ('18652952310', '578385', '2018-12-01 17:09:55');

SET FOREIGN_KEY_CHECKS = 1;
