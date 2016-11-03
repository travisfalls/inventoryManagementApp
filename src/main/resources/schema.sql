CREATE SCHEMA IF NOT EXISTS indydroids;
USE indydroids;

CREATE TABLE IF NOT EXISTS indydroids.products (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  sku INT NOT NULL,
  product_name VARCHAR(45) NOT NULL,
  product_price DECIMAL NOT NULL,
  inventory INT NOT NULL,
  PRIMARY KEY (id));
  
  CREATE TABLE IF NOT EXISTS indydroids.product_images (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  product_id INT UNSIGNED NOT NULL,
  content_type VARCHAR(45) NOT NULL,
  image BLOB NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS indydroids.product_properties (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  product_id INT UNSIGNED NOT NULL,
  prop_name VARCHAR(45) NOT NULL,
  prop_value VARCHAR(255) NOT NULL,
  PRIMARY KEY (id));
  
CREATE TABLE IF NOT EXISTS indydroids.users (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_first_name VARCHAR (60) NOT NULL,
  user_last_name VARCHAR (60) NOT NULL,
  user_email VARCHAR(128) NULL,
  user_phone_number VARCHAR(10) NULL,
  PRIMARY KEY (id));
 
CREATE TABLE IF NOT EXISTS indydroids.user_images (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id INT UNSIGNED NOT NULL,
  content_type VARCHAR(45) NOT NULL,
  image BLOB NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS indydroids.user_properties (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id INT UNSIGNED NOT NULL,
  prop_name VARCHAR(45) NOT NULL,
  prop_value VARCHAR(255) NOT NULL,
  PRIMARY KEY (id));