CREATE TABLE `sensor` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Accelerometer` bit(1) DEFAULT NULL,
  `AmbientTemperature` bit(1) DEFAULT NULL,
  `Gyroscope` bit(1) DEFAULT NULL,
  `MagneticField` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;