-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: ftb_db
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `aircraft`
use ftb;
DROP TABLE IF EXISTS `aircraft`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aircraft` (
    `aircraft_id` bigint(20) NOT NULL,
    `manufacturer` varchar(255) DEFAULT NULL,
    `model` varchar(255) DEFAULT NULL,
    `number_of_seats` int(11) DEFAULT NULL,
    PRIMARY KEY (`aircraft_id`)
    ) ENGINE=InnoDB;
/*!40101 SET character_set_client = @saved_cs_client */;





--
-- Table structure for table `airport`
--

DROP TABLE IF EXISTS `airport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airport` (
    `airport_id` int(11) NOT NULL,
    `airport_code` varchar(255) DEFAULT NULL,
    `airport_name` varchar(255) DEFAULT NULL,
    `city` varchar(255) DEFAULT NULL,
    `country` varchar(255) DEFAULT NULL,
    `state` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`airport_id`)
    ) ENGINE=InnoDB;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight` (
    `flight_id` bigint(20) NOT NULL,
    `arrival_date` date DEFAULT NULL,
    `arrival_time` varchar(255) DEFAULT NULL,
    `departure_date` date DEFAULT NULL,
    `departure_time` varchar(255) DEFAULT NULL,
    `flight_charge` double NOT NULL,
    `flight_number` varchar(255) DEFAULT NULL,
    `aircraft_aircraft_id` bigint(20) DEFAULT NULL,
    `departure_airport_airport_id` int(11) DEFAULT NULL,
    `destination_airport_airport_id` int(11) DEFAULT NULL,
    PRIMARY KEY (`flight_id`),
    KEY `FK98q69epkawxnm44tayvrppdbs` (`aircraft_aircraft_id`),
    KEY `FK3oa47xgnaiy3jyqk2j1a4bdmq` (`departure_airport_airport_id`),
    KEY `FKtk8ruym4g6f4flrcnnop2mnah` (`destination_airport_airport_id`),
    CONSTRAINT `FK3oa47xgnaiy3jyqk2j1a4bdmq` FOREIGN KEY (`departure_airport_airport_id`) REFERENCES `airport` (`airport_id`),
    CONSTRAINT `FK98q69epkawxnm44tayvrppdbs` FOREIGN KEY (`aircraft_aircraft_id`) REFERENCES `aircraft` (`aircraft_id`),
    CONSTRAINT `FKtk8ruym4g6f4flrcnnop2mnah` FOREIGN KEY (`destination_airport_airport_id`) REFERENCES `airport` (`airport_id`)
    ) ENGINE=InnoDB;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
    `next_val` bigint(20) DEFAULT NULL
    ) ENGINE=InnoDB;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `passenger`
--

DROP TABLE IF EXISTS `passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passenger` (
    `passenger_id` varchar(255) NOT NULL,
    `address` varchar(255) DEFAULT NULL,
    `email` varchar(255) DEFAULT NULL,
    `first_name` varchar(255) DEFAULT NULL,
    `last_name` varchar(255) DEFAULT NULL,
    `passport_number` varchar(255) DEFAULT NULL,
    `phone_number` varchar(255) DEFAULT NULL,
    `flight_flight_id` bigint(20) DEFAULT NULL,
    PRIMARY KEY (`passenger_id`),
    KEY `FKffb69w8vqqqv7dqnf91o7yl91` (`flight_flight_id`),
    CONSTRAINT `FKffb69w8vqqqv7dqnf91o7yl91` FOREIGN KEY (`flight_flight_id`) REFERENCES `flight` (`flight_id`)
    ) ENGINE=InnoDB;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
    `id` int(11) NOT NULL,
    `name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_ofx66keruapi6vyqpv6f2or37` (`name`)
    ) ENGINE=InnoDB;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
    `id` int(11) NOT NULL,
    `email` varchar(255) NOT NULL,
    `firstname` varchar(255) NOT NULL,
    `lastname` varchar(255) NOT NULL,
    `middlename` varchar(255) DEFAULT NULL,
    `password` varchar(255) NOT NULL,
    `username` varchar(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
    UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`)
    ) ENGINE=InnoDB;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roles` (
    `user_id` int(11) NOT NULL,
    `role_id` int(11) NOT NULL,
    PRIMARY KEY (`user_id`),
    KEY `roles_users_roles_idx` (`role_id`),
    CONSTRAINT `roles_users_roles` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
    CONSTRAINT `users_users_roles` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
    ) ENGINE=InnoDB;
/*!40101 SET character_set_client = @saved_cs_client */;



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-15 17:29:30
