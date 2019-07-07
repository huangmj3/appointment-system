-- 创建数据库
create database if not exists `appointment-system`;
# sql中在英文状态下Tab上方的键，用来标识字符串
use `appointment-system`;

-- 创建图书表
CREATE TABLE `book` (
#     auto_increment自增
                        `book_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '图书ID',
                        `name` varchar(100) NOT NULL COMMENT '图书名称',
                        `number` int(11) NOT NULL COMMENT '馆藏数量',
                        PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='图书表';

-- 初始化图书数据
INSERT INTO `book` (`book_id`, `name`, `number`)
VALUES
(1000, 'Java程序设计', 10),
(1001, '数据结构', 10),
(1002, '设计模式', 10),
(1003, '编译原理', 10);

-- 创建预约图书表
CREATE TABLE `appointment` (
                               `book_id` bigint(20) NOT NULL COMMENT '图书ID',
                               `student_id` bigint(20) NOT NULL COMMENT '学号',
#                               初值为current_timestamp,并随update语句进行更新
                               `appoint_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '预约时间' ,
                               PRIMARY KEY (`book_id`, `student_id`),
                               INDEX `idx_appoint_time` (`appoint_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='预约图书表';
