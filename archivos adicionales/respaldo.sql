-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 26, 2018 at 03:28 PM
-- Server version: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `encuesta`
--
CREATE DATABASE IF NOT EXISTS `encuesta` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `encuesta`;

-- --------------------------------------------------------

--
-- Table structure for table `encuesta_res`
--

DROP TABLE IF EXISTS `encuesta_res`;
CREATE TABLE IF NOT EXISTS `encuesta_res` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `programa` varchar(50) NOT NULL,
  `genero` varchar(6) NOT NULL,
  `edad` int(3) NOT NULL,
  `bebida` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `encuesta_res`
--

INSERT INTO `encuesta_res` (`id`, `programa`, `genero`, `edad`, `bebida`) VALUES
(1, 'Ingeniería de sistemas', 'Hombre', 20, 'Jugo natural'),
(2, 'Ingeniería de Telecomunicaciones', 'Mujer', 22, 'Gaseosa'),
(3, 'Ingeniería industrial', 'Hombre', 23, 'Gaseosa'),
(4, 'Ingeniería industrial', 'Mujer', 25, 'Agua de panela');

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `password` varchar(24) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ik_usuarios_name` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `password`) VALUES
(1, 'admin', 'admin');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
