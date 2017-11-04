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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `design_slot`
--

LOCK TABLES `design_slot` WRITE;
/*!40000 ALTER TABLE `design_slot` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `label`
--

LOCK TABLES `label` WRITE;
/*!40000 ALTER TABLE `label` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `numeric_attribute`
--

LOCK TABLES `numeric_attribute` WRITE;
/*!40000 ALTER TABLE `numeric_attribute` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partial_result`
--

LOCK TABLES `partial_result` WRITE;
/*!40000 ALTER TABLE `partial_result` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result_summary`
--

LOCK TABLES `result_summary` WRITE;
/*!40000 ALTER TABLE `result_summary` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sensory_evaluation`
--

LOCK TABLES `sensory_evaluation` WRITE;
/*!40000 ALTER TABLE `sensory_evaluation` DISABLE KEYS */;
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
INSERT INTO `user_account` VALUES ('maxisar@gmail.com','Maxi Sarno','ab3691d8e45c1f50684b2762fc640afbe61266bf49c34e0a5319044da23af364','ADMIN');
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

-- Dump completed on 2017-11-03 22:42:09
