-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 09, 2018 at 07:43 AM
-- Server version: 5.7.11
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `micro_electronics`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `billNumber` varchar(15) NOT NULL,
  `totalAmount` float NOT NULL,
  `discountAll` float NOT NULL,
  `netSales` float NOT NULL,
  `billDate` varchar(15) NOT NULL,
  `paymentMode` varchar(15) NOT NULL,
  `month` varchar(11) NOT NULL,
  `year` varchar(7) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`billNumber`, `totalAmount`, `discountAll`, `netSales`, `billDate`, `paymentMode`, `month`, `year`) VALUES
('1', 11000, 5, 10450, '2018/07/22', 'Cash', '07', '2018'),
('2', 5000, 0, 5000, '2018/08/22', 'Cheque', '08', '2018'),
('3', 7500, 0, 7500, '2018/09/22', 'Cash', '09', '2018'),
('4', 5000, 0, 5000, '2018/09/22', 'Cash', '09', '2018'),
('5', 5000, 0, 5000, '2018/09/22', 'Cheque', '09', '2018'),
('6', 1200, 0, 1200, '22/09/2018', 'Cash', '09', '2018'),
('7', 6000, 0, 6000, '07/10/2018', 'Cash', '10', '2018'),
('8', 1200, 0, 1200, '07/10/2018', 'Cash', '10', '2018'),
('9', 1200, 0, 1200, '07/10/2018', 'Cash', '10', '2018'),
('10', 1200, 0, 1200, '07/10/2018', 'Cash', '10', '2018'),
('11', 1200, 0, 1200, '07/10/2018', 'Cash', '10', '2018'),
('12', 1200, 0, 1200, '08/10/2018', 'Cash', '10', '2018'),
('13', 1200, 0, 1200, '08/10/2018', 'Cheque', '10', '2018'),
('14', 6000, 0, 6000, '08/10/2018', 'Cash', '10', '2018'),
('15', 1200, 0, 1200, '08/10/2018', 'Cash', '10', '2018'),
('16', 1200, 0, 1200, '09/10/2018', 'Cash', '10', '2018'),
('17', 16200, 4, 15552, '09/10/2018', 'Cash', '10', '2018');

-- --------------------------------------------------------

--
-- Table structure for table `cheque`
--

