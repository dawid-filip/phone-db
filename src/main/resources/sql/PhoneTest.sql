CREATE TABLE `phone` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `BrandOfPhone` varchar(100) NOT NULL,
  `MoodelOfPhone` varchar(100) NOT NULL,
  `premierePrice` decimal(10,2) DEFAULT NULL,
  `PriceOfPhone` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;