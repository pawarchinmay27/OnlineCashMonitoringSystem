-- phpMyAdmin SQL Dump
-- version 3.2.0.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 16, 2018 at 01:16 AM
-- Server version: 5.1.36
-- PHP Version: 5.3.0

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bank`
--

-- --------------------------------------------------------

--
-- Table structure for table `banks`
--

CREATE TABLE IF NOT EXISTS `banks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `zone` varchar(40) NOT NULL,
  `bank_name` varchar(40) NOT NULL,
  `cash_stat` varchar(40) NOT NULL,
  `crowd_stat` varchar(40) NOT NULL,
  `cash_dep` varchar(40) NOT NULL,
  `cashdep_det` varchar(40) NOT NULL,
  `cashdep_time` varchar(30) NOT NULL,
  `REGION` varchar(40) NOT NULL,
  `bankman_id` varchar(40) NOT NULL,
  `bankman_passw` varchar(40) NOT NULL,
  `max_cash_limit` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `banks`
--

INSERT INTO `banks` (`id`, `zone`, `bank_name`, `cash_stat`, `crowd_stat`, `cash_dep`, `cashdep_det`, `cashdep_time`, `REGION`, `bankman_id`, `bankman_passw`, `max_cash_limit`) VALUES
(1, 'west', 'yesbank', 'CASH AVILABLE', 'LOW', '900000', '02/03/2017', '02:00', 'SANTACRUZ', 'yesman', 'yesman123', '5000'),
(2, 'west', 'axisbank', 'CASH AVILABLE', 'HIGH', '2111', '21-9-17', '12:16', 'ANDHERI', 'axisman', 'axisman123', '23000'),
(4, 'east', 'yesbank', 'CASH AVILABLE', 'HIGH', '400000', '123344', '23', 'WADALA', 'yesman', 'yesman123', '25000');

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE IF NOT EXISTS `customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  `mobile_no` varchar(40) NOT NULL,
  `acbal` double NOT NULL DEFAULT '0',
  `profile_pic_image` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=19 ;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`id`, `name`, `password`, `email`, `mobile_no`, `acbal`, `profile_pic_image`) VALUES
(1, 'chinmaypawar', '1234', 'pawarchinmay27@gmail.com', '123445', 462654.4, ''),
(17, 'Aditya', 'adi123', 'adi@gmail.com', '9873456213', 0, 'Empty'),
(7, 'test', 'test', 'test@gmail.com', '1234567890', 9501922.99, ''),
(8, 'pool', 'pool', 'pawarchinmay27@gmail.com', '1234', 13228, ''),
(18, 'pranay', 'pranay123', 'pranay27@gmail.com', '9892645332', 0, 'Empty'),
(15, 'mehul', 'mehul123', 'mehul1991@gmail.com', '9892645346', 4, 'Empty');

-- --------------------------------------------------------

--
-- Table structure for table `rbia`
--

CREATE TABLE IF NOT EXISTS `rbia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `rbia`
--

INSERT INTO `rbia` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin');
