Drop table if exists controls;
CREATE TABLE `controls` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(45) DEFAULT NULL,
  `widget_name` varchar(255) DEFAULT NULL,
  `mi_height` varchar(45) DEFAULT NULL,
  `mi_width` varchar(45) DEFAULT NULL,
  `mi_x` varchar(45) DEFAULT NULL,
  `mi_y` varchar(45) DEFAULT NULL,
  `mi_params` varchar(1000) DEFAULT NULL,
  `zindex` varchar(45) DEFAULT NULL,
  `parent_id` varchar(45) DEFAULT NULL,
  `page_uuid` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uudi_Index` (`uuid`),
  KEY `parent_id_index` (`parent_id`),
  KEY `page_uuid_index` (`page_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
