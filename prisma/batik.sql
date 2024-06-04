-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 04, 2024 at 12:35 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `batikhub_dev`
--

-- --------------------------------------------------------

--
-- Table structure for table `batik`
--

CREATE TABLE `batik` (
  `id_batik` varchar(191) NOT NULL,
  `nama_batik` varchar(191) NOT NULL,
  `asal_daerah` varchar(191) NOT NULL,
  `deskripsi_batik` varchar(191) NOT NULL,
  `gambar_batik` varchar(191) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `batik`
--

INSERT INTO `batik` (`id_batik`, `nama_batik`, `asal_daerah`, `deskripsi_batik`, `gambar_batik`) VALUES
('03488283-b66a-4889-a517-731833ff779d', 'Batik Celup', 'Indonesia', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec non placerat massa, sit amet blandit ligula. Donec ullamcorper, felis sit amet rhoncus pulvinar, nunc nisi vehicula enim, sit am', 'https://drive.google.com/file/d/1Mb8fomogb4vWZCvkB4AQryZYhrxyjHLi/view?usp=drive_link'),
('62de60ca-609d-4318-9061-9a88d0373851', 'Batik Betawi', 'DKI Jakarta', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec non placerat massa, sit amet blandit ligula. Donec ullamcorper, felis sit amet rhoncus pulvinar, nunc nisi vehicula enim, sit am', 'https://drive.google.com/file/d/17aNYAJHLqVryteus45TQih2Fezm9rdOR/view?usp=drive_link'),
('6c7ac3fc-6806-4658-82b5-45b6e267af9f', 'Batik Bali', 'Bali', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec non placerat massa, sit amet blandit ligula. Donec ullamcorper, felis sit amet rhoncus pulvinar, nunc nisi vehicula enim, sit am', 'https://drive.google.com/file/d/1PN_M5C_CT-2gMLdgbX09VxWX33taIJs_/view?usp=drive_link'),
('936eba49-1bd7-4b54-902c-316cd569f0d1', 'Batik Cenderawasih', 'Papua', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec non placerat massa, sit amet blandit ligula. Donec ullamcorper, felis sit amet rhoncus pulvinar, nunc nisi vehicula enim, sit am', 'https://drive.google.com/file/d/1wgclI9HQLWVRhoZ52lp8Yl2IQ0HIkCGT/view?usp=drive_link'),
('b409cf5b-f7cb-47ee-a376-efcc73584646', 'Batik Ceplok', 'Kabupaten Bantul, DIY', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec non placerat massa, sit amet blandit ligula. Donec ullamcorper, felis sit amet rhoncus pulvinar, nunc nisi vehicula enim, sit am', 'https://drive.google.com/file/d/1cG4iip3LbY9lWuCtEiNv6u8nHKO-qC2p/view?usp=drive_link');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `batik`
--
ALTER TABLE `batik`
  ADD PRIMARY KEY (`id_batik`),
  ADD UNIQUE KEY `Batik_id_batik_key` (`id_batik`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
