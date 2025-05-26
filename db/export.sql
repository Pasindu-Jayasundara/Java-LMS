-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.37 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.7.0.6850
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for java_lms
CREATE DATABASE IF NOT EXISTS `java_lms` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `java_lms`;

-- Dumping structure for table java_lms.admin
CREATE TABLE IF NOT EXISTS `admin` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `contact_number` varchar(10) DEFAULT NULL,
  `status_status_id` int NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `fk_admin_status1_idx` (`status_status_id`),
  CONSTRAINT `fk_admin_status1` FOREIGN KEY (`status_status_id`) REFERENCES `status` (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.admin: ~1 rows (approximately)
INSERT INTO `admin` (`user_id`, `username`, `password`, `email`, `contact_number`, `status_status_id`) VALUES
	(1, 'admin', '12456789', 'a@gmail.com', '0740211671', 1);

-- Dumping structure for table java_lms.attendance
CREATE TABLE IF NOT EXISTS `attendance` (
  `id` int NOT NULL AUTO_INCREMENT,
  `timetable_timetable_id` int NOT NULL,
  `student_user_id` int NOT NULL,
  `attendance_status_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_attendance_timetable1_idx` (`timetable_timetable_id`),
  KEY `fk_attendance_student1_idx` (`student_user_id`),
  KEY `fk_attendance_attendance_status1_idx` (`attendance_status_id`),
  CONSTRAINT `fk_attendance_attendance_status1` FOREIGN KEY (`attendance_status_id`) REFERENCES `attendance_status` (`id`),
  CONSTRAINT `fk_attendance_student1` FOREIGN KEY (`student_user_id`) REFERENCES `student` (`user_id`),
  CONSTRAINT `fk_attendance_timetable1` FOREIGN KEY (`timetable_timetable_id`) REFERENCES `timetable` (`timetable_id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.attendance: ~44 rows (approximately)
INSERT INTO `attendance` (`id`, `timetable_timetable_id`, `student_user_id`, `attendance_status_id`) VALUES
	(1, 3, 1, 1),
	(2, 3, 2, 2),
	(3, 3, 3, 1),
	(4, 3, 4, 1),
	(5, 3, 5, 1),
	(6, 3, 6, 2),
	(7, 3, 7, 1),
	(8, 3, 8, 1),
	(9, 3, 9, 2),
	(10, 3, 10, 1),
	(11, 3, 11, 1),
	(12, 3, 12, 2),
	(13, 3, 13, 1),
	(14, 3, 14, 1),
	(15, 3, 15, 1),
	(16, 3, 16, 2),
	(17, 3, 17, 1),
	(18, 3, 18, 1),
	(19, 3, 19, 1),
	(20, 3, 20, 1),
	(21, 3, 21, 2),
	(22, 3, 22, 1),
	(23, 4, 1, 1),
	(24, 4, 2, 1),
	(25, 4, 3, 2),
	(26, 4, 4, 1),
	(27, 4, 5, 1),
	(28, 4, 6, 1),
	(29, 4, 7, 2),
	(30, 4, 8, 1),
	(31, 4, 9, 1),
	(32, 4, 10, 2),
	(33, 4, 11, 1),
	(34, 4, 12, 1),
	(35, 4, 13, 2),
	(36, 4, 14, 1),
	(37, 4, 15, 1),
	(38, 4, 16, 1),
	(39, 4, 17, 2),
	(40, 4, 18, 1),
	(41, 4, 19, 1),
	(42, 4, 20, 2),
	(43, 4, 21, 1),
	(44, 4, 22, 1);

-- Dumping structure for table java_lms.attendance_status
CREATE TABLE IF NOT EXISTS `attendance_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `status` varchar(30) DEFAULT NULL COMMENT '1=> attended\n0=> not attended',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.attendance_status: ~2 rows (approximately)
INSERT INTO `attendance_status` (`id`, `status`) VALUES
	(1, 'Attended'),
	(2, 'Not-Attended');

-- Dumping structure for table java_lms.course
CREATE TABLE IF NOT EXISTS `course` (
  `course_id` int NOT NULL AUTO_INCREMENT,
  `course` varchar(60) DEFAULT NULL,
  `credit` int DEFAULT NULL,
  `department_has_undergraduate_level_id` int NOT NULL,
  `course_code` varchar(45) NOT NULL,
  `course_hours` double DEFAULT NULL,
  `lecturer_user_id` int NOT NULL,
  `total_quiz` int DEFAULT NULL,
  `total_assessment` int DEFAULT NULL,
  `ca_use_quiz_count` int DEFAULT NULL,
  `ca_use_assessment_count` int DEFAULT NULL,
  `quiz_marks_percentage` double DEFAULT NULL,
  `assessment_marks_percentage` double DEFAULT NULL,
  `mid_marks_percentage` double DEFAULT NULL,
  `final_theory_marks_percentage` double DEFAULT NULL,
  `final_practical_marks_percentage` double DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  UNIQUE KEY `course_code_UNIQUE` (`course_code`),
  KEY `fk_course_department_has_undergraduate_level1_idx` (`department_has_undergraduate_level_id`),
  KEY `fk_course_lecturer1_idx` (`lecturer_user_id`),
  CONSTRAINT `fk_course_department_has_undergraduate_level1` FOREIGN KEY (`department_has_undergraduate_level_id`) REFERENCES `department_has_undergraduate_level` (`id`),
  CONSTRAINT `fk_course_lecturer1` FOREIGN KEY (`lecturer_user_id`) REFERENCES `lecturer` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.course: ~5 rows (approximately)
INSERT INTO `course` (`course_id`, `course`, `credit`, `department_has_undergraduate_level_id`, `course_code`, `course_hours`, `lecturer_user_id`, `total_quiz`, `total_assessment`, `ca_use_quiz_count`, `ca_use_assessment_count`, `quiz_marks_percentage`, `assessment_marks_percentage`, `mid_marks_percentage`, `final_theory_marks_percentage`, `final_practical_marks_percentage`) VALUES
	(6, 'Data Structures and Algorithm', 3, 26, 'ict2113', 10, 1, 5, 5, 3, 4, 5, 5, 20, 30, 40),
	(7, 'Object Oriented Programming', 2, 27, 'ict2122', 14, 1, 5, 4, 3, 2, 5, 5, 20, 30, 40),
	(8, 'Server Side Web Development', 3, 28, 'ict2133', 15, 1, 5, 4, 2, 3, 5, 5, 20, 30, 40),
	(9, 'Object Oriented Practical', 2, 29, 'ict2142', 20, 1, 5, 5, 3, 4, 5, 5, 20, 30, 40),
	(10, 'E commerce', 3, 30, 'ict2152', 14, 1, 5, 4, 3, 4, 5, 5, 20, 30, 40),
	(11, 'Intro to Programming', 3, 1, 'ICT101', 10, 1, 3, 2, 2, 2, 10, 10, 30, 30, 20),
	(12, 'Math for IT', 3, 2, 'ICT102', 10, 1, 3, 2, 2, 2, 10, 10, 30, 30, 20),
	(13, 'Computer Architecture', 3, 3, 'ICT103', 10, 1, 3, 2, 2, 2, 10, 10, 30, 30, 20),
	(14, 'Web Technologies', 3, 4, 'ICT104', 10, 1, 3, 2, 2, 2, 10, 10, 30, 30, 20),
	(15, 'Networking Fundamentals', 3, 5, 'ICT105', 10, 1, 3, 2, 2, 2, 10, 10, 30, 30, 20),
	(16, 'Operating Systems', 3, 6, 'ICT106', 10, 1, 3, 2, 2, 2, 10, 10, 30, 30, 20),
	(17, 'Database Systems', 3, 7, 'ICT107', 10, 1, 3, 2, 2, 2, 10, 10, 30, 30, 20),
	(18, 'Data Structures', 3, 8, 'ICT108', 10, 1, 3, 2, 2, 2, 10, 10, 30, 30, 20),
	(19, 'OOP in Java', 3, 9, 'ICT109', 10, 1, 3, 2, 2, 2, 10, 10, 30, 30, 20),
	(20, 'Mobile App Dev', 3, 10, 'ICT110', 10, 1, 3, 2, 2, 2, 10, 10, 30, 30, 20),
	(21, 'Software Engineering', 3, 11, 'ICT111', 10, 1, 3, 2, 2, 2, 10, 10, 30, 30, 20),
	(22, 'IT Project Mgmt', 3, 12, 'ICT112', 10, 1, 3, 2, 2, 2, 10, 10, 30, 30, 20),
	(23, 'Computer Security', 3, 13, 'ICT113', 10, 1, 3, 2, 2, 2, 10, 10, 30, 30, 20),
	(24, 'AI Basics', 3, 14, 'ICT114', 10, 1, 3, 2, 2, 2, 10, 10, 30, 30, 20),
	(25, 'Machine Learning', 3, 15, 'ICT115', 10, 1, 3, 2, 2, 2, 10, 10, 30, 30, 20),
	(26, 'Cloud Computing', 3, 16, 'ICT116', 10, 1, 3, 2, 2, 2, 10, 10, 30, 30, 20),
	(27, 'Big Data', 3, 17, 'ICT117', 10, 1, 3, 2, 2, 2, 10, 10, 30, 30, 20),
	(28, 'DevOps', 3, 18, 'ICT118', 10, 1, 3, 2, 2, 2, 10, 10, 30, 30, 20),
	(29, 'UI/UX Design', 3, 19, 'ICT119', 10, 1, 3, 2, 2, 2, 10, 10, 30, 30, 20),
	(30, 'Business IT', 3, 20, 'ICT120', 10, 1, 3, 2, 2, 2, 10, 10, 30, 30, 20),
	(31, 'Ethics in Tech', 3, 21, 'ICT121', 10, 1, 3, 2, 2, 2, 10, 10, 30, 30, 20),
	(32, 'Capstone Project', 3, 22, 'ICT122', 10, 1, 3, 2, 2, 2, 10, 10, 30, 30, 20);

-- Dumping structure for table java_lms.department
CREATE TABLE IF NOT EXISTS `department` (
  `department_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.department: ~3 rows (approximately)
INSERT INTO `department` (`department_id`, `name`) VALUES
	(1, 'ICT'),
	(2, 'ET'),
	(3, 'BST');

-- Dumping structure for table java_lms.department_has_undergraduate_level
CREATE TABLE IF NOT EXISTS `department_has_undergraduate_level` (
  `department_department_id` int NOT NULL,
  `undergraduate_level_level_id` int NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `semester_semester_id` int NOT NULL,
  `status_status_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_department_has_undergraduate_level_undergraduate_level1_idx` (`undergraduate_level_level_id`),
  KEY `fk_department_has_undergraduate_level_department1_idx` (`department_department_id`),
  KEY `fk_department_has_undergraduate_level_semester1_idx` (`semester_semester_id`),
  KEY `fk_department_has_undergraduate_level_status1_idx` (`status_status_id`),
  CONSTRAINT `fk_department_has_undergraduate_level_department1` FOREIGN KEY (`department_department_id`) REFERENCES `department` (`department_id`),
  CONSTRAINT `fk_department_has_undergraduate_level_semester1` FOREIGN KEY (`semester_semester_id`) REFERENCES `semester` (`semester_id`),
  CONSTRAINT `fk_department_has_undergraduate_level_status1` FOREIGN KEY (`status_status_id`) REFERENCES `status` (`status_id`),
  CONSTRAINT `fk_department_has_undergraduate_level_undergraduate_level1` FOREIGN KEY (`undergraduate_level_level_id`) REFERENCES `undergraduate_level` (`level_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.department_has_undergraduate_level: ~30 rows (approximately)
INSERT INTO `department_has_undergraduate_level` (`department_department_id`, `undergraduate_level_level_id`, `id`, `semester_semester_id`, `status_status_id`) VALUES
	(1, 1, 1, 1, 1),
	(1, 1, 2, 2, 1),
	(1, 2, 3, 1, 1),
	(1, 2, 4, 2, 1),
	(1, 3, 5, 1, 1),
	(1, 3, 6, 2, 1),
	(1, 4, 7, 1, 1),
	(1, 4, 8, 2, 1),
	(2, 1, 9, 1, 1),
	(2, 1, 10, 2, 1),
	(2, 2, 11, 1, 1),
	(2, 2, 12, 2, 1),
	(2, 3, 13, 1, 1),
	(2, 3, 14, 2, 1),
	(2, 4, 15, 1, 1),
	(2, 4, 16, 2, 1),
	(3, 1, 17, 1, 1),
	(3, 1, 18, 2, 1),
	(3, 2, 19, 1, 1),
	(3, 2, 20, 2, 1),
	(3, 3, 21, 1, 1),
	(3, 3, 22, 2, 1),
	(3, 4, 23, 1, 1),
	(3, 4, 24, 2, 1),
	(1, 1, 25, 1, 1),
	(1, 1, 26, 1, 1),
	(1, 1, 27, 1, 1),
	(1, 1, 28, 1, 1),
	(1, 1, 29, 1, 1),
	(1, 1, 30, 1, 1);

-- Dumping structure for table java_lms.exam
CREATE TABLE IF NOT EXISTS `exam` (
  `exam_id` int NOT NULL AUTO_INCREMENT,
  `date_time` datetime NOT NULL,
  `venue` varchar(45) DEFAULT NULL,
  `description` text,
  `department_has_undergraduate_level_id` int NOT NULL,
  `exam_type_type_id` int NOT NULL,
  `course_course_id` int NOT NULL,
  PRIMARY KEY (`exam_id`),
  KEY `fk_exam_department_has_undergraduate_level1_idx` (`department_has_undergraduate_level_id`),
  KEY `fk_exam_exam_type1_idx` (`exam_type_type_id`),
  KEY `fk_exam_course1_idx` (`course_course_id`),
  CONSTRAINT `fk_exam_course1` FOREIGN KEY (`course_course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `fk_exam_department_has_undergraduate_level1` FOREIGN KEY (`department_has_undergraduate_level_id`) REFERENCES `department_has_undergraduate_level` (`id`),
  CONSTRAINT `fk_exam_exam_type1` FOREIGN KEY (`exam_type_type_id`) REFERENCES `exam_type` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.exam: ~20 rows (approximately)
INSERT INTO `exam` (`exam_id`, `date_time`, `venue`, `description`, `department_has_undergraduate_level_id`, `exam_type_type_id`, `course_course_id`) VALUES
	(1, '2025-05-01 09:00:00', 'Hall A', 'Quiz - DSA', 1, 1, 6),
	(2, '2025-05-02 09:00:00', 'Hall A', 'Assessment - DSA', 1, 2, 6),
	(3, '2025-05-03 09:00:00', 'Hall A', 'Mid - DSA', 1, 3, 6),
	(4, '2025-05-04 09:00:00', 'Hall A', 'Final - DSA', 1, 4, 6),
	(5, '2025-05-05 09:00:00', 'Hall B', 'Quiz - OOP', 1, 1, 7),
	(6, '2025-05-06 09:00:00', 'Hall B', 'Assessment - OOP', 1, 2, 7),
	(7, '2025-05-07 09:00:00', 'Hall B', 'Mid - OOP', 1, 3, 7),
	(8, '2025-05-08 09:00:00', 'Hall B', 'Final - OOP', 1, 4, 7),
	(9, '2025-05-09 09:00:00', 'Hall C', 'Quiz - Server Side', 1, 1, 8),
	(10, '2025-05-10 09:00:00', 'Hall C', 'Assessment - Server Side', 1, 2, 8),
	(11, '2025-05-11 09:00:00', 'Hall C', 'Mid - Server Side', 1, 3, 8),
	(12, '2025-05-12 09:00:00', 'Hall C', 'Final - Server Side', 1, 4, 8),
	(13, '2025-05-13 09:00:00', 'Hall D', 'Quiz - OOP Practical', 1, 1, 9),
	(14, '2025-05-14 09:00:00', 'Hall D', 'Assessment - OOP Practical', 1, 2, 9),
	(15, '2025-05-15 09:00:00', 'Hall D', 'Mid - OOP Practical', 1, 3, 9),
	(16, '2025-05-16 09:00:00', 'Hall D', 'Final - OOP Practical', 1, 4, 9),
	(17, '2025-05-17 09:00:00', 'Hall E', 'Quiz - E-commerce', 1, 1, 10),
	(18, '2025-05-18 09:00:00', 'Hall E', 'Assessment - E-commerce', 1, 2, 10),
	(19, '2025-05-19 09:00:00', 'Hall E', 'Mid - E-commerce', 1, 3, 10),
	(20, '2025-05-20 09:00:00', 'Hall E', 'Final - E-commerce', 1, 4, 10);

-- Dumping structure for table java_lms.exam_type
CREATE TABLE IF NOT EXISTS `exam_type` (
  `type_id` int NOT NULL AUTO_INCREMENT,
  `exam_type` varchar(45) DEFAULT NULL COMMENT '1=> quizes\n2=> assesment\n3=> mid\n4=> final',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.exam_type: ~4 rows (approximately)
INSERT INTO `exam_type` (`type_id`, `exam_type`) VALUES
	(1, 'Quiz'),
	(2, 'Assessment'),
	(3, 'Mid'),
	(4, 'Final');

-- Dumping structure for table java_lms.lecturer
CREATE TABLE IF NOT EXISTS `lecturer` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `contact_number` varchar(10) DEFAULT NULL,
  `status_status_id` int NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `fk_lecturer_status1_idx` (`status_status_id`),
  CONSTRAINT `fk_lecturer_status1` FOREIGN KEY (`status_status_id`) REFERENCES `status` (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.lecturer: ~5 rows (approximately)
INSERT INTO `lecturer` (`user_id`, `username`, `password`, `email`, `contact_number`, `status_status_id`) VALUES
	(1, 'Pasindu', 'Pasindu328@', 'p@gmail.com', '0740211671', 1),
	(2, 'Kamal', 'Kamal@23f', 'k@gmail.com', '0740211456', 1),
	(3, 'Nimal', 'Nimal@3f3', 'n@gmal.com', '0717955879', 1),
	(4, 'Danush', 'D@123shf', 'd@gmail.com', '0713302456', 1),
	(5, 'Kalid', 'kK@12123f', 'l@gmail.com', '0740211671', 1);

-- Dumping structure for table java_lms.marks
CREATE TABLE IF NOT EXISTS `marks` (
  `student_user_id` int NOT NULL,
  `exam_exam_id` int NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `marks` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_student_has_exam_exam1_idx` (`exam_exam_id`),
  KEY `fk_student_has_exam_student1_idx` (`student_user_id`),
  CONSTRAINT `fk_student_has_exam_exam1` FOREIGN KEY (`exam_exam_id`) REFERENCES `exam` (`exam_id`),
  CONSTRAINT `fk_student_has_exam_student1` FOREIGN KEY (`student_user_id`) REFERENCES `student` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.marks: ~22 rows (approximately)
INSERT INTO `marks` (`student_user_id`, `exam_exam_id`, `id`, `marks`) VALUES
	(1, 3, 23, '78'),
	(2, 3, 24, '85'),
	(3, 3, 25, '66'),
	(4, 3, 26, '90'),
	(5, 3, 27, '74'),
	(6, 3, 28, '81'),
	(7, 3, 29, '68'),
	(8, 3, 30, '77'),
	(9, 3, 31, '83'),
	(10, 3, 32, '91'),
	(11, 3, 33, '69'),
	(12, 3, 34, '75'),
	(13, 3, 35, '88'),
	(14, 3, 36, '70'),
	(15, 3, 37, '79'),
	(16, 3, 38, '84'),
	(17, 3, 39, '67'),
	(18, 3, 40, '76'),
	(19, 3, 41, '73'),
	(20, 3, 42, '80'),
	(21, 3, 43, '86'),
	(22, 3, 44, '82');

-- Dumping structure for table java_lms.marks_document
CREATE TABLE IF NOT EXISTS `marks_document` (
  `id` int NOT NULL AUTO_INCREMENT,
  `url` text NOT NULL,
  `file_name` varchar(45) NOT NULL,
  `exam_exam_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_marks_document_exam1_idx` (`exam_exam_id`),
  CONSTRAINT `fk_marks_document_exam1` FOREIGN KEY (`exam_exam_id`) REFERENCES `exam` (`exam_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.marks_document: ~0 rows (approximately)

-- Dumping structure for table java_lms.material
CREATE TABLE IF NOT EXISTS `material` (
  `material_id` int NOT NULL AUTO_INCREMENT,
  `datetime` datetime NOT NULL,
  `url` text NOT NULL,
  `course_course_id` int NOT NULL,
  `type_type_id` int NOT NULL,
  `name` text NOT NULL,
  PRIMARY KEY (`material_id`),
  KEY `fk_material_course1_idx` (`course_course_id`),
  KEY `fk_material_type1_idx` (`type_type_id`),
  CONSTRAINT `fk_material_course1` FOREIGN KEY (`course_course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `fk_material_type1` FOREIGN KEY (`type_type_id`) REFERENCES `type` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.material: ~0 rows (approximately)

-- Dumping structure for table java_lms.medical_record
CREATE TABLE IF NOT EXISTS `medical_record` (
  `record_id` int NOT NULL AUTO_INCREMENT,
  `description` text,
  `date` datetime DEFAULT NULL,
  `student_user_id` int NOT NULL,
  `status_status_id` int NOT NULL,
  `url` text,
  PRIMARY KEY (`record_id`),
  KEY `fk_medical_record_student1_idx` (`student_user_id`),
  KEY `fk_medical_record_status1_idx` (`status_status_id`),
  CONSTRAINT `fk_medical_record_status1` FOREIGN KEY (`status_status_id`) REFERENCES `status` (`status_id`),
  CONSTRAINT `fk_medical_record_student1` FOREIGN KEY (`student_user_id`) REFERENCES `student` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.medical_record: ~0 rows (approximately)

-- Dumping structure for table java_lms.notice
CREATE TABLE IF NOT EXISTS `notice` (
  `notice_id` int NOT NULL AUTO_INCREMENT,
  `post_date` datetime DEFAULT NULL,
  `content` text,
  `title` varchar(60) DEFAULT NULL,
  `status_status_id` int NOT NULL,
  `admin_user_id` int NOT NULL,
  PRIMARY KEY (`notice_id`),
  KEY `fk_notice_status1_idx` (`status_status_id`),
  KEY `fk_notice_admin1_idx` (`admin_user_id`),
  CONSTRAINT `fk_notice_admin1` FOREIGN KEY (`admin_user_id`) REFERENCES `admin` (`user_id`),
  CONSTRAINT `fk_notice_status1` FOREIGN KEY (`status_status_id`) REFERENCES `status` (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.notice: ~5 rows (approximately)
INSERT INTO `notice` (`notice_id`, `post_date`, `content`, `title`, `status_status_id`, `admin_user_id`) VALUES
	(1, '2025-05-01 10:00:00', 'Midterm exams will commence from May 15. Please check the timetable section.', 'Midterm Exam Notification', 1, 1),
	(2, '2025-05-03 14:00:00', 'Server maintenance is scheduled on May 7 from 1 AM to 3 AM. Access to the system may be limited.', 'Scheduled Maintenance Notice', 1, 1),
	(3, '2025-05-05 09:30:00', 'All students are required to submit their assessments by May 10.', 'Assessment Submission Deadline', 1, 1),
	(4, '2025-05-07 11:00:00', 'New learning materials have been uploaded for Object Oriented Programming.', 'New Materials Uploaded', 1, 1),
	(5, '2025-05-10 16:00:00', 'Final exam dates have been updated. Please review the revised exam schedule.', 'Final Exam Date Changes', 1, 1);

-- Dumping structure for table java_lms.semester
CREATE TABLE IF NOT EXISTS `semester` (
  `semester_id` int NOT NULL AUTO_INCREMENT,
  `semester` int DEFAULT NULL,
  PRIMARY KEY (`semester_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.semester: ~2 rows (approximately)
INSERT INTO `semester` (`semester_id`, `semester`) VALUES
	(1, 1),
	(2, 2);

-- Dumping structure for table java_lms.status
CREATE TABLE IF NOT EXISTS `status` (
  `status_id` int NOT NULL AUTO_INCREMENT,
  `status` varchar(35) DEFAULT NULL COMMENT '1=> acitive\n0=> deactive\n2 => medical accespted\n3 => medical rejected',
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.status: ~4 rows (approximately)
INSERT INTO `status` (`status_id`, `status`) VALUES
	(1, 'Active'),
	(2, 'Medical Accepted'),
	(3, 'Medical Rejected'),
	(4, 'Deactive');

-- Dumping structure for table java_lms.student
CREATE TABLE IF NOT EXISTS `student` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `contact_number` varchar(10) DEFAULT NULL,
  `enrollment_date` datetime DEFAULT NULL,
  `profile_picture` text,
  `status_status_id` int NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `fk_student_status_idx` (`status_status_id`),
  CONSTRAINT `fk_student_status` FOREIGN KEY (`status_status_id`) REFERENCES `status` (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.student: ~22 rows (approximately)
INSERT INTO `student` (`user_id`, `username`, `password`, `email`, `contact_number`, `enrollment_date`, `profile_picture`, `status_status_id`) VALUES
	(1, 'Ameera', '12345678', 's@gmail.com', '0740211671', '2025-04-21 11:25:00', NULL, 1),
	(2, 'Sandaruwan', '12345678', 's2@gmail.com', '0740211672', '2025-04-21 11:25:00', NULL, 1),
	(3, 'john_doe', 'password123', 'johndoe@example.com', '0711234567', '2023-01-15 00:00:00', NULL, 1),
	(4, 'jane_smith', 'password123', 'janesmith@example.com', '0722345678', '2023-01-16 00:00:00', NULL, 1),
	(5, 'mike_jones', 'password123', 'mikejones@example.com', '0733456789', '2023-01-17 00:00:00', NULL, 1),
	(6, 'emily_brown', 'password123', 'emilybrown@example.com', '0744567890', '2023-01-18 00:00:00', NULL, 1),
	(7, 'chris_davis', 'password123', 'chrisdavis@example.com', '0755678901', '2023-01-19 00:00:00', NULL, 1),
	(8, 'sarah_wilson', 'password123', 'sarahwilson@example.com', '0766789012', '2023-01-20 00:00:00', NULL, 1),
	(9, 'david_miller', 'password123', 'davidmiller@example.com', '0777890123', '2023-01-21 00:00:00', NULL, 1),
	(10, 'laura_moore', 'password123', 'lauramoore@example.com', '0788901234', '2023-01-22 00:00:00', NULL, 1),
	(11, 'james_taylor', 'password123', 'jamestaylor@example.com', '0799012345', '2023-01-23 00:00:00', NULL, 1),
	(12, 'linda_jackson', 'password123', 'lindajackson@example.com', '0700123456', '2023-01-24 00:00:00', NULL, 1),
	(13, 'robert_white', 'password123', 'robertwhite@example.com', '0711234568', '2023-01-25 00:00:00', NULL, 1),
	(14, 'patricia_harris', 'password123', 'patriciaharris@example.com', '0722345679', '2023-01-26 00:00:00', NULL, 1),
	(15, 'charles_thompson', 'password123', 'charlesthompson@example.com', '0733456790', '2023-01-27 00:00:00', NULL, 1),
	(16, 'jessica_garcia', 'password123', 'jessicagarcia@example.com', '0744567901', '2023-01-28 00:00:00', NULL, 1),
	(17, 'daniel_martinez', 'password123', 'danielmartinez@example.com', '0755678912', '2023-01-29 00:00:00', NULL, 1),
	(18, 'susan_robinson', 'password123', 'susanrobinson@example.com', '0766789023', '2023-01-30 00:00:00', NULL, 1),
	(19, 'matthew_clark', 'password123', 'matthewclark@example.com', '0777890134', '2023-01-31 00:00:00', NULL, 1),
	(20, 'karen_lewis', 'password123', 'karenlewis@example.com', '0788901245', '2023-02-01 00:00:00', NULL, 1),
	(21, 'steven_walker', 'password123', 'stevenwalker@example.com', '0799012356', '2023-02-02 00:00:00', NULL, 1),
	(22, 'nancy_hall', 'password123', 'nancyhall@example.com', '0700123467', '2023-02-03 00:00:00', NULL, 1);

-- Dumping structure for table java_lms.student_has_department_has_undergraduate_level
CREATE TABLE IF NOT EXISTS `student_has_department_has_undergraduate_level` (
  `student_user_id` int NOT NULL,
  `department_has_undergraduate_level_id` int NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_student_has_department_has_undergraduate_level_departmen_idx` (`department_has_undergraduate_level_id`),
  KEY `fk_student_has_department_has_undergraduate_level_student1_idx` (`student_user_id`),
  CONSTRAINT `fk_student_has_department_has_undergraduate_level_department_1` FOREIGN KEY (`department_has_undergraduate_level_id`) REFERENCES `department_has_undergraduate_level` (`id`),
  CONSTRAINT `fk_student_has_department_has_undergraduate_level_student1` FOREIGN KEY (`student_user_id`) REFERENCES `student` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.student_has_department_has_undergraduate_level: ~22 rows (approximately)
INSERT INTO `student_has_department_has_undergraduate_level` (`student_user_id`, `department_has_undergraduate_level_id`, `id`) VALUES
	(1, 1, 1),
	(2, 2, 2),
	(3, 1, 3),
	(4, 1, 4),
	(5, 1, 5),
	(6, 1, 6),
	(7, 1, 7),
	(8, 1, 8),
	(9, 1, 9),
	(10, 1, 10),
	(11, 1, 11),
	(12, 1, 12),
	(13, 1, 13),
	(14, 1, 14),
	(15, 1, 15),
	(16, 1, 16),
	(17, 1, 17),
	(18, 1, 18),
	(19, 1, 19),
	(20, 1, 20),
	(21, 1, 21),
	(22, 1, 22);

-- Dumping structure for table java_lms.technical_officer
CREATE TABLE IF NOT EXISTS `technical_officer` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `contact_number` varchar(10) DEFAULT NULL,
  `status_status_id` int NOT NULL,
  `department_department_id` int NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `fk_technical_officer_status1_idx` (`status_status_id`),
  KEY `fk_technical_officer_department1_idx` (`department_department_id`),
  CONSTRAINT `fk_technical_officer_department1` FOREIGN KEY (`department_department_id`) REFERENCES `department` (`department_id`),
  CONSTRAINT `fk_technical_officer_status1` FOREIGN KEY (`status_status_id`) REFERENCES `status` (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.technical_officer: ~4 rows (approximately)
INSERT INTO `technical_officer` (`user_id`, `username`, `password`, `email`, `contact_number`, `status_status_id`, `department_department_id`) VALUES
	(1, 'Kamal', 'P@123sdwf', 'P@gmail.com', '0740211452', 1, 1),
	(2, 'Sandun', 'S@123def', 's@gmail.com', '0740256542', 1, 1),
	(3, 'Rahul', 'R@12345wd', 'r@gmail.com', '0714566324', 1, 1),
	(4, 'Darshan', 'D@sgh345', 'd@gmail.com', '0713324567', 1, 1);

-- Dumping structure for table java_lms.timetable
CREATE TABLE IF NOT EXISTS `timetable` (
  `timetable_id` int NOT NULL AUTO_INCREMENT,
  `day` varchar(10) DEFAULT NULL,
  `from` time DEFAULT NULL,
  `to` time DEFAULT NULL,
  `course_course_id` int NOT NULL,
  PRIMARY KEY (`timetable_id`),
  KEY `fk_timetable_course1_idx` (`course_course_id`),
  CONSTRAINT `fk_timetable_course1` FOREIGN KEY (`course_course_id`) REFERENCES `course` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.timetable: ~5 rows (approximately)
INSERT INTO `timetable` (`timetable_id`, `day`, `from`, `to`, `course_course_id`) VALUES
	(3, 'Monday', '08:01:00', '12:00:00', 6),
	(4, 'Tuesday', '08:00:00', '13:01:00', 7),
	(5, 'Wednesday', '08:30:00', '12:29:00', 8),
	(6, 'Thursday', '10:00:00', '14:30:00', 9),
	(7, 'Friday', '09:59:00', '12:30:00', 10);

-- Dumping structure for table java_lms.type
CREATE TABLE IF NOT EXISTS `type` (
  `type_id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.type: ~1 rows (approximately)
INSERT INTO `type` (`type_id`, `type`) VALUES
	(1, 'PDF');

-- Dumping structure for table java_lms.undergraduate_level
CREATE TABLE IF NOT EXISTS `undergraduate_level` (
  `level_id` int NOT NULL AUTO_INCREMENT,
  `level` int DEFAULT NULL,
  PRIMARY KEY (`level_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.undergraduate_level: ~4 rows (approximately)
INSERT INTO `undergraduate_level` (`level_id`, `level`) VALUES
	(1, 1),
	(2, 2),
	(3, 3),
	(4, 4);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
