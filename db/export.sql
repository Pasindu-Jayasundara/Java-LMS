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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.attendance: ~0 rows (approximately)

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.course: ~0 rows (approximately)
INSERT INTO `course` (`course_id`, `course`, `credit`, `department_has_undergraduate_level_id`, `course_code`, `course_hours`, `lecturer_user_id`, `total_quiz`, `total_assessment`, `ca_use_quiz_count`, `ca_use_assessment_count`, `quiz_marks_percentage`, `assessment_marks_percentage`, `mid_marks_percentage`, `final_theory_marks_percentage`, `final_practical_marks_percentage`) VALUES
	(1, 'Course 1', 12, 3, '11245', 10, 1, 4, 4, 3, 2, 5, 5, 20, 50, 0),
	(2, 'Course 2', 5, 4, '1124', 10, 1, 4, 4, 3, 2, 5, 5, 20, 50, 0),
	(3, 'Course 3', 128, 5, '1111', 8, 1, 6, 4, 6, 2, 5, 5, 20, 50, 0),
	(4, 'Cou4 ', 12, 6, '114565', 40, 1, 4, 4, 4, 2, 5, 5, 20, 50, 0);

-- Dumping structure for table java_lms.department
CREATE TABLE IF NOT EXISTS `department` (
  `department_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.department: ~0 rows (approximately)
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.department_has_undergraduate_level: ~0 rows (approximately)
INSERT INTO `department_has_undergraduate_level` (`department_department_id`, `undergraduate_level_level_id`, `id`, `semester_semester_id`, `status_status_id`) VALUES
	(1, 1, 1, 1, 1),
	(1, 1, 2, 1, 1),
	(1, 1, 3, 1, 1),
	(1, 1, 4, 1, 1),
	(1, 1, 5, 1, 1),
	(1, 1, 6, 1, 1);

-- Dumping structure for table java_lms.exam
CREATE TABLE IF NOT EXISTS `exam` (
  `exam_id` int NOT NULL AUTO_INCREMENT,
  `date_time` datetime NOT NULL,
  `venue` varchar(45) DEFAULT NULL,
  `description` text,
  `department_has_undergraduate_level_id` int NOT NULL,
  `exam_type_type_id` int NOT NULL,
  PRIMARY KEY (`exam_id`),
  KEY `fk_exam_department_has_undergraduate_level1_idx` (`department_has_undergraduate_level_id`),
  KEY `fk_exam_exam_type1_idx` (`exam_type_type_id`),
  CONSTRAINT `fk_exam_department_has_undergraduate_level1` FOREIGN KEY (`department_has_undergraduate_level_id`) REFERENCES `department_has_undergraduate_level` (`id`),
  CONSTRAINT `fk_exam_exam_type1` FOREIGN KEY (`exam_type_type_id`) REFERENCES `exam_type` (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.exam: ~0 rows (approximately)

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.lecturer: ~0 rows (approximately)
INSERT INTO `lecturer` (`user_id`, `username`, `password`, `email`, `contact_number`, `status_status_id`) VALUES
	(1, 'Pasindu', 'Pasindu328@', 'p@gmail.com', '0740211671', 1);

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.marks: ~0 rows (approximately)

-- Dumping structure for table java_lms.marks_document
CREATE TABLE IF NOT EXISTS `marks_document` (
  `id` int NOT NULL AUTO_INCREMENT,
  `url` text NOT NULL,
  `file_name` varchar(45) DEFAULT NULL,
  `exam_exam_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `file_name_UNIQUE` (`file_name`),
  KEY `fk_marks_document_exam1_idx` (`exam_exam_id`),
  CONSTRAINT `fk_marks_document_exam1` FOREIGN KEY (`exam_exam_id`) REFERENCES `exam` (`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.notice: ~3 rows (approximately)
INSERT INTO `notice` (`notice_id`, `post_date`, `content`, `title`, `status_status_id`, `admin_user_id`) VALUES
	(1, '2025-04-20 21:59:39', 'Testing notice content', 'Conent Title', 1, 1),
	(2, '2025-04-20 21:59:40', 'Testing notice content', 'Conent Title', 1, 1),
	(3, '2025-04-20 21:59:43', 'Testing notice content', 'Conent Title', 1, 1);

-- Dumping structure for table java_lms.semester
CREATE TABLE IF NOT EXISTS `semester` (
  `semester_id` int NOT NULL AUTO_INCREMENT,
  `semester` int DEFAULT NULL,
  PRIMARY KEY (`semester_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.semester: ~0 rows (approximately)
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.student: ~0 rows (approximately)

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.student_has_department_has_undergraduate_level: ~0 rows (approximately)

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.technical_officer: ~0 rows (approximately)

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table java_lms.timetable: ~0 rows (approximately)
INSERT INTO `timetable` (`timetable_id`, `day`, `from`, `to`, `course_course_id`) VALUES
	(1, 'Monday', '08:00:00', '12:30:00', 4);

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

-- Dumping data for table java_lms.undergraduate_level: ~0 rows (approximately)
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
