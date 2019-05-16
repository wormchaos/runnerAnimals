-- 活动表
CREATE TABLE `t_activity` (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `admin_user_id` bigint(20) DEFAULT NULL COMMENT '发起人用户id',
  `active` tinyint(2) NOT NULL DEFAULT 0 COMMENT '是否激活活动 0 待激活 1 激活 2结束',
  `activity_begin_time` datetime NOT NULL DEFAULT NULL COMMENT '活动开始时间',
  `activity_end_time` datetime NOT NULL DEFAULT NULL COMMENT '活动结束时间',
  `activity_abort_time` datetime NOT NULL DEFAULT NULL COMMENT '活动实际结束时间',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_user` varchar(50) NOT NULL DEFAULT 'system' COMMENT '创建人',
  `update_user` varchar(50) NOT NULL DEFAULT 'system' COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动表';

-- 用户表
CREATE TABLE `t_user` (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `open_id` varchar(255) NOT NULL DEFAULT '' COMMENT '用户微信ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_user` varchar(50) NOT NULL DEFAULT 'system' COMMENT '创建人',
  `update_user` varchar(50) NOT NULL DEFAULT 'system' COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
