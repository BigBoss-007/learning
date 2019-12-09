/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : sms

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 09/12/2019 22:41:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for access_token
-- ----------------------------
DROP TABLE IF EXISTS `access_token`;
CREATE TABLE `access_token` (
  `pk_id` varchar(31) COLLATE utf8mb4_bin NOT NULL,
  `token` varchar(127) COLLATE utf8mb4_bin NOT NULL,
  `client_type` varchar(31) COLLATE utf8mb4_bin NOT NULL,
  `access_key` varchar(31) COLLATE utf8mb4_bin NOT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `exp_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`pk_id`),
  UNIQUE KEY `access_token_token_uindex` (`token`),
  KEY `access_token_clientType_access_key_index` (`client_type`,`access_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='token验证表';

-- ----------------------------
-- Records of access_token
-- ----------------------------
BEGIN;
INSERT INTO `access_token` VALUES ('1204047001768022018', '9c8ce286-f830-487e-9e2e-e4c486c3ea51', 'APP', 'root', '2019-12-09 22:35:50', '2019-12-09 22:45:50');
INSERT INTO `access_token` VALUES ('1204047224217128961', '3167a194-3526-4b98-ac55-89159879290f', 'APP', 'root', '2019-12-09 22:36:43', '2019-12-09 22:46:43');
INSERT INTO `access_token` VALUES ('1204047567235706881', 'a357d9e3-8f81-4713-88b8-da29ea4e03f6', 'APP', 'root', '2019-12-09 22:38:05', '2019-12-09 22:48:05');
COMMIT;

-- ----------------------------
-- Table structure for reg_user
-- ----------------------------
DROP TABLE IF EXISTS `reg_user`;
CREATE TABLE `reg_user` (
  `pk_id` varchar(31) COLLATE utf8mb4_bin NOT NULL COMMENT '主键，使用雪花算法生成',
  `client_type` varchar(31) COLLATE utf8mb4_bin NOT NULL DEFAULT 'DEFAULT' COMMENT '客户端类型',
  `access_key` varchar(31) COLLATE utf8mb4_bin NOT NULL COMMENT '认证key',
  `access_secret` varchar(31) COLLATE utf8mb4_bin NOT NULL COMMENT '认证密码，前期为了方便可以使用明文',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '账号状态\n\n0-未启用\n1-启用\n2-已禁用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`pk_id`),
  UNIQUE KEY `reg_user_access_key_uindex` (`access_key`),
  KEY `reg_user_client_type_index` (`client_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='注册用户，即允许使用推送服务的账号';

-- ----------------------------
-- Records of reg_user
-- ----------------------------
BEGIN;
INSERT INTO `reg_user` VALUES ('1', 'APP', 'root', '123456', 1, '2019-12-07 14:19:57', '2019-12-07 14:19:57');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
