
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
   `course_Duration` Time DEFAULT NULL,
   `course_rating` BIGINT(20) DEFAULT NULL,

    
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


INSERT INTO course_category VALUES(1,"SOFT SKILL"),(2,"UI/UX"),(3,"CORE LANGUAGES");

INSERT INTO course VALUES(100,"COMMUNICATION","TIPS FOR EFFECTIVE COMMUNICATION ","https://5.imimg.com/data5/NX/VJ/MY-65545223/diploma-courses-communications-skills-500x500.png","1","000500",0),
(102,"EMAIL-ETIQUETTE","COME LETS COMMUNICATE THROUGH EMAIL ","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR34o_-GsEl1s2XBwvFbVBLlC9pERqEwpublA&usqp=CAU","1","001000",5),
(103,"HTML & CSS","BASICS OF WEB DESIGNING ","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSL7OBtKiuFepjHYPjerjXPpDCETYHyx-K4g&usqp=CAU","2","001000",0),
(104,"CORE JAVA","CORE JAVA FOR BEGINNERS","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQY_jXc_zdH7jotROmPmhrI0ZFT5C0rfp-F9g&usqp=CAU","3","000700",9);


INSERT INTO role VALUES(1,"Super Admin"),(2,"Learning Admin"),(3,"User");


CREATE TABLE IF NOT EXISTS `LMSDATABASE`.`employees` (
   `emp_id` BIGINT(20) NOT NULL AUTO_INCREMENT UNIQUE,
   `emp_firstname` VARCHAR(55) NULL DEFAULT NULL,
   `emp_lastname` VARCHAR(55) NULL DEFAULT NULL,
   `emp_email` VARCHAR(255) UNIQUE DEFAULT NULL,
   PRIMARY KEY (`emp_id`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;



CREATE TABLE IF NOT EXISTS `LMSDATABASE`.`module` (
   `course_id` BIGINT(20) NOT NULL ,
   `module_id` BIGINT(20) NOT NULL ,
   `module_name` VARCHAR(255) DEFAULT NULL,
   `module_image_url` VARCHAR(255) DEFAULT NULL,
   `module_url` VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (`module_id`),
   CONSTRAINT `fk_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`)on update cascade on delete cascade
 )
 ENGINE=InnoDB
 AUTO_INCREMENT = 1;




CREATE TABLE IF NOT EXISTS `LMSDATABASE`.`userprofile` (
   `user_id` BIGINT(20)  AUTO_INCREMENT NOT NULL UNIQUE,
   `emp_id` BIGINT(20) NOT NULL  UNIQUE,
   `role_id` BIGINT(20) NOT NULL DEFAULT 3 ,
   `emp_name` VARCHAR(255) DEFAULT NULL,
   `user_name` VARCHAR(255) DEFAULT NULL UNIQUE,
   `user_password` VARCHAR(255) DEFAULT "$2a$10$dleGunq2amw9nmG.CKED0uHwZgDhsjL7rf3RWttolT7A4earCJI0C",
   `initial_status` Boolean DEFAULT false,
    PRIMARY KEY (`user_id`),
   CONSTRAINT `fk_employee` FOREIGN KEY (`emp_id`) REFERENCES `employees` (`emp_id`) on update cascade on delete cascade,
   CONSTRAINT `fk_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
 )
 ENGINE=InnoDB
 AUTO_INCREMENT = 1;



DROP TRIGGER IF EXISTS `lmsdatabase`.`employees_AFTER_INSERT`;

  DELIMITER $$

  CREATE DEFINER=`root`@`localhost` TRIGGER `employees_AFTER_INSERT` AFTER INSERT ON `employees` FOR EACH ROW
  BEGIN
  insert ignore into userprofile(emp_id,emp_name,user_name)
  select new.emp_id,new.emp_firstname,new.emp_email from employees;
  END$$

  DELIMITER ;



CREATE TABLE IF NOT EXISTS `LMSDATABASE`.`module_resource` (
   `module_resource_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
   `module_id` BIGINT(20) NOT NULL ,
   `module_resource_name` VARCHAR(255) DEFAULT NULL,
   `module_resource_type` VARCHAR(255) DEFAULT NULL,
   `module_resource_url` VARCHAR(255) DEFAULT NULL,
   `module_resource_duration` TIME DEFAULT NULL,
    PRIMARY KEY (`module_resource_id`),
   CONSTRAINT `fk_module` FOREIGN KEY (`module_id`) REFERENCES `module` (`module_id`) on update cascade on delete cascade
 )
 ENGINE=InnoDB
 AUTO_INCREMENT = 1;


 insert into employees values
   (1001,"jithin","raj","jithin.r@experionglobal.com"),
   (1002,"robin","cheriyan mathew","robin.cm@experionglobal.com"),
   (1003,"vaishnav","l","vaishnav.l@experionglobal.com"),
   (1004,"rithika","jr","rithika.jr@experionglobal.com"),
   (1005,"drishya","t","drishya.t@experionglobal.com");


CREATE TABLE IF NOT EXISTS `LMSDATABASE`.`course_approval` (
   `course_approval_id` BIGINT(20) AUTO_INCREMENT NOT NULL,
   `emp_id` BIGINT(20) NOT NULL,
   `emp_name` varchar(255) NOT NULL,
   `course_id` BIGINT(20) NOT NULL,
   `course_name`varchar(255) NOT NULL,
   `approval_status`varchar(255) default 'pending',
 PRIMARY KEY (`course_approval_id`)
  )
ENGINE=InnoDB
AUTO_INCREMENT = 1;


CREATE TABLE IF NOT EXISTS `LMSDATABASE`.`session` (
   `session_id` BIGINT(20) AUTO_INCREMENT NOT NULL,
   `session_name` varchar(255) NOT NULL,
   `session_description` varchar(255)  NULL,
   `trainer_name` varchar(255) NOT NULL,
   `session_start_time` Time NOT NULL,
   `session_end_time` Time NOT Null,
   `session_date` Date NOT NULL,
   `session_cost` Decimal NOT NULL,
 PRIMARY KEY (`session_id`)
  )
ENGINE=InnoDB
AUTO_INCREMENT = 1;



CREATE TABLE IF NOT EXISTS `LMSDATABASE`.`enrolled_course` (
   `enrolled_course_id` BIGINT(20) AUTO_INCREMENT NOT NULL,
   `course_id` BIGINT(20) NOT NULL,
   `emp_id` BIGINT(20) NOT NULL,
   `enrolled_date` DATE DEFAULT NULL,
   `status` enum('completed','enrolled') default 'enrolled',
   `employee_rating` BIGINT(20) default 5,
   PRIMARY KEY (`enrolled_course_id`),
   CONSTRAINT `fk_courses` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
   CONSTRAINT `fk_employees` FOREIGN KEY (`emp_id`) REFERENCES `employees` (`emp_id`)
   )
ENGINE=InnoDB
AUTO_INCREMENT = 1;




CREATE TABLE IF NOT EXISTS `LMSDATABASE`.`completed_course` (
   `completed_course_id` BIGINT(50) AUTO_INCREMENT NOT NULL,
   `enrolled_course_id` BIGINT(20) NOT NULL,
   `course_id` BIGINT(20) NOT NULL,
   `emp_id` BIGINT(20) NOT NULL,
   `status` enum('completed') default 'completed',
   PRIMARY KEY (`completed_course_id`),
   CONSTRAINT `fk_enrolled_course` FOREIGN KEY (`enrolled_course_id`) REFERENCES `enrolled_course` (`enrolled_course_id`),
   CONSTRAINT `fk_coursess` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
   CONSTRAINT `fk_employeess` FOREIGN KEY (`emp_id`) REFERENCES `employees` (`emp_id`)
)
 ENGINE=InnoDB
 AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `LMSDATABASE`.`feedback` (
   `feedback_id` BIGINT(20) AUTO_INCREMENT NOT NULL,
   `emp_id` BIGINT(20) NOT NULL,
   `emp_name` varchar(255) NOT NULL,
   `feedback`  TEXT NULL,
   `status` Boolean default false,
   PRIMARY KEY (`feedback_id`))
 ENGINE=InnoDB
 AUTO_INCREMENT = 1;






    










