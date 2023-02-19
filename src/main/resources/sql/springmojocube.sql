-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mybatis
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_dept`
--

DROP TABLE IF EXISTS `tb_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_dept` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_dept`
--

LOCK TABLES `tb_dept` WRITE;
/*!40000 ALTER TABLE `tb_dept` DISABLE KEYS */;
INSERT INTO `tb_dept` VALUES (11,'Dara Crosby'),(13,'Leo Schultz'),(15,'Germane Ortega'),(17,'Chancellor Morton'),(19,'Jorden Hewitt'),(21,'Abdul Molina'),(23,'Nathan Fitzpatrick'),(25,'Ila Kirkland'),(27,'Joshua Powell'),(29,'Lenore Reeves'),(31,'Alisa Paul'),(33,'Fallon Neal'),(35,'Marah Hood'),(37,'Dylan Gray'),(39,'Yeo Mayo'),(41,'Beatrice Cochran'),(43,'Elijah Jordan'),(45,'Dieter Clements'),(47,'Echo Monroe'),(49,'Rinah Delgado');
/*!40000 ALTER TABLE `tb_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_reservation`
--

DROP TABLE IF EXISTS `tb_reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_reservation` (
  `id` int NOT NULL,
  `doctor_name` varchar(255) DEFAULT NULL,
  `day` int DEFAULT NULL,
  `size` int DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `dept_id` int DEFAULT NULL,
  `title_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_reservation`
--

LOCK TABLES `tb_reservation` WRITE;
/*!40000 ALTER TABLE `tb_reservation` DISABLE KEYS */;
INSERT INTO `tb_reservation` VALUES (1,'Linus',1,6,_binary '',11,5),(2,'Bradley',4,6,_binary '',13,8),(3,'Geoffrey',1,8,_binary '',15,11),(4,'Bradley',0,2,_binary '',17,14),(5,'Raymond',6,2,_binary '',19,17),(6,'Rajah',8,3,_binary '',21,20),(7,'Addison',5,8,_binary '\0',23,23),(8,'Paul',2,5,_binary '\0',25,26),(9,'Kaseem',3,4,_binary '',27,29),(10,'Elton',5,4,_binary '',29,32),(11,'Gregory',7,8,_binary '\0',31,35),(12,'Hedley',5,7,_binary '',33,38),(13,'Knox',1,4,_binary '\0',35,41),(14,'Zachary',8,1,_binary '',37,44),(15,'Wade',8,1,_binary '',39,47),(16,'Jonah',2,3,_binary '\0',41,50),(17,'Basil',1,2,_binary '',43,53),(18,'Jakeem',2,1,_binary '\0',45,56),(19,'Fritz',2,8,_binary '',47,59),(20,'Carter',7,6,_binary '\0',49,62);
/*!40000 ALTER TABLE `tb_reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_title`
--

DROP TABLE IF EXISTS `tb_title`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_title` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_title`
--

LOCK TABLES `tb_title` WRITE;
/*!40000 ALTER TABLE `tb_title` DISABLE KEYS */;
INSERT INTO `tb_title` VALUES (5,'Dorothy Bruce'),(8,'Halla Stone'),(11,'Chandler Emerson'),(14,'Elvis Joseph'),(17,'Karleigh Mills'),(20,'Alana Key'),(23,'Gareth Vincent'),(26,'Walter Lucas'),(29,'Kylee Larson'),(32,'Hammett Frederick'),(35,'Charlotte Sloan'),(38,'Ashely Lynn'),(41,'Darius Battle'),(44,'Sean Flynn'),(47,'Damon Bennett'),(50,'Alexis Simmons'),(53,'Maxine Vincent'),(56,'Alexa Hensley'),(59,'Anthony Ruiz'),(62,'Ronan Hancock');
/*!40000 ALTER TABLE `tb_title` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_user` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES (1,'张三','1234',_binary ''),(2,'李四','5678',_binary '');
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-19 10:57:07
