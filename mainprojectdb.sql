
CREATE DATABASE IF NOT EXISTS LMSDATABASE;

USE LMSDATABASE;


CREATE TABLE IF NOT EXISTS `LMSDATABASE`.`course_category` (
   `category_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
   `category_name` VARCHAR(255) NULL DEFAULT NULL,
   PRIMARY KEY (`category_id`))
 ENGINE=InnoDB
 AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `LMSDATABASE`.`course` (
   `course_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
   `course_name` VARCHAR(255) DEFAULT NULL,
   `course_description` VARCHAR(255) DEFAULT NULL,
   `course_image_url` VARCHAR(255) DEFAULT NULL,
   `category_id` BIGINT(20) NOT NULL,
   PRIMARY KEY (`course_id`),
   KEY `fk_category` (`category_id`),
   CONSTRAINT `fk_category` FOREIGN KEY (`category_id`) REFERENCES `course_category` (`category_id`)
 ) 
 ENGINE=InnoDB
 AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `LMSDATABASE`.`role` (
   `role_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
   `role_name` VARCHAR(255) NULL DEFAULT NULL,
   PRIMARY KEY (`role_id`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;


CREATE TABLE IF NOT EXISTS `LMSDATABASE`.`userprofile` (`user_id` BIGINT(20) NOT NULL AUTO_INCREMENT,`user_firstname` VARCHAR(255) DEFAULT NULL,
`user_lastname` VARCHAR(255) DEFAULT NULL,`role_id` BIGINT(20) NOT NULL,PRIMARY KEY (`user_id`),
KEY `fk_role` (`role_id`),
CONSTRAINT `fk_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;




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
   CONSTRAINT `fk_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`)
 ) 
 ENGINE=InnoDB
 AUTO_INCREMENT = 1;

















