-- MySQL dump 10.13  Distrib 8.0.34, for macos13 (x86_64)
--
-- Host: localhost    Database: computer_store
-- ------------------------------------------------------
-- Server version	8.2.0

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `addrId` int NOT NULL,
  `street` varchar(100) NOT NULL,
  `province` varchar(20) NOT NULL,
  `country` varchar(50) NOT NULL,
  `postalCode` varchar(10) NOT NULL,
  `phone` varchar(20) NOT NULL,
  PRIMARY KEY (`addrId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrator` (
  `adminId` int NOT NULL,
  `admFirstName` varchar(20) NOT NULL,
  `admLastName` varchar(20) NOT NULL,
  `admAddrID` int NOT NULL,
  PRIMARY KEY (`adminId`),
  KEY `admAddrID` (`admAddrID`),
  CONSTRAINT `administrator_ibfk_1` FOREIGN KEY (`admAddrID`) REFERENCES `Address` (`addrId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL,
  `firstName` varchar(60) NOT NULL,
  `lastName` varchar(60) NOT NULL,
  `addressID` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `addressID` (`addressID`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`addressID`) REFERENCES `Address` (`addrId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `itemId` varchar(20) NOT NULL,
  `prodType` varchar(20) NOT NULL,
  `prodName` varchar(60) NOT NULL,
  `prodInfo` varchar(90) NOT NULL,
  `brand` varchar(60) NOT NULL,
  `quantity` int NOT NULL,
  `price` double NOT NULL,
  `rating` double DEFAULT NULL,
  `ecoFriendly` tinyint(1) DEFAULT NULL,
  `prodVersion` double NOT NULL,
  `prodPlatform` varchar(60) DEFAULT NULL,
  `imURL` varchar(30),
  `weight` int NOT NULL,
  PRIMARY KEY (`itemId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES ('ITM001','Laptop','Model X1','15-inch display, 8GB RAM, 256GB SSD','BrandA',10,1200,4.5,1,1.1,'Windows',1500),('ITM002','Desktop','Model D2','Core i5, 16GB RAM, 1TB HDD','BrandB',15,800,4.3,0,2,'Linux',7500),('ITM003','Monitor','UltraView 27','27-inch 4K UHD','BrandC',20,300,4.7,1,1,'Any',3000),('ITM004','Keyboard','Mechanical KB100','Mechanical keys, RGB lighting','BrandD',30,100,4.6,0,1.2,'Any',500),('ITM005','Mouse','GamerMouse Pro','Ergonomic design, 7 buttons','BrandE',50,50,4.4,1,1.3,'Any',200),('ITM006','Headphones','AudioBeat X','Noise cancellation, wireless','BrandF',25,150,4.8,0,2.1,'Any',300),('ITM007','Speaker','SoundWave 3','Bluetooth connectivity, waterproof','BrandG',15,80,4.2,1,2,'Any',600),('ITM008','Tablet','Tab Elite 8','8-inch screen, 64GB storage','BrandH',10,400,4.5,0,1.4,'Android',700),('ITM009','Router','NetFast X500','Dual-band, 4 antennas','BrandI',20,120,4.3,1,1.5,'Any',400),('ITM010','Printer','PrintMaster 2000','Laser printer, wireless','BrandJ',12,250,4,0,1,'Any',5000),('ITM011','Scanner','ScanPro 3D','3D scanning capabilities','BrandK',5,500,4.6,1,1.2,'Any',4500),('ITM012','Webcam','ClearView HD','1080p, built-in microphone','BrandL',25,70,4.4,0,1,'Any',150),('ITM013','External Drive','1TB StorePlus','1TB capacity, USB 3.0','BrandM',20,90,4.7,1,1.1,'Any',250),('ITM014','Graphics Card','GTX 1080Ti','11GB GDDR5X','BrandN',8,700,4.8,0,1,'Any',800),('ITM015','RAM','16GB DDR4','16GB, 3200MHz','BrandO',30,60,4.5,1,1,'Any',100);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderItem`
--

DROP TABLE IF EXISTS `orderItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderItem` (
  `orderItemId` int NOT NULL AUTO_INCREMENT,
  `purchId` int NOT NULL,
  `itemId` varchar(20) NOT NULL,
  `quantity` int NOT NULL,
  `orderItemCost` double NOT NULL,
  PRIMARY KEY (`orderItemId`),
  KEY `purchId` (`purchId`),
  KEY `itemId` (`itemId`),
  CONSTRAINT `orderitem_ibfk_1` FOREIGN KEY (`purchId`) REFERENCES `purchaseOrder` (`purchId`),
  CONSTRAINT `orderitem_ibfk_2` FOREIGN KEY (`itemId`) REFERENCES `item` (`itemId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderItem`
--

LOCK TABLES `orderItem` WRITE;
/*!40000 ALTER TABLE `orderItem` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchaseOrder`
--

DROP TABLE IF EXISTS `purchaseOrder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchaseOrder` (
  `purchId` int NOT NULL,
  `customerId` int NOT NULL,
  `quantity` int NOT NULL,
  `date` varchar(20) NOT NULL,
  PRIMARY KEY (`purchId`),
  KEY `customerId` (`customerId`),
  CONSTRAINT `purchaseorder_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchaseOrder`
--

LOCK TABLES `purchaseOrder` WRITE;
/*!40000 ALTER TABLE `purchaseOrder` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchaseOrder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `reviewId` varchar(20) NOT NULL,
  `productId` varchar(20) NOT NULL,
  `review` varchar(200) DEFAULT NULL,
  `rating` double NOT NULL,
  `customerId` int DEFAULT NULL,
  PRIMARY KEY (`reviewId`),
  KEY `customerId` (`customerId`),
  KEY `productId` (`productId`),
  CONSTRAINT `review_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `customer` (`id`),
  CONSTRAINT `review_ibfk_2` FOREIGN KEY (`productId`) REFERENCES `item` (`itemId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-25 22:32:15
