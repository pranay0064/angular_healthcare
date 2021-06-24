CREATE DATABASE  IF NOT EXISTS `h_management`;
USE `h_management`;


CREATE TABLE `Doctor` (
  `did` int not null AUTO_INCREMENT,
  `dname` varchar(45) DEFAULT NULL unique,
  `emailid` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `specialization` varchar(45) DEFAULT NULL,
  `availability` int default 1,
  slot varchar(45) default NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT = 1;



CREATE TABLE `patient` (
  `pid` int not null,
  `pname` varchar(45) DEFAULT NULL unique,
  `emailid` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `symptoms` varchar(45) DEFAULT NULL,
  `age` int not null,
  `slot1` int default null,
  `slot2` int default null,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

alter table patient add column(prescription text default NULL);

insert into doctor values(1,1,'pranay','mintugarlapati@gmail.com','123456789P','A1','Cardiologist');
insert into doctor values(2,1,'mintu','pranaygarlapati@gmail.com','123456789P','A2','Nuerologist');
insert into doctor values(3,1,'bittu','bittugarlapati@gmail.com','123456789P','A1','Eye');
insert into doctor values(4,1,'ritesh','riteshgarlapati@gmail.com','123456789P','A2','hand');
