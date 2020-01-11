CREATE TABLE IF NOT EXISTS `poc_order` (
  `order_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'order_id',
  `order_code` VARCHAR DEFAULT '' COMMENT '标题',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `update_time` DATETIME NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`order_id`))
ENGINE = InnoDB
COMMENT = '分布式事务验证表';