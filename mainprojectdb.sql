
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
   CONSTRAINT `fk_category` FOREIGN KEY (`category_id`) REFERENCES `course_category` (`category_id`) on update cascade on delete cascade
 )
 ENGINE=InnoDB
 AUTO_INCREMENT = 1;







CREATE TABLE IF NOT EXISTS `LMSDATABASE`.`module` (
   `module_id` BIGINT(20) NOT NULL ,
   `course_id` BIGINT(20) NOT NULL ,
   `module_serial_number` INT  ,
   `module_name` VARCHAR(255) DEFAULT NULL,
   PRIMARY KEY (`module_id`),
   CONSTRAINT `fk_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`)on update cascade on delete cascade
 )
 ENGINE=InnoDB
 AUTO_INCREMENT = 1;

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


CREATE TABLE IF NOT EXISTS `LMSDATABASE`.`role` (
   `role_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
   `role_name` VARCHAR(255) NULL DEFAULT NULL,
   PRIMARY KEY (`role_id`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;


CREATE TABLE IF NOT EXISTS `LMSDATABASE`.`employees` (
   `emp_id` BIGINT(20) NOT NULL AUTO_INCREMENT UNIQUE,
   `emp_firstname` VARCHAR(55) NULL DEFAULT NULL,
   `emp_lastname` VARCHAR(55) NULL DEFAULT NULL,
   `emp_email` VARCHAR(255) UNIQUE DEFAULT NULL,
   PRIMARY KEY (`emp_id`))
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
   CONSTRAINT `fk_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) on update cascade on delete cascade
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





CREATE TABLE IF NOT EXISTS `LMSDATABASE`.`course_approval` (
   `course_approval_id` BIGINT(20) AUTO_INCREMENT NOT NULL,
   `emp_id` BIGINT(20) NOT NULL,
   `emp_name` varchar(255) NOT NULL,
   `emp_email` varchar(255) NOT NULL,
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
    CONSTRAINT `fk_courses` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) on update cascade on delete cascade,
   CONSTRAINT `fk_employees` FOREIGN KEY (`emp_id`) REFERENCES `employees` (`emp_id`)on update cascade on delete cascade

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
   CONSTRAINT `fk_coursess` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) on update cascade on delete cascade,
   CONSTRAINT `fk_employeess` FOREIGN KEY (`emp_id`) REFERENCES `employees` (`emp_id`) on update cascade on delete cascade

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








INSERT INTO course_category VALUES(1,"SOFT SKILL"),(2,"UI/UX"),(3,"CORE LANGUAGES");

INSERT INTO course VALUES(1,"Communicating with impact",null,"https://pll.harvard.edu/sites/default/files/styles/social_share/public/course/communicating%20-impact-virtual.jpg?itok=4hX1eOGX",1,
null,null),(2,"Effective Business Writing",null,"https://eezeeenglishzone.files.wordpress.com/2018/11/effective-business-writing.png",1,null,null),
(3,"Problem Solving and Creativity",null,"https://www.careeraddict.com/uploads/article/61083/problem-solving-skills.png",1,null,null),
(4,"Angular JS",null,"https://nareshit.com/wp-content/uploads/2018/08/angular-JS-online-training-nareshit.jpg",2,null,null),
(5,"HTML/CSS/JS",null,"https://blog.boot.dev/img/800/HTML-vs-CSS-vs-JavaScript-min.webp",2,null,null),
(6,"React JS",null,"https://www.patterns.dev/img/reactjs/react-logo@3x.svg",2,null,null),
(7,"C++",NULL,"https://www.educative.io/v2api/editorpage/5393602882568192/image/6038586442907648",3,null,null),
(8,"Java",null,"https://contentstatic.techgig.com/photo/93000110/what-makes-java-still-popular-among-developers.jpg?28608",3,null,null),
(9,"Python",null,"https://uploads.sololearn.com/uploads/courses/1073.png",3,null,null);


