/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost
 Source Database       : atlantic2

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : utf-8

 Date: 09/13/2017 10:49:38 AM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `user_1`
-- ----------------------------
DROP TABLE IF EXISTS `user_1`;
CREATE TABLE `user_1` (
  `id` varchar(20) NOT NULL,
  `user_id` varchar(30) DEFAULT NULL,
  `user_name` varchar(10) NOT NULL,
  `user_psd` varchar(30) NOT NULL,
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `comment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `user_2`
-- ----------------------------
DROP TABLE IF EXISTS `user_2`;
CREATE TABLE `user_2` (
  `id` varchar(20) NOT NULL,
  `user_id` varchar(30) DEFAULT NULL,
  `user_name` varchar(10) NOT NULL,
  `user_psd` varchar(30) NOT NULL,
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `comment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `user_3`
-- ----------------------------
DROP TABLE IF EXISTS `user_3`;
CREATE TABLE `user_3` (
  `id` varchar(20) NOT NULL,
  `user_id` varchar(30) DEFAULT NULL,
  `user_name` varchar(10) NOT NULL,
  `user_psd` varchar(30) NOT NULL,
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `comment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `user_info_1`
-- ----------------------------
DROP TABLE IF EXISTS `user_info_1`;
CREATE TABLE `user_info_1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(255) NOT NULL,
  `phone` int(11) DEFAULT NULL,
  `addr` int(11) DEFAULT NULL,
  `gender` tinyint(4) NOT NULL DEFAULT '0',
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `user_info_2`
-- ----------------------------
DROP TABLE IF EXISTS `user_info_2`;
CREATE TABLE `user_info_2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(255) NOT NULL,
  `phone` int(11) DEFAULT NULL,
  `addr` int(11) DEFAULT NULL,
  `gender` tinyint(4) NOT NULL DEFAULT '0',
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `user_info_3`
-- ----------------------------
DROP TABLE IF EXISTS `user_info_3`;
CREATE TABLE `user_info_3` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(255) NOT NULL,
  `phone` int(11) DEFAULT NULL,
  `addr` int(11) DEFAULT NULL,
  `gender` tinyint(4) NOT NULL DEFAULT '0',
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
