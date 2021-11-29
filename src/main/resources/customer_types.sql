CREATE TABLE `customer_types` (
  `customer_types_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_types_name` varchar(45) DEFAULT NULL,
  `customer_types_description` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`customer_types_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
