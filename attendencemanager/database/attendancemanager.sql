# --------------------------------------------------------
# Host:                         127.0.0.1
# Server version:               5.5.16
# Server OS:                    Win32
# HeidiSQL version:             6.0.0.3603
# Date/time:                    2012-04-15 11:49:22
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

# Dumping database structure for attendancemanager
CREATE DATABASE IF NOT EXISTS `attendancemanager` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `attendancemanager`;


# Dumping structure for table attendancemanager.admin
CREATE TABLE IF NOT EXISTS `admin` (
  `id` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table attendancemanager.admin: ~1 rows (approximately)
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`id`, `password`) VALUES
	('admin', 'attendance');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;


# Dumping structure for table attendancemanager.attendance
CREATE TABLE IF NOT EXISTS `attendance` (
  `entryid` int(10) NOT NULL AUTO_INCREMENT,
  `rollno` varchar(50) DEFAULT NULL,
  `classname` varchar(50) DEFAULT NULL,
  `entrydate` date DEFAULT NULL,
  `faculty` varchar(50) DEFAULT NULL,
  `classyear` varchar(50) DEFAULT NULL,
  `semester` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`entryid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table attendancemanager.attendance: ~0 rows (approximately)
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` (`entryid`, `rollno`, `classname`, `entrydate`, `faculty`, `classyear`, `semester`, `status`) VALUES
	(6, '1', 'B.Tech. Civil', '2012-04-15', 'a', 'I', 'I', 'Present'),
	(7, '2', 'B.Tech. Civil', '2012-04-15', 'a', 'I', 'I', 'Absent'),
	(8, '1', 'B.Tech. Civil', '2012-04-16', 'a', 'I', 'I', 'Present'),
	(9, '2', 'B.Tech. Civil', '2012-04-16', 'a', 'I', 'I', 'Present');
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;


# Dumping structure for table attendancemanager.classdata
CREATE TABLE IF NOT EXISTS `classdata` (
  `entryid` int(10) NOT NULL AUTO_INCREMENT,
  `classname` varchar(50) DEFAULT '0',
  `classyear` varchar(50) DEFAULT '0',
  `semester` varchar(50) DEFAULT '0',
  PRIMARY KEY (`entryid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

# Dumping data for table attendancemanager.classdata: ~6 rows (approximately)
/*!40000 ALTER TABLE `classdata` DISABLE KEYS */;
INSERT INTO `classdata` (`entryid`, `classname`, `classyear`, `semester`) VALUES
	(6, 'B.Tech. Civil', 'I', 'I'),
	(7, 'B.Tech. Civil', 'I', 'II'),
	(8, 'B.Tech. Civil', 'II', 'I'),
	(9, 'B.Tech. Civil', 'II', 'II'),
	(10, 'B.Tech. Civil', 'III', 'I'),
	(11, 'B.Tech. Civil', 'III', 'II');
/*!40000 ALTER TABLE `classdata` ENABLE KEYS */;


# Dumping structure for table attendancemanager.classteacher
CREATE TABLE IF NOT EXISTS `classteacher` (
  `entryid` int(10) NOT NULL AUTO_INCREMENT,
  `faculty` varchar(50) DEFAULT NULL,
  `classname` varchar(50) DEFAULT NULL,
  `classyear` varchar(50) DEFAULT NULL,
  `semester` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`entryid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

# Dumping data for table attendancemanager.classteacher: ~3 rows (approximately)
/*!40000 ALTER TABLE `classteacher` DISABLE KEYS */;
INSERT INTO `classteacher` (`entryid`, `faculty`, `classname`, `classyear`, `semester`) VALUES
	(8, 'b', 'B.Tech. Civil', 'I', 'I'),
	(9, 'a', 'B.Tech. Civil', 'I', 'I'),
	(10, NULL, 'B.Tech. Civil', 'I', 'I');
/*!40000 ALTER TABLE `classteacher` ENABLE KEYS */;


# Dumping structure for table attendancemanager.faculty
CREATE TABLE IF NOT EXISTS `faculty` (
  `entryid` int(10) NOT NULL AUTO_INCREMENT,
  `loginid` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`entryid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

# Dumping data for table attendancemanager.faculty: ~2 rows (approximately)
/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
INSERT INTO `faculty` (`entryid`, `loginid`, `password`, `name`) VALUES
	(7, 'a', 'a', 'a'),
	(8, 'b', 'b', 'b');
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;


# Dumping structure for table attendancemanager.student
CREATE TABLE IF NOT EXISTS `student` (
  `entryid` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT '0',
  `gender` varchar(50) DEFAULT '0',
  `rollno` varchar(50) DEFAULT '0',
  `classname` varchar(50) DEFAULT '0',
  `semester` varchar(50) DEFAULT '0',
  `classyear` varchar(50) DEFAULT '0',
  PRIMARY KEY (`entryid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

# Dumping data for table attendancemanager.student: ~2 rows (approximately)
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`entryid`, `name`, `gender`, `rollno`, `classname`, `semester`, `classyear`) VALUES
	(1, 'a', 'Present', '1', 'B.Tech. Civil', 'I', 'I'),
	(2, 'a', 'Present', '2', 'B.Tech. Civil', 'I', 'I');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
attendancemanagerattendance