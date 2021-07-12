-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 12, 2021 at 04:03 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_spakuba2`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(11) NOT NULL,
  `namaadmin` varchar(50) NOT NULL,
  `namacompany` varchar(50) NOT NULL,
  `notelpadmin` int(11) NOT NULL,
  `alamatadmin` varchar(100) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `namaadmin`, `namacompany`, `notelpadmin`, `alamatadmin`, `username`, `password`) VALUES
(1, 'aster', 'Gama', 765324, 'Belimbing', 'admin', '123'),
(2, 'visra', 'go', 76543, 'Kuranji', 'visra@gmail.com', '123'),
(33, 'aster', 'Go', 1234, 'Balimbiang', 'admin', '123');

-- --------------------------------------------------------

--
-- Table structure for table `ajar`
--

CREATE TABLE `ajar` (
  `id_kelas` int(11) NOT NULL,
  `id_pengajar` int(11) NOT NULL,
  `tanggal` varchar(30) NOT NULL,
  `waktu` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ajar`
--

INSERT INTO `ajar` (`id_kelas`, `id_pengajar`, `tanggal`, `waktu`) VALUES
(111, 1, 'Senin', '1 (13.00-14.15)'),
(222, 3, 'Rabu', '2'),
(1, 2, 'Sabtu', 'pagi');

-- --------------------------------------------------------

--
-- Table structure for table `kelas`
--

CREATE TABLE `kelas` (
  `id_kelas` int(11) NOT NULL,
  `NamaKelas` varchar(50) NOT NULL,
  `programkls` varchar(30) NOT NULL,
  `hari` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kelas`
--

INSERT INTO `kelas` (`id_kelas`, `NamaKelas`, `programkls`, `hari`) VALUES
(1, 'J2', 'Bahasa Jepang', 'Senin'),
(111, 'b1', 'Bahasa Inggris', 'Senin'),
(222, 'K01', 'Bahasa Korea', 'Rabu'),
(234, '11', 'Bahasa Jepang', 'Selasa'),
(999, 'E01', 'Bahasa Inggris', 'Senin');

-- --------------------------------------------------------

--
-- Table structure for table `pengajar`
--

CREATE TABLE `pengajar` (
  `id_pengajar` int(11) NOT NULL,
  `namapengajar` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `notelppengajar` int(11) NOT NULL,
  `alamatpengajar` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pengajar`
--

INSERT INTO `pengajar` (`id_pengajar`, `namapengajar`, `email`, `notelppengajar`, `alamatpengajar`) VALUES
(1, 'raven', 'ravend', 87654, 'kjansd'),
(2, 'aster', 'asterr@gmail.com', 87, 'padang'),
(3, 'happy', 'atr@gmail.com', 123, 'belimbing'),
(4, 'aster', 'aster@gamil.com', 7451, 'Belimbing'),
(134, 'aster', 'aster@gmail.com', 872525252, 'padang');

-- --------------------------------------------------------

--
-- Table structure for table `siswa`
--

CREATE TABLE `siswa` (
  `id_siswa` int(11) NOT NULL,
  `namasiswa` varchar(50) NOT NULL,
  `ttlsiswa` varchar(50) NOT NULL,
  `notelpsiswa` int(11) NOT NULL,
  `alamatsiswa` varchar(100) NOT NULL,
  `id_kelas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `siswa`
--

INSERT INTO `siswa` (`id_siswa`, `namasiswa`, `ttlsiswa`, `notelpsiswa`, `alamatsiswa`, `id_kelas`) VALUES
(2, 'ezik', 'padang/1 januari 2001', 7654, 'Siteba', 1),
(123, 'ezik', 'padang/12-11-2000', 83646464, 'padang', 111);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `ajar`
--
ALTER TABLE `ajar`
  ADD KEY `id_pengajar` (`id_pengajar`),
  ADD KEY `idkelas` (`id_kelas`);

--
-- Indexes for table `kelas`
--
ALTER TABLE `kelas`
  ADD PRIMARY KEY (`id_kelas`);

--
-- Indexes for table `pengajar`
--
ALTER TABLE `pengajar`
  ADD PRIMARY KEY (`id_pengajar`);

--
-- Indexes for table `siswa`
--
ALTER TABLE `siswa`
  ADD PRIMARY KEY (`id_siswa`),
  ADD KEY `id_kelas` (`id_kelas`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `kelas`
--
ALTER TABLE `kelas`
  MODIFY `id_kelas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1000;

--
-- AUTO_INCREMENT for table `pengajar`
--
ALTER TABLE `pengajar`
  MODIFY `id_pengajar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=135;

--
-- AUTO_INCREMENT for table `siswa`
--
ALTER TABLE `siswa`
  MODIFY `id_siswa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=124;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ajar`
--
ALTER TABLE `ajar`
  ADD CONSTRAINT `id_pengajar` FOREIGN KEY (`id_pengajar`) REFERENCES `pengajar` (`id_pengajar`),
  ADD CONSTRAINT `idkelas` FOREIGN KEY (`id_kelas`) REFERENCES `kelas` (`id_kelas`);

--
-- Constraints for table `siswa`
--
ALTER TABLE `siswa`
  ADD CONSTRAINT `id_kelas` FOREIGN KEY (`id_kelas`) REFERENCES `kelas` (`id_kelas`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
