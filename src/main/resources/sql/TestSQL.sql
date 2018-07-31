SELECT * FROM phonedb.user WHERE lastLogin = (SELECT max(lastLogin) FROM phonedb.user group by userName);

SELECT * FROM phonedb.user WHERE lastLogin IN 
	(SELECT max(lastLogin) FROM phonedb.user group by userName);



SELECT * FROM phonedb.STAT;

SELECT * FROM phonedb.STAT WHERE lastLogin IN 
	(SELECT max(lastLogin) FROM phonedb.STAT group by userName);


SELECT * FROM phonedb.STAT group by userName;

/*
SELECT * FROM phonedb.STAT group by userName;

CREATE TABLE `STAT` (
  `userName` varchar(255) NOT NULL,
  `lastLogin` datetime(6) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO phonedb.STAT (userName, lastLogin, password, role) 
values ('Dawid', '2018-07-30 00:00:00.0', 'passwordValue', 'Admin');
INSERT INTO phonedb.STAT (userName, lastLogin, password, role) 
values ('Dawid', '2018-07-31 00:00:00.0', 'passwordValue', 'Admin');

INSERT INTO phonedb.STAT (userName, lastLogin, password, role) 
values ('Czeslaw', '2018-06-10 00:00:00.0', 'passwordValue', 'Admin');
INSERT INTO phonedb.STAT (userName, lastLogin, password, role) 
values ('Czeslaw', '2018-06-22 00:00:00.0', 'passwordValue', 'Admin');

INSERT INTO phonedb.STAT (userName, lastLogin, password, role) 
values ('Piotr', '2017-06-10 00:00:00.0', 'passwordValue', 'User');
INSERT INTO phonedb.STAT (userName, lastLogin, password, role) 
values ('Piotr', '2018-06-22 00:00:00.0', 'passwordValue', 'User');
*/

/*
INSERT INTO phonedb.user (userName, lastLogin, password, role) 
values ('Dawid', '2018-07-30 00:00:00.0', 'passwordValue', 'Admin');
INSERT INTO phonedb.user (userName, lastLogin, password, role) 
values ('Dawid', '2018-07-31 00:00:00.0', 'passwordValue', 'Admin');

INSERT INTO phonedb.user (userName, lastLogin, password, role) 
values ('Czeslaw', '2018-06-10 00:00:00.0', 'passwordValue', 'Admin');
INSERT INTO phonedb.user (userName, lastLogin, password, role) 
values ('Czeslaw', '2018-06-22 00:00:00.0', 'passwordValue', 'Admin');
*/