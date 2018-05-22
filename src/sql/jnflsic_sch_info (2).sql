-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 22, 2018 at 05:48 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `jnflsic_sch_info`
--
CREATE DATABASE IF NOT EXISTS `jnflsic_sch_info` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `jnflsic_sch_info`;

-- --------------------------------------------------------

--
-- Table structure for table `ic_admin`
--

DROP TABLE IF EXISTS `ic_admin`;
CREATE TABLE IF NOT EXISTS `ic_admin` (
`adminID` int(11) NOT NULL,
  `adminName` varchar(20) DEFAULT NULL,
  `adminPassword` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Truncate table before insert `ic_admin`
--

TRUNCATE TABLE `ic_admin`;
--
-- Dumping data for table `ic_admin`
--

INSERT INTO `ic_admin` (`adminID`, `adminName`, `adminPassword`) VALUES
(1, 'shen', '20cc88d2e204ffa768509d33fa882492');

-- --------------------------------------------------------

--
-- Table structure for table `ic_area`
--

DROP TABLE IF EXISTS `ic_area`;
CREATE TABLE IF NOT EXISTS `ic_area` (
`AreaID` int(11) NOT NULL,
  `AreaName` varchar(128) CHARACTER SET utf8 NOT NULL,
  `AreaCountry` varchar(128) CHARACTER SET utf8 NOT NULL,
  `AreaDescription` text CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Truncate table before insert `ic_area`
--

TRUNCATE TABLE `ic_area`;
-- --------------------------------------------------------

--
-- Table structure for table `ic_course`
--

DROP TABLE IF EXISTS `ic_course`;
CREATE TABLE IF NOT EXISTS `ic_course` (
  `courseID` int(11) NOT NULL,
  `courseName` varchar(128) CHARACTER SET utf8 NOT NULL,
  `courseDescription` text CHARACTER SET utf8 NOT NULL,
  `courseActive` tinyint(1) NOT NULL,
  `courseValue` tinyint(4) NOT NULL,
  `coursePreReq` varchar(255) CHARACTER SET utf8 NOT NULL,
  `courseDepartmentID` int(11) NOT NULL,
  `courseArea` varchar(32) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Truncate table before insert `ic_course`
--

TRUNCATE TABLE `ic_course`;
--
-- Dumping data for table `ic_course`
--

INSERT INTO `ic_course` (`courseID`, `courseName`, `courseDescription`, `courseActive`, `courseValue`, `coursePreReq`, `courseDepartmentID`, `courseArea`) VALUES
(3203, 'df', '', 0, 2, '', 3665, 'Advanced Level (AL)'),
(99361, 'dfc', 'asdf', 0, 1, 'asdf', 51, 'Advanced Level (AL)'),
(99780, 'dss', 'fsd', 1, 5, 'sef', 99780, 'Advanced Level (AL)'),
(113717, 'sdf', 'asdf', 1, 2, 'fsd', 3665, 'Advanced Level (AL)'),
(3080244, 'dfas', 'dfsas', 1, 6, 'safd', 101687, 'National Course'),
(99162322, 'hello', '', 0, 1, '', -1, 'N/A');

-- --------------------------------------------------------

--
-- Table structure for table `ic_department`
--

DROP TABLE IF EXISTS `ic_department`;
CREATE TABLE IF NOT EXISTS `ic_department` (
  `depID` int(11) NOT NULL,
  `depName` varchar(128) CHARACTER SET utf8 NOT NULL,
  `depPhone` varchar(16) CHARACTER SET utf8 NOT NULL,
  `depDescription` text CHARACTER SET utf8 NOT NULL,
  `depLeader` text CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Truncate table before insert `ic_department`
--

TRUNCATE TABLE `ic_department`;
--
-- Dumping data for table `ic_department`
--

INSERT INTO `ic_department` (`depID`, `depName`, `depPhone`, `depDescription`, `depLeader`) VALUES
(51, '3', '23', 'afs', 'sfa'),
(3665, 'sd', '324', 'fasd', 'fasd'),
(99425, 'dhe', '4343', 'alkrjaew;fnsd,.cnaea;flj;l', 'dfa;cjx'),
(99780, 'dss', '324', 'fasd', 'asdf'),
(101687, 'fsd', '324', 'fasd', '23erw'),
(101688, 'fsd', '234', 'asfd', 'asfd'),
(113717, 'sdf', '23', '32dfs', '334'),
(3152394, 'fsda', '23', 'afsd', '223wer');

-- --------------------------------------------------------

--
-- Table structure for table `ic_student`
--

DROP TABLE IF EXISTS `ic_student`;
CREATE TABLE IF NOT EXISTS `ic_student` (
  `stuID` int(64) NOT NULL,
  `first_name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `middle_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `last_name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `sex` char(1) CHARACTER SET utf8 NOT NULL,
  `birthdate` date NOT NULL,
  `grade` smallint(6) NOT NULL,
  `enrollYear` smallint(4) NOT NULL,
  `phone` varchar(50) CHARACTER SET utf8 NOT NULL,
  `address` text CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Truncate table before insert `ic_student`
--

TRUNCATE TABLE `ic_student`;
--
-- Dumping data for table `ic_student`
--

INSERT INTO `ic_student` (`stuID`, `first_name`, `middle_name`, `last_name`, `sex`, `birthdate`, `grade`, `enrollYear`, `phone`, `address`) VALUES
(17011924, 'fdfff', 'afss', '43erf', 'm', '2018-05-17', 12, 2016, '3243', '53425'),
(198688928, 'dsf', 'sdffasd', 'afsd', 'm', '2018-05-22', 10, 2016, '2342', 'sdf'),
(282556948, 'sdd', 'asd', 'asdf', 'm', '2018-05-18', 10, 2015, '3423', 'sdfasd'),
(1913628024, 'aa', 'asdf', 'asdf', 'm', '2018-05-09', 12, 2017, '2344', 'asdf'),
(2116642945, 'sdd', 'bbbbb', 'asff', 'm', '2018-05-17', 10, 2016, '324123', '234df');

-- --------------------------------------------------------

--
-- Table structure for table `ic_teacher`
--

DROP TABLE IF EXISTS `ic_teacher`;
CREATE TABLE IF NOT EXISTS `ic_teacher` (
  `teaID` int(11) NOT NULL,
  `teaSurName` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `teaMidName` varchar(20) CHARACTER SET utf8 NOT NULL,
  `teaFirName` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `teaValid` tinyint(1) DEFAULT '0' COMMENT 'true for work',
  `RegDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Truncate table before insert `ic_teacher`
--

TRUNCATE TABLE `ic_teacher`;
--
-- Dumping data for table `ic_teacher`
--

INSERT INTO `ic_teacher` (`teaID`, `teaSurName`, `teaMidName`, `teaFirName`, `teaValid`, `RegDate`) VALUES
(-2061451755, 'shen', 'd', 'md', 1, '2018-04-25 00:00:00'),
(2061451755, 'shen', 'd', 'md', 0, '0000-00-00 00:00:00'),
(2061451756, 'd', 'd', 'd', 0, '0000-00-00 00:00:00'),
(2061451757, 'd', 'dd', 'd', 0, '0000-00-00 00:00:00'),
(2061451758, 'd', 'd', 'd', 1, '0000-00-00 00:00:00'),
(2061451759, 'd', 'dd', 'd', 0, '0000-00-00 00:00:00'),
(2061451760, 'd', 'dd', 'd', 0, '0000-00-00 00:00:00'),
(2061451761, 'd', 'd', 'd', 1, '0000-00-00 00:00:00'),
(2061451762, 'd', 'dd', 'd', 0, '0000-00-00 00:00:00'),
(2061451763, 'd', 'dd', 'd', 0, '0000-00-00 00:00:00'),
(2061451764, 'dfd', 'dfa', 'dsf', 0, '2018-04-26 15:26:48'),
(2061451765, 'd', 'd', 'd', 0, '0000-00-00 00:00:00'),
(2061451766, 'sdfa', 'sadf', 'asdf', 0, '2018-04-26 15:27:05'),
(2061451770, 'd', 'dd', 'd', 0, '0000-00-00 00:00:00'),
(2061451776, 'd', 'dd', 'd', 0, '2018-04-02 00:00:00'),
(2061451783, 'd', 'dd', 'd', 0, '0000-00-00 00:00:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ic_admin`
--
ALTER TABLE `ic_admin`
 ADD PRIMARY KEY (`adminID`);

--
-- Indexes for table `ic_area`
--
ALTER TABLE `ic_area`
 ADD PRIMARY KEY (`AreaID`);

--
-- Indexes for table `ic_course`
--
ALTER TABLE `ic_course`
 ADD PRIMARY KEY (`courseID`), ADD UNIQUE KEY `courseName` (`courseName`);

--
-- Indexes for table `ic_department`
--
ALTER TABLE `ic_department`
 ADD PRIMARY KEY (`depID`);

--
-- Indexes for table `ic_student`
--
ALTER TABLE `ic_student`
 ADD PRIMARY KEY (`stuID`);

--
-- Indexes for table `ic_teacher`
--
ALTER TABLE `ic_teacher`
 ADD PRIMARY KEY (`teaID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ic_admin`
--
ALTER TABLE `ic_admin`
MODIFY `adminID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `ic_area`
--
ALTER TABLE `ic_area`
MODIFY `AreaID` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
