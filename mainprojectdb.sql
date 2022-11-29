
CREATE DATABASE IF NOT EXISTS LMSDATABASE;

USE LMSDATABASE;


CREATE TABLE IF NOT EXISTS `LMSDATABASE`.`course_category` (
   `category_id` BIGINT(20) NOT NULL ,
   `category_name` VARCHAR(255) NULL DEFAULT NULL,
   PRIMARY KEY (`category_id`))
 ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS `LMSDATABASE`.`course` (
   `course_id` BIGINT(20) NOT NULL ,
   `course_name` VARCHAR(255) DEFAULT NULL,
   `course_description` VARCHAR(255) DEFAULT NULL,
   `course_image_url` VARCHAR(255) DEFAULT NULL,
   `category_id` BIGINT(20) NOT NULL,
   PRIMARY KEY (`course_id`),
   KEY `fk_category` (`category_id`),
   CONSTRAINT `fk_category` FOREIGN KEY (`category_id`) REFERENCES `course_category` (`category_id`)
 ) 
 ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `LMSDATABASE`.`role` (
   `role_id` BIGINT(20) NOT NULL ,
   `role_name` VARCHAR(255) NULL DEFAULT NULL,
   PRIMARY KEY (`role_id`))
ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS `LMSDATABASE`.`userprofile` (`user_id` BIGINT(20) NOT NULL ,`user_firstname` VARCHAR(255) DEFAULT NULL,
`user_lastname` VARCHAR(255) DEFAULT NULL,`role_id` BIGINT(20) NOT NULL,PRIMARY KEY (`user_id`),
KEY `fk_role` (`role_id`),
CONSTRAINT `fk_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`))
ENGINE=InnoDB;




INSERT INTO course_category VALUES(1,"SOFT SKILL"),(2,"UI/UX"),(3,"CORE LANGUAGES");

INSERT INTO course VALUES(100,"COMMUNICATION","TIPS FOR EFFECTIVE COMMUNICATION ","https://5.imimg.com/data5/NX/VJ/MY-65545223/diploma-courses-communications-skills-500x500.png","1"),
(101,"EMAIL-ETIQUETTE","COME LETS COMMUNICATE THROUGH EMAIL ","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR34o_-GsEl1s2XBwvFbVBLlC9pERqEwpublA&usqp=CAU","1"),
(103,"HTML & CSS","BASICS OF WEB DESIGNING ","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSL7OBtKiuFepjHYPjerjXPpDCETYHyx-K4g&usqp=CAU","2"),
(104,"CORE JAVA","CORE JAVA FOR BEGINNERS","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQY_jXc_zdH7jotROmPmhrI0ZFT5C0rfp-F9g&usqp=CAU","3");


INSERT INTO role VALUES(007,"Admin"),(008,"learningAdmin"),(123,"endUser");











CREATE TABLE IF NOT EXISTS `LMSDATABASE`.`employees` (
   `emp_id` BIGINT(20) NOT NULL ,
   `emp_firstname` VARCHAR(55) NULL DEFAULT NULL,
   `emp_lasstname` VARCHAR(55) NULL DEFAULT NULL,
   `emp_email` VARCHAR(255) NULL DEFAULT NULL,
   PRIMARY KEY (`emp_id`))
ENGINE=InnoDB;







CREATE TABLE IF NOT EXISTS `LMSDATABASE`.`module` (

   `course_id` BIGINT(20) NOT NULL ,
   `module_id` BIGINT(20) NOT NULL ,
   `module_name` VARCHAR(255) DEFAULT NULL,
   `module_image_url` VARCHAR(255) DEFAULT NULL,
   `module_url` VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (`module_id`),
    KEY `fk_course` (`course_id`),
   CONSTRAINT `fk_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`)
 ) 
 ENGINE=InnoDB;



/*
-- Query: SELECT * FROM lmsdatabase.module
LIMIT 0, 1000

-- Date: 2022-11-25 19:00
*/
INSERT INTO `module` (`category_id`,course_id`,`module_id`,`module_name`,`module_image_url`,`module_url`) VALUES (1,100,1,'Effective Communication','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRHca7CDuJZnIXEiQ4Fntfirii-OCau_EkusQ&usqp=CAU','https://www.youtube.com/watch?v=6pYSbdGiDYw');
INSERT INTO `module` (`category_id`,`course_id`,`module_id`,`module_name`,`module_image_url`,`module_url`) VALUES (1,100,2,'Leadership Skills','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTql9f7dd3ke97aGuaqXBFANVfjGOGMmAguvw&usqp=CAU','https://www.youtube.com/watch?v=0sY3uf3LZZg');
INSERT INTO `module` (`category_id`,`course_id`,`module_id`,`module_name`,`module_image_url`,`module_url`) VALUES (2,104,3,'core java basics','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTrzIDMcw4qBbz9Ccj6qgGm1qM8lOvYvH1TIA&usqp=CAU','https://www.youtube.com/watch?v=Yy1yx9uTHIs');
INSERT INTO `module` (`category_id`,`course_id`,`module_id`,`module_name`,`module_image_url`,`module_url`) VALUES (1,101,4,'email basics','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTEpfoCTGiO1JIrPF2S_32rL-tt92amduy8tA&usqp=CAU','https://www.youtube.com/watch?v=1XctnF7C74s');
INSERT INTO `module` (`category_id`,`course_id`,`module_id`,`module_name`,`module_image_url`,`module_url`) VALUES (2,103,5,'html css basics','https://developer.mozilla.org/en-US/docs/Learn/Getting_started_with_the_web/CSS_basics/css-declaration-small.png','https://www.youtube.com/watch?v=G3e-cpL7ofc');














