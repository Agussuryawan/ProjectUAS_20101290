/*
SQLyog Community
MySQL - 10.4.14-MariaDB : Database - mhs
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `dsn` */

CREATE TABLE `dsn` (
  `NIDN` int(8) NOT NULL,
  `Nama` varchar(50) DEFAULT NULL,
  `Gelar` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`NIDN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `dsn` */

insert  into `dsn`(`NIDN`,`Nama`,`Gelar`) values (123231212,'Rahmat','S2');
insert  into `dsn`(`NIDN`,`Nama`,`Gelar`) values (200101030,'rama surya','S2');

/*Table structure for table `dt_mhs` */

CREATE TABLE `dt_mhs` (
  `Nama` varchar(50) DEFAULT NULL,
  `NIM` int(8) NOT NULL,
  `Jns_Kelamin` varchar(50) DEFAULT NULL,
  `Jurusan` varchar(50) DEFAULT NULL,
  `TGL_Lahir` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`NIM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `dt_mhs` */

insert  into `dt_mhs`(`Nama`,`NIM`,`Jns_Kelamin`,`Jurusan`,`TGL_Lahir`) values ('adi',11223344,'L','DGM','20-02-2022');
insert  into `dt_mhs`(`Nama`,`NIM`,`Jns_Kelamin`,`Jurusan`,`TGL_Lahir`) values ('Adri',20101902,'L','KAB','12-12-2008');

/*Table structure for table `dtmatkul` */

CREATE TABLE `dtmatkul` (
  `id_matkul` int(10) NOT NULL,
  `Nama_Matkul` varchar(50) DEFAULT NULL,
  `sks` varchar(10) DEFAULT NULL,
  `semester` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_matkul`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `dtmatkul` */

insert  into `dtmatkul`(`id_matkul`,`Nama_Matkul`,`sks`,`semester`) values (2011,'Sejarah','2','4');
insert  into `dtmatkul`(`id_matkul`,`Nama_Matkul`,`sks`,`semester`) values (3012,'BHS Indonesia','2','3');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
