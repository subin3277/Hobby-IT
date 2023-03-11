-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hobby_it
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hobby_it
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hobby_it` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `hobby_it` ;

-- -----------------------------------------------------
-- Table `hobby_it`.`member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hobby_it`.`member` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(64) NOT NULL,
  `name` VARCHAR(16) NOT NULL,
  `nickname` VARCHAR(16) NOT NULL,
  `password` VARCHAR(64) NOT NULL,
  `intro` VARCHAR(128) NULL DEFAULT NULL,
  `owned_hobby_cnt` TINYINT NOT NULL CHECK(0 <= `owned_hobby_cnt` AND `owned_hobby_cnt` <= 5) DEFAULT 0,
  `point` INT NOT NULL DEFAULT 0,
  `img_url` VARCHAR(255) NULL DEFAULT NULL,
  `state` VARCHAR(16) NOT NULL CHECK(`state` IN ('ACTIVE', 'WAITING', 'RESIGNED', 'BAN')) DEFAULT 'ACTIVE',
  `resd_req_dt` DATETIME NULL DEFAULT NULL,
  `reg_dt` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `chg_dt` DATETIME NOT NULL,
  `is_Sns` VARCHAR(5) NOT NULL CHECK(`is_SNS` IN ('FALSE', 'TRUE')) DEFAULT 'FALSE',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hobby_it`.`article`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hobby_it`.`article` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `member_id` BIGINT NOT NULL,
  `hobby_id` BIGINT NOT NULL,
  `header` VARCHAR(16) NOT NULL CHECK(`header` IN ('RECRUITMENT', 'MEETUP')),
  `title` VARCHAR(128) NOT NULL,
  `content` VARCHAR(512) NOT NULL,
  `hit` INT NOT NULL DEFAULT 0,
  `reg_dt` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `chg_dt` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_article_member1_idx` (`member_id` ASC) VISIBLE,
  INDEX `fk_article_hobby1_idx` (`hobby_id` ASC) VISIBLE,
  CONSTRAINT `fk_article_member1_idx`
    FOREIGN KEY (`member_id`)
    REFERENCES `hobby_it`.`member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_article_hobby1_idx`    
    FOREIGN KEY (`hobby_id`)
    REFERENCES `hobby_it`.`hobby` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hobby_it`.`hobby`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hobby_it`.`hobby` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(32) NOT NULL,
  `category` VARCHAR(16) NOT NULL,
  `intro` VARCHAR(128) NOT NULL,
  `cur_mem_cnt` TINYINT NOT NULL DEFAULT 0,
  `max_mem_cnt` TINYINT NOT NULL CHECK(12 <= `max_mem_cnt` AND `max_mem_cnt` <= 16) DEFAULT 16,
  `free` VARCHAR(16) NOT NULL CHECK(`free` IN ('FREE', 'NONFREE')) DEFAULT 'FREE',
  `img_url` VARCHAR(255) NULL DEFAULT NULL,
  `resd_req_dt` DATETIME NULL DEFAULT NULL,
  `reg_dt` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hobby_it`.`hobby_article`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hobby_it`.`hobby_article` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `hobby_id` BIGINT NOT NULL,
  `member_id` BIGINT NOT NULL,
  `category` VARCHAR(16) NOT NULL CHECK(`category` IN ('GENERAL', 'NOTICE')) DEFAULT 'GENERAL',
  `title` VARCHAR(128) NOT NULL,
  `content` VARCHAR(512) NOT NULL,
  `hit` INT NOT NULL DEFAULT 0,
  `like` INT NOT NULL DEFAULT 0,
  `reg_dt` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `chg_dt` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_hobby_article_hobby1_idx` (`hobby_id` ASC) VISIBLE,
  INDEX `fk_hobby_article_member1_idx` (`member_id` ASC) VISIBLE,
  CONSTRAINT `fk_hobby_article_hobby1`
    FOREIGN KEY (`hobby_id`)
    REFERENCES `hobby_it`.`hobby` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_hobby_article_member1`
    FOREIGN KEY (`member_id`)
    REFERENCES `hobby_it`.`member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hobby_it`.`hobby_article_comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hobby_it`.`hobby_article_comment` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `hobby_art_id` BIGINT NOT NULL,
  `member_id` BIGINT NOT NULL,
  `content` VARCHAR(255) NOT NULL,
  `reg_dt` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `chg_dt` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKsjgdomlf8tj025kanorkbsilj` (`member_id` ASC) VISIBLE,
  INDEX `fk_hobby_article_comment_hobby_article1_idx` (`hobby_art_id` ASC) VISIBLE,
  CONSTRAINT `FKsjgdomlf8tj025kanorkbsilj`
    FOREIGN KEY (`member_id`)
    REFERENCES `hobby_it`.`member` (`id`)
	ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_hobby_article_comment_hobby_article1`
    FOREIGN KEY (`hobby_art_id`)
    REFERENCES `hobby_it`.`hobby_article` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hobby_it`.`hobby_article_img`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hobby_it`.`hobby_article_img` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `hobby_art_id` BIGINT NOT NULL,
  `img_url` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_hobby_article_img_hobby_article1`
    FOREIGN KEY (`hobby_art_id`)
    REFERENCES `hobby_it`.`hobby_article` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hobby_it`.`hobby_member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hobby_it`.`hobby_member` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `member_id` BIGINT NOT NULL,
  `hobby_id` BIGINT NOT NULL,
  `state` VARCHAR(16) NOT NULL CHECK(`state` IN ('ACTIVE', 'RESIGNED', 'KICKED')) DEFAULT 'ACTIVE',
  `privilege` VARCHAR(16) NOT NULL CHECK(`privilege` IN ('OWNER', 'MANAGER', 'GENERAL')) DEFAULT 'GENERAL',
  `postit_reg_dt` DATETIME NULL DEFAULT NULL,
  `reg_dt` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `chg_dt` DATETIME NOT NULL,
  `resd_dt` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKcfgupav30t74rjlp5tkxsdpkm` (`hobby_id` ASC) VISIBLE,
  INDEX `FKkvsc6gtl5htm0aao87bge0768` (`member_id` ASC) VISIBLE,
  CONSTRAINT `FKcfgupav30t74rjlp5tkxsdpkm`
    FOREIGN KEY (`hobby_id`)
    REFERENCES `hobby_it`.`hobby` (`id`)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FKkvsc6gtl5htm0aao87bge0768`
    FOREIGN KEY (`member_id`)
    REFERENCES `hobby_it`.`member` (`id`)
	ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hobby_it`.`hobby_postit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hobby_it`.`hobby_postit` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `hobby_id` BIGINT NOT NULL,
  `member_id` BIGINT NOT NULL,
  `img_url` VARCHAR(255) NOT NULL,
  `reg_dt` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKh915heilkj6vqg9ok842k7abs` (`hobby_id` ASC) VISIBLE,
  INDEX `FK1gpbmbgtd2j24s4t6vk2u0oi8` (`member_id` ASC) VISIBLE,
  CONSTRAINT `FK1gpbmbgtd2j24s4t6vk2u0oi8`
    FOREIGN KEY (`member_id`)
    REFERENCES `hobby_it`.`member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FKh915heilkj6vqg9ok842k7abs`
    FOREIGN KEY (`hobby_id`)
    REFERENCES `hobby_it`.`hobby` (`id`)
	ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hobby_it`.`item_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hobby_it`.`item_type` (
  `id` BIGINT NOT NULL,
  `type` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hobby_it`.`item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hobby_it`.`item` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `item_type_id` BIGINT NOT NULL,
  `name` VARCHAR(16) NOT NULL,
  `rqd_point` INT NOT NULL,
  `img_url` VARCHAR(255) NOT NULL,
  `is_null` VARCHAR(7) NOT NULL CHECK(`is_null` IN ('NOTNULL', 'NULL')) DEFAULT 'NOTNULL',
  `reg_dt` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `chg_dt` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_item_item_type1_idx` (`item_type_id` ASC) VISIBLE,
  CONSTRAINT `fk_item_item_type1`
    FOREIGN KEY (`item_type_id`)
    REFERENCES `hobby_it`.`item_type` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hobby_it`.`member_privilege`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hobby_it`.`member_privilege` (
  `member_id` BIGINT NOT NULL,
  `privilege` VARCHAR(16) NOT NULL,
  INDEX `FKip0gxhcbexdphtovjjc3c6kc7` (`member_id` ASC) VISIBLE,
  PRIMARY KEY (`member_id`, `privilege`),
  CONSTRAINT `FKip0gxhcbexdphtovjjc3c6kc7`
    FOREIGN KEY (`member_id`)
    REFERENCES `hobby_it`.`member` (`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hobby_it`.`pending`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hobby_it`.`pending` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `member_id` BIGINT NOT NULL,
  `hobby_id` BIGINT NOT NULL,
  `msg` VARCHAR(128) NOT NULL,
  `state` VARCHAR(16) NOT NULL CHECK(`state` IN ('WAITING', 'APPROVED', 'REJECTED')) DEFAULT 'WAITING',
  `reg_dt` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `chg_dt` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK4d4pp5u74kcme9dx1hsrty2rg` (`hobby_id` ASC) VISIBLE,
  INDEX `FKqh8q4d61m3lx01nh8lc0wqq2u` (`member_id` ASC) VISIBLE,
  CONSTRAINT `FK4d4pp5u74kcme9dx1hsrty2rg`
    FOREIGN KEY (`hobby_id`)
    REFERENCES `hobby_it`.`hobby` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FKqh8q4d61m3lx01nh8lc0wqq2u`
    FOREIGN KEY (`member_id`)
    REFERENCES `hobby_it`.`member` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hobby_it`.`item_choice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hobby_it`.`item_choice` (
  `member_id` BIGINT NOT NULL,
  `item_type_id` BIGINT NOT NULL,
  `item_id` BIGINT NOT NULL,
  PRIMARY KEY (`member_id`, `item_type_id`),
  INDEX `fk_item_choice_member1_idx` (`member_id` ASC) VISIBLE,
  INDEX `fk_item_choice_item1_idx` (`item_id` ASC) VISIBLE,
  CONSTRAINT `fk_item_choice_item_type1`
    FOREIGN KEY (`item_type_id`)
    REFERENCES `hobby_it`.`item_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_choice_member1`
    FOREIGN KEY (`member_id`)
    REFERENCES `hobby_it`.`member` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_item_choice_item1`
    FOREIGN KEY (`item_id`)
    REFERENCES `hobby_it`.`item` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hobby_it`.`hobby_article_like`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hobby_it`.`hobby_article_like` (
  `hobby_art_id` BIGINT NOT NULL,
  `member_id` BIGINT NOT NULL,
  PRIMARY KEY (`hobby_art_id`, `member_id`),
  INDEX `fk_hobby_article_like_hobby_article1_idx` (`hobby_art_id` ASC) VISIBLE,
  CONSTRAINT `fk_hobby_article_like_member1`
    FOREIGN KEY (`member_id`)
    REFERENCES `hobby_it`.`member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_hobby_article_like_hobby_article1`
    FOREIGN KEY (`hobby_art_id`)
    REFERENCES `hobby_it`.`hobby_article` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hobby_it`.`hobby_postit_record`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hobby_it`.`hobby_postit_record` (
  `hobby_id` BIGINT NOT NULL,
  `reg_dt` DATE NOT NULL,
  PRIMARY KEY (`hobby_id`, `reg_dt`),
  CONSTRAINT `fk_hobby_postit_record_hobby_it1`
    FOREIGN KEY (`hobby_id`)
    REFERENCES `hobby_it`.`hobby` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
-- use hobby_it;