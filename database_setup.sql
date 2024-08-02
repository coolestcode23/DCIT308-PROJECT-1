CREATE DATABASE  IF NOT EXISTS `pharmacy` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pharmacy`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: pharmacy
-- ------------------------------------------------------
-- Server version	8.0.38

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `customerID` varchar(10) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `contactInformation` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`customerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drugs`
--

DROP TABLE IF EXISTS `drugs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drugs` (
  `drugCode` varchar(10) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`drugCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drugs`
--

LOCK TABLES `drugs` WRITE;
/*!40000 ALTER TABLE `drugs` DISABLE KEYS */;
INSERT INTO `drugs` VALUES ('D001','Aspirin',95,9.99),('D002','Paracetamol',198,4.99),('D003','Ibuprofen',150,8.49),('D004','Amoxicillin',72,15.99),('D005','Cetirizine',300,6.49),('D006','Lisinopril',120,25),('D007','Metformin',177,20),('D008','Amlodipine',247,22.5),('D009','Omeprazole',396,18.75),('D010','Simvastatin',150,19.99),('D012','Atorvastatin',95,24.99),('D013','Pantoprazole',176,17.49),('D014','Levothyroxine',297,16.99),('D015','Montelukast',140,21),('D016','Furosemide',160,10),('D017','Gabapentin',190,28),('D018','Sertraline',130,26.5),('D019','Tamsulosin',170,30),('D020','Ebony Condom',200,7.2);
/*!40000 ALTER TABLE `drugs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchases`
--

DROP TABLE IF EXISTS `purchases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchases` (
  `purchaseID` varchar(10) NOT NULL,
  `drugCode` varchar(10) DEFAULT NULL,
  `dateTime` timestamp NULL DEFAULT NULL,
  `customerID` varchar(10) DEFAULT NULL,
  `totalAmount` double DEFAULT NULL,
  PRIMARY KEY (`purchaseID`),
  KEY `drugCode` (`drugCode`),
  KEY `customerID` (`customerID`),
  CONSTRAINT `purchases_ibfk_1` FOREIGN KEY (`drugCode`) REFERENCES `drugs` (`drugCode`),
  CONSTRAINT `purchases_ibfk_2` FOREIGN KEY (`customerID`) REFERENCES `customers` (`customerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchases`
--

LOCK TABLES `purchases` WRITE;
/*!40000 ALTER TABLE `purchases` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales` (
  `saleID` varchar(50) NOT NULL,
  `drugCode` varchar(10) DEFAULT NULL,
  `dateTime` timestamp NULL DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `totalPrice` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`saleID`),
  KEY `sales_drugcode_fk` (`drugCode`),
  CONSTRAINT `sales_drugcode_fk` FOREIGN KEY (`drugCode`) REFERENCES `drugs` (`drugCode`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES ('SALE-1720114935945','D002','2024-07-04 17:42:16',2,9.98),('SALE-1720115180954','D001','2024-07-04 17:46:21',5,49.95),('SALE-1720115493995','D004','2024-07-04 17:51:34',5,79.95),('SALE-1720302588180','D014','2024-07-06 21:49:48',3,50.97),('SALE-1720302664791','D004','2024-07-06 21:51:05',3,47.97),('SALE-1720388911758','D013','2024-07-07 21:48:32',4,69.96),('SALE-1720973078631','D008','2024-07-14 16:04:39',3,67.50),('SALE-1720973176529','D012','2024-07-14 16:06:17',5,124.95),('SALE-1720973483486','D007','2024-07-14 16:11:23',3,60.00),('SALE-1720974506804','D009','2024-07-14 16:28:27',4,75.00);
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suppliers`
--

DROP TABLE IF EXISTS `suppliers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suppliers` (
  `supplierID` varchar(10) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`supplierID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suppliers`
--

LOCK TABLES `suppliers` WRITE;
/*!40000 ALTER TABLE `suppliers` DISABLE KEYS */;
/*!40000 ALTER TABLE `suppliers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-30 11:12:23