INSERT INTO module VALUES(1,1,1,"Introduction"),(2,1,2,"Basics of Communication"),(3,1,3,"Communicate with impact"),(4,1,4,"Conclusion"),
(5,2,1,"Introduction"),(6,2,2,"Basics of legible writing"),(7,2,3,"Effective Business Writing"),(8,2,4,"Conclusion"),
(9,3,1,"Introduction"),(10,3,2,"Basics of problem solving skills"),(11,3,3,"Creative problem solving methods"),(12,3,4,"Conclusion"),
(13,4,1,"Introduction"),(14,4,2,"Basics of html and js"),(15,4,3,"Angular Framework"),(16,4,4,"Conclusion"),
(17,5,1,"Introduction"),(18,5,2,"Basics"),(19,5,3,"Conclusion"),
(20,6,1,"Introduction"),(21,6,2,"Basics"),(22,6,3,"Conclusion"),
(23,7,1,"Introduction"),(24,7,2,"Basics"),(25,7,3,"Conclusion"),
(26,8,1,"Introduction to Java"),(27,8,2,"Basics of OOPs Concept"),(28,8,3,"Java IDEs and Installation"),(29,8,4,"Control Statements"),(30,8,5,"Conclusion"),
(31,9,1,"Introduction"),(32,9,2,"Basics"),(33,9,3,"Conclusion");

INSERT INTO module_resource VALUES(1,26,"Introduction to Java Programming","mp4","https://drive.google.com/file/d/1dUAhTlcTxNm38_jMFP9Bf0if1c5t57Y0/preview","06:03"),
(2,26,"Java for Beginners Introduction","mp4","https://drive.google.com/file/d/19GmB4UhOYZV9YE2u8vEpdI1kMYLgi2P-/preview","13:09"),
(3,26,"Java Reading Material","pdf","https://drive.google.com/file/d/16iOzFPsvJgyQ_xoGvQ9PMHqUKHhGyZrZ/preview","00:00"),
(4,26,"Java-Intro-Notes","pdf","https://drive.google.com/file/d/1PRKGy6Roxi9Vb9-KQslJJWNSZWCoLs4f/preview","00:00"),
(5,27,"OOPS in 7 minutes","mp4","https://drive.google.com/file/d/11krMStfUwdzzjlwFxD423oyePiDri4Ms/preview","07:33"),
(6,27,"OOPS Concept","mp4","https://drive.google.com/file/d/1hiPRIKxrw6UazwqkaitUVeKggu6JOKva/preview","20:23"),
(7,27,"What is object oriented programming","mp4","https://drive.google.com/file/d/1hiPRIKxrw6UazwqkaitUVeKggu6JOKva/preview","07:29"),
(8,27,"Basics of OOPs","mp4","https://drive.google.com/file/d/1wcmZhSc0noMqk0XlhI3bbtTRQDu7_Qdk/preview","00:00"),
(9,27,"OOPs Reading Material","pdf","https://drive.google.com/file/d/1O5CiuulX3l3xLClDum0XnYG5c3GcoLYy/preview","00:00"),
(10,28,"Installing and Setting up Eclipse IDE","mp4","https://drive.google.com/file/d/1k1GT3B895aoEPAtNmgYqzzzDmBxst9p3/preview","15:02"),
(11,28,"Creating First Java Project","mp4","https://drive.google.com/file/d/1lqOtfkzFT0yHYNsoqRNSObmZcICjkAIX/preview","19:39"),
(12,29,"IF..Else In Java","mp4","https://drive.google.com/file/d/1ifXQB1g_8jJbO9X4hrPSAGMsdlNDiSNH/preview","08:34"),
(13,29,"Logical Operators","mp4","https://drive.google.com/file/d/1wH6N-4doZ716m28sZo1gXRMF1B8tMvZb/preview","07:27"),
(14,29,"The do-while statement","mp4","https://drive.google.com/file/d/1d4m3IyyZTOGN7yfwek2nVbNdW01k_p5A/preview","06:00"),
(15,29,"For Statement","mp4","https://drive.google.com/file/d/1YRvrub6wVhE1cPM7-Tt3jCVytT3uZjhs/preview","08:34"),
(16,29,"While Statement","mp4","https://drive.google.com/file/d/11kCtZlm_21h7PjRciMFvhpR7y_FVfOd3/preview","06:47"),
(17,30,"Conclusion","mp4","https://drive.google.com/file/d/1UT3VGIaKRSTgTo51FrMTc0lbb-D7_TCg/preview","03:04"),
(18,30,"Java Tutorial","pdf","https://drive.google.com/file/d/1Z5cfK-PSv7GnGqfbbj1yVLsD5A4k08WP/preview","00:00"),
(19,30,"Teach yourself Java in 21 days","pdf","https://drive.google.com/file/d/1VIPCmgaORfhghd62bXILlAdyU_Cc1Zoq/preview","00:00");


 INSERT INTO role VALUES(1,"Super Admin"),(2,"Learning Admin"),(3,"User");


