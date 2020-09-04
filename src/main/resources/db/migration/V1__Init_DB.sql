-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema webhosting
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema webhosting
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `webhosting` DEFAULT CHARACTER SET latin1;
USE `webhosting`;

-- -----------------------------------------------------
-- Table `webhosting`.`SPRING_SESSION`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webhosting`.`SPRING_SESSION`
(
    `PRIMARY_ID`            CHAR(36)     NOT NULL,
    `SESSION_ID`            CHAR(36)     NOT NULL,
    `CREATION_TIME`         BIGINT(20)   NOT NULL,
    `LAST_ACCESS_TIME`      BIGINT(20)   NOT NULL,
    `MAX_INACTIVE_INTERVAL` INT(11)      NOT NULL,
    `EXPIRY_TIME`           BIGINT(20)   NOT NULL,
    `PRINCIPAL_NAME`        VARCHAR(100) NULL DEFAULT NULL,
    PRIMARY KEY (`PRIMARY_ID`),
    UNIQUE INDEX `SPRING_SESSION_IX1` (`SESSION_ID` ASC),
    INDEX `SPRING_SESSION_IX2` (`EXPIRY_TIME` ASC),
    INDEX `SPRING_SESSION_IX3` (`PRINCIPAL_NAME` ASC)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8
    ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `webhosting`.`SPRING_SESSION_ATTRIBUTES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webhosting`.`SPRING_SESSION_ATTRIBUTES`
(
    `SESSION_PRIMARY_ID` CHAR(36)     NOT NULL,
    `ATTRIBUTE_NAME`     VARCHAR(200) NOT NULL,
    `ATTRIBUTE_BYTES`    BLOB         NOT NULL,
    PRIMARY KEY (`SESSION_PRIMARY_ID`, `ATTRIBUTE_NAME`),
    CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK`
        FOREIGN KEY (`SESSION_PRIMARY_ID`)
            REFERENCES `webhosting`.`SPRING_SESSION` (`PRIMARY_ID`)
            ON DELETE CASCADE
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8
    ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `webhosting`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webhosting`.`category`
(
    `id`              BIGINT(20)   NOT NULL AUTO_INCREMENT,
    `name`            VARCHAR(255) NOT NULL,
    `sub_category_id` BIGINT(20)   NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    INDEX `FKoevfe7tm4v9r283j143d5ktrl` (`sub_category_id` ASC)
)
    ENGINE = MyISAM
    DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `webhosting`.`flyway_schema_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webhosting`.`flyway_schema_history`
(
    `installed_rank` INT(11)       NOT NULL,
    `version`        VARCHAR(50)   NULL     DEFAULT NULL,
    `description`    VARCHAR(200)  NOT NULL,
    `type`           VARCHAR(20)   NOT NULL,
    `script`         VARCHAR(1000) NOT NULL,
    `checksum`       INT(11)       NULL     DEFAULT NULL,
    `installed_by`   VARCHAR(100)  NOT NULL,
    `installed_on`   TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `execution_time` INT(11)       NOT NULL,
    `success`        TINYINT(1)    NOT NULL,
    PRIMARY KEY (`installed_rank`),
    INDEX `flyway_schema_history_s_idx` (`success` ASC)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `webhosting`.`question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webhosting`.`question`
(
    `id`          BIGINT(20)   NOT NULL AUTO_INCREMENT,
    `name`        VARCHAR(255) NOT NULL,
    `category_id` BIGINT(20)   NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    INDEX `FK7jaqbm9p4prg7n91dd1uabrvj` (`category_id` ASC)
)
    ENGINE = MyISAM
    DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `webhosting`.`request`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webhosting`.`request`
(
    `id`                 BIGINT(20)   NOT NULL AUTO_INCREMENT,
    `date`               DATE         NULL DEFAULT NULL,
    `end_date`           DATE         NULL DEFAULT NULL,
    `query_type`         VARCHAR(255) NOT NULL,
    `response_type`      VARCHAR(255) NOT NULL,
    `response_wait_time` INT(11)      NULL DEFAULT NULL,
    `start_date`         DATE         NULL DEFAULT NULL,
    `question_id`        BIGINT(20)   NOT NULL,
    `service_id`         BIGINT(20)   NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `FKpx0upme7m5jl1wkole0931vic` (`question_id` ASC),
    INDEX `FKows6i5dlelxfga5nbfq6ilyku` (`service_id` ASC)
)
    ENGINE = MyISAM
    DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `webhosting`.`service`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webhosting`.`service`
(
    `id`           BIGINT(20)   NOT NULL AUTO_INCREMENT,
    `name`         VARCHAR(255) NOT NULL,
    `variation_id` BIGINT(20)   NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    INDEX `FKcdvtkt3f3meqjifqrwglflton` (`variation_id` ASC)
)
    ENGINE = MyISAM
    DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `webhosting`.`sub_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webhosting`.`sub_category`
(
    `id`   BIGINT(20)   NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = MyISAM
    DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `webhosting`.`variation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webhosting`.`variation`
(
    `id`   BIGINT(20)   NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = MyISAM
    DEFAULT CHARACTER SET = latin1;


SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;
