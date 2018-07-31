CREATE TABLE `camera` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Matrix` varchar(10) DEFAULT NULL,
  `Model` varchar(50) NOT NULL,
  `Resolution` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;