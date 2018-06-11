-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 11, 2018 at 03:56 PM
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

-- --------------------------------------------------------

--
-- Table structure for table `ic_admin`
--

CREATE TABLE IF NOT EXISTS `ic_admin` (
`adminID` int(11) NOT NULL,
  `adminName` varchar(20) DEFAULT NULL,
  `adminPassword` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ic_admin`
--

INSERT INTO `ic_admin` (`adminID`, `adminName`, `adminPassword`) VALUES
(1, 'shen', '20cc88d2e204ffa768509d33fa882492'),
(2, 'haha', '21423423'),
(3, 'fasdf', 'fw3rfsdf');

-- --------------------------------------------------------

--
-- Table structure for table `ic_area`
--

CREATE TABLE IF NOT EXISTS `ic_area` (
`AreaID` int(11) NOT NULL,
  `AreaName` varchar(128) CHARACTER SET utf8 NOT NULL,
  `AreaCountry` varchar(128) CHARACTER SET utf8 NOT NULL,
  `AreaDescription` text CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ic_class`
--

CREATE TABLE IF NOT EXISTS `ic_class` (
`classID` int(11) NOT NULL,
  `studentID` int(11) NOT NULL,
  `courseID` int(11) NOT NULL,
  `gradeID` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ic_class`
--

INSERT INTO `ic_class` (`classID`, `studentID`, `courseID`, `gradeID`) VALUES
(1, 17011924, 103, 1),
(2, 198688928, 3203, 1),
(3, 312, 234, 0),
(4, 312, 234, 1),
(9, 2069095245, 3203, 0),
(10, 1913628024, 99377, 0),
(12, 17011924, 972812930, 0),
(17, 1913628024, 972812930, 0),
(18, 1913628024, 3203, 0),
(26, 2116642945, 972812930, 0),
(28, 198688928, 103, 0),
(29, 2069095245, 3262, 0),
(32, 2116642945, 99361, 0),
(33, 17011924, 99361, 0),
(37, 2069095245, 2100038840, 0);

-- --------------------------------------------------------

--
-- Table structure for table `ic_course`
--

CREATE TABLE IF NOT EXISTS `ic_course` (
  `courseID` int(11) NOT NULL,
  `courseName` varchar(128) CHARACTER SET utf8 NOT NULL,
  `courseDescription` text CHARACTER SET utf8 NOT NULL,
  `courseActive` tinyint(1) NOT NULL,
  `courseValue` tinyint(4) NOT NULL,
  `coursePreReq` varchar(255) CHARACTER SET utf8 NOT NULL,
  `courseDepartmentID` int(11) NOT NULL,
  `courseArea` varchar(32) CHARACTER SET utf8 NOT NULL,
  `teacherID` int(11) NOT NULL,
  `max_Students` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ic_course`
--

INSERT INTO `ic_course` (`courseID`, `courseName`, `courseDescription`, `courseActive`, `courseValue`, `coursePreReq`, `courseDepartmentID`, `courseArea`, `teacherID`, `max_Students`) VALUES
(103, 'f', 'asdf', 1, 3, 'sdf', 99780, 'Advanced Level (AL)', 1079421613, 20),
(3203, 'df', '', 0, 2, '', 3665, 'Advanced Level (AL)', 0, 20),
(3262, 'fd', '234', 0, 2, '324', -1, 'Advanced Placement (AP)', -1, 20),
(3665, 'sd', 'fsd', 1, 3, 'fsd', 99425, 'Advanced Placement (AP)', -2061451755, 20),
(99361, 'dfc', 'asdf', 0, 1, 'asdf', 51, 'Advanced Level (AL)', 0, 20),
(99377, 'dfs', 'asdf', 0, 2, 'asdf', 3665, 'Advanced Placement (AP)', -1, 20),
(99780, 'dss', 'fsd', 1, 5, 'sef', 99780, 'Advanced Level (AL)', 0, 20),
(101330, 'fgs', 'sf', 0, 4, 'fas', 99780, 'Advanced Level (AL)', -1, 20),
(113717, 'sdf', 'asdf', 1, 2, 'fsd', 3665, 'Advanced Level (AL)', 0, 20),
(3080244, 'dfas', 'dfsas', 1, 6, 'safd', 101687, 'National Course', 0, 20),
(3152399, 'fsdf', 'sdf', 1, 1, 'sdf', 99425, 'Advanced Level (AL)', -1, 20),
(3525265, 'sddd', '', 0, 3, '', -1, 'Advanced Placement (AP)', -1, 20),
(99162322, 'hello', '', 0, 1, '', -1, 'N/A', 0, 20),
(597559036, 'dfasdfasd', 'asdf', 0, 2, 'asdf', 3665, 'Advanced Placement (AP)', -1, 20),
(678146365, 'fsdfasdf', 'sdf', 0, 1, 'fsd', 3152394, 'N/A', -1, 20),
(972812930, 'afsdfasd', 'asfd', 1, 3, 'asdf', 51, 'Advanced Placement (AP)', -1, 20),
(1039451718, 'dfsdafasd', 'asf', 0, 3, 'asf', 3665, 'Advanced Placement (AP)', -1, 20),
(1889953797, 'cfasdfasd', 'sdf', 0, 2, '32', 99425, 'Advanced Placement (AP)', -1, 20),
(1932062038, 'ewfdfasdf', 'asdf', 0, 3, 'd', 51, 'Advanced Level (AL)', -1, 20),
(1944347627, 'sdfsdaf', 'sdf', 0, 1, 'sdf', 3665, 'Advanced Level (AL)', -1, 20),
(1944347777, 'sdfsdfa', 'sdf', 0, 2, 'sdf', 51, 'Advanced Level (AL)', -1, 20),
(1945758790, 'dsffsdf', 'sf', 0, 3, 'sdf', 51, 'Advanced Placement (AP)', -1, 20),
(2100038840, 'fasdgasdgdfgad', 'fasd', 0, 3, 'fsd', 3665, 'N/A', -1, 20);

-- --------------------------------------------------------

--
-- Table structure for table `ic_department`
--

CREATE TABLE IF NOT EXISTS `ic_department` (
  `depID` int(11) NOT NULL,
  `depName` varchar(128) CHARACTER SET utf8 NOT NULL,
  `depPhone` varchar(16) CHARACTER SET utf8 NOT NULL,
  `depDescription` text CHARACTER SET utf8 NOT NULL,
  `depLeader` text CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
-- Dumping data for table `ic_student`
--

INSERT INTO `ic_student` (`stuID`, `first_name`, `middle_name`, `last_name`, `sex`, `birthdate`, `grade`, `enrollYear`, `phone`, `address`) VALUES
(17011924, 'fdfff', 'afss', '43erf', 'm', '2018-05-17', 12, 2016, '3243', '53425'),
(198688928, 'dsf', 'sdffasd', 'afsd', 'm', '2018-05-22', 10, 2016, '2342', 'sdf'),
(1913628024, 'aa', 'asdf', 'asdf', 'm', '2018-05-09', 12, 2017, '2344', 'asdf'),
(2069095245, 'sdd', 'asd', 'asd', 'm', '2018-05-18', 10, 2015, '3423', 'sdfasd'),
(2116642945, 'sdd', 'bbbbb', 'asff', 'm', '2018-05-17', 10, 2016, '324123', '234df');

-- --------------------------------------------------------

--
-- Table structure for table `ic_teacher`
--

CREATE TABLE IF NOT EXISTS `ic_teacher` (
  `teaID` int(11) NOT NULL,
  `teaSurName` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `teaMidName` varchar(20) CHARACTER SET utf8 NOT NULL,
  `teaFirName` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `teaValid` tinyint(1) DEFAULT '0' COMMENT 'true for work',
  `RegDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userName` varchar(255) CHARACTER SET utf8 NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 NOT NULL,
  `degree` varchar(125) CHARACTER SET utf8 NOT NULL,
  `graduSchool` varchar(125) CHARACTER SET utf8 NOT NULL,
  `position` varchar(125) CHARACTER SET utf8 NOT NULL,
  `Major` varchar(128) CHARACTER SET utf8 NOT NULL,
  `depID` smallint(6) NOT NULL,
  `teaCertificate` tinyint(1) NOT NULL DEFAULT '0',
  `phone` varchar(64) NOT NULL,
  `sex` char(1) NOT NULL DEFAULT 'm',
  `Birthday` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ic_teacher`
--

INSERT INTO `ic_teacher` (`teaID`, `teaSurName`, `teaMidName`, `teaFirName`, `teaValid`, `RegDate`, `userName`, `password`, `degree`, `graduSchool`, `position`, `Major`, `depID`, `teaCertificate`, `phone`, `sex`, `Birthday`) VALUES
(2341324, 'rwee', 'wer', '324', 0, '2018-05-28 20:26:39', '', '', '', '', '', '', -1, 0, '', 'm', '2018-05-29'),
(931165682, 'asdf', 'asdf', 'dsfa', 0, '2018-05-29 00:00:00', 'asdf', '202cb962ac59075b964b07152d234b70', 'df', 'sdfvxc', 'Physical Teacher', 'asdf', 3665, 0, '234', 'm', '2018-05-29'),
(1034966234, 'asdf', 'sdf', 'df', 1, '2018-05-31 00:00:00', 'sd', 'f4c536502d005607f8960ee365143137', '', 'df', 'N/A', '', -1, 1, '', 'm', '2018-05-29'),
(1079421613, 'sdff', 'asd', 'dsf', 0, '2018-05-31 00:00:00', 'fsd', 'ad5dc94aa356a8a2e3791649ff83104e', 'sdf', 'asdff', 'N/A', 'asf', -1, 0, '', 'm', '2018-05-29'),
(1294220720, 'sdfa', 'sadf', 'asdf', 0, '2018-05-31 00:00:00', 'ds', '21d3261e527be17c0dcb5c19e4d4b075', '', '', 'N/A', '', -1, 1, '0', 'm', '2018-05-29'),
(1544121022, 'ljk;l', 'lj', 'jh', 0, '2018-05-29 00:00:00', 'dd', '202cb962ac59075b964b07152d234b70', '-1', '', 'N/A', '', -1, 1, '', 'm', '2018-05-29');

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
-- Indexes for table `ic_class`
--
ALTER TABLE `ic_class`
 ADD PRIMARY KEY (`classID`);

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
MODIFY `adminID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `ic_area`
--
ALTER TABLE `ic_area`
MODIFY `AreaID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `ic_class`
--
ALTER TABLE `ic_class`
MODIFY `classID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=38;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
