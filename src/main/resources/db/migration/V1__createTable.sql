DROP TABLE IF EXISTS `hibernate_sequence`;
create table hibernate_sequence(next_val INTEGER NOT NULL);

INSERT INTO hibernate_sequence (next_val) VALUES (1);

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (`next_val` bigint DEFAULT NULL);

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `uuid` varchar(255),
                        `adress_part_one` varchar(255) DEFAULT NULL,
                        `adress_part_two` varchar(255) DEFAULT NULL,
                        `city` varchar(255) DEFAULT NULL,
                        `last_name` varchar(255) DEFAULT NULL,
                        `name` varchar(255) DEFAULT NULL,
                        `password` varchar(255) DEFAULT NULL,
                        `username` varchar(255) DEFAULT NULL,
                        `zip` varchar(255) DEFAULT NULL,
                        `whish_list_id` bigint DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ;

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `name` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ;

DROP TABLE IF EXISTS `adresses`;
CREATE TABLE `adresses` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `adress_part_one` varchar(255) DEFAULT NULL,
                            `adress_part_two` varchar(255) DEFAULT NULL,
                            `city` varchar(255) DEFAULT NULL,
                            `is_delivery_adress` bit(1) DEFAULT NULL,
                            `is_invoice_adress` bit(1) DEFAULT NULL,
                            `last_name_adress` varchar(255) DEFAULT NULL,
                            `name_adress` varchar(255) DEFAULT NULL,
                            `street_number` varchar(255) DEFAULT NULL,
                            `zip` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ;

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `uuid` varchar(255),
                           `autor` varchar(255) DEFAULT NULL,
                           `date` datetime DEFAULT NULL,
                           `description` LONGTEXT DEFAULT NULL,
                           `edition` varchar(255) DEFAULT NULL,
                           `image` varchar(255) DEFAULT NULL,
                           `name` varchar(255) DEFAULT NULL,
                           `price` double DEFAULT NULL,
                           `category_id` bigint DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ;

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `category` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ;

DROP TABLE IF EXISTS `wish_list`;
CREATE TABLE `wish_list` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `name` varchar(255) DEFAULT NULL,
                             PRIMARY KEY (`id`)
) ;

DROP TABLE IF EXISTS `payment_mode`;
CREATE TABLE `payment_mode` (
                                `id` bigint NOT NULL AUTO_INCREMENT,
                                `card_number` varchar(255) DEFAULT NULL,
                                `card_type` varchar(255) DEFAULT NULL,
                                `code_secret` varchar(255) DEFAULT NULL,
                                `is_credit_card_to_use` bit(1) DEFAULT NULL,
                                `name` varchar(255) DEFAULT NULL,
                                PRIMARY KEY (`id`)
) ;

DROP TABLE IF EXISTS `category_products`;
CREATE TABLE `category_products` (
                                     `category_id` bigint NOT NULL,
                                     `products_id` bigint NOT NULL,
                                     PRIMARY KEY (`category_id`,`products_id`),
                                     FOREIGN KEY (`category_id`) REFERENCES category(`id`),
                                     FOREIGN KEY (`products_id`) REFERENCES product(`id`)
) ;

DROP TABLE IF EXISTS `orderf`;
CREATE TABLE `orderf` (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `user_id` bigint NOT NULL,
                           PRIMARY KEY (`id`),
                           FOREIGN KEY (`user_id`) REFERENCES user(`id`)
) ;

DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
                           `order_id` bigint NOT NULL,
                           `payment_mode_id` bigint NOT NULL,
                           PRIMARY KEY (`order_id`,`payment_mode_id`),
                           FOREIGN KEY (`order_id`) REFERENCES orderf(`id`),
                           FOREIGN KEY (`payment_mode_id`) REFERENCES payment_mode(`id`)
) ;


DROP TABLE IF EXISTS `product_order`;
CREATE TABLE `product_order` (
                                 `quantity` bigint DEFAULT NULL,
                                 `order_id` bigint NOT NULL,
                                 `product_id` bigint NOT NULL,
                                 PRIMARY KEY (`order_id`,`product_id`),
                                 FOREIGN KEY (`order_id`) REFERENCES orderf(`id`),
                                 FOREIGN KEY (`product_id`) REFERENCES product(`id`)
) ;

DROP TABLE IF EXISTS `user_adresses`;
CREATE TABLE `user_adresses` (
                                 `user_id` bigint NOT NULL,
                                 `adresses_id` bigint NOT NULL,
                                 PRIMARY KEY (`user_id`,`adresses_id`),
                                 FOREIGN KEY (`user_id`) REFERENCES user(`id`),
                                 FOREIGN KEY (`adresses_id`) REFERENCES adresses(`id`)
) ;

DROP TABLE IF EXISTS `user_payment_mode`;
CREATE TABLE `user_payment_mode` (
                                     `user_id` bigint NOT NULL,
                                     `payment_mode_id` bigint NOT NULL,
                                     PRIMARY KEY (`user_id`,`payment_mode_id`),
                                     FOREIGN KEY (`user_id`) REFERENCES user(`id`),
                                     FOREIGN KEY (`payment_mode_id`) REFERENCES payment_mode(`id`)
) ;

DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
                              `user_id` bigint NOT NULL,
                              `roles_id` bigint NOT NULL,
                              KEY `FKj9553ass9uctjrmh0gkqsmv0d` (`roles_id`),
                              KEY `FK55itppkw3i07do3h7qoclqd4k` (`user_id`)
) ;

DROP TABLE IF EXISTS `wish_list_product`;
CREATE TABLE `wish_list_product` (
                                     `wish_list_id` bigint NOT NULL,
                                     `product_id` bigint NOT NULL,
                                     PRIMARY KEY (`wish_list_id`,`product_id`),
                                     FOREIGN KEY (`wish_list_id`) REFERENCES wish_list(`id`),
                                     FOREIGN KEY (`product_id`) REFERENCES product(`id`)
) ;