insert into employees values
   (1001,"jithin","raj","jithin.r@experionglobal.com"),
   (1002,"robin","cheriyan mathew","robin.cm@experionglobal.com"),
   (1003,"vaishnav","l","vaishnav.l@experionglobal.com"),
   (1004,"rithika","jr","rithika.jr@experionglobal.com"),
   (1005,"drishya","t","drishya.t@experionglobal.com");























#
# In your Quartz properties file, you'll need to set
# org.quartz.jobStore.driverDelegateClass = org.quartz.impl.jdbcjobstore.StdJDBCDelegate
#
#
# By: Ron Cordell - roncordell
#  I didn't see this anywhere, so I thought I'd post it here. This is the script from Quartz to create the tables in a MySQL database, modified to use INNODB instead of MYISAM.

DROP TABLE IF EXISTS QRTZ_FIRED_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_PAUSED_TRIGGER_GRPS;
DROP TABLE IF EXISTS QRTZ_SCHEDULER_STATE;
DROP TABLE IF EXISTS QRTZ_LOCKS;
DROP TABLE IF EXISTS QRTZ_SIMPLE_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_SIMPROP_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_CRON_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_BLOB_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_JOB_DETAILS;
DROP TABLE IF EXISTS QRTZ_CALENDARS;

CREATE TABLE QRTZ_JOB_DETAILS(
SCHED_NAME VARCHAR(120) NOT NULL,
JOB_NAME VARCHAR(190) NOT NULL,
JOB_GROUP VARCHAR(190) NOT NULL,
DESCRIPTION VARCHAR(250) NULL,
JOB_CLASS_NAME VARCHAR(250) NOT NULL,
IS_DURABLE VARCHAR(1) NOT NULL,
IS_NONCONCURRENT VARCHAR(1) NOT NULL,
IS_UPDATE_DATA VARCHAR(1) NOT NULL,
REQUESTS_RECOVERY VARCHAR(1) NOT NULL,
JOB_DATA BLOB NULL,
PRIMARY KEY (SCHED_NAME,JOB_NAME,JOB_GROUP))
ENGINE=InnoDB;

CREATE TABLE QRTZ_TRIGGERS (
SCHED_NAME VARCHAR(120) NOT NULL,
TRIGGER_NAME VARCHAR(190) NOT NULL,
TRIGGER_GROUP VARCHAR(190) NOT NULL,
JOB_NAME VARCHAR(190) NOT NULL,
JOB_GROUP VARCHAR(190) NOT NULL,
DESCRIPTION VARCHAR(250) NULL,
NEXT_FIRE_TIME BIGINT(13) NULL,
PREV_FIRE_TIME BIGINT(13) NULL,
PRIORITY INTEGER NULL,
TRIGGER_STATE VARCHAR(16) NOT NULL,
TRIGGER_TYPE VARCHAR(8) NOT NULL,
START_TIME BIGINT(13) NOT NULL,
END_TIME BIGINT(13) NULL,
CALENDAR_NAME VARCHAR(190) NULL,
MISFIRE_INSTR SMALLINT(2) NULL,
JOB_DATA BLOB NULL,
PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
FOREIGN KEY (SCHED_NAME,JOB_NAME,JOB_GROUP)
REFERENCES QRTZ_JOB_DETAILS(SCHED_NAME,JOB_NAME,JOB_GROUP))
ENGINE=InnoDB;

