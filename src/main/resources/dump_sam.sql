-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: localhost    Database: sam
-- ------------------------------------------------------
-- Server version	5.7.20-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `sam`
--

/*!40000 DROP DATABASE IF EXISTS `sam`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `sam /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `sam`;

--
-- Table structure for table `design`
--

DROP TABLE IF EXISTS `design`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `design` (
  `sam_id` bigint(20) NOT NULL,
  `judges` int(11) DEFAULT NULL,
  `samples` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `design`
--

LOCK TABLES `design` WRITE;
/*!40000 ALTER TABLE `design` DISABLE KEYS */;
INSERT INTO `design` VALUES (15,35,'producto 1,producto 2');
/*!40000 ALTER TABLE `design` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `design_design_slots`
--

DROP TABLE IF EXISTS `design_design_slots`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `design_design_slots` (
  `design_sam_id` bigint(20) NOT NULL,
  `design_slots_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_6osv6617ykw226j8q3rdupkf6` (`design_slots_id`),
  KEY `FKcd30uu17lw5huc2l0rvkc4wmy` (`design_sam_id`),
  CONSTRAINT `FK1k1477jicwlu7k25eudno7fth` FOREIGN KEY (`design_slots_id`) REFERENCES `design_slot` (`id`),
  CONSTRAINT `FKcd30uu17lw5huc2l0rvkc4wmy` FOREIGN KEY (`design_sam_id`) REFERENCES `design` (`sam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `design_design_slots`
--

LOCK TABLES `design_design_slots` WRITE;
/*!40000 ALTER TABLE `design_design_slots` DISABLE KEYS */;
INSERT INTO `design_design_slots` VALUES (15,173),(15,174),(15,175),(15,176),(15,177),(15,178),(15,179),(15,180),(15,181),(15,182),(15,183),(15,184),(15,185),(15,186),(15,187),(15,188),(15,189),(15,190),(15,191),(15,192),(15,193),(15,194),(15,195),(15,196),(15,197),(15,198),(15,199),(15,200),(15,201),(15,202),(15,203),(15,204),(15,205),(15,206),(15,207);
/*!40000 ALTER TABLE `design_design_slots` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `design_slot`
--

DROP TABLE IF EXISTS `design_slot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `design_slot` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `judge` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=208 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `design_slot`
--

LOCK TABLES `design_slot` WRITE;
/*!40000 ALTER TABLE `design_slot` DISABLE KEYS */;
INSERT INTO `design_slot` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10),(11,11),(12,12),(13,13),(14,14),(15,15),(16,16),(17,17),(18,18),(19,19),(20,20),(21,21),(22,22),(23,23),(24,24),(25,25),(26,26),(27,27),(28,28),(29,29),(30,30),(31,31),(32,32),(33,33),(34,34),(35,35),(36,1),(37,2),(38,3),(39,4),(40,5),(41,6),(42,7),(43,8),(44,9),(45,10),(46,11),(47,12),(48,13),(49,14),(50,15),(51,16),(52,17),(53,18),(54,19),(55,20),(56,21),(57,22),(58,23),(59,24),(60,25),(61,26),(62,27),(63,28),(64,29),(65,30),(66,31),(67,32),(68,33),(69,34),(70,35),(173,1),(174,2),(175,3),(176,4),(177,5),(178,6),(179,7),(180,8),(181,9),(182,10),(183,11),(184,12),(185,13),(186,14),(187,15),(188,16),(189,17),(190,18),(191,19),(192,20),(193,21),(194,22),(195,23),(196,24),(197,25),(198,26),(199,27),(200,28),(201,29),(202,30),(203,31),(204,32),(205,33),(206,34),(207,35);
/*!40000 ALTER TABLE `design_slot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `design_slot_labels`
--

DROP TABLE IF EXISTS `design_slot_labels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `design_slot_labels` (
  `design_slot_id` bigint(20) NOT NULL,
  `labels_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_gckjhirsnvwayem91beb4ui0y` (`labels_id`),
  KEY `FKja6von3csxiuq8djewdmw7g66` (`design_slot_id`),
  CONSTRAINT `FKja6von3csxiuq8djewdmw7g66` FOREIGN KEY (`design_slot_id`) REFERENCES `design_slot` (`id`),
  CONSTRAINT `FKo0xcg8m6j0hdmutuertu7a2gj` FOREIGN KEY (`labels_id`) REFERENCES `label` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `design_slot_labels`
--

LOCK TABLES `design_slot_labels` WRITE;
/*!40000 ALTER TABLE `design_slot_labels` DISABLE KEYS */;
INSERT INTO `design_slot_labels` VALUES (1,1),(1,2),(1,3),(2,4),(2,5),(2,6),(3,7),(3,8),(3,9),(4,10),(4,11),(4,12),(5,13),(5,14),(5,15),(6,16),(6,17),(6,18),(7,19),(7,20),(7,21),(8,22),(8,23),(8,24),(9,25),(9,26),(9,27),(10,28),(10,29),(10,30),(11,31),(11,32),(11,33),(12,34),(12,35),(12,36),(13,37),(13,38),(13,39),(14,40),(14,41),(14,42),(15,43),(15,44),(15,45),(16,46),(16,47),(16,48),(17,49),(17,50),(17,51),(18,52),(18,53),(18,54),(19,55),(19,56),(19,57),(20,58),(20,59),(20,60),(21,61),(21,62),(21,63),(22,64),(22,65),(22,66),(23,67),(23,68),(23,69),(24,70),(24,71),(24,72),(25,73),(25,74),(25,75),(26,76),(26,77),(26,78),(27,79),(27,80),(27,81),(28,82),(28,83),(28,84),(29,85),(29,86),(29,87),(30,88),(30,89),(30,90),(31,91),(31,92),(31,93),(32,94),(32,95),(32,96),(33,97),(33,98),(33,99),(34,100),(34,101),(34,102),(35,103),(35,104),(35,105),(36,106),(36,107),(36,108),(37,109),(37,110),(37,111),(38,112),(38,113),(38,114),(39,115),(39,116),(39,117),(40,118),(40,119),(40,120),(41,121),(41,122),(41,123),(42,124),(42,125),(42,126),(43,127),(43,128),(43,129),(44,130),(44,131),(44,132),(45,133),(45,134),(45,135),(46,136),(46,137),(46,138),(47,139),(47,140),(47,141),(48,142),(48,143),(48,144),(49,145),(49,146),(49,147),(50,148),(50,149),(50,150),(51,151),(51,152),(51,153),(52,154),(52,155),(52,156),(53,157),(53,158),(53,159),(54,160),(54,161),(54,162),(55,163),(55,164),(55,165),(56,166),(56,167),(56,168),(57,169),(57,170),(57,171),(58,172),(58,173),(58,174),(59,175),(59,176),(59,177),(60,178),(60,179),(60,180),(61,181),(61,182),(61,183),(62,184),(62,185),(62,186),(63,187),(63,188),(63,189),(64,190),(64,191),(64,192),(65,193),(65,194),(65,195),(66,196),(66,197),(66,198),(67,199),(67,200),(67,201),(68,202),(68,203),(68,204),(69,205),(69,206),(69,207),(70,208),(70,209),(70,210),(173,517),(173,518),(174,519),(174,520),(175,521),(175,522),(176,523),(176,524),(177,525),(177,526),(178,527),(178,528),(179,529),(179,530),(180,531),(180,532),(181,533),(181,534),(182,535),(182,536),(183,537),(183,538),(184,539),(184,540),(185,541),(185,542),(186,543),(186,544),(187,545),(187,546),(188,547),(188,548),(189,549),(189,550),(190,551),(190,552),(191,553),(191,554),(192,555),(192,556),(193,557),(193,558),(194,559),(194,560),(195,561),(195,562),(196,563),(196,564),(197,565),(197,566),(198,567),(198,568),(199,569),(199,570),(200,571),(200,572),(201,573),(201,574),(202,575),(202,576),(203,577),(203,578),(204,579),(204,580),(205,581),(205,582),(206,583),(206,584),(207,585),(207,586);
/*!40000 ALTER TABLE `design_slot_labels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `label`
--

DROP TABLE IF EXISTS `label`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `label` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `label_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=587 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `label`
--

LOCK TABLES `label` WRITE;
/*!40000 ALTER TABLE `label` DISABLE KEYS */;
INSERT INTO `label` VALUES (1,'b',525),(2,'c',967),(3,'a',438),(4,'c',421),(5,'b',730),(6,'a',835),(7,'b',285),(8,'c',155),(9,'a',436),(10,'a',60),(11,'c',945),(12,'b',189),(13,'c',807),(14,'a',138),(15,'b',278),(16,'c',71),(17,'a',98),(18,'b',666),(19,'c',408),(20,'a',376),(21,'b',440),(22,'b',455),(23,'a',864),(24,'c',240),(25,'c',833),(26,'b',703),(27,'a',623),(28,'b',268),(29,'c',688),(30,'a',246),(31,'a',841),(32,'b',726),(33,'c',907),(34,'a',705),(35,'b',212),(36,'c',817),(37,'b',57),(38,'a',764),(39,'c',143),(40,'a',968),(41,'c',904),(42,'b',574),(43,'c',628),(44,'b',390),(45,'a',298),(46,'b',204),(47,'c',847),(48,'a',514),(49,'b',224),(50,'c',840),(51,'a',822),(52,'c',632),(53,'b',313),(54,'a',640),(55,'c',827),(56,'a',700),(57,'b',739),(58,'c',966),(59,'b',308),(60,'a',9),(61,'b',104),(62,'a',624),(63,'c',499),(64,'a',931),(65,'b',494),(66,'c',595),(67,'b',903),(68,'a',656),(69,'c',209),(70,'c',28),(71,'b',460),(72,'a',117),(73,'a',464),(74,'b',395),(75,'c',552),(76,'c',467),(77,'a',549),(78,'b',180),(79,'c',890),(80,'b',345),(81,'a',193),(82,'a',882),(83,'c',939),(84,'b',592),(85,'a',777),(86,'c',529),(87,'b',912),(88,'a',359),(89,'c',301),(90,'b',880),(91,'b',681),(92,'a',515),(93,'c',845),(94,'a',696),(95,'c',707),(96,'b',687),(97,'a',597),(98,'b',39),(99,'c',407),(100,'c',304),(101,'b',378),(102,'a',461),(103,'a',424),(104,'b',305),(105,'c',381),(106,'c',78),(107,'b',415),(108,'a',814),(109,'b',758),(110,'c',633),(111,'a',624),(112,'a',617),(113,'b',418),(114,'c',257),(115,'b',117),(116,'a',407),(117,'c',272),(118,'b',161),(119,'c',85),(120,'a',112),(121,'b',563),(122,'c',733),(123,'a',811),(124,'c',7),(125,'a',591),(126,'b',920),(127,'b',275),(128,'a',893),(129,'c',124),(130,'a',149),(131,'c',965),(132,'b',908),(133,'a',772),(134,'c',277),(135,'b',288),(136,'b',661),(137,'a',298),(138,'c',612),(139,'b',455),(140,'a',852),(141,'c',152),(142,'a',121),(143,'c',460),(144,'b',827),(145,'b',426),(146,'c',154),(147,'a',109),(148,'b',457),(149,'c',193),(150,'a',573),(151,'b',307),(152,'a',410),(153,'c',323),(154,'b',297),(155,'a',41),(156,'c',252),(157,'b',781),(158,'c',222),(159,'a',537),(160,'b',301),(161,'a',427),(162,'c',521),(163,'a',2),(164,'c',664),(165,'b',31),(166,'b',794),(167,'c',732),(168,'a',885),(169,'a',761),(170,'c',26),(171,'b',701),(172,'b',517),(173,'a',151),(174,'c',689),(175,'a',484),(176,'c',779),(177,'b',118),(178,'c',513),(179,'b',20),(180,'a',620),(181,'a',950),(182,'c',219),(183,'b',981),(184,'b',322),(185,'c',674),(186,'a',584),(187,'c',369),(188,'b',886),(189,'a',412),(190,'c',345),(191,'b',523),(192,'a',411),(193,'c',362),(194,'b',678),(195,'a',812),(196,'b',994),(197,'a',810),(198,'c',595),(199,'c',973),(200,'a',997),(201,'b',500),(202,'c',12),(203,'b',209),(204,'a',927),(205,'b',530),(206,'c',900),(207,'a',459),(208,'a',235),(209,'c',825),(210,'b',559),(517,'producto 2',867),(518,'producto 1',148),(519,'producto 2',410),(520,'producto 1',353),(521,'producto 1',524),(522,'producto 2',313),(523,'producto 2',419),(524,'producto 1',135),(525,'producto 1',289),(526,'producto 2',843),(527,'producto 1',964),(528,'producto 2',652),(529,'producto 1',346),(530,'producto 2',184),(531,'producto 1',626),(532,'producto 2',436),(533,'producto 1',57),(534,'producto 2',551),(535,'producto 1',787),(536,'producto 2',161),(537,'producto 2',486),(538,'producto 1',533),(539,'producto 1',372),(540,'producto 2',100),(541,'producto 1',87),(542,'producto 2',268),(543,'producto 1',144),(544,'producto 2',427),(545,'producto 2',875),(546,'producto 1',303),(547,'producto 2',442),(548,'producto 1',813),(549,'producto 2',958),(550,'producto 1',239),(551,'producto 2',1),(552,'producto 1',720),(553,'producto 2',49),(554,'producto 1',46),(555,'producto 2',883),(556,'producto 1',552),(557,'producto 2',295),(558,'producto 1',572),(559,'producto 2',622),(560,'producto 1',582),(561,'producto 1',484),(562,'producto 2',743),(563,'producto 2',103),(564,'producto 1',733),(565,'producto 1',390),(566,'producto 2',82),(567,'producto 2',644),(568,'producto 1',983),(569,'producto 1',256),(570,'producto 2',198),(571,'producto 1',799),(572,'producto 2',750),(573,'producto 1',986),(574,'producto 2',628),(575,'producto 2',324),(576,'producto 1',880),(577,'producto 1',177),(578,'producto 2',350),(579,'producto 1',930),(580,'producto 2',93),(581,'producto 2',795),(582,'producto 1',693),(583,'producto 1',40),(584,'producto 2',451),(585,'producto 1',421),(586,'producto 2',88);
/*!40000 ALTER TABLE `label` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `numeric_attribute`
--

DROP TABLE IF EXISTS `numeric_attribute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `numeric_attribute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `attribute` varchar(255) DEFAULT NULL,
  `product` varchar(255) DEFAULT NULL,
  `sam_id` bigint(20) NOT NULL,
  `value` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1401 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `numeric_attribute`
--

LOCK TABLES `numeric_attribute` WRITE;
/*!40000 ALTER TABLE `numeric_attribute` DISABLE KEYS */;
INSERT INTO `numeric_attribute` VALUES (1,'agrado del sabor','producto 1',3,6),(2,'agrado del sabor','producto 2',3,5),(3,'agrado del sabor','producto 3',3,2),(4,'intensidad del sabor','producto 1',3,3),(5,'intensidad del sabor','producto 2',3,3),(6,'intensidad del sabor','producto 3',3,2),(7,'intensidad del sabor residual','producto 1',3,3),(8,'intensidad del sabor residual','producto 2',3,3),(9,'intensidad del sabor residual','producto 3',3,7),(10,'agrado del sabor','producto 1',3,6),(11,'agrado del sabor','producto 2',3,4),(12,'agrado del sabor','producto 3',3,8),(13,'intensidad del sabor','producto 1',3,3),(14,'intensidad del sabor','producto 2',3,4),(15,'intensidad del sabor','producto 3',3,10),(16,'intensidad del sabor residual','producto 1',3,3),(17,'intensidad del sabor residual','producto 2',3,3),(18,'intensidad del sabor residual','producto 3',3,3),(19,'agrado del sabor','producto 1',3,6),(20,'agrado del sabor','producto 2',3,3),(21,'agrado del sabor','producto 3',3,10),(22,'intensidad del sabor','producto 1',3,3),(23,'intensidad del sabor','producto 2',3,4),(24,'intensidad del sabor','producto 3',3,10),(25,'intensidad del sabor residual','producto 1',3,3),(26,'intensidad del sabor residual','producto 2',3,2),(27,'intensidad del sabor residual','producto 3',3,3),(28,'agrado del sabor','producto 1',3,7),(29,'agrado del sabor','producto 2',3,5),(30,'agrado del sabor','producto 3',3,9),(31,'intensidad del sabor','producto 1',3,3),(32,'intensidad del sabor','producto 2',3,2),(33,'intensidad del sabor','producto 3',3,1),(34,'intensidad del sabor residual','producto 1',3,3),(35,'intensidad del sabor residual','producto 2',3,1),(36,'intensidad del sabor residual','producto 3',3,9),(37,'agrado del sabor','producto 1',3,5),(38,'agrado del sabor','producto 2',3,4),(39,'agrado del sabor','producto 3',3,7),(40,'intensidad del sabor','producto 1',3,3),(41,'intensidad del sabor','producto 2',3,2),(42,'intensidad del sabor','producto 3',3,2),(43,'intensidad del sabor residual','producto 1',3,3),(44,'intensidad del sabor residual','producto 2',3,2),(45,'intensidad del sabor residual','producto 3',3,4),(46,'agrado del sabor','producto 1',3,6),(47,'agrado del sabor','producto 2',3,2),(48,'agrado del sabor','producto 3',3,7),(49,'intensidad del sabor','producto 1',3,3),(50,'intensidad del sabor','producto 2',3,5),(51,'intensidad del sabor','producto 3',3,10),(52,'intensidad del sabor residual','producto 1',3,3),(53,'intensidad del sabor residual','producto 2',3,4),(54,'intensidad del sabor residual','producto 3',3,4),(55,'agrado del sabor','producto 1',3,5),(56,'agrado del sabor','producto 2',3,5),(57,'agrado del sabor','producto 3',3,10),(58,'intensidad del sabor','producto 1',3,3),(59,'intensidad del sabor','producto 2',3,3),(60,'intensidad del sabor','producto 3',3,5),(61,'intensidad del sabor residual','producto 1',3,3),(62,'intensidad del sabor residual','producto 2',3,3),(63,'intensidad del sabor residual','producto 3',3,7),(64,'agrado del sabor','producto 1',3,6),(65,'agrado del sabor','producto 2',3,5),(66,'agrado del sabor','producto 3',3,4),(67,'intensidad del sabor','producto 1',3,3),(68,'intensidad del sabor','producto 2',3,3),(69,'intensidad del sabor','producto 3',3,4),(70,'intensidad del sabor residual','producto 1',3,3),(71,'intensidad del sabor residual','producto 2',3,3),(72,'intensidad del sabor residual','producto 3',3,10),(73,'agrado del sabor','producto 1',3,6),(74,'agrado del sabor','producto 2',3,5),(75,'agrado del sabor','producto 3',3,2),(76,'intensidad del sabor','producto 1',3,3),(77,'intensidad del sabor','producto 2',3,3),(78,'intensidad del sabor','producto 3',3,8),(79,'intensidad del sabor residual','producto 1',3,3),(80,'intensidad del sabor residual','producto 2',3,3),(81,'intensidad del sabor residual','producto 3',3,2),(82,'agrado del sabor','producto 1',3,6),(83,'agrado del sabor','producto 2',3,4),(84,'agrado del sabor','producto 3',3,7),(85,'intensidad del sabor','producto 1',3,3),(86,'intensidad del sabor','producto 2',3,3),(87,'intensidad del sabor','producto 3',3,7),(88,'intensidad del sabor residual','producto 1',3,3),(89,'intensidad del sabor residual','producto 2',3,3),(90,'intensidad del sabor residual','producto 3',3,7),(91,'agrado del sabor','producto 1',3,6),(92,'agrado del sabor','producto 2',3,4),(93,'agrado del sabor','producto 3',3,5),(94,'intensidad del sabor','producto 1',3,3),(95,'intensidad del sabor','producto 2',3,4),(96,'intensidad del sabor','producto 3',3,9),(97,'intensidad del sabor residual','producto 1',3,3),(98,'intensidad del sabor residual','producto 2',3,4),(99,'intensidad del sabor residual','producto 3',3,9),(100,'agrado del sabor','producto 1',3,6),(101,'agrado del sabor','producto 2',3,5),(102,'agrado del sabor','producto 3',3,6),(103,'intensidad del sabor','producto 1',3,3),(104,'intensidad del sabor','producto 2',3,3),(105,'intensidad del sabor','producto 3',3,3),(106,'intensidad del sabor residual','producto 1',3,3),(107,'intensidad del sabor residual','producto 2',3,3),(108,'intensidad del sabor residual','producto 3',3,8),(109,'agrado del sabor','producto 1',3,7),(110,'agrado del sabor','producto 2',3,6),(111,'agrado del sabor','producto 3',3,3),(112,'intensidad del sabor','producto 1',3,3),(113,'intensidad del sabor','producto 2',3,3),(114,'intensidad del sabor','producto 3',3,9),(115,'intensidad del sabor residual','producto 1',3,3),(116,'intensidad del sabor residual','producto 2',3,3),(117,'intensidad del sabor residual','producto 3',3,3),(118,'agrado del sabor','producto 1',3,6),(119,'agrado del sabor','producto 2',3,5),(120,'agrado del sabor','producto 3',3,9),(121,'intensidad del sabor','producto 1',3,3),(122,'intensidad del sabor','producto 2',3,3),(123,'intensidad del sabor','producto 3',3,10),(124,'intensidad del sabor residual','producto 1',3,3),(125,'intensidad del sabor residual','producto 2',3,4),(126,'intensidad del sabor residual','producto 3',3,9),(127,'agrado del sabor','producto 1',3,5),(128,'agrado del sabor','producto 2',3,2),(129,'agrado del sabor','producto 3',3,4),(130,'intensidad del sabor','producto 1',3,2),(131,'intensidad del sabor','producto 2',3,5),(132,'intensidad del sabor','producto 3',3,8),(133,'intensidad del sabor residual','producto 1',3,3),(134,'intensidad del sabor residual','producto 2',3,2),(135,'intensidad del sabor residual','producto 3',3,9),(136,'agrado del sabor','producto 1',3,6),(137,'agrado del sabor','producto 2',3,5),(138,'agrado del sabor','producto 3',3,5),(139,'intensidad del sabor','producto 1',3,3),(140,'intensidad del sabor','producto 2',3,3),(141,'intensidad del sabor','producto 3',3,4),(142,'intensidad del sabor residual','producto 1',3,3),(143,'intensidad del sabor residual','producto 2',3,3),(144,'intensidad del sabor residual','producto 3',3,8),(145,'agrado del sabor','producto 1',3,6),(146,'agrado del sabor','producto 2',3,4),(147,'agrado del sabor','producto 3',3,5),(148,'intensidad del sabor','producto 1',3,3),(149,'intensidad del sabor','producto 2',3,2),(150,'intensidad del sabor','producto 3',3,6),(151,'intensidad del sabor residual','producto 1',3,3),(152,'intensidad del sabor residual','producto 2',3,2),(153,'intensidad del sabor residual','producto 3',3,5),(154,'agrado del sabor','producto 1',3,4),(155,'agrado del sabor','producto 2',3,3),(156,'agrado del sabor','producto 3',3,9),(157,'intensidad del sabor','producto 1',3,4),(158,'intensidad del sabor','producto 2',3,2),(159,'intensidad del sabor','producto 3',3,6),(160,'intensidad del sabor residual','producto 1',3,4),(161,'intensidad del sabor residual','producto 2',3,2),(162,'intensidad del sabor residual','producto 3',3,4),(163,'agrado del sabor','producto 1',3,6),(164,'agrado del sabor','producto 2',3,4),(165,'agrado del sabor','producto 3',3,6),(166,'intensidad del sabor','producto 1',3,3),(167,'intensidad del sabor','producto 2',3,2),(168,'intensidad del sabor','producto 3',3,10),(169,'intensidad del sabor residual','producto 1',3,3),(170,'intensidad del sabor residual','producto 2',3,2),(171,'intensidad del sabor residual','producto 3',3,3),(172,'agrado del sabor','producto 1',3,5),(173,'agrado del sabor','producto 2',3,4),(174,'agrado del sabor','producto 3',3,7),(175,'intensidad del sabor','producto 1',3,2),(176,'intensidad del sabor','producto 2',3,3),(177,'intensidad del sabor','producto 3',3,9),(178,'intensidad del sabor residual','producto 1',3,3),(179,'intensidad del sabor residual','producto 2',3,3),(180,'intensidad del sabor residual','producto 3',3,1),(181,'agrado del sabor','producto 1',3,6),(182,'agrado del sabor','producto 2',3,5),(183,'agrado del sabor','producto 3',3,4),(184,'intensidad del sabor','producto 1',3,3),(185,'intensidad del sabor','producto 2',3,3),(186,'intensidad del sabor','producto 3',3,3),(187,'intensidad del sabor residual','producto 1',3,3),(188,'intensidad del sabor residual','producto 2',3,3),(189,'intensidad del sabor residual','producto 3',3,8),(190,'agrado del sabor','producto 1',3,6),(191,'agrado del sabor','producto 2',3,6),(192,'agrado del sabor','producto 3',3,2),(193,'intensidad del sabor','producto 1',3,3),(194,'intensidad del sabor','producto 2',3,3),(195,'intensidad del sabor','producto 3',3,9),(196,'intensidad del sabor residual','producto 1',3,3),(197,'intensidad del sabor residual','producto 2',3,3),(198,'intensidad del sabor residual','producto 3',3,6),(199,'agrado del sabor','producto 1',3,3),(200,'agrado del sabor','producto 2',3,5),(201,'agrado del sabor','producto 3',3,1),(202,'intensidad del sabor','producto 1',3,3),(203,'intensidad del sabor','producto 2',3,4),(204,'intensidad del sabor','producto 3',3,5),(205,'intensidad del sabor residual','producto 1',3,1),(206,'intensidad del sabor residual','producto 2',3,1),(207,'intensidad del sabor residual','producto 3',3,5),(208,'agrado del sabor','producto 1',3,6),(209,'agrado del sabor','producto 2',3,3),(210,'agrado del sabor','producto 3',3,10),(211,'intensidad del sabor','producto 1',3,3),(212,'intensidad del sabor','producto 2',3,4),(213,'intensidad del sabor','producto 3',3,3),(214,'intensidad del sabor residual','producto 1',3,3),(215,'intensidad del sabor residual','producto 2',3,2),(216,'intensidad del sabor residual','producto 3',3,2),(217,'agrado del sabor','producto 1',3,6),(218,'agrado del sabor','producto 2',3,4),(219,'agrado del sabor','producto 3',3,10),(220,'intensidad del sabor','producto 1',3,3),(221,'intensidad del sabor','producto 2',3,2),(222,'intensidad del sabor','producto 3',3,4),(223,'intensidad del sabor residual','producto 1',3,3),(224,'intensidad del sabor residual','producto 2',3,2),(225,'intensidad del sabor residual','producto 3',3,8),(226,'agrado del sabor','producto 1',3,5),(227,'agrado del sabor','producto 2',3,2),(228,'agrado del sabor','producto 3',3,8),(229,'intensidad del sabor','producto 1',3,3),(230,'intensidad del sabor','producto 2',3,3),(231,'intensidad del sabor','producto 3',3,4),(232,'intensidad del sabor residual','producto 1',3,3),(233,'intensidad del sabor residual','producto 2',3,2),(234,'intensidad del sabor residual','producto 3',3,1),(235,'agrado del sabor','producto 1',3,6),(236,'agrado del sabor','producto 2',3,3),(237,'agrado del sabor','producto 3',3,7),(238,'intensidad del sabor','producto 1',3,3),(239,'intensidad del sabor','producto 2',3,2),(240,'intensidad del sabor','producto 3',3,8),(241,'intensidad del sabor residual','producto 1',3,3),(242,'intensidad del sabor residual','producto 2',3,4),(243,'intensidad del sabor residual','producto 3',3,5),(244,'agrado del sabor','producto 1',3,4),(245,'agrado del sabor','producto 2',3,5),(246,'agrado del sabor','producto 3',3,9),(247,'intensidad del sabor','producto 1',3,3),(248,'intensidad del sabor','producto 2',3,3),(249,'intensidad del sabor','producto 3',3,1),(250,'intensidad del sabor residual','producto 1',3,3),(251,'intensidad del sabor residual','producto 2',3,3),(252,'intensidad del sabor residual','producto 3',3,4),(253,'agrado del sabor','producto 1',3,5),(254,'agrado del sabor','producto 2',3,3),(255,'agrado del sabor','producto 3',3,8),(256,'intensidad del sabor','producto 1',3,3),(257,'intensidad del sabor','producto 2',3,1),(258,'intensidad del sabor','producto 3',3,9),(259,'intensidad del sabor residual','producto 1',3,2),(260,'intensidad del sabor residual','producto 2',3,4),(261,'intensidad del sabor residual','producto 3',3,6),(262,'agrado del sabor','producto 1',3,4),(263,'agrado del sabor','producto 2',3,3),(264,'agrado del sabor','producto 3',3,6),(265,'intensidad del sabor','producto 1',3,4),(266,'intensidad del sabor','producto 2',3,2),(267,'intensidad del sabor','producto 3',3,9),(268,'intensidad del sabor residual','producto 1',3,3),(269,'intensidad del sabor residual','producto 2',3,4),(270,'intensidad del sabor residual','producto 3',3,5),(271,'agrado del sabor','producto 1',3,4),(272,'agrado del sabor','producto 2',3,3),(273,'agrado del sabor','producto 3',3,8),(274,'intensidad del sabor','producto 1',3,4),(275,'intensidad del sabor','producto 2',3,5),(276,'intensidad del sabor','producto 3',3,5),(277,'intensidad del sabor residual','producto 1',3,4),(278,'intensidad del sabor residual','producto 2',3,5),(279,'intensidad del sabor residual','producto 3',3,5),(280,'agrado del sabor','producto 1',3,6),(281,'agrado del sabor','producto 2',3,2),(282,'agrado del sabor','producto 3',3,1),(283,'intensidad del sabor','producto 1',3,3),(284,'intensidad del sabor','producto 2',3,2),(285,'intensidad del sabor','producto 3',3,9),(286,'intensidad del sabor residual','producto 1',3,3),(287,'intensidad del sabor residual','producto 2',3,4),(288,'intensidad del sabor residual','producto 3',3,1),(289,'agrado del sabor','producto 1',3,6),(290,'agrado del sabor','producto 2',3,4),(291,'agrado del sabor','producto 3',3,10),(292,'intensidad del sabor','producto 1',3,3),(293,'intensidad del sabor','producto 2',3,3),(294,'intensidad del sabor','producto 3',3,4),(295,'intensidad del sabor residual','producto 1',3,3),(296,'intensidad del sabor residual','producto 2',3,3),(297,'intensidad del sabor residual','producto 3',3,8),(298,'agrado del sabor','producto 1',3,5),(299,'agrado del sabor','producto 2',3,5),(300,'agrado del sabor','producto 3',3,8),(301,'intensidad del sabor','producto 1',3,4),(302,'intensidad del sabor','producto 2',3,2),(303,'intensidad del sabor','producto 3',3,3),(304,'intensidad del sabor residual','producto 1',3,4),(305,'intensidad del sabor residual','producto 2',3,3),(306,'intensidad del sabor residual','producto 3',3,6),(307,'agrado del sabor','producto 1',3,6),(308,'agrado del sabor','producto 2',3,3),(309,'agrado del sabor','producto 3',3,1),(310,'intensidad del sabor','producto 1',3,3),(311,'intensidad del sabor','producto 2',3,2),(312,'intensidad del sabor','producto 3',3,10),(313,'intensidad del sabor residual','producto 1',3,3),(314,'intensidad del sabor residual','producto 2',3,3),(315,'intensidad del sabor residual','producto 3',3,5),(316,'agrado del sabor','producto 1',1,6),(317,'intensidad del sabor','producto 1',1,6),(318,'intensidad del sabor residual','producto 1',1,3),(319,'agrado del sabor','producto 1',1,6),(320,'intensidad del sabor','producto 1',1,4),(321,'intensidad del sabor residual','producto 1',1,3),(322,'agrado del sabor','producto 1',1,6),(323,'intensidad del sabor','producto 1',1,6),(324,'intensidad del sabor residual','producto 1',1,3),(325,'agrado del sabor','producto 1',1,7),(326,'intensidad del sabor','producto 1',1,6),(327,'intensidad del sabor residual','producto 1',1,3),(328,'agrado del sabor','producto 1',1,5),(329,'intensidad del sabor','producto 1',1,4),(330,'intensidad del sabor residual','producto 1',1,3),(331,'agrado del sabor','producto 1',1,6),(332,'intensidad del sabor','producto 1',1,6),(333,'intensidad del sabor residual','producto 1',1,3),(334,'agrado del sabor','producto 1',1,5),(335,'intensidad del sabor','producto 1',1,5),(336,'intensidad del sabor residual','producto 1',1,3),(337,'agrado del sabor','producto 1',1,6),(338,'intensidad del sabor','producto 1',1,5),(339,'intensidad del sabor residual','producto 1',1,3),(340,'agrado del sabor','producto 1',1,6),(341,'intensidad del sabor','producto 1',1,6),(342,'intensidad del sabor residual','producto 1',1,3),(343,'agrado del sabor','producto 1',1,6),(344,'intensidad del sabor','producto 1',1,5),(345,'intensidad del sabor residual','producto 1',1,3),(346,'agrado del sabor','producto 1',1,6),(347,'intensidad del sabor','producto 1',1,5),(348,'intensidad del sabor residual','producto 1',1,3),(349,'agrado del sabor','producto 1',1,6),(350,'intensidad del sabor','producto 1',1,6),(351,'intensidad del sabor residual','producto 1',1,3),(352,'agrado del sabor','producto 1',1,7),(353,'intensidad del sabor','producto 1',1,7),(354,'intensidad del sabor residual','producto 1',1,3),(355,'agrado del sabor','producto 1',1,6),(356,'intensidad del sabor','producto 1',1,6),(357,'intensidad del sabor residual','producto 1',1,3),(358,'agrado del sabor','producto 1',1,5),(359,'intensidad del sabor','producto 1',1,5),(360,'intensidad del sabor residual','producto 1',1,2),(361,'agrado del sabor','producto 1',1,6),(362,'intensidad del sabor','producto 1',1,5),(363,'intensidad del sabor residual','producto 1',1,3),(364,'agrado del sabor','producto 1',1,6),(365,'intensidad del sabor','producto 1',1,6),(366,'intensidad del sabor residual','producto 1',1,3),(367,'agrado del sabor','producto 1',1,4),(368,'intensidad del sabor','producto 1',1,5),(369,'intensidad del sabor residual','producto 1',1,4),(370,'agrado del sabor','producto 1',1,6),(371,'intensidad del sabor','producto 1',1,6),(372,'intensidad del sabor residual','producto 1',1,3),(373,'agrado del sabor','producto 1',1,5),(374,'intensidad del sabor','producto 1',1,4),(375,'intensidad del sabor residual','producto 1',1,2),(376,'agrado del sabor','producto 1',1,6),(377,'intensidad del sabor','producto 1',1,5),(378,'intensidad del sabor residual','producto 1',1,3),(379,'agrado del sabor','producto 1',1,6),(380,'intensidad del sabor','producto 1',1,6),(381,'intensidad del sabor residual','producto 1',1,3),(382,'agrado del sabor','producto 1',1,3),(383,'intensidad del sabor','producto 1',1,3),(384,'intensidad del sabor residual','producto 1',1,3),(385,'agrado del sabor','producto 1',1,6),(386,'intensidad del sabor','producto 1',1,6),(387,'intensidad del sabor residual','producto 1',1,3),(388,'agrado del sabor','producto 1',1,6),(389,'intensidad del sabor','producto 1',1,5),(390,'intensidad del sabor residual','producto 1',1,3),(391,'agrado del sabor','producto 1',1,5),(392,'intensidad del sabor','producto 1',1,5),(393,'intensidad del sabor residual','producto 1',1,3),(394,'agrado del sabor','producto 1',1,6),(395,'intensidad del sabor','producto 1',1,6),(396,'intensidad del sabor residual','producto 1',1,3),(397,'agrado del sabor','producto 1',1,4),(398,'intensidad del sabor','producto 1',1,4),(399,'intensidad del sabor residual','producto 1',1,3),(400,'agrado del sabor','producto 1',1,5),(401,'intensidad del sabor','producto 1',1,4),(402,'intensidad del sabor residual','producto 1',1,3),(403,'agrado del sabor','producto 1',1,4),(404,'intensidad del sabor','producto 1',1,4),(405,'intensidad del sabor residual','producto 1',1,4),(406,'agrado del sabor','producto 1',1,4),(407,'intensidad del sabor','producto 1',1,3),(408,'intensidad del sabor residual','producto 1',1,4),(409,'agrado del sabor','producto 1',1,6),(410,'intensidad del sabor','producto 1',1,6),(411,'intensidad del sabor residual','producto 1',1,3),(412,'agrado del sabor','producto 1',1,6),(413,'intensidad del sabor','producto 1',1,6),(414,'intensidad del sabor residual','producto 1',1,3),(415,'agrado del sabor','producto 1',1,5),(416,'intensidad del sabor','producto 1',1,4),(417,'intensidad del sabor residual','producto 1',1,4),(418,'agrado del sabor','producto 1',1,6),(419,'intensidad del sabor','producto 1',1,5),(420,'intensidad del sabor residual','producto 1',1,3),(421,'agrado del sabor','producto 1',1,6),(422,'intensidad del sabor','producto 1',1,6),(423,'intensidad del sabor residual','producto 1',1,3),(424,'agrado del sabor','producto 1',1,6),(425,'intensidad del sabor','producto 1',1,4),(426,'intensidad del sabor residual','producto 1',1,3),(427,'agrado del sabor','producto 1',1,6),(428,'intensidad del sabor','producto 1',1,6),(429,'intensidad del sabor residual','producto 1',1,3),(430,'agrado del sabor','producto 1',1,7),(431,'intensidad del sabor','producto 1',1,6),(432,'intensidad del sabor residual','producto 1',1,3),(433,'agrado del sabor','producto 1',1,5),(434,'intensidad del sabor','producto 1',1,4),(435,'intensidad del sabor residual','producto 1',1,3),(436,'agrado del sabor','producto 1',1,6),(437,'intensidad del sabor','producto 1',1,6),(438,'intensidad del sabor residual','producto 1',1,3),(439,'agrado del sabor','producto 1',1,5),(440,'intensidad del sabor','producto 1',1,5),(441,'intensidad del sabor residual','producto 1',1,3),(442,'agrado del sabor','producto 1',1,6),(443,'intensidad del sabor','producto 1',1,5),(444,'intensidad del sabor residual','producto 1',1,3),(445,'agrado del sabor','producto 1',1,6),(446,'intensidad del sabor','producto 1',1,6),(447,'intensidad del sabor residual','producto 1',1,3),(448,'agrado del sabor','producto 1',1,6),(449,'intensidad del sabor','producto 1',1,5),(450,'intensidad del sabor residual','producto 1',1,3),(451,'agrado del sabor','producto 1',1,6),(452,'intensidad del sabor','producto 1',1,5),(453,'intensidad del sabor residual','producto 1',1,3),(454,'agrado del sabor','producto 1',1,6),(455,'intensidad del sabor','producto 1',1,6),(456,'intensidad del sabor residual','producto 1',1,3),(457,'agrado del sabor','producto 1',1,7),(458,'intensidad del sabor','producto 1',1,7),(459,'intensidad del sabor residual','producto 1',1,3),(460,'agrado del sabor','producto 1',1,6),(461,'intensidad del sabor','producto 1',1,6),(462,'intensidad del sabor residual','producto 1',1,3),(463,'agrado del sabor','producto 1',1,5),(464,'intensidad del sabor','producto 1',1,5),(465,'intensidad del sabor residual','producto 1',1,2),(466,'agrado del sabor','producto 1',1,6),(467,'intensidad del sabor','producto 1',1,5),(468,'intensidad del sabor residual','producto 1',1,3),(469,'agrado del sabor','producto 1',1,6),(470,'intensidad del sabor','producto 1',1,6),(471,'intensidad del sabor residual','producto 1',1,3),(472,'agrado del sabor','producto 1',1,4),(473,'intensidad del sabor','producto 1',1,5),(474,'intensidad del sabor residual','producto 1',1,4),(475,'agrado del sabor','producto 1',1,6),(476,'intensidad del sabor','producto 1',1,6),(477,'intensidad del sabor residual','producto 1',1,3),(478,'agrado del sabor','producto 1',1,5),(479,'intensidad del sabor','producto 1',1,4),(480,'intensidad del sabor residual','producto 1',1,2),(481,'agrado del sabor','producto 1',1,6),(482,'intensidad del sabor','producto 1',1,5),(483,'intensidad del sabor residual','producto 1',1,3),(484,'agrado del sabor','producto 1',1,6),(485,'intensidad del sabor','producto 1',1,6),(486,'intensidad del sabor residual','producto 1',1,3),(487,'agrado del sabor','producto 1',1,3),(488,'intensidad del sabor','producto 1',1,3),(489,'intensidad del sabor residual','producto 1',1,3),(490,'agrado del sabor','producto 1',1,6),(491,'intensidad del sabor','producto 1',1,6),(492,'intensidad del sabor residual','producto 1',1,3),(493,'agrado del sabor','producto 1',1,6),(494,'intensidad del sabor','producto 1',1,5),(495,'intensidad del sabor residual','producto 1',1,3),(496,'agrado del sabor','producto 1',1,5),(497,'intensidad del sabor','producto 1',1,5),(498,'intensidad del sabor residual','producto 1',1,3),(499,'agrado del sabor','producto 1',1,6),(500,'intensidad del sabor','producto 1',1,6),(501,'intensidad del sabor residual','producto 1',1,3),(502,'agrado del sabor','producto 1',1,4),(503,'intensidad del sabor','producto 1',1,4),(504,'intensidad del sabor residual','producto 1',1,3),(505,'agrado del sabor','producto 1',1,5),(506,'intensidad del sabor','producto 1',1,4),(507,'intensidad del sabor residual','producto 1',1,3),(508,'agrado del sabor','producto 1',1,4),(509,'intensidad del sabor','producto 1',1,4),(510,'intensidad del sabor residual','producto 1',1,4),(511,'agrado del sabor','producto 1',1,4),(512,'intensidad del sabor','producto 1',1,3),(513,'intensidad del sabor residual','producto 1',1,4),(514,'agrado del sabor','producto 1',1,6),(515,'intensidad del sabor','producto 1',1,6),(516,'intensidad del sabor residual','producto 1',1,3),(517,'agrado del sabor','producto 1',1,6),(518,'intensidad del sabor','producto 1',1,6),(519,'intensidad del sabor residual','producto 1',1,3),(520,'agrado del sabor','producto 1',1,5),(521,'intensidad del sabor','producto 1',1,4),(522,'intensidad del sabor residual','producto 1',1,4),(523,'agrado del sabor','producto 1',1,6),(524,'intensidad del sabor','producto 1',1,5),(525,'intensidad del sabor residual','producto 1',1,3),(526,'agrado del sabor','producto 1',1,6),(527,'intensidad del sabor','producto 1',1,6),(528,'intensidad del sabor residual','producto 1',1,3),(529,'agrado del sabor','producto 1',1,6),(530,'intensidad del sabor','producto 1',1,4),(531,'intensidad del sabor residual','producto 1',1,3),(532,'agrado del sabor','producto 1',1,6),(533,'intensidad del sabor','producto 1',1,6),(534,'intensidad del sabor residual','producto 1',1,3),(535,'agrado del sabor','producto 1',1,7),(536,'intensidad del sabor','producto 1',1,6),(537,'intensidad del sabor residual','producto 1',1,3),(538,'agrado del sabor','producto 1',1,5),(539,'intensidad del sabor','producto 1',1,4),(540,'intensidad del sabor residual','producto 1',1,3),(541,'agrado del sabor','producto 1',1,6),(542,'intensidad del sabor','producto 1',1,6),(543,'intensidad del sabor residual','producto 1',1,3),(544,'agrado del sabor','producto 1',1,5),(545,'intensidad del sabor','producto 1',1,5),(546,'intensidad del sabor residual','producto 1',1,3),(547,'agrado del sabor','producto 1',1,6),(548,'intensidad del sabor','producto 1',1,5),(549,'intensidad del sabor residual','producto 1',1,3),(550,'agrado del sabor','producto 1',1,6),(551,'intensidad del sabor','producto 1',1,6),(552,'intensidad del sabor residual','producto 1',1,3),(553,'agrado del sabor','producto 1',1,6),(554,'intensidad del sabor','producto 1',1,5),(555,'intensidad del sabor residual','producto 1',1,3),(556,'agrado del sabor','producto 1',1,6),(557,'intensidad del sabor','producto 1',1,5),(558,'intensidad del sabor residual','producto 1',1,3),(559,'agrado del sabor','producto 1',1,6),(560,'intensidad del sabor','producto 1',1,6),(561,'intensidad del sabor residual','producto 1',1,3),(562,'agrado del sabor','producto 1',1,7),(563,'intensidad del sabor','producto 1',1,7),(564,'intensidad del sabor residual','producto 1',1,3),(565,'agrado del sabor','producto 1',1,6),(566,'intensidad del sabor','producto 1',1,6),(567,'intensidad del sabor residual','producto 1',1,3),(568,'agrado del sabor','producto 1',1,5),(569,'intensidad del sabor','producto 1',1,5),(570,'intensidad del sabor residual','producto 1',1,2),(571,'agrado del sabor','producto 1',1,6),(572,'intensidad del sabor','producto 1',1,5),(573,'intensidad del sabor residual','producto 1',1,3),(574,'agrado del sabor','producto 1',1,6),(575,'intensidad del sabor','producto 1',1,6),(576,'intensidad del sabor residual','producto 1',1,3),(577,'agrado del sabor','producto 1',1,4),(578,'intensidad del sabor','producto 1',1,5),(579,'intensidad del sabor residual','producto 1',1,4),(580,'agrado del sabor','producto 1',1,6),(581,'intensidad del sabor','producto 1',1,6),(582,'intensidad del sabor residual','producto 1',1,3),(583,'agrado del sabor','producto 1',1,5),(584,'intensidad del sabor','producto 1',1,4),(585,'intensidad del sabor residual','producto 1',1,2),(586,'agrado del sabor','producto 1',1,6),(587,'intensidad del sabor','producto 1',1,5),(588,'intensidad del sabor residual','producto 1',1,3),(589,'agrado del sabor','producto 1',1,6),(590,'intensidad del sabor','producto 1',1,6),(591,'intensidad del sabor residual','producto 1',1,3),(592,'agrado del sabor','producto 1',1,3),(593,'intensidad del sabor','producto 1',1,3),(594,'intensidad del sabor residual','producto 1',1,3),(595,'agrado del sabor','producto 1',1,6),(596,'intensidad del sabor','producto 1',1,6),(597,'intensidad del sabor residual','producto 1',1,3),(598,'agrado del sabor','producto 1',1,6),(599,'intensidad del sabor','producto 1',1,5),(600,'intensidad del sabor residual','producto 1',1,3),(601,'agrado del sabor','producto 1',1,5),(602,'intensidad del sabor','producto 1',1,5),(603,'intensidad del sabor residual','producto 1',1,3),(604,'agrado del sabor','producto 1',1,6),(605,'intensidad del sabor','producto 1',1,6),(606,'intensidad del sabor residual','producto 1',1,3),(607,'agrado del sabor','producto 1',1,4),(608,'intensidad del sabor','producto 1',1,4),(609,'intensidad del sabor residual','producto 1',1,3),(610,'agrado del sabor','producto 1',1,5),(611,'intensidad del sabor','producto 1',1,4),(612,'intensidad del sabor residual','producto 1',1,3),(613,'agrado del sabor','producto 1',1,4),(614,'intensidad del sabor','producto 1',1,4),(615,'intensidad del sabor residual','producto 1',1,4),(616,'agrado del sabor','producto 1',1,4),(617,'intensidad del sabor','producto 1',1,3),(618,'intensidad del sabor residual','producto 1',1,4),(619,'agrado del sabor','producto 1',1,6),(620,'intensidad del sabor','producto 1',1,6),(621,'intensidad del sabor residual','producto 1',1,3),(622,'agrado del sabor','producto 1',1,6),(623,'intensidad del sabor','producto 1',1,6),(624,'intensidad del sabor residual','producto 1',1,3),(625,'agrado del sabor','producto 1',1,5),(626,'intensidad del sabor','producto 1',1,4),(627,'intensidad del sabor residual','producto 1',1,4),(628,'agrado del sabor','producto 1',1,6),(629,'intensidad del sabor','producto 1',1,5),(630,'intensidad del sabor residual','producto 1',1,3),(631,'agrado del sabor','producto 1',12,6),(632,'intensidad del sabor','producto 1',12,6),(633,'intensidad del sabor residual','producto 1',12,3),(634,'agrado del sabor','producto 1',12,6),(635,'intensidad del sabor','producto 1',12,4),(636,'intensidad del sabor residual','producto 1',12,3),(637,'agrado del sabor','producto 1',12,6),(638,'intensidad del sabor','producto 1',12,6),(639,'intensidad del sabor residual','producto 1',12,3),(640,'agrado del sabor','producto 1',12,7),(641,'intensidad del sabor','producto 1',12,6),(642,'intensidad del sabor residual','producto 1',12,3),(643,'agrado del sabor','producto 1',12,5),(644,'intensidad del sabor','producto 1',12,4),(645,'intensidad del sabor residual','producto 1',12,3),(646,'agrado del sabor','producto 1',12,6),(647,'intensidad del sabor','producto 1',12,6),(648,'intensidad del sabor residual','producto 1',12,3),(649,'agrado del sabor','producto 1',12,5),(650,'intensidad del sabor','producto 1',12,5),(651,'intensidad del sabor residual','producto 1',12,3),(652,'agrado del sabor','producto 1',12,6),(653,'intensidad del sabor','producto 1',12,5),(654,'intensidad del sabor residual','producto 1',12,3),(655,'agrado del sabor','producto 1',12,6),(656,'intensidad del sabor','producto 1',12,6),(657,'intensidad del sabor residual','producto 1',12,3),(658,'agrado del sabor','producto 1',12,6),(659,'intensidad del sabor','producto 1',12,5),(660,'intensidad del sabor residual','producto 1',12,3),(661,'agrado del sabor','producto 1',12,6),(662,'intensidad del sabor','producto 1',12,5),(663,'intensidad del sabor residual','producto 1',12,3),(664,'agrado del sabor','producto 1',12,6),(665,'intensidad del sabor','producto 1',12,6),(666,'intensidad del sabor residual','producto 1',12,3),(667,'agrado del sabor','producto 1',12,7),(668,'intensidad del sabor','producto 1',12,7),(669,'intensidad del sabor residual','producto 1',12,3),(670,'agrado del sabor','producto 1',12,6),(671,'intensidad del sabor','producto 1',12,6),(672,'intensidad del sabor residual','producto 1',12,3),(673,'agrado del sabor','producto 1',12,5),(674,'intensidad del sabor','producto 1',12,5),(675,'intensidad del sabor residual','producto 1',12,2),(676,'agrado del sabor','producto 1',12,6),(677,'intensidad del sabor','producto 1',12,5),(678,'intensidad del sabor residual','producto 1',12,3),(679,'agrado del sabor','producto 1',12,6),(680,'intensidad del sabor','producto 1',12,6),(681,'intensidad del sabor residual','producto 1',12,3),(682,'agrado del sabor','producto 1',12,4),(683,'intensidad del sabor','producto 1',12,5),(684,'intensidad del sabor residual','producto 1',12,4),(685,'agrado del sabor','producto 1',12,6),(686,'intensidad del sabor','producto 1',12,6),(687,'intensidad del sabor residual','producto 1',12,3),(688,'agrado del sabor','producto 1',12,5),(689,'intensidad del sabor','producto 1',12,4),(690,'intensidad del sabor residual','producto 1',12,2),(691,'agrado del sabor','producto 1',12,6),(692,'intensidad del sabor','producto 1',12,5),(693,'intensidad del sabor residual','producto 1',12,3),(694,'agrado del sabor','producto 1',12,6),(695,'intensidad del sabor','producto 1',12,6),(696,'intensidad del sabor residual','producto 1',12,3),(697,'agrado del sabor','producto 1',12,3),(698,'intensidad del sabor','producto 1',12,3),(699,'intensidad del sabor residual','producto 1',12,3),(700,'agrado del sabor','producto 1',12,6),(701,'intensidad del sabor','producto 1',12,6),(702,'intensidad del sabor residual','producto 1',12,3),(703,'agrado del sabor','producto 1',12,6),(704,'intensidad del sabor','producto 1',12,5),(705,'intensidad del sabor residual','producto 1',12,3),(706,'agrado del sabor','producto 1',12,5),(707,'intensidad del sabor','producto 1',12,5),(708,'intensidad del sabor residual','producto 1',12,3),(709,'agrado del sabor','producto 1',12,6),(710,'intensidad del sabor','producto 1',12,6),(711,'intensidad del sabor residual','producto 1',12,3),(712,'agrado del sabor','producto 1',12,4),(713,'intensidad del sabor','producto 1',12,4),(714,'intensidad del sabor residual','producto 1',12,3),(715,'agrado del sabor','producto 1',12,5),(716,'intensidad del sabor','producto 1',12,4),(717,'intensidad del sabor residual','producto 1',12,3),(718,'agrado del sabor','producto 1',12,4),(719,'intensidad del sabor','producto 1',12,4),(720,'intensidad del sabor residual','producto 1',12,4),(721,'agrado del sabor','producto 1',12,4),(722,'intensidad del sabor','producto 1',12,3),(723,'intensidad del sabor residual','producto 1',12,4),(724,'agrado del sabor','producto 1',12,6),(725,'intensidad del sabor','producto 1',12,6),(726,'intensidad del sabor residual','producto 1',12,3),(727,'agrado del sabor','producto 1',12,6),(728,'intensidad del sabor','producto 1',12,6),(729,'intensidad del sabor residual','producto 1',12,3),(730,'agrado del sabor','producto 1',12,5),(731,'intensidad del sabor','producto 1',12,4),(732,'intensidad del sabor residual','producto 1',12,4),(733,'agrado del sabor','producto 1',12,6),(734,'intensidad del sabor','producto 1',12,5),(735,'intensidad del sabor residual','producto 1',12,3),(841,'agrado del sabor','producto 1',15,6),(842,'agrado del sabor','producto 2',15,5),(843,'intensidad del sabor','producto 1',15,3),(844,'intensidad del sabor','producto 2',15,3),(845,'intensidad del sabor residual','producto 1',15,3),(846,'intensidad del sabor residual','producto 2',15,3),(847,'agrado del sabor','producto 1',15,6),(848,'agrado del sabor','producto 2',15,4),(849,'intensidad del sabor','producto 1',15,3),(850,'intensidad del sabor','producto 2',15,4),(851,'intensidad del sabor residual','producto 1',15,3),(852,'intensidad del sabor residual','producto 2',15,3),(853,'agrado del sabor','producto 1',15,6),(854,'agrado del sabor','producto 2',15,3),(855,'intensidad del sabor','producto 1',15,3),(856,'intensidad del sabor','producto 2',15,4),(857,'intensidad del sabor residual','producto 1',15,3),(858,'intensidad del sabor residual','producto 2',15,2),(859,'agrado del sabor','producto 1',15,7),(860,'agrado del sabor','producto 2',15,5),(861,'intensidad del sabor','producto 1',15,3),(862,'intensidad del sabor','producto 2',15,2),(863,'intensidad del sabor residual','producto 1',15,3),(864,'intensidad del sabor residual','producto 2',15,1),(865,'agrado del sabor','producto 1',15,5),(866,'agrado del sabor','producto 2',15,4),(867,'intensidad del sabor','producto 1',15,3),(868,'intensidad del sabor','producto 2',15,2),(869,'intensidad del sabor residual','producto 1',15,3),(870,'intensidad del sabor residual','producto 2',15,2),(871,'agrado del sabor','producto 1',15,6),(872,'agrado del sabor','producto 2',15,2),(873,'intensidad del sabor','producto 1',15,3),(874,'intensidad del sabor','producto 2',15,5),(875,'intensidad del sabor residual','producto 1',15,3),(876,'intensidad del sabor residual','producto 2',15,4),(877,'agrado del sabor','producto 1',15,5),(878,'agrado del sabor','producto 2',15,5),(879,'intensidad del sabor','producto 1',15,3),(880,'intensidad del sabor','producto 2',15,3),(881,'intensidad del sabor residual','producto 1',15,3),(882,'intensidad del sabor residual','producto 2',15,3),(883,'agrado del sabor','producto 1',15,6),(884,'agrado del sabor','producto 2',15,5),(885,'intensidad del sabor','producto 1',15,3),(886,'intensidad del sabor','producto 2',15,3),(887,'intensidad del sabor residual','producto 1',15,3),(888,'intensidad del sabor residual','producto 2',15,3),(889,'agrado del sabor','producto 1',15,6),(890,'agrado del sabor','producto 2',15,5),(891,'intensidad del sabor','producto 1',15,3),(892,'intensidad del sabor','producto 2',15,3),(893,'intensidad del sabor residual','producto 1',15,3),(894,'intensidad del sabor residual','producto 2',15,3),(895,'agrado del sabor','producto 1',15,6),(896,'agrado del sabor','producto 2',15,4),(897,'intensidad del sabor','producto 1',15,3),(898,'intensidad del sabor','producto 2',15,3),(899,'intensidad del sabor residual','producto 1',15,3),(900,'intensidad del sabor residual','producto 2',15,3),(901,'agrado del sabor','producto 1',15,6),(902,'agrado del sabor','producto 2',15,4),(903,'intensidad del sabor','producto 1',15,3),(904,'intensidad del sabor','producto 2',15,4),(905,'intensidad del sabor residual','producto 1',15,3),(906,'intensidad del sabor residual','producto 2',15,4),(907,'agrado del sabor','producto 1',15,6),(908,'agrado del sabor','producto 2',15,5),(909,'intensidad del sabor','producto 1',15,3),(910,'intensidad del sabor','producto 2',15,3),(911,'intensidad del sabor residual','producto 1',15,3),(912,'intensidad del sabor residual','producto 2',15,3),(913,'agrado del sabor','producto 1',15,7),(914,'agrado del sabor','producto 2',15,6),(915,'intensidad del sabor','producto 1',15,3),(916,'intensidad del sabor','producto 2',15,3),(917,'intensidad del sabor residual','producto 1',15,3),(918,'intensidad del sabor residual','producto 2',15,3),(919,'agrado del sabor','producto 1',15,6),(920,'agrado del sabor','producto 2',15,5),(921,'intensidad del sabor','producto 1',15,3),(922,'intensidad del sabor','producto 2',15,3),(923,'intensidad del sabor residual','producto 1',15,3),(924,'intensidad del sabor residual','producto 2',15,4),(925,'agrado del sabor','producto 1',15,5),(926,'agrado del sabor','producto 2',15,2),(927,'intensidad del sabor','producto 1',15,2),(928,'intensidad del sabor','producto 2',15,5),(929,'intensidad del sabor residual','producto 1',15,3),(930,'intensidad del sabor residual','producto 2',15,2),(931,'agrado del sabor','producto 1',15,6),(932,'agrado del sabor','producto 2',15,5),(933,'intensidad del sabor','producto 1',15,3),(934,'intensidad del sabor','producto 2',15,3),(935,'intensidad del sabor residual','producto 1',15,3),(936,'intensidad del sabor residual','producto 2',15,3),(937,'agrado del sabor','producto 1',15,6),(938,'agrado del sabor','producto 2',15,4),(939,'intensidad del sabor','producto 1',15,3),(940,'intensidad del sabor','producto 2',15,2),(941,'intensidad del sabor residual','producto 1',15,3),(942,'intensidad del sabor residual','producto 2',15,2),(943,'agrado del sabor','producto 1',15,4),(944,'agrado del sabor','producto 2',15,3),(945,'intensidad del sabor','producto 1',15,4),(946,'intensidad del sabor','producto 2',15,2),(947,'intensidad del sabor residual','producto 1',15,4),(948,'intensidad del sabor residual','producto 2',15,2),(949,'agrado del sabor','producto 1',15,6),(950,'agrado del sabor','producto 2',15,4),(951,'intensidad del sabor','producto 1',15,3),(952,'intensidad del sabor','producto 2',15,2),(953,'intensidad del sabor residual','producto 1',15,3),(954,'intensidad del sabor residual','producto 2',15,2),(955,'agrado del sabor','producto 1',15,5),(956,'agrado del sabor','producto 2',15,4),(957,'intensidad del sabor','producto 1',15,2),(958,'intensidad del sabor','producto 2',15,3),(959,'intensidad del sabor residual','producto 1',15,3),(960,'intensidad del sabor residual','producto 2',15,3),(961,'agrado del sabor','producto 1',15,6),(962,'agrado del sabor','producto 2',15,5),(963,'intensidad del sabor','producto 1',15,3),(964,'intensidad del sabor','producto 2',15,3),(965,'intensidad del sabor residual','producto 1',15,3),(966,'intensidad del sabor residual','producto 2',15,3),(967,'agrado del sabor','producto 1',15,6),(968,'agrado del sabor','producto 2',15,6),(969,'intensidad del sabor','producto 1',15,3),(970,'intensidad del sabor','producto 2',15,3),(971,'intensidad del sabor residual','producto 1',15,3),(972,'intensidad del sabor residual','producto 2',15,3),(973,'agrado del sabor','producto 1',15,3),(974,'agrado del sabor','producto 2',15,5),(975,'intensidad del sabor','producto 1',15,3),(976,'intensidad del sabor','producto 2',15,4),(977,'intensidad del sabor residual','producto 1',15,1),(978,'intensidad del sabor residual','producto 2',15,1),(979,'agrado del sabor','producto 1',15,6),(980,'agrado del sabor','producto 2',15,3),(981,'intensidad del sabor','producto 1',15,3),(982,'intensidad del sabor','producto 2',15,4),(983,'intensidad del sabor residual','producto 1',15,3),(984,'intensidad del sabor residual','producto 2',15,2),(985,'agrado del sabor','producto 1',15,6),(986,'agrado del sabor','producto 2',15,4),(987,'intensidad del sabor','producto 1',15,3),(988,'intensidad del sabor','producto 2',15,2),(989,'intensidad del sabor residual','producto 1',15,3),(990,'intensidad del sabor residual','producto 2',15,2),(991,'agrado del sabor','producto 1',15,5),(992,'agrado del sabor','producto 2',15,2),(993,'intensidad del sabor','producto 1',15,3),(994,'intensidad del sabor','producto 2',15,3),(995,'intensidad del sabor residual','producto 1',15,3),(996,'intensidad del sabor residual','producto 2',15,2),(997,'agrado del sabor','producto 1',15,6),(998,'agrado del sabor','producto 2',15,3),(999,'intensidad del sabor','producto 1',15,3),(1000,'intensidad del sabor','producto 2',15,2),(1001,'intensidad del sabor residual','producto 1',15,3),(1002,'intensidad del sabor residual','producto 2',15,4),(1003,'agrado del sabor','producto 1',15,4),(1004,'agrado del sabor','producto 2',15,5),(1005,'intensidad del sabor','producto 1',15,3),(1006,'intensidad del sabor','producto 2',15,3),(1007,'intensidad del sabor residual','producto 1',15,3),(1008,'intensidad del sabor residual','producto 2',15,3),(1009,'agrado del sabor','producto 1',15,5),(1010,'agrado del sabor','producto 2',15,3),(1011,'intensidad del sabor','producto 1',15,3),(1012,'intensidad del sabor','producto 2',15,1),(1013,'intensidad del sabor residual','producto 1',15,2),(1014,'intensidad del sabor residual','producto 2',15,4),(1015,'agrado del sabor','producto 1',15,4),(1016,'agrado del sabor','producto 2',15,3),(1017,'intensidad del sabor','producto 1',15,4),(1018,'intensidad del sabor','producto 2',15,2),(1019,'intensidad del sabor residual','producto 1',15,3),(1020,'intensidad del sabor residual','producto 2',15,4),(1021,'agrado del sabor','producto 1',15,4),(1022,'agrado del sabor','producto 2',15,3),(1023,'intensidad del sabor','producto 1',15,4),(1024,'intensidad del sabor','producto 2',15,5),(1025,'intensidad del sabor residual','producto 1',15,4),(1026,'intensidad del sabor residual','producto 2',15,5),(1027,'agrado del sabor','producto 1',15,6),(1028,'agrado del sabor','producto 2',15,2),(1029,'intensidad del sabor','producto 1',15,3),(1030,'intensidad del sabor','producto 2',15,2),(1031,'intensidad del sabor residual','producto 1',15,3),(1032,'intensidad del sabor residual','producto 2',15,4),(1033,'agrado del sabor','producto 1',15,6),(1034,'agrado del sabor','producto 2',15,4),(1035,'intensidad del sabor','producto 1',15,3),(1036,'intensidad del sabor','producto 2',15,3),(1037,'intensidad del sabor residual','producto 1',15,3),(1038,'intensidad del sabor residual','producto 2',15,3),(1039,'agrado del sabor','producto 1',15,5),(1040,'agrado del sabor','producto 2',15,5),(1041,'intensidad del sabor','producto 1',15,4),(1042,'intensidad del sabor','producto 2',15,2),(1043,'intensidad del sabor residual','producto 1',15,4),(1044,'intensidad del sabor residual','producto 2',15,3),(1045,'agrado del sabor','producto 1',15,6),(1046,'agrado del sabor','producto 2',15,3),(1047,'intensidad del sabor','producto 1',15,3),(1048,'intensidad del sabor','producto 2',15,2),(1049,'intensidad del sabor residual','producto 1',15,3),(1050,'intensidad del sabor residual','producto 2',15,3),(1051,'agrado','producto 1',16,6),(1052,'intensidad','producto 1',16,6),(1053,'sabor residual','producto 1',16,3),(1054,'acidez','producto 1',16,6),(1055,'dulzura','producto 1',16,4),(1056,'agrado','producto 2',16,3),(1057,'intensidad','producto 2',16,4),(1058,'sabor residual','producto 2',16,6),(1059,'acidez','producto 2',16,6),(1060,'dulzura','producto 2',16,7),(1061,'agrado','producto 1',16,6),(1062,'intensidad','producto 1',16,4),(1063,'sabor residual','producto 1',16,3),(1064,'acidez','producto 1',16,6),(1065,'dulzura','producto 1',16,2),(1066,'agrado','producto 2',16,3),(1067,'intensidad','producto 2',16,2),(1068,'sabor residual','producto 2',16,6),(1069,'acidez','producto 2',16,4),(1070,'dulzura','producto 2',16,7),(1071,'agrado','producto 1',16,6),(1072,'intensidad','producto 1',16,6),(1073,'sabor residual','producto 1',16,3),(1074,'acidez','producto 1',16,6),(1075,'dulzura','producto 1',16,4),(1076,'agrado','producto 2',16,3),(1077,'intensidad','producto 2',16,4),(1078,'sabor residual','producto 2',16,6),(1079,'acidez','producto 2',16,6),(1080,'dulzura','producto 2',16,7),(1081,'agrado','producto 1',16,7),(1082,'intensidad','producto 1',16,6),(1083,'sabor residual','producto 1',16,3),(1084,'acidez','producto 1',16,6),(1085,'dulzura','producto 1',16,4),(1086,'agrado','producto 2',16,3),(1087,'intensidad','producto 2',16,4),(1088,'sabor residual','producto 2',16,6),(1089,'acidez','producto 2',16,6),(1090,'dulzura','producto 2',16,7),(1091,'agrado','producto 1',16,5),(1092,'intensidad','producto 1',16,4),(1093,'sabor residual','producto 1',16,3),(1094,'acidez','producto 1',16,6),(1095,'dulzura','producto 1',16,2),(1096,'agrado','producto 2',16,3),(1097,'intensidad','producto 2',16,2),(1098,'sabor residual','producto 2',16,6),(1099,'acidez','producto 2',16,4),(1100,'dulzura','producto 2',16,7),(1101,'agrado','producto 1',16,6),(1102,'intensidad','producto 1',16,6),(1103,'sabor residual','producto 1',16,3),(1104,'acidez','producto 1',16,6),(1105,'dulzura','producto 1',16,4),(1106,'agrado','producto 2',16,3),(1107,'intensidad','producto 2',16,4),(1108,'sabor residual','producto 2',16,6),(1109,'acidez','producto 2',16,6),(1110,'dulzura','producto 2',16,7),(1111,'agrado','producto 1',16,5),(1112,'intensidad','producto 1',16,5),(1113,'sabor residual','producto 1',16,3),(1114,'acidez','producto 1',16,6),(1115,'dulzura','producto 1',16,3),(1116,'agrado','producto 2',16,3),(1117,'intensidad','producto 2',16,3),(1118,'sabor residual','producto 2',16,6),(1119,'acidez','producto 2',16,5),(1120,'dulzura','producto 2',16,7),(1121,'agrado','producto 1',16,6),(1122,'intensidad','producto 1',16,5),(1123,'sabor residual','producto 1',16,3),(1124,'acidez','producto 1',16,6),(1125,'dulzura','producto 1',16,3),(1126,'agrado','producto 2',16,3),(1127,'intensidad','producto 2',16,3),(1128,'sabor residual','producto 2',16,6),(1129,'acidez','producto 2',16,5),(1130,'dulzura','producto 2',16,7),(1131,'agrado','producto 1',16,6),(1132,'intensidad','producto 1',16,6),(1133,'sabor residual','producto 1',16,3),(1134,'acidez','producto 1',16,6),(1135,'dulzura','producto 1',16,4),(1136,'agrado','producto 2',16,3),(1137,'intensidad','producto 2',16,4),(1138,'sabor residual','producto 2',16,6),(1139,'acidez','producto 2',16,6),(1140,'dulzura','producto 2',16,7),(1141,'agrado','producto 1',16,6),(1142,'intensidad','producto 1',16,5),(1143,'sabor residual','producto 1',16,3),(1144,'acidez','producto 1',16,6),(1145,'dulzura','producto 1',16,3),(1146,'agrado','producto 2',16,3),(1147,'intensidad','producto 2',16,3),(1148,'sabor residual','producto 2',16,6),(1149,'acidez','producto 2',16,5),(1150,'dulzura','producto 2',16,7),(1151,'agrado','producto 1',16,6),(1152,'intensidad','producto 1',16,5),(1153,'sabor residual','producto 1',16,3),(1154,'acidez','producto 1',16,6),(1155,'dulzura','producto 1',16,3),(1156,'agrado','producto 2',16,3),(1157,'intensidad','producto 2',16,3),(1158,'sabor residual','producto 2',16,6),(1159,'acidez','producto 2',16,5),(1160,'dulzura','producto 2',16,7),(1161,'agrado','producto 1',16,6),(1162,'intensidad','producto 1',16,6),(1163,'sabor residual','producto 1',16,3),(1164,'acidez','producto 1',16,6),(1165,'dulzura','producto 1',16,4),(1166,'agrado','producto 2',16,3),(1167,'intensidad','producto 2',16,4),(1168,'sabor residual','producto 2',16,6),(1169,'acidez','producto 2',16,6),(1170,'dulzura','producto 2',16,7),(1171,'agrado','producto 1',16,7),(1172,'intensidad','producto 1',16,7),(1173,'sabor residual','producto 1',16,3),(1174,'acidez','producto 1',16,6),(1175,'dulzura','producto 1',16,5),(1176,'agrado','producto 2',16,3),(1177,'intensidad','producto 2',16,5),(1178,'sabor residual','producto 2',16,6),(1179,'acidez','producto 2',16,7),(1180,'dulzura','producto 2',16,7),(1181,'agrado','producto 1',16,6),(1182,'intensidad','producto 1',16,6),(1183,'sabor residual','producto 1',16,3),(1184,'acidez','producto 1',16,6),(1185,'dulzura','producto 1',16,4),(1186,'agrado','producto 2',16,3),(1187,'intensidad','producto 2',16,4),(1188,'sabor residual','producto 2',16,6),(1189,'acidez','producto 2',16,6),(1190,'dulzura','producto 2',16,7),(1191,'agrado','producto 1',16,5),(1192,'intensidad','producto 1',16,5),(1193,'sabor residual','producto 1',16,2),(1194,'acidez','producto 1',16,5),(1195,'dulzura','producto 1',16,3),(1196,'agrado','producto 2',16,2),(1197,'intensidad','producto 2',16,3),(1198,'sabor residual','producto 2',16,5),(1199,'acidez','producto 2',16,5),(1200,'dulzura','producto 2',16,6),(1201,'agrado','producto 1',16,6),(1202,'intensidad','producto 1',16,5),(1203,'sabor residual','producto 1',16,3),(1204,'acidez','producto 1',16,6),(1205,'dulzura','producto 1',16,3),(1206,'agrado','producto 2',16,3),(1207,'intensidad','producto 2',16,3),(1208,'sabor residual','producto 2',16,6),(1209,'acidez','producto 2',16,5),(1210,'dulzura','producto 2',16,7),(1211,'agrado','producto 1',16,6),(1212,'intensidad','producto 1',16,6),(1213,'sabor residual','producto 1',16,3),(1214,'acidez','producto 1',16,6),(1215,'dulzura','producto 1',16,4),(1216,'agrado','producto 2',16,3),(1217,'intensidad','producto 2',16,4),(1218,'sabor residual','producto 2',16,6),(1219,'acidez','producto 2',16,6),(1220,'dulzura','producto 2',16,7),(1221,'agrado','producto 1',16,4),(1222,'intensidad','producto 1',16,5),(1223,'sabor residual','producto 1',16,4),(1224,'acidez','producto 1',16,7),(1225,'dulzura','producto 1',16,3),(1226,'agrado','producto 2',16,4),(1227,'intensidad','producto 2',16,3),(1228,'sabor residual','producto 2',16,7),(1229,'acidez','producto 2',16,5),(1230,'dulzura','producto 2',16,8),(1231,'agrado','producto 1',16,6),(1232,'intensidad','producto 1',16,6),(1233,'sabor residual','producto 1',16,3),(1234,'acidez','producto 1',16,6),(1235,'dulzura','producto 1',16,4),(1236,'agrado','producto 2',16,3),(1237,'intensidad','producto 2',16,4),(1238,'sabor residual','producto 2',16,6),(1239,'acidez','producto 2',16,6),(1240,'dulzura','producto 2',16,7),(1241,'agrado','producto 1',16,5),(1242,'intensidad','producto 1',16,4),(1243,'sabor residual','producto 1',16,2),(1244,'acidez','producto 1',16,5),(1245,'dulzura','producto 1',16,2),(1246,'agrado','producto 2',16,2),(1247,'intensidad','producto 2',16,2),(1248,'sabor residual','producto 2',16,5),(1249,'acidez','producto 2',16,4),(1250,'dulzura','producto 2',16,6),(1251,'agrado','producto 1',16,6),(1252,'intensidad','producto 1',16,5),(1253,'sabor residual','producto 1',16,3),(1254,'acidez','producto 1',16,6),(1255,'dulzura','producto 1',16,3),(1256,'agrado','producto 2',16,3),(1257,'intensidad','producto 2',16,3),(1258,'sabor residual','producto 2',16,6),(1259,'acidez','producto 2',16,5),(1260,'dulzura','producto 2',16,7),(1261,'agrado','producto 1',16,6),(1262,'intensidad','producto 1',16,6),(1263,'sabor residual','producto 1',16,3),(1264,'acidez','producto 1',16,6),(1265,'dulzura','producto 1',16,4),(1266,'agrado','producto 2',16,3),(1267,'intensidad','producto 2',16,4),(1268,'sabor residual','producto 2',16,6),(1269,'acidez','producto 2',16,6),(1270,'dulzura','producto 2',16,7),(1271,'agrado','producto 1',16,3),(1272,'intensidad','producto 1',16,3),(1273,'sabor residual','producto 1',16,3),(1274,'acidez','producto 1',16,6),(1275,'dulzura','producto 1',16,1),(1276,'agrado','producto 2',16,3),(1277,'intensidad','producto 2',16,1),(1278,'sabor residual','producto 2',16,6),(1279,'acidez','producto 2',16,3),(1280,'dulzura','producto 2',16,7),(1281,'agrado','producto 1',16,6),(1282,'intensidad','producto 1',16,6),(1283,'sabor residual','producto 1',16,3),(1284,'acidez','producto 1',16,6),(1285,'dulzura','producto 1',16,4),(1286,'agrado','producto 2',16,3),(1287,'intensidad','producto 2',16,4),(1288,'sabor residual','producto 2',16,6),(1289,'acidez','producto 2',16,6),(1290,'dulzura','producto 2',16,7),(1291,'agrado','producto 1',16,6),(1292,'intensidad','producto 1',16,5),(1293,'sabor residual','producto 1',16,3),(1294,'acidez','producto 1',16,6),(1295,'dulzura','producto 1',16,3),(1296,'agrado','producto 2',16,3),(1297,'intensidad','producto 2',16,3),(1298,'sabor residual','producto 2',16,6),(1299,'acidez','producto 2',16,5),(1300,'dulzura','producto 2',16,7),(1301,'agrado','producto 1',16,5),(1302,'intensidad','producto 1',16,5),(1303,'sabor residual','producto 1',16,3),(1304,'acidez','producto 1',16,6),(1305,'dulzura','producto 1',16,3),(1306,'agrado','producto 2',16,3),(1307,'intensidad','producto 2',16,3),(1308,'sabor residual','producto 2',16,6),(1309,'acidez','producto 2',16,5),(1310,'dulzura','producto 2',16,7),(1311,'agrado','producto 1',16,6),(1312,'intensidad','producto 1',16,6),(1313,'sabor residual','producto 1',16,3),(1314,'acidez','producto 1',16,6),(1315,'dulzura','producto 1',16,4),(1316,'agrado','producto 2',16,3),(1317,'intensidad','producto 2',16,4),(1318,'sabor residual','producto 2',16,6),(1319,'acidez','producto 2',16,6),(1320,'dulzura','producto 2',16,7),(1321,'agrado','producto 1',16,4),(1322,'intensidad','producto 1',16,4),(1323,'sabor residual','producto 1',16,3),(1324,'acidez','producto 1',16,6),(1325,'dulzura','producto 1',16,2),(1326,'agrado','producto 2',16,3),(1327,'intensidad','producto 2',16,2),(1328,'sabor residual','producto 2',16,6),(1329,'acidez','producto 2',16,4),(1330,'dulzura','producto 2',16,7),(1331,'agrado','producto 1',16,5),(1332,'intensidad','producto 1',16,4),(1333,'sabor residual','producto 1',16,3),(1334,'acidez','producto 1',16,6),(1335,'dulzura','producto 1',16,2),(1336,'agrado','producto 2',16,3),(1337,'intensidad','producto 2',16,2),(1338,'sabor residual','producto 2',16,6),(1339,'acidez','producto 2',16,4),(1340,'dulzura','producto 2',16,7),(1341,'agrado','producto 1',16,4),(1342,'intensidad','producto 1',16,4),(1343,'sabor residual','producto 1',16,4),(1344,'acidez','producto 1',16,7),(1345,'dulzura','producto 1',16,2),(1346,'agrado','producto 2',16,4),(1347,'intensidad','producto 2',16,2),(1348,'sabor residual','producto 2',16,7),(1349,'acidez','producto 2',16,4),(1350,'dulzura','producto 2',16,8),(1351,'agrado','producto 1',16,4),(1352,'intensidad','producto 1',16,3),(1353,'sabor residual','producto 1',16,4),(1354,'acidez','producto 1',16,7),(1355,'dulzura','producto 1',16,1),(1356,'agrado','producto 2',16,4),(1357,'intensidad','producto 2',16,1),(1358,'sabor residual','producto 2',16,7),(1359,'acidez','producto 2',16,3),(1360,'dulzura','producto 2',16,8),(1361,'agrado','producto 1',16,6),(1362,'intensidad','producto 1',16,6),(1363,'sabor residual','producto 1',16,3),(1364,'acidez','producto 1',16,6),(1365,'dulzura','producto 1',16,4),(1366,'agrado','producto 2',16,3),(1367,'intensidad','producto 2',16,4),(1368,'sabor residual','producto 2',16,6),(1369,'acidez','producto 2',16,6),(1370,'dulzura','producto 2',16,7),(1371,'agrado','producto 1',16,6),(1372,'intensidad','producto 1',16,6),(1373,'sabor residual','producto 1',16,3),(1374,'acidez','producto 1',16,6),(1375,'dulzura','producto 1',16,4),(1376,'agrado','producto 2',16,3),(1377,'intensidad','producto 2',16,4),(1378,'sabor residual','producto 2',16,6),(1379,'acidez','producto 2',16,6),(1380,'dulzura','producto 2',16,7),(1381,'agrado','producto 1',16,5),(1382,'intensidad','producto 1',16,4),(1383,'sabor residual','producto 1',16,4),(1384,'acidez','producto 1',16,7),(1385,'dulzura','producto 1',16,2),(1386,'agrado','producto 2',16,4),(1387,'intensidad','producto 2',16,2),(1388,'sabor residual','producto 2',16,7),(1389,'acidez','producto 2',16,4),(1390,'dulzura','producto 2',16,8),(1391,'agrado','producto 1',16,6),(1392,'intensidad','producto 1',16,5),(1393,'sabor residual','producto 1',16,3),(1394,'acidez','producto 1',16,6),(1395,'dulzura','producto 1',16,3),(1396,'agrado','producto 2',16,3),(1397,'intensidad','producto 2',16,3),(1398,'sabor residual','producto 2',16,6),(1399,'acidez','producto 2',16,5),(1400,'dulzura','producto 2',16,7);
/*!40000 ALTER TABLE `numeric_attribute` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partial_result`
--

DROP TABLE IF EXISTS `partial_result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partial_result` (
  `dtype` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `are_different` bit(1) NOT NULL,
  `attribute_name` varchar(255) DEFAULT NULL,
  `distribution` varchar(255) DEFAULT NULL,
  `winner` varchar(255) DEFAULT NULL,
  `f_crit_value` double DEFAULT NULL,
  `f_value` double DEFAULT NULL,
  `p_value` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partial_result`
--

LOCK TABLES `partial_result` WRITE;
/*!40000 ALTER TABLE `partial_result` DISABLE KEYS */;
INSERT INTO `partial_result` VALUES ('PartialResultAnova',1,'','agrado del sabor','ANOVA','producto 3',0,13.033787029623705,0.00000910354265704072),('PartialResultAnova',2,'','intensidad del sabor','ANOVA','producto 3',0,36.263693014102984,0.0000000000012693179840539415),('PartialResultAnova',3,'','intensidad del sabor residual','ANOVA','producto 3',0,27.883383816529616,0.00000000021868395982949096),('PartialResultAnova',4,'\0','a1','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',5,'\0','a2','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',6,'\0','a1','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',7,'\0','a1','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',8,'\0','a2','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',9,'\0','a3','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',10,'\0','a1','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',11,'\0','a2','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',12,'\0','a1','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',13,'\0','a2','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',14,'\0','a3','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',15,'\0','a1','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',16,'\0','a2','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',17,'\0','a1','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',18,'\0','a1','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',19,'\0','a2','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',20,'\0','a3','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',21,'\0','a1','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',22,'\0','a2','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',23,'\0','a1','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',24,'\0','a2','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',25,'\0','a3','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',26,'\0','a1','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',27,'\0','a2','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',28,'\0','a1','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',29,'\0','a1','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',30,'\0','a2','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',31,'\0','a3','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',32,'\0','a1','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',33,'\0','a2','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',34,'\0','a1','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',35,'\0','a2','ANOVA','iguales',0,NULL,NULL),('PartialResultAnova',36,'\0','a3','ANOVA','iguales',0,NULL,NULL),('PartialResultStudent',37,'','agrado del sabor','STUDENT_T','producto 1',NULL,NULL,NULL),('PartialResultStudent',38,'\0','intensidad del sabor','STUDENT_T','iguales',NULL,NULL,NULL),('PartialResultStudent',39,'\0','intensidad del sabor residual','STUDENT_T','iguales',NULL,NULL,NULL),('PartialResultStudent',40,'','agrado del sabor','STUDENT_T','producto 1',NULL,NULL,NULL),('PartialResultStudent',41,'\0','intensidad del sabor','STUDENT_T','iguales',NULL,NULL,NULL),('PartialResultStudent',42,'\0','intensidad del sabor residual','STUDENT_T','iguales',NULL,NULL,NULL),('PartialResultStudent',43,'','dulzura','STUDENT_T','producto 2',NULL,NULL,NULL),('PartialResultStudent',44,'','agrado','STUDENT_T','producto 1',NULL,NULL,NULL),('PartialResultStudent',45,'','intensidad','STUDENT_T','producto 1',NULL,NULL,NULL),('PartialResultStudent',46,'','acidez','STUDENT_T','producto 1',NULL,NULL,NULL),('PartialResultStudent',47,'','sabor residual','STUDENT_T','producto 2',NULL,NULL,NULL);
/*!40000 ALTER TABLE `partial_result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partial_result_summaries`
--

DROP TABLE IF EXISTS `partial_result_summaries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partial_result_summaries` (
  `partial_result_id` bigint(20) NOT NULL,
  `summaries_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_6ihnnhyiai8r0ydkw7bbjg6hx` (`summaries_id`),
  KEY `FK19losrciiyo1m5yn2wbw8ow69` (`partial_result_id`),
  CONSTRAINT `FK19losrciiyo1m5yn2wbw8ow69` FOREIGN KEY (`partial_result_id`) REFERENCES `partial_result` (`id`),
  CONSTRAINT `FKbkb8o9pje8l3ck9ulay72uu0r` FOREIGN KEY (`summaries_id`) REFERENCES `result_summary` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partial_result_summaries`
--

LOCK TABLES `partial_result_summaries` WRITE;
/*!40000 ALTER TABLE `partial_result_summaries` DISABLE KEYS */;
INSERT INTO `partial_result_summaries` VALUES (1,1),(1,2),(1,3),(2,4),(2,5),(2,6),(3,7),(3,8),(3,9),(4,10),(4,11),(4,12),(5,13),(5,14),(5,15),(6,16),(6,17),(6,18),(7,19),(7,20),(7,21),(8,22),(8,23),(8,24),(9,25),(9,26),(9,27),(10,28),(10,29),(10,30),(11,31),(11,32),(11,33),(12,34),(12,35),(12,36),(13,37),(13,38),(13,39),(14,40),(14,41),(14,42),(15,43),(15,44),(15,45),(16,46),(16,47),(16,48),(17,49),(17,50),(17,51),(18,52),(18,53),(18,54),(19,55),(19,56),(19,57),(20,58),(20,59),(20,60),(21,61),(21,62),(21,63),(22,64),(22,65),(22,66),(23,67),(23,68),(23,69),(24,70),(24,71),(24,72),(25,73),(25,74),(25,75),(26,76),(26,77),(26,78),(27,79),(27,80),(27,81),(28,82),(28,83),(28,84),(29,85),(29,86),(29,87),(30,88),(30,89),(30,90),(31,91),(31,92),(31,93),(32,94),(32,95),(32,96),(33,97),(33,98),(33,99),(34,100),(34,101),(34,102),(35,103),(35,104),(35,105),(36,106),(36,107),(36,108),(37,109),(37,110),(38,111),(38,112),(39,113),(39,114),(40,115),(40,116),(41,117),(41,118),(42,119),(42,120),(43,121),(43,122),(44,123),(44,124),(45,125),(45,126),(46,127),(46,128),(47,129),(47,130);
/*!40000 ALTER TABLE `partial_result_summaries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `result`
--

DROP TABLE IF EXISTS `result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `result` (
  `sam_id` bigint(20) NOT NULL,
  `alpha` float NOT NULL,
  PRIMARY KEY (`sam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result`
--

LOCK TABLES `result` WRITE;
/*!40000 ALTER TABLE `result` DISABLE KEYS */;
INSERT INTO `result` VALUES (1,0.05),(3,0.1),(15,0.05),(16,0.05);
/*!40000 ALTER TABLE `result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `result_partial_results`
--

DROP TABLE IF EXISTS `result_partial_results`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `result_partial_results` (
  `result_sam_id` bigint(20) NOT NULL,
  `partial_results_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_pf8bxpp2in8ypq72x22gr3pf2` (`partial_results_id`),
  KEY `FKao4c2hm6uon2dtktfu5h0dyg9` (`result_sam_id`),
  CONSTRAINT `FKao4c2hm6uon2dtktfu5h0dyg9` FOREIGN KEY (`result_sam_id`) REFERENCES `result` (`sam_id`),
  CONSTRAINT `FKhtl9qlbwesgt3k6bgq8vfdjvq` FOREIGN KEY (`partial_results_id`) REFERENCES `partial_result` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result_partial_results`
--

LOCK TABLES `result_partial_results` WRITE;
/*!40000 ALTER TABLE `result_partial_results` DISABLE KEYS */;
INSERT INTO `result_partial_results` VALUES (1,34),(1,35),(1,36),(3,1),(3,2),(3,3),(15,40),(15,41),(15,42),(16,43),(16,44),(16,45),(16,46),(16,47);
/*!40000 ALTER TABLE `result_partial_results` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `result_summary`
--

DROP TABLE IF EXISTS `result_summary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `result_summary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `average` double NOT NULL,
  `count` bigint(20) NOT NULL,
  `max` double NOT NULL,
  `min` double NOT NULL,
  `sample_name` varchar(255) DEFAULT NULL,
  `sum` double NOT NULL,
  `variance` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result_summary`
--

LOCK TABLES `result_summary` WRITE;
/*!40000 ALTER TABLE `result_summary` DISABLE KEYS */;
INSERT INTO `result_summary` VALUES (1,5.542857142857144,35,7,3,'producto 1',194,0.7848739495798325),(2,4,35,6,2,'producto 2',140,1.2941176470588232),(3,6.228571428571429,35,10,1,'producto 3',218,8.416806722689074),(4,3.057142857142857,35,4,2,'producto 1',107,0.173109243697479),(5,2.9428571428571426,35,5,1,'producto 2',103,0.9378151260504201),(6,6.257142857142856,35,10,1,'producto 3',219,9.137815126050418),(7,2.9999999999999996,35,4,1,'producto 1',105,0.23529411764705882),(8,2.8857142857142852,35,5,1,'producto 2',101,0.8100840336134457),(9,5.428571428571428,35,10,1,'producto 3',190,6.72268907563025),(10,2,2,2,2,'p1',4,0),(11,3,2,3,3,'p2',6,0),(12,4,2,4,4,'p3',8,0),(13,2,2,2,2,'p1',4,0),(14,3,2,3,3,'p2',6,0),(15,4,2,4,4,'p3',8,0),(16,2,2,2,2,'p1',4,0),(17,3,2,3,3,'p2',6,0),(18,4,2,4,4,'p3',8,0),(19,2,2,2,2,'p1',4,0),(20,3,2,3,3,'p2',6,0),(21,4,2,4,4,'p3',8,0),(22,2,2,2,2,'p1',4,0),(23,3,2,3,3,'p2',6,0),(24,4,2,4,4,'p3',8,0),(25,2,2,2,2,'p1',4,0),(26,3,2,3,3,'p2',6,0),(27,4,2,4,4,'p3',8,0),(28,2,2,2,2,'p1',4,0),(29,3,2,3,3,'p2',6,0),(30,4,2,4,4,'p3',8,0),(31,2,2,2,2,'p1',4,0),(32,3,2,3,3,'p2',6,0),(33,4,2,4,4,'p3',8,0),(34,2,2,2,2,'p1',4,0),(35,3,2,3,3,'p2',6,0),(36,4,2,4,4,'p3',8,0),(37,2,2,2,2,'p1',4,0),(38,3,2,3,3,'p2',6,0),(39,4,2,4,4,'p3',8,0),(40,2,2,2,2,'p1',4,0),(41,3,2,3,3,'p2',6,0),(42,4,2,4,4,'p3',8,0),(43,2,2,2,2,'p1',4,0),(44,3,2,3,3,'p2',6,0),(45,4,2,4,4,'p3',8,0),(46,2,2,2,2,'p1',4,0),(47,3,2,3,3,'p2',6,0),(48,4,2,4,4,'p3',8,0),(49,2,2,2,2,'p1',4,0),(50,3,2,3,3,'p2',6,0),(51,4,2,4,4,'p3',8,0),(52,2,2,2,2,'p1',4,0),(53,3,2,3,3,'p2',6,0),(54,4,2,4,4,'p3',8,0),(55,2,2,2,2,'p1',4,0),(56,3,2,3,3,'p2',6,0),(57,4,2,4,4,'p3',8,0),(58,2,2,2,2,'p1',4,0),(59,3,2,3,3,'p2',6,0),(60,4,2,4,4,'p3',8,0),(61,2,2,2,2,'p1',4,0),(62,3,2,3,3,'p2',6,0),(63,4,2,4,4,'p3',8,0),(64,2,2,2,2,'p1',4,0),(65,3,2,3,3,'p2',6,0),(66,4,2,4,4,'p3',8,0),(67,2,2,2,2,'p1',4,0),(68,3,2,3,3,'p2',6,0),(69,4,2,4,4,'p3',8,0),(70,2,2,2,2,'p1',4,0),(71,3,2,3,3,'p2',6,0),(72,4,2,4,4,'p3',8,0),(73,2,2,2,2,'p1',4,0),(74,3,2,3,3,'p2',6,0),(75,4,2,4,4,'p3',8,0),(76,2,2,2,2,'p1',4,0),(77,3,2,3,3,'p2',6,0),(78,4,2,4,4,'p3',8,0),(79,2,2,2,2,'p1',4,0),(80,3,2,3,3,'p2',6,0),(81,4,2,4,4,'p3',8,0),(82,2,2,2,2,'p1',4,0),(83,3,2,3,3,'p2',6,0),(84,4,2,4,4,'p3',8,0),(85,2,2,2,2,'p1',4,0),(86,3,2,3,3,'p2',6,0),(87,4,2,4,4,'p3',8,0),(88,2,2,2,2,'p1',4,0),(89,3,2,3,3,'p2',6,0),(90,4,2,4,4,'p3',8,0),(91,2,2,2,2,'p1',4,0),(92,3,2,3,3,'p2',6,0),(93,4,2,4,4,'p3',8,0),(94,2,2,2,2,'p1',4,0),(95,3,2,3,3,'p2',6,0),(96,4,2,4,4,'p3',8,0),(97,2,2,2,2,'p1',4,0),(98,3,2,3,3,'p2',6,0),(99,4,2,4,4,'p3',8,0),(100,2,2,2,2,'p1',4,0),(101,3,2,3,3,'p2',6,0),(102,4,2,4,4,'p3',8,0),(103,2,2,2,2,'p1',4,0),(104,3,2,3,3,'p2',6,0),(105,4,2,4,4,'p3',8,0),(106,2,2,2,2,'p1',4,0),(107,3,2,3,3,'p2',6,0),(108,4,2,4,4,'p3',8,0),(109,5.542857142857144,35,7,3,'producto 1',194,0.7848739495798325),(110,4,35,6,2,'producto 2',140,1.2941176470588232),(111,3.057142857142857,35,4,2,'producto 1',107,0.173109243697479),(112,2.9428571428571426,35,5,1,'producto 2',103,0.9378151260504201),(113,2.9999999999999996,35,4,1,'producto 1',105,0.23529411764705882),(114,2.8857142857142852,35,5,1,'producto 2',101,0.8100840336134457),(115,5.542857142857144,35,7,3,'producto 1',194,0.7848739495798325),(116,4,35,6,2,'producto 2',140,1.2941176470588232),(117,3.057142857142857,35,4,2,'producto 1',107,0.173109243697479),(118,2.9428571428571426,35,5,1,'producto 2',103,0.9378151260504201),(119,2.9999999999999996,35,4,1,'producto 1',105,0.23529411764705882),(120,2.8857142857142852,35,5,1,'producto 2',101,0.8100840336134457),(121,3.1428571428571437,35,5,1,'producto 1',110,0.9495798319327731),(122,7.057142857142858,35,8,6,'producto 2',247,0.17310924369747882),(123,5.542857142857144,35,7,3,'producto 1',194,0.7848739495798325),(124,3.057142857142857,35,4,2,'producto 2',107,0.173109243697479),(125,5.142857142857143,35,7,3,'producto 1',180,0.9495798319327728),(126,3.1428571428571437,35,5,1,'producto 2',110,0.9495798319327731),(127,6.057142857142858,35,7,5,'producto 1',212,0.17310924369747882),(128,5.142857142857143,35,7,3,'producto 2',180,0.9495798319327728),(129,3.057142857142857,35,4,2,'producto 1',107,0.173109243697479),(130,6.057142857142858,35,7,5,'producto 2',212,0.17310924369747882);
/*!40000 ALTER TABLE `result_summary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sensory_evaluation`
--

DROP TABLE IF EXISTS `sensory_evaluation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sensory_evaluation` (
  `sam_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `scale` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sam_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sensory_evaluation`
--

LOCK TABLES `sensory_evaluation` WRITE;
/*!40000 ALTER TABLE `sensory_evaluation` DISABLE KEYS */;
INSERT INTO `sensory_evaluation` VALUES (14,'Maxi Sarno','2017-11-13 02:02:33','caso 1','FIVE','DESCRIPTIVE'),(15,'usuario@sam.uade.ar','2017-11-13 02:18:46','caso 2','NINE','HEDONIC'),(16,'maxisar@gmail.com','2017-11-13 10:52:08','caso 7','NINE','HEDONIC');
/*!40000 ALTER TABLE `sensory_evaluation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_account`
--

DROP TABLE IF EXISTS `user_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_account` (
  `username` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_account`
--

LOCK TABLES `user_account` WRITE;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
INSERT INTO `user_account` VALUES ('administrador@sam.uade.ar','administrador sam','2ff362faea73ddbc8df81690ab5e79337c024089c9de70b861da9d5bc7ef8c99','ADMIN'),('cgodio@uade.edu.ar','Claudio Godio','8cface989a3a91edb14989e82ff3ab67cfd3046906d0cee828f8882a8e137823','ADMIN'),('maxisar@gmail.com','Maxi Sarno','ab3691d8e45c1f50684b2762fc640afbe61266bf49c34e0a5319044da23af364','ADMIN'),('syasky@uade.edu.ar','Sofia Yasky','86846e84f9bfb2053a4823193843d22a0be24a75d304d6f8a2e4d2fac445efaa','ADMIN'),('usuario@sam.uade.ar','usuario sam','2ff362faea73ddbc8df81690ab5e79337c024089c9de70b861da9d5bc7ef8c99','USER');
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-13 12:26:22