CREATE TABLE `cheque` (
  `cusName` varchar(20) NOT NULL,
  `cNumber` int(11) NOT NULL,
  `date` varchar(15) NOT NULL,
  `amount` float NOT NULL,
  `bankName` varchar(15) NOT NULL,
  `branchName` varchar(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cheque`
--

INSERT INTO `cheque` (`cusName`, `cNumber`, `date`, `amount`, `bankName`, `branchName`) VALUES
('Kaushi Rajapakshe', 62299, '2018/10/12', 12500, 'Peoples Bank', 'Kollupitiya'),
('Kaushi Rajapakshe', 62297, '2018/10/12', 12500, 'Peoples Bank', 'Kollupitiya');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CID` varchar(5) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `TelephoneNo` varchar(10) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Date` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CID`, `Name`, `TelephoneNo`, `Address`, `Date`) VALUES
('C101', 'Mal', '0112277846', '67,Wellawatta', '2018-10-08'),
('C102', 'Akash', '0477896854', '67,Maradana', '2018-10-08'),
('C103', 'Roshni', '0784569758', '89,Hanwella', '2018-10-08'),
('C104', 'Tholya', '0917788945', '87,Karapitiya', '2018-10-08'),
('C105', 'Lahiru', '0334567458', '34,Nittambuwa', '2018-10-08'),
('C106', 'Rajiththa', '0757895679', '67,Karapitiya', '2018-10-08'),
('C107', 'Chathuki', '0776664539', '34,Weligama', '2018-10-08'),
('C108', 'Sunanda', '0887894568', '67,Mahaoya', '2018-10-08'),
('C109', 'Jaliya', '0667843946', '56,Bandarawela', '2018-10-08'),
('C110', 'Akshara', '0776554346', '43,Nallur', '2018-10-08'),
('C111', 'Sithmi', '0718916485', '45,Kamburugamuwa', '2018-10-09');

-- --------------------------------------------------------

--
-- Table structure for table `customerbill`
--

CREATE TABLE `customerbill` (
  `billNumber` varchar(15) NOT NULL,
  `billDate` varchar(15) NOT NULL,
  `noOfItem` int(11) NOT NULL,
  `itemNo` varchar(15) NOT NULL,
  `itemName` varchar(20) NOT NULL,
  `rate` float NOT NULL,
  `qty` int(11) NOT NULL,
  `discount` float NOT NULL,
  `amount` float NOT NULL,
  `cusName` varchar(25) NOT NULL,
  `cusAddress` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customerbill`
--

INSERT INTO `customerbill` (`billNumber`, `billDate`, `noOfItem`, `itemNo`, `itemName`, `rate`, `qty`, `discount`, `amount`, `cusName`, `cusAddress`) VALUES
('2', '22/09/2018', 2, '1', 'Ardino Uno', 1100, 1, 0, 1100, 'KN', 'N'),
('2', '22/09/2018', 3, '1', 'Ardino Uno', 1100, 1, 0, 1100, 'Manu', 'Malabe'),
('3', '22/09/2018', 1, '1', 'Ardino Uno', 1100, 1, 0, 1100, 'KKK', 'MMM'),
('6', '22/09/2018', 1, '1', 'Ardino Uno', 1200, 1, 0, 1200, 'Nithin', 'Matara'),
('7', '07/10/2018', 1, '1', 'Ardino Uno', 1200, 5, 0, 6000, 'Niki', 'Malabe'),
('8', '07/10/2018', 1, '1', 'Ardino Uno', 1200, 1, 0, 1200, 'k', 'k'),
('9', '07/10/2018', 1, '1', 'Ardino Uno', 1200, 1, 0, 1200, 'k', 'k'),
('10', '07/10/2018', 1, '1', 'Ardino Uno', 1200, 1, 0, 1200, 'k', 'k'),
('11', '07/10/2018', 1, '1', 'Ardino Uno', 1200, 1, 0, 1200, 'k', 'k'),
('12', '08/10/2018', 1, '1', 'Ardino Uno', 1200, 1, 0, 1200, 'h', 'h'),
('13', '08/10/2018', 1, '1', 'Ardino Uno', 1200, 1, 0, 1200, 'g', 'f'),
('14', '08/10/2018', 1, '1', 'Ardino Uno', 1200, 1, 0, 1200, 'h', 'h'),
('14', '08/10/2018', 2, '1', 'Ardino Uno', 1200, 1, 0, 1200, 'f', 'f'),
('14', '08/10/2018', 3, '1', 'Ardino Uno', 1200, 1, 0, 1200, 'a', 'a'),
('14', '08/10/2018', 4, '1', 'Ardino Uno', 1200, 1, 0, 1200, 'a', 'a'),
('14', '08/10/2018', 5, '1', 'Ardino Uno', 1200, 1, 0, 1200, 'h', 'n'),
('15', '08/10/2018', 1, '1', 'Ardino Uno', 1200, 1, 0, 1200, 'k', 'k'),
('16', '09/10/2018', 1, '1', 'Ardino Uno', 1200, 1, 0, 1200, 'kk', 'kk'),
('17', '09/10/2018', 1, '1', 'Ardino Uno', 1200, 5, 0, 6000, 'Manoli', 'Gampaha'),
('17', '09/10/2018', 2, '2', 'Ardino Uno', 1200, 5, 0, 6000, 'Manoli', 'Gampaha'),
('17', '09/10/2018', 3, '3', 'ArdinoMega', 1500, 2, 0, 3000, 'Manoli', 'Gampaha'),
('17', '09/10/2018', 4, '1', 'Ardino Uno', 1200, 1, 0, 1200, 'Manoli', 'Gampaha'),
('2', '22/09/2018', 1, '1', 'Ardino Uno', 1100, 1, 0, 1100, 'K', 'N'),
('1', '22/09/2018', 1, '1', 'Ardino Uno', 1100, 3, 0, 3300, 'Kaushi', 'Gampaha');

-- --------------------------------------------------------

--
-- Table structure for table `emp`
--

CREATE TABLE `emp` (
  `id` int(15) NOT NULL,
  `name` varchar(15) NOT NULL,
  `designation` varchar(15) NOT NULL,
  `Bsal` float NOT NULL,
  `contactNumber` int(15) NOT NULL,
  `category` varchar(12) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `emp`
--

INSERT INTO `emp` (`id`, `name`, `designation`, `Bsal`, `contactNumber`, `category`) VALUES
(1, 'Samadhi', 'Manager', 30000, 777425432, 'Cashier'),
(2, 'Kaushi', 'Cashier', 25000, 112290909, 'Manager'),
(3, 'Pulasthi', 'Manager', 32000, 784434567, 'Employee'),
(4, 'Himashi', 'Cashier', 26000, 765529789, 'Cashier'),
(5, 'Dilshan', 'Employee', 22000, 0, '');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `EID` varchar(5) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Status` varchar(10) NOT NULL,
  `Designation` varchar(50) NOT NULL,
  `Age` int(2) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `NIC` varchar(10) NOT NULL,
  `AccNo` int(10) NOT NULL,
  `TelNo` int(12) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Qualification` varchar(200) NOT NULL,
  `WorkExperience` varchar(50) NOT NULL,
  `Password` text NOT NULL,
  `Salary` int(10) NOT NULL,
  `Date` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`EID`, `Name`, `Status`, `Designation`, `Age`, `Address`, `NIC`, `AccNo`, `TelNo`, `Email`, `Qualification`, `WorkExperience`, `Password`, `Salary`, `Date`) VALUES
('105', 'Malan', 'Mr.', 'Cashier', 25, '76,Kottawa', '935859725v', 32112365, 767899875, 'malan@gmail.com', 'A/L', '1yr', 'mal123', 25000, '2018-10-08'),
('104', 'Diaerrt', 'Mr.', 'Cashier', 29, '45,Kadana', '895642394v', 98788965, 774568267, 'dias@gmail.com', 'A/L', '3yrs', 'dis123', 25000, '2018-10-08'),
('103', 'Diana', 'Mrs.', 'Assistant Manager', 28, '67,Malabe', '907894369v', 94828486, 776663489, 'diana@gmail.com', 'A/L', '3yrs', 'dia123', 30000, '2018-10-08'),
('102', 'Anna', 'Mrs.', 'Assistant manager', 30, '45,Kaduwela', '887897438v', 14774165, 787794562, 'anna@gmail.com', 'Diploma', '5yrs', 'ana123', 30000, '2018-10-08'),
('101', 'Alan', 'Mr.', 'Manager', 40, '12,Kotte', '788264813v', 74136979, 717894556, 'alan@mail.com', 'Diploma', '10yrs', 'alan123', 40000, '2018-10-08'),
('106', 'Oshara', 'Mrs.', 'Sales Manager', 26, '45,Kollupitiya', '927898765v', 93696565, 753455437, 'oshara@gmail.com', 'A/L', '1yr', 'osh123', 20000, '2018-10-08'),
('107', 'Jackson', 'Mr.', 'Salesman', 30, '25,Rajagiriya', '786565986v', 98787657, 712323457, 'jack@gmail.com', 'A/L', '6mnths', 'jak123', 15000, '2018-10-08'),
('108', 'Somapala', 'Mr.', 'Salesman', 36, '98,Awissawella', '826576567v', 23423432, 717654567, 'somapala@gmail.com', 'A/L', '7mnths', 'som123', 15000, '2018-10-08'),
('110', 'Ishan', 'Mr.', 'Salesman', 26, '87,Hanwella', '925864585v', 74136912, 717858754, 'ishan@hamil.com', 'O/L', '6mnths', 'ish123', 15000, '2018-10-08');

-- --------------------------------------------------------

--
-- Table structure for table `emptable`
--

CREATE TABLE `emptable` (
  `inquiryID` int(11) NOT NULL,
  `EID` varchar(15) NOT NULL,
  `Name` varchar(25) NOT NULL,
  `contactNumber` varchar(15) NOT NULL,
  `category` varchar(20) NOT NULL,
  `date` varchar(15) NOT NULL,
  `description` varchar(150) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `emptable`
--

INSERT INTO `emptable` (`inquiryID`, `EID`, `Name`, `contactNumber`, `category`, `date`, `description`) VALUES
(3, 'ED001', 'Kaushi', '777425432', 'Payment', '', ''),
(20, '101', 'Alan', '0717894556', 'payment', '09/10/2018', 'call me'),
(16, '16', 'new', '0772311272', 'a', '09/10/2018', 'aj'),
(15, '16', 'new', '0772311272', 'asd', '09/10/2018', 'aj'),
(17, '101', 'Alan', '0717894556', 'None', '09/10/2018', 'Save this content'),
(18, '105', 'Malan', '0767899875', 'None', '09/10/2018', 'Save this content'),
(19, '108', 'Somapala', '0772311272', 'garys', '09/10/2018', 'Save this content');

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `productName` varchar(50) DEFAULT NULL,
  `productID` int(20) NOT NULL,
  `productDescription` varchar(80) DEFAULT NULL,
  `cost` float DEFAULT NULL,
  `price` float DEFAULT NULL,
  `discount` float DEFAULT NULL,
  `date` varchar(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`productName`, `productID`, `productDescription`, `cost`, `price`, `discount`, `date`) VALUES
('Ardino Uno', 1, 'Blue Sri Lanka New', 900, 1200, 0, '14/09/2018'),
('ArdinoMega', 3, 'Black Sri Lanka New', 1200, 1500, 0, '14/09/2018'),
('Raspery PI', 4, 'New 18px', 3000, 4000, 0, '21/09/2018'),
('HC 12', 5, 'LANKA TRONICS', 800, 1000, 0, '22/09/2018'),
('Neon max ex1', 6, 'Neon max ex1', 1500, 2000, 0, '09/10/2018'),
('Neon max max nell', 7, 'Neon max ex1 nell', 1250, 1550, 0, '09/10/2018'),
('Marks max max nell', 8, 'Marks max ex1 nell', 1270, 1570, 0, '09/10/2018');

-- --------------------------------------------------------

--
-- Table structure for table `leaves`
--

CREATE TABLE `leaves` (
  `ID` varchar(15) NOT NULL,
  `name` varchar(25) NOT NULL,
  `designation` varchar(25) NOT NULL,
  `sdate` varchar(15) NOT NULL,
  `edate` varchar(15) NOT NULL,
  `rdate` varchar(15) NOT NULL,
  `reason` varchar(30) NOT NULL,
  `tdate` varchar(15) NOT NULL,
  `recBy` varchar(15) NOT NULL,
  `retDate` varchar(15) NOT NULL,
  `arrival` varchar(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `leaves`
--

INSERT INTO `leaves` (`ID`, `name`, `designation`, `sdate`, `edate`, `rdate`, `reason`, `tdate`, `recBy`, `retDate`, `arrival`) VALUES
('101', 'Alan', 'Manager', '12/10/2018', '19/10/2018', '19/10/2018', 'Fever', '09/10/2018', 'N001', '21/10/2018', 'No'),
('102', 'Anna', 'Assistant manager', '19/10/2018', '20/10/2018', '20/10/2018', 'None', '09/10/2018', 'N001', '21/10/2018', 'No'),
('103', 'Diana', 'Assistant Manager', '09/10/2018', '12/10/2018', '09/10/2018', 'None', '09/10/2018', 'N001', '21/10/2018', 'No'),
('105', 'Malan', 'Cashier', '19/10/2018', '20/10/2018', '21/10/2018', 'None', '09/10/2018', 'N001', '21/10/2018', 'No'),
('109', 'Sajini', 'Salesman', '09/10/2018', '12/10/2018', '12/10/2018', 'None', '09/10/2018', 'N001', '21/10/2018', 'No'),
('108', 'Somapala', 'Salesman', '2018/10/12', '2018/09/08', '2018/09/08', 'Fever', '09/10/2018', 'N001', '21/10/2018', 'No');

-- --------------------------------------------------------

--
-- Table structure for table `log`
--

CREATE TABLE `log` (
  `id` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `catogory` varchar(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `log`
--

INSERT INTO `log` (`id`, `password`, `catogory`) VALUES
('P002', 'Pula', 'Manager'),
('K003', 'Kaushi', 'Cashier'),
('N001', 'Niki', 'Owner'),
('H002', 'Himashi', 'Manager'),
('D004', 'Dilshan', 'Crew Member'),
('D001', 'Dilshan', 'Owner'),
('D002', 'Dilshan', 'Crew Member'),
('N001', 'Niki', 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `salary`
--

CREATE TABLE `salary` (
  `ID` varchar(15) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Designation` varchar(20) NOT NULL,
  `Today` varchar(15) NOT NULL,
  `Bsal` float NOT NULL,
  `leaves` int(11) NOT NULL,
  `OT` float NOT NULL,
  `Performance` float NOT NULL,
  `Advance` float NOT NULL,
  `EPF` float NOT NULL,
  `Gross` float NOT NULL,
  `Deduction` float NOT NULL,
  `NetSal` float NOT NULL,
  `month` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salary`
--

INSERT INTO `salary` (`ID`, `Name`, `Designation`, `Today`, `Bsal`, `leaves`, `OT`, `Performance`, `Advance`, `EPF`, `Gross`, `Deduction`, `NetSal`, `month`) VALUES
('106', 'Oshara', 'Sales Manager', '09/10/2018', 20000, 2, 2000, 1000, 1200, 1840, 23000, 3040, 19960, 10),
('102', 'Anna', 'Assistant manager', '09/10/2018', 30000, 2, 2000, 1000, 1200, 2640, 33000, 3840, 29160, 10),
('107', 'Jackson', 'Salesman', '09/10/2018', 15000, 2, 2000, 1000, 1200, 1440, 18000, 2640, 15360, 10),
('108', 'Somapala', 'Salesman', '09/10/2018', 15000, 2, 2000, 1000, 1200, 1440, 18000, 2640, 15360, 10),
('109', 'Sajini', 'Salesman', '09/10/2018', 15000, 2, 2000, 1000, 1200, 1440, 18000, 2640, 15360, 10);

-- --------------------------------------------------------

--
-- Table structure for table `salesreport`
--

CREATE TABLE `salesreport` (
  `Id` int(10) NOT NULL,
  `Sales` varchar(20) NOT NULL,
  `Deduction` varchar(20) NOT NULL,
  `Profit` varchar(20) NOT NULL,
  `Month` varchar(20) NOT NULL,
  `Year` int(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salesreport`
--

INSERT INTO `salesreport` (`Id`, `Sales`, `Deduction`, `Profit`, `Month`, `Year`) VALUES
(5, '20400.0', '22463.04', '-2063.039', '10', 2018),
(4, '20400.0', '10863.52', '9536.48', '10', 2018),
(6, '21600.0', '97200.0', '-75600.0', '10', 2018),
(7, '21600.0', '95800.0', '-74200.0', '10', 2018),
(8, '25000', '6150.0', '18850.0', '10', 2018);

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `productID` int(20) NOT NULL,
  `productName` varchar(50) NOT NULL,
  `productDescription` varchar(80) NOT NULL,
  `stockLevel` int(11) NOT NULL,
  `recorderLevel` int(11) NOT NULL,
  `date` varchar(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`productID`, `productName`, `productDescription`, `stockLevel`, `recorderLevel`, `date`) VALUES
(1, 'Ardino Uno', 'Blue Sri Lanka', 257, 10, '14/09/2018'),
(3, 'ArdinoMega', 'Black Sri Lanka New', 178, 7, '14/09/2018'),
(4, 'Raspery PI', 'New 18px', 18, 2, '21/09/2018'),
(5, 'HC 12', 'LANKA TRONICS', 10, 0, '22/09/2018');

-- --------------------------------------------------------

--
-- Table structure for table `warranty`
--

CREATE TABLE `warranty` (
  `WarrantyID` int(6) NOT NULL,
  `CusID` varchar(6) NOT NULL,
  `CusName` varchar(50) NOT NULL,
  `CusTelNo` int(10) NOT NULL,
  `ProductID` varchar(6) NOT NULL,
  `WarrantyPeriod` varchar(10) NOT NULL,
  `StartDate` date NOT NULL,
  `Status` varchar(20) NOT NULL,
  `Description` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `warranty`
--

INSERT INTO `warranty` (`WarrantyID`, `CusID`, `CusName`, `CusTelNo`, `ProductID`, `WarrantyPeriod`, `StartDate`, `Status`, `Description`) VALUES
(1, '2', '', 0, '15', '2yrs', '2003-02-05', '-', ''),
(2, '2', '', 0, '13', '2yrs', '2003-02-05', 'Select', ''),
(3, '2', '', 0, '11', '2yrs', '2003-02-05', 'Select', ''),
(4, '3', '', 0, '21', '3yrs', '2003-02-09', '-', ''),
(5, '6', '', 0, '21', '3yrs', '2003-06-09', '-', ''),
(7, '16', '', 0, '22', '3yrs', '2003-06-09', 'Send company', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`billNumber`);

--
-- Indexes for table `cheque`
--
ALTER TABLE `cheque`
  ADD PRIMARY KEY (`cNumber`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CID`);

--
-- Indexes for table `emp`
--
ALTER TABLE `emp`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`EID`);

--
-- Indexes for table `emptable`
--
ALTER TABLE `emptable`
  ADD PRIMARY KEY (`inquiryID`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`productID`);

--
-- Indexes for table `leaves`
--
ALTER TABLE `leaves`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `salary`
--
ALTER TABLE `salary`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `salesreport`
--
ALTER TABLE `salesreport`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`productID`);

--
-- Indexes for table `warranty`
--
ALTER TABLE `warranty`
  ADD PRIMARY KEY (`WarrantyID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `emptable`
--
ALTER TABLE `emptable`
  MODIFY `inquiryID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `productID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `salesreport`
--
ALTER TABLE `salesreport`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `stock`
--
ALTER TABLE `stock`
  MODIFY `productID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `warranty`
--
ALTER TABLE `warranty`
  MODIFY `WarrantyID` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
