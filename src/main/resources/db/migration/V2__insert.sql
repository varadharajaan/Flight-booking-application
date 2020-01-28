
--
-- Dumping data for table `aircraft`
--
use ftb;

LOCK TABLES `aircraft` WRITE;
/*!40000 ALTER TABLE `aircraft` DISABLE KEYS */;
INSERT INTO `aircraft` VALUES (3,'Boeing','Boeing 307',100),(4,'Boeing','Boeing 737',300),(16,'Airbus','Airbus A220',200),(20,'Airbus','Airbus A340',340),(23,'Airbus','Airbus A440',400),(36,'Boeing','Boeing 201',180);
/*!40000 ALTER TABLE `aircraft` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `airport`
--

LOCK TABLES `airport` WRITE;
/*!40000 ALTER TABLE `airport` DISABLE KEYS */;
INSERT INTO `airport` VALUES (1,'DAL','Dallas Love Field','Dallas','United States','Dallas'),(2,'DCG','Dubai Creek SPB','Dubai','United Arab Emirates','Dubai'),(15,'CID','Cedar Rapid Airport','IOWA','United States','Iowa'),(19,'CHI','Chicago Airport','Chicago','United States','Illinois'),(31,'CLN','California Airport','California','United States','California'),(35,'TEX','Texas Airport','Texas','United States','Texas');
/*!40000 ALTER TABLE `airport` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (5,'2019-08-01','10:30','2019-08-01','08:00',1200,'dallas-dubai100',3,1,2),(6,'2019-08-02','00:20','2019-08-02','10:20',1600,'dubai-dalas110',3,2,1),(25,'2019-08-08','09:00','2019-08-08','07:00',250,'chi-cedar01',3,19,15),(26,'2019-08-03','16:00','2019-08-03','14:00',180,'ced-chi05',16,15,19),(33,'2019-08-16','21:00','2019-08-16','00:00',500,'dal - cal',4,1,31),(37,'2019-08-31','14:40','2019-08-31','08:00',650,'IA-TEX101',36,15,35);
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (38),(38),(38),(38);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Dumping data for table `passenger`
--

LOCK TABLES `passenger` WRITE;
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` VALUES ('EU-CUS-001','1000 N 4th Street, MUM','john@mum.edu','John','Doe','78998787','6414513308',5),('EU-CUS-002','1000 N 4th Street, MUM, MR#100','anna@gmail.com','Anna','Smith','02538467','6414513308',5),('EU-CUS-007','1000 N 4th Street, MUM, MR#15','chibusi@gmail.com','Chibusi','Kelvin','45687997','6414513308',6),('EU-CUS-009','1000 N 4th Street, MUM, MR#48','alimohammad.ahmadi2008@gmail.com','Ali Mohammed','Ahmadi','45687997','6414513308',5),('EU-CUS-34','1000 N 4th Street, Maharishi University of Management','churn@mum.com','Chinedu','Urbanus','A20193885','23456789',33);
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_AGENT');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Dumping data for table `users`
-- password1: inviapassword , password2: inviaflight

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'varathu09@gmail.com','John','Doe',NULL,'$2y$12$io6IqvvV19/PSl3gn7BOh.Ln5EQYTy5KDpaDh13qYtmLXkjvr2A5i','john'),(2,'mike@gmail.com','Mike','Jacson',NULL,'$2y$12$s2XXzS1WhXvTGf9jHbz5ueeCLmTUGTrVLEKReH4xCv1C5vpAytoWC','mike');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;
