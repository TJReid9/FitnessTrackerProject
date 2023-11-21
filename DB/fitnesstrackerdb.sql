-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema fitnesstrackerdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `fitnesstrackerdb` ;

-- -----------------------------------------------------
-- Schema fitnesstrackerdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fitnesstrackerdb` DEFAULT CHARACTER SET utf8 ;
USE `fitnesstrackerdb` ;

-- -----------------------------------------------------
-- Table `fitness_tracker`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fitness_tracker` ;

CREATE TABLE IF NOT EXISTS `fitness_tracker` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NULL,
  `activity` VARCHAR(45) NULL,
  `location` VARCHAR(45) NULL,
  `duration` TIME NULL,
  `notes` TEXT NULL,
  `create_date` DATETIME NULL,
  `update_date` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS fitnesstracker@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'fitnesstracker'@'localhost' IDENTIFIED BY 'fitnesstracker';

GRANT SELECT, INSERT, TRIGGER ON TABLE * TO 'fitnesstracker'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `fitness_tracker`
-- -----------------------------------------------------
START TRANSACTION;
USE `fitnesstrackerdb`;
INSERT INTO `fitness_tracker` (`id`, `date`, `activity`, `location`, `duration`, `notes`, `create_date`, `update_date`) VALUES (1, '2023-11-20', 'Workout', 'Colorado Athletic Club', '1:00:00', 'Moved up to 35 pound dumbells', NULL, NULL);

COMMIT;