CREATE TABLE QRTZ_SIMPLE_TRIGGERS (
SCHED_NAME VARCHAR(120) NOT NULL,
TRIGGER_NAME VARCHAR(190) NOT NULL,
TRIGGER_GROUP VARCHAR(190) NOT NULL,
REPEAT_COUNT BIGINT(7) NOT NULL,
REPEAT_INTERVAL BIGINT(12) NOT NULL,
TIMES_TRIGGERED BIGINT(10) NOT NULL,
PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP))
ENGINE=InnoDB;

CREATE TABLE QRTZ_CRON_TRIGGERS (
SCHED_NAME VARCHAR(120) NOT NULL,
TRIGGER_NAME VARCHAR(190) NOT NULL,
TRIGGER_GROUP VARCHAR(190) NOT NULL,
CRON_EXPRESSION VARCHAR(120) NOT NULL,
TIME_ZONE_ID VARCHAR(80),
PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP))
ENGINE=InnoDB;

CREATE TABLE QRTZ_SIMPROP_TRIGGERS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    TRIGGER_NAME VARCHAR(190) NOT NULL,
    TRIGGER_GROUP VARCHAR(190) NOT NULL,
    STR_PROP_1 VARCHAR(512) NULL,
    STR_PROP_2 VARCHAR(512) NULL,
    STR_PROP_3 VARCHAR(512) NULL,
    INT_PROP_1 INT NULL,
    INT_PROP_2 INT NULL,
    LONG_PROP_1 BIGINT NULL,
    LONG_PROP_2 BIGINT NULL,
    DEC_PROP_1 NUMERIC(13,4) NULL,
    DEC_PROP_2 NUMERIC(13,4) NULL,
    BOOL_PROP_1 VARCHAR(1) NULL,
    BOOL_PROP_2 VARCHAR(1) NULL,
    PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
    REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP))
ENGINE=InnoDB;

CREATE TABLE QRTZ_BLOB_TRIGGERS (
SCHED_NAME VARCHAR(120) NOT NULL,
TRIGGER_NAME VARCHAR(190) NOT NULL,
TRIGGER_GROUP VARCHAR(190) NOT NULL,
BLOB_DATA BLOB NULL,
PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
INDEX (SCHED_NAME,TRIGGER_NAME, TRIGGER_GROUP),
FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP))
ENGINE=InnoDB;

CREATE TABLE QRTZ_CALENDARS (
SCHED_NAME VARCHAR(120) NOT NULL,
CALENDAR_NAME VARCHAR(190) NOT NULL,
CALENDAR BLOB NOT NULL,
PRIMARY KEY (SCHED_NAME,CALENDAR_NAME))
ENGINE=InnoDB;

CREATE TABLE QRTZ_PAUSED_TRIGGER_GRPS (
SCHED_NAME VARCHAR(120) NOT NULL,
TRIGGER_GROUP VARCHAR(190) NOT NULL,
PRIMARY KEY (SCHED_NAME,TRIGGER_GROUP))
ENGINE=InnoDB;

CREATE TABLE QRTZ_FIRED_TRIGGERS (
SCHED_NAME VARCHAR(120) NOT NULL,
ENTRY_ID VARCHAR(95) NOT NULL,
TRIGGER_NAME VARCHAR(190) NOT NULL,
TRIGGER_GROUP VARCHAR(190) NOT NULL,
INSTANCE_NAME VARCHAR(190) NOT NULL,
FIRED_TIME BIGINT(13) NOT NULL,
SCHED_TIME BIGINT(13) NOT NULL,
PRIORITY INTEGER NOT NULL,
STATE VARCHAR(16) NOT NULL,
JOB_NAME VARCHAR(190) NULL,
JOB_GROUP VARCHAR(190) NULL,
IS_NONCONCURRENT VARCHAR(1) NULL,
REQUESTS_RECOVERY VARCHAR(1) NULL,
PRIMARY KEY (SCHED_NAME,ENTRY_ID))
ENGINE=InnoDB;

