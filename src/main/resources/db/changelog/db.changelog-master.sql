-- liquibase formatted sql
-- changeset mawei:1
CREATE TABLE `tenant`
(
    `id`                      int unsigned     NOT NULL AUTO_INCREMENT,
    `create_time`             timestamp        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`             timestamp        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `tenant_name`             varchar(32)      NOT NULL DEFAULT '' COMMENT '租户名称',
    `employee_count`          int unsigned     NOT NULL DEFAULT '0' COMMENT '员工数',
    `activate_employee_count` int unsigned     NOT NULL DEFAULT '0' COMMENT '已激活员工数',
    `create_user`             varchar(32)      NOT NULL DEFAULT '' COMMENT '创建人',
    `is_deleted`              tinyint unsigned NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) COMMENT ='租户';

-- changeset mawei:2
INSERT INTO `tenant`(`tenant_name`,`employee_count`,`activate_employee_count`,`create_user`,`is_deleted`)
VALUES ('mawei','1','1','maw-b','0');
