-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 11 Bulan Mei 2020 pada 09.08
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tokoroti`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `login`
--

CREATE TABLE `login` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('galih', '123456'),
('goku', '321654');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pegawai`
--

CREATE TABLE `pegawai` (
  `Id_pegawai` int(10) NOT NULL,
  `Nama_pegawai` varchar(20) NOT NULL,
  `Jabatan` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pegawai`
--

INSERT INTO `pegawai` (`Id_pegawai`, `Nama_pegawai`, `Jabatan`) VALUES
(101, 'Vairus Covid', 'Satpam'),
(202, 'Samita Saras', 'Casier'),
(204, 'Kanya Ranti', 'Casier'),
(212, 'Sasuke Uchiha', 'Koki'),
(219, 'Kaori Chan', 'Satpam'),
(305, 'Handy Sanitiza', 'Pramuniaga'),
(306, 'Zilong Damagendaru', 'Pramuniaga'),
(696, 'Naruto', 'Satpam'),
(700, 'Xeizor', 'Koki'),
(989, 'Ujang', 'Satpam');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembeli`
--

CREATE TABLE `pembeli` (
  `id_pembeli` int(10) NOT NULL,
  `Nama_pembeli` varchar(20) NOT NULL,
  `Kontak_pembeli` varchar(15) NOT NULL,
  `Alamat` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pembeli`
--

INSERT INTO `pembeli` (`id_pembeli`, `Nama_pembeli`, `Kontak_pembeli`, `Alamat`) VALUES
(1, 'Agus Uzumaki', '0896345345', 'Konoha'),
(4, 'Ujang', '08963435345', 'Astera'),
(28, 'Omaewa', '0879965435', 'Sofya City'),
(32, 'Fanny', '0879961231', 'Mobalog'),
(45, 'Doraemon', '0978324234', 'Kebon Bambu'),
(67, 'Hatsune', '098765432', 'Senbonzakura'),
(69, 'Nauval Uchiha', '086969696969', 'Andromeda');

-- --------------------------------------------------------

--
-- Struktur dari tabel `produk`
--

CREATE TABLE `produk` (
  `Id_roti` varchar(10) NOT NULL,
  `Nama_roti` varchar(50) NOT NULL,
  `Harga` int(20) NOT NULL,
  `Stok` int(20) NOT NULL,
  `Id_pegawai` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `produk`
--

INSERT INTO `produk` (`Id_roti`, `Nama_roti`, `Harga`, `Stok`, `Id_pegawai`) VALUES
('601', 'Bagel', 12500, 12, 700),
('602', 'Bialy', 10000, 11, 700),
('603', 'Donat', 10000, 13, 696),
('604', 'Ciabata', 13500, 18, 212),
('605', 'Croissant', 10500, 14, 212),
('606', 'Muffin', 15000, 3, 212),
('607', 'Dragon Ball Cake', 200000, 7, 306),
('608', 'Dorayaki', 1000, 8, 700);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `relasijual`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `relasijual` (
`No_transaksi` int(10)
,`Id_pembeli` int(10)
,`Nama_pembeli` varchar(20)
,`Kontak_pembeli` varchar(15)
,`Alamat` varchar(30)
,`Id_roti` varchar(10)
,`Nama_roti` varchar(50)
,`Harga` int(20)
,`Stok` int(20)
,`Id_pegawai` int(20)
,`Nama_pegawai` varchar(20)
,`Jabatan` varchar(15)
,`Tgl_transaksi` date
,`Jumlah_beli` int(10)
);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `no_transaksi` int(10) NOT NULL,
  `id_pembeli` int(10) NOT NULL,
  `id_roti` varchar(10) NOT NULL,
  `tgl_transaksi` date NOT NULL,
  `jumlah_beli` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`no_transaksi`, `id_pembeli`, `id_roti`, `tgl_transaksi`, `jumlah_beli`) VALUES
(3, 32, '604', '2020-05-08', 2),
(4, 67, '603', '2020-05-06', 1),
(5, 4, '603', '2020-05-04', 3),
(6, 45, '606', '2020-05-03', 7),
(7, 28, '601', '2020-02-05', 5),
(8, 32, '608', '2020-02-07', 2),
(9, 67, '602', '2020-02-01', 6),
(10, 28, '603', '2020-02-02', 4),
(12, 69, '607', '2020-05-05', 1);

-- --------------------------------------------------------

--
-- Struktur untuk view `relasijual`
--
DROP TABLE IF EXISTS `relasijual`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `relasijual`  AS  select `transaksi`.`no_transaksi` AS `No_transaksi`,`transaksi`.`id_pembeli` AS `Id_pembeli`,`pembeli`.`Nama_pembeli` AS `Nama_pembeli`,`pembeli`.`Kontak_pembeli` AS `Kontak_pembeli`,`pembeli`.`Alamat` AS `Alamat`,`transaksi`.`id_roti` AS `Id_roti`,`produk`.`Nama_roti` AS `Nama_roti`,`produk`.`Harga` AS `Harga`,`produk`.`Stok` AS `Stok`,`produk`.`Id_pegawai` AS `Id_pegawai`,`pegawai`.`Nama_pegawai` AS `Nama_pegawai`,`pegawai`.`Jabatan` AS `Jabatan`,`transaksi`.`tgl_transaksi` AS `Tgl_transaksi`,`transaksi`.`jumlah_beli` AS `Jumlah_beli` from (((`transaksi` join `pembeli`) join `produk`) join `pegawai`) where `transaksi`.`id_pembeli` = `pembeli`.`id_pembeli` and `transaksi`.`id_roti` = `produk`.`Id_roti` and `produk`.`Id_pegawai` = `pegawai`.`Id_pegawai` ;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`Id_pegawai`);

--
-- Indeks untuk tabel `pembeli`
--
ALTER TABLE `pembeli`
  ADD PRIMARY KEY (`id_pembeli`);

--
-- Indeks untuk tabel `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`Id_roti`),
  ADD KEY `Id_pegawai` (`Id_pegawai`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`no_transaksi`),
  ADD KEY `id_roti` (`id_roti`),
  ADD KEY `id_pembeli` (`id_pembeli`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `no_transaksi` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `produk`
--
ALTER TABLE `produk`
  ADD CONSTRAINT `produk_ibfk_1` FOREIGN KEY (`Id_pegawai`) REFERENCES `pegawai` (`Id_pegawai`);

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_roti`) REFERENCES `produk` (`Id_roti`),
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`id_pembeli`) REFERENCES `pembeli` (`id_pembeli`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
