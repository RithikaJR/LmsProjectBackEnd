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
   `course_url` VARCHAR(255) DEFAULT NULL,
   `course_image_url` VARCHAR(255) DEFAULT NULL,
   `category_id` BIGINT(20) NOT NULL,
   PRIMARY KEY (`course_id`),
   KEY `fk_category` (`category_id`),
   CONSTRAINT `fk_category` FOREIGN KEY (`category_id`) REFERENCES `course_category` (`category_id`)
 ) 
 ENGINE=InnoDB
 AUTO_INCREMENT = 1;

INSERT INTO course_category VALUES(1,"SOFT SKILL"),(2,"UI/UX"),(3,"CORE LANGUAGES");
INSERT INTO course VALUES(100,"COMMUNICATION","TIPS FOR EFFECTIVE COMMUNICATION ","https://www.youtube.com/watch?v=hE6I9apUvrk","https://5.imimg.com/data5/NX/VJ/MY-65545223/diploma-courses-communications-skills-500x500.png","1"),
(101,"EMAIL-ETIQUETTE","COME LETS COMMUNICATE THROUGH EMAIL ","https://www.youtube.com/watch?v=1XctnF7C74s","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR34o_-GsEl1s2XBwvFbVBLlC9pERqEwpublA&usqp=CAU","1"),
(103,"HTML & CSS","BASICS OF WEB DESIGNING ","https://www.youtube.com/watch?v=G3e-cpL7ofc","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSL7OBtKiuFepjHYPjerjXPpDCETYHyx-K4g&usqp=CAU","2"),
(104,"CORE JAVA","CORE JAVA FOR BEGINNERS","https://www.youtube.com/watch?v=CFD9EFcNZTQ","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQY_jXc_zdH7jotROmPmhrI0ZFT5C0rfp-F9g&usqp=CAU","3");



insert into userprofile(user_firstname,user_lastname)
 select emp_firstname,emp_lasstname from employees;



