CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) default null,
  `password` varchar(50) default null,
  `balance` int default 0,
  `idusersubs` bigint(20) default null AUTO_INCREMENT,
  `name` varchar(50) default null,
  `surname` varchar(50) default null,
  `birthday` varchar(50) default null,
  `email` varchar(25) default null,
  `isAdmin` bool default false,
  `address` varchar(255) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `isAdmin` BOOLEAN default NULL,
  `blocked` BOOLEAN default NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1

