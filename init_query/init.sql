
CREATE TABLE IF NOT EXISTS `doctor` (
  `consultationFees` double DEFAULT NULL,
  `doctorId` varchar(255) DEFAULT NULL,
  `experience` int(11) DEFAULT NULL,
  `maximumPatientPerSlot` int(11) DEFAULT NULL,
  `qualification` varchar(255) DEFAULT NULL,
  `specialization` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FKB0EF911FFAB20CE4` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `doctor` (`consultationFees`, `doctorId`, `experience`, `maximumPatientPerSlot`, `qualification`, `specialization`, `status`, `user_id`) VALUES
(150, 'UHCD01', 5, 10, 'MBBS MS', 'Cardiology', 'Working', 1),
(200, 'UHCD02', 10, 10, 'MBBS MS', 'Dermatology', 'Working', 2),
(150, 'UHCD03', 9, 10, 'MBBS MD', 'Gynecology', 'Working', 3),
(150, 'UHCD04', 9, 10, 'MBBS MD', 'Immunology', 'Working', 4),
(200, 'UHCD05', 10, 10, 'MBBS MD', 'Pediatrics', 'Not Working', 5);


CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `blood_group` varchar(255) DEFAULT NULL,
  `contact_no` varchar(255) DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;


INSERT INTO `user` (`id`, `age`, `blood_group`, `contact_no`, `dob`, `email`, `name`, `password`, `username`) VALUES
(1, 34, 'O+ve', '8965230147', '1985-05-05 00:00:00', 'clay@gmail.com', 'Clay', 'Clay', 'Clay'),
(2, 27, 'A+ve', '7896541230', '1993-05-25 00:00:00', 'Will', 'Will', 'Will', 'Will'),
(3, 25, 'B+ve', '7412589630', '1995-03-25 00:00:00', 'Joyce', 'Joyce', 'Joyce', 'Joyce'),
(4, 27, 'AB+ve', '8523697410', '1992-06-21 00:00:00', 'Hooper', 'Hopper', 'Hopper', 'Hopper'),
(5, 25, 'B+ve', '7536984120', '1995-06-21 00:00:00', 'Jane', 'Jane', 'Jane', 'Jane'),
(6, 49, 'AB+ve', '9512368740', '1970-08-15 00:00:00', 'Micheal', 'Micheal', 'Micheal', 'Micheal'),
(7, 49, 'AB+ve', '9512368740', '1970-09-15 00:00:00', 'Lucas', 'Lucas', 'Lucas', 'Lucas'),
(8, 50, 'AB+ve', '7863254190', '1969-09-15 00:00:00', 'Dustin', 'Dustin', 'Dustin', 'Dustin');


