CREATE TABLE `customers` (
  `customers_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customers_firstname` varchar(120) DEFAULT NULL,
  `customers_lastname` varchar(120) DEFAULT NULL,
  `customers_phone` varchar(15) DEFAULT NULL,
  `customers_email` varchar(300) DEFAULT NULL,
  `customers_startdate` datetime DEFAULT NULL,
  `fk_customer_types` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`customers_id`),
  KEY `fk_customer_types_idx` (`fk_customer_types`),
  CONSTRAINT `fk_customer_types` FOREIGN KEY (`fk_customer_types`) REFERENCES `customer_types` (`customer_types_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;
