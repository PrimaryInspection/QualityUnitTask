-- -----------------------------------------------------
-- Table `webhosting`.`request`
-- -----------------------------------------------------
INSERT INTO webhosting.request(id,date,query_type,response_type,response_wait_time,service_id,question_id) VALUES
(1,'2016.03.13','C','P',11,8,5),
(2,'2016.03.18','C','P',18,8,3),
(3,'2016.03.17','C','N',97,2,3),
(5,'2016.03.19','C','N',56,5,2),
(6,'2016.03.18','C','N',24,6,3),
(8,'2016.03.22','C','N',73,2,8),
(9,'2016.03.16','C','P',33,7,3),
(11,'2016.03.12','C','P',23,9,3),
(12,'2016.03.13','C','N',52,4,2),
(13,'2016.03.18','C','P',32,6,2),
(14,'2016.03.05','C','P',72,4,2);

INSERT INTO webhosting.request(id,start_date,end_date,query_type,response_type,service_id,question_id) VALUES
(4,'2016.03.12','2016.03.24','D','P',8,1),
(7,'2016.02.14','2016.06.22', 'D','N',1,2),
(10,'2016.03.16', '2016.03.20', 'D','P',5,2),
(15,'2016.03.03', '2016.03.22', 'D','P',1,1);


-- -----------------------------------------------------
-- Table `webhosting`.`question`
-- -----------------------------------------------------

INSERT INTO webhosting.question(id,name) VALUES
(1,'*'),
(3,'Question type 3'),
(7,'Question type 7');


INSERT INTO webhosting.question(id,name,category_id) VALUES
(2,'Question type 2',2),
(5,'Question type 5',1),
(6,'Question type 6',2),
(8,'Question type 8',5),
(9,'Question type 9',4),
(10,'Question type 10',4);

-- -----------------------------------------------------
-- Table `webhosting`.`service`
-- -----------------------------------------------------

INSERT INTO webhosting.service(id,name) VALUES
(1,'*'),
(9,'Service type 9'),
(6,'Service type 6'),
(3,'Service type 3');

INSERT INTO webhosting.service(id,name,variation_id) VALUES
(2,'Service type 2',1),
(4,'Service type 4',3),
(5,'Service type 5',2),
(7,'Service type 7',1),
(8,'Service type 8',2),
(10,'Service type 10',3);

-- -----------------------------------------------------
-- Table `webhosting`.`category`
-- -----------------------------------------------------
INSERT INTO webhosting.category(id,name) VALUES
(1,'*'),
(2,'Category type 2'),
(6,'Category type 6');

INSERT INTO webhosting.category(id,name,sub_category_id) VALUES
(3,'Category type 3',3),
(4,'Category type 4',2),
(5,'Category type 5',5),
(7,'Category type 7',2),
(8,'Category type 8',4),
(9,'Category type 9',5),
(10,'Category type 10',1);

-- -----------------------------------------------------
-- Table `webhosting`.`sub_category`
-- -----------------------------------------------------
INSERT INTO webhosting.sub_category(id,name) VALUES
(9,'Sub-Category type 9'),
(6,'Sub-Category type 6');

INSERT INTO webhosting.sub_category(id,name) VALUES
(1,'Sub-Category type 1'),
(2,'Sub-Category type 2'),
(3,'Sub-Category type 3'),
(4,'Sub-Category type 4'),
(5,'Sub-Category type 5'),
(7,'Sub-Category type 7'),
(8,'Sub-Category type 8'),
(10,'Sub-Category type 10');

-- -----------------------------------------------------
-- Table `webhosting`.`variation`
-- -----------------------------------------------------

INSERT INTO webhosting.variation(id,name) VALUES
(1,'Variation type 1'),
(2,'Variation type 2'),
(3,'Variation type 3');
