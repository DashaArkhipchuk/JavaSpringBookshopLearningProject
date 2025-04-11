-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bookshop
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bookshop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bookshop` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `bookshop` ;

-- -----------------------------------------------------
-- Table `bookshop`.`authors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookshop`.`authors` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL DEFAULT NULL,
  `last_name` VARCHAR(45) NULL DEFAULT NULL,
  `biography` VARCHAR(300) NULL DEFAULT NULL,
  `activity_years` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bookshop`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookshop`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(50) NULL,
  `password` VARCHAR(255) NULL,
  `role` VARCHAR(50) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bookshop`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookshop`.`products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `year_of_publishing` INT(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `genre` VARCHAR(255) NULL DEFAULT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  `authors_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_products_authors1_idx` (`authors_id` ASC) VISIBLE,
  CONSTRAINT `fk_products_authors1`
    FOREIGN KEY (`authors_id`)
    REFERENCES `bookshop`.`authors` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bookshop`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookshop`.`cart` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL DEFAULT NULL,
  `product_id` INT NULL DEFAULT NULL,
  `quantity` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_id` (`user_id` ASC) VISIBLE,
  INDEX `product_id` (`product_id` ASC) VISIBLE,
  CONSTRAINT `cart_ibfk_1`
    FOREIGN KEY (`user_id`)
    REFERENCES `bookshop`.`users` (`id`),
  CONSTRAINT `cart_ibfk_2`
    FOREIGN KEY (`product_id`)
    REFERENCES `bookshop`.`products` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bookshop`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookshop`.`orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL DEFAULT NULL,
  `order_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `total_price` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_id` (`user_id` ASC) VISIBLE,
  CONSTRAINT `orders_ibfk_1`
    FOREIGN KEY (`user_id`)
    REFERENCES `bookshop`.`users` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bookshop`.`order_items`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookshop`.`order_items` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `order_id` INT NULL DEFAULT NULL,
  `product_id` INT NULL DEFAULT NULL,
  `quantity` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `order_id` (`order_id` ASC) VISIBLE,
  INDEX `product_id` (`product_id` ASC) VISIBLE,
  CONSTRAINT `order_items_ibfk_1`
    FOREIGN KEY (`order_id`)
    REFERENCES `bookshop`.`orders` (`id`),
  CONSTRAINT `order_items_ibfk_2`
    FOREIGN KEY (`product_id`)
    REFERENCES `bookshop`.`products` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