CREATE TABLE QRTZ_SCHEDULER_STATE (
SCHED_NAME VARCHAR(120) NOT NULL,
INSTANCE_NAME VARCHAR(190) NOT NULL,
LAST_CHECKIN_TIME BIGINT(13) NOT NULL,
CHECKIN_INTERVAL BIGINT(13) NOT NULL,
PRIMARY KEY (SCHED_NAME,INSTANCE_NAME))
ENGINE=InnoDB;

CREATE TABLE QRTZ_LOCKS (
SCHED_NAME VARCHAR(120) NOT NULL,
LOCK_NAME VARCHAR(40) NOT NULL,
PRIMARY KEY (SCHED_NAME,LOCK_NAME))
ENGINE=InnoDB;

CREATE INDEX IDX_QRTZ_J_REQ_RECOVERY ON QRTZ_JOB_DETAILS(SCHED_NAME,REQUESTS_RECOVERY);
CREATE INDEX IDX_QRTZ_J_GRP ON QRTZ_JOB_DETAILS(SCHED_NAME,JOB_GROUP);

CREATE INDEX IDX_QRTZ_T_J ON QRTZ_TRIGGERS(SCHED_NAME,JOB_NAME,JOB_GROUP);
CREATE INDEX IDX_QRTZ_T_JG ON QRTZ_TRIGGERS(SCHED_NAME,JOB_GROUP);
CREATE INDEX IDX_QRTZ_T_C ON QRTZ_TRIGGERS(SCHED_NAME,CALENDAR_NAME);
CREATE INDEX IDX_QRTZ_T_G ON QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_GROUP);
CREATE INDEX IDX_QRTZ_T_STATE ON QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_STATE);
CREATE INDEX IDX_QRTZ_T_N_STATE ON QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP,TRIGGER_STATE);
CREATE INDEX IDX_QRTZ_T_N_G_STATE ON QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_GROUP,TRIGGER_STATE);
CREATE INDEX IDX_QRTZ_T_NEXT_FIRE_TIME ON QRTZ_TRIGGERS(SCHED_NAME,NEXT_FIRE_TIME);
CREATE INDEX IDX_QRTZ_T_NFT_ST ON QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_STATE,NEXT_FIRE_TIME);
CREATE INDEX IDX_QRTZ_T_NFT_MISFIRE ON QRTZ_TRIGGERS(SCHED_NAME,MISFIRE_INSTR,NEXT_FIRE_TIME);
CREATE INDEX IDX_QRTZ_T_NFT_ST_MISFIRE ON QRTZ_TRIGGERS(SCHED_NAME,MISFIRE_INSTR,NEXT_FIRE_TIME,TRIGGER_STATE);
CREATE INDEX IDX_QRTZ_T_NFT_ST_MISFIRE_GRP ON QRTZ_TRIGGERS(SCHED_NAME,MISFIRE_INSTR,NEXT_FIRE_TIME,TRIGGER_GROUP,TRIGGER_STATE);

CREATE INDEX IDX_QRTZ_FT_TRIG_INST_NAME ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,INSTANCE_NAME);
CREATE INDEX IDX_QRTZ_FT_INST_JOB_REQ_RCVRY ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,INSTANCE_NAME,REQUESTS_RECOVERY);
CREATE INDEX IDX_QRTZ_FT_J_G ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,JOB_NAME,JOB_GROUP);
CREATE INDEX IDX_QRTZ_FT_JG ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,JOB_GROUP);
CREATE INDEX IDX_QRTZ_FT_T_G ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP);
CREATE INDEX IDX_QRTZ_FT_TG ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,TRIGGER_GROUP);

commit;

















