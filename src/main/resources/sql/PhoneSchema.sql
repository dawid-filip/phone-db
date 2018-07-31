CREATE TABLE `phone` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Alias` varchar(255) DEFAULT NULL,
  `Batery` smallint(6) DEFAULT NULL,
  `Brand` varchar(85) NOT NULL,
  `InternalMemory` smallint(6) DEFAULT NULL,
  `Model` varchar(85) NOT NULL,
  `Ram` smallint(6) DEFAULT NULL,
  `cameraBackId` bigint(20) DEFAULT NULL,
  `cameraFrontId` bigint(20) DEFAULT NULL,
  `sensorId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK608aqmxrq28obitpoeduau3u1` (`cameraBackId`),
  KEY `FKlgdbpsgnkbk60rmk8n701w97i` (`cameraFrontId`),
  KEY `FKnfifcdoc6flot3or01ifibfh1` (`sensorId`),
  CONSTRAINT `FK608aqmxrq28obitpoeduau3u1` FOREIGN KEY (`cameraBackId`) REFERENCES `camera` (`Id`),
  CONSTRAINT `FKlgdbpsgnkbk60rmk8n701w97i` FOREIGN KEY (`cameraFrontId`) REFERENCES `camera` (`Id`),
  CONSTRAINT `FKnfifcdoc6flot3or01ifibfh1` FOREIGN KEY (`sensorId`) REFERENCES `sensor` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;