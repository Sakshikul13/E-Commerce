CREATE DATABASE  IF NOT EXISTS `users_directory`;
USE `users_directory`;
--
-- Table structure for table `employee`
--

DROP TABLE `users`;


CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) ,
  `last_name` varchar(45) ,
  `email` varchar(45),
  password varchar(30),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `user` VALUES 
	(1,'Leslie','Andrews','leslie@luv2code.com','les@123'),
	(2,'Emma','Baumgarten','emma@luv2code.com', 'emma@123'),
	(3,'Avani','Gupta','avani@luv2code.com', 'ava@123'),
	(4,'Yuri','Petrov','yuri@luv2code.com', 'yuri@123'),
	(5,'Juan','Vega','juan@luv2code.com', 'juan@123');
    
select * from user;

CREATE TABLE `sellers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) ,
  `last_name` varchar(45) ,
  `email` varchar(45),
  password varchar(30),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `sellers` VALUES 
	(1,'Leslie','Andrews','leslie@luv2code.com','les@123'),
	(2,'Emma','Baumgarten','emma@luv2code.com', 'emma@123'),
	(3,'Avani','Gupta','avani@luv2code.com', 'ava@123'),
	(4,'Yuri','Petrov','yuri@luv2code.com', 'yuri@123'),
	(5,'Juan','Vega','juan@luv2code.com', 'juan@123');

select * from sellers;

CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) ,
  `last_name` varchar(45) ,
  `email` varchar(45),
  password varchar(30),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `admin` VALUES 
	(1,'Leslie','Andrews','leslie@luv2code.com','les@123'),
	(2,'Emma','Baumgarten','emma@luv2code.com', 'emma@123'),
	(3,'Avani','Gupta','avani@luv2code.com', 'ava@123'),
	(4,'Yuri','Petrov','yuri@luv2code.com', 'yuri@123'),
	(5,'Juan','Vega','juan@luv2code.com', 'juan@123');

select * from admin;

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL ,
  `password` varchar(50) NOT NULL ,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;

INSERT INTO `users` VALUES 
	('vinay', '{noop}test123', 1),
    ('yesh', '{noop}test123', 1),
    ('sakshi', '{noop}test123', 1)
	;
    
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `authorities` 
VALUES 
('vinay','ROLE_USER'),
('sakshi','ROLE_USER'),
('yesh','ROLE_SELLER'),
('vinay','ROLE_SELLER'),
('vinay','ROLE_ADMIN');

select * from users;

select * from authorities;