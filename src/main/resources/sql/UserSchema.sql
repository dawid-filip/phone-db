CREATE TABLE `user` (
  `userName` varchar(255) NOT NULL,
  `lastLogin` datetime(6) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;