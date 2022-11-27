DROP TABLE IF EXISTS `hibernate_sequence`;
create table hibernate_sequence(
                                    next_val INTEGER NOT NULL
);

INSERT INTO hibernate_sequence (next_val) VALUES (1);

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

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `category` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ;

DROP TABLE IF EXISTS `category_products`;
CREATE TABLE `category_products` (
                                     `category_id` bigint NOT NULL,
                                     `products_id` bigint NOT NULL,
                                     UNIQUE KEY `UK_fdnk3mk70n1rc08vw1cj65kqw` (`products_id`),
                                     KEY `FKqwkr0l0xbluhhkm7s0c1tg8en` (`category_id`)
) ;

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
    `next_val` bigint DEFAULT NULL
) ;

DROP TABLE IF EXISTS `orderf`;
CREATE TABLE `orderf` (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `user_id` bigint NOT NULL,
                          PRIMARY KEY (`id`),
                          KEY `FKyag0scwqv0n21eapvv5nmg42` (`user_id`)
) ;

DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `order_id` bigint DEFAULT NULL,
                           `payment_mode_id` bigint DEFAULT NULL,
                           PRIMARY KEY (`id`),
                           KEY `FK5ttjtanjlx35g8q7ut9pn601` (`order_id`),
                           KEY `FKba6y7uepbpwmounho6a0s376k` (`payment_mode_id`)
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
                           PRIMARY KEY (`id`),
                           KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`)
) ;

DROP TABLE IF EXISTS `product_order`;
CREATE TABLE `product_order` (
                                 `quantity` bigint DEFAULT NULL,
                                 `order_id` bigint NOT NULL,
                                 `product_id` bigint NOT NULL,
                                 PRIMARY KEY (`order_id`,`product_id`),
                                 KEY `FKh73acsd9s5wp6l0e55td6jr1m` (`product_id`)
) ;

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `name` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ;

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
                        PRIMARY KEY (`id`),
                        KEY `FK2c5wgy4wrgccngxqbre0uy1ag` (`whish_list_id`)
) ;

DROP TABLE IF EXISTS `user_adresses`;
CREATE TABLE `user_adresses` (
                                 `user_id` bigint NOT NULL,
                                 `adresses_id` bigint NOT NULL,
                                 UNIQUE KEY `UK_f1k2idvvr3akl7lkq2wv3otwm` (`adresses_id`),
                                 KEY `FKh9r96dgv6vd3qjvc39x1hpk4u` (`user_id`)
) ;

DROP TABLE IF EXISTS `user_payment_mode`;
CREATE TABLE `user_payment_mode` (
                                     `user_id` bigint NOT NULL,
                                     `payment_mode_id` bigint NOT NULL,
                                     UNIQUE KEY `UK_g166namr77nfsd15n8lmp20sa` (`payment_mode_id`),
                                     KEY `FKaxsye2aaw82qljryth34m34l8` (`user_id`)
) ;

DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
                              `user_id` bigint NOT NULL,
                              `roles_id` bigint NOT NULL,
                              KEY `FKj9553ass9uctjrmh0gkqsmv0d` (`roles_id`),
                              KEY `FK55itppkw3i07do3h7qoclqd4k` (`user_id`)
) ;

DROP TABLE IF EXISTS `wish_list`;
CREATE TABLE `wish_list` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `name` varchar(255) DEFAULT NULL,
                             PRIMARY KEY (`id`)
) ;

DROP TABLE IF EXISTS `wish_list_product`;
CREATE TABLE `wish_list_product` (
                                     `wish_list_id` bigint NOT NULL,
                                     `product_id` bigint NOT NULL,
                                     UNIQUE KEY `UK_3v7ckd2bs9rs5a7pynwrjxvvr` (`product_id`),
                                     KEY `FKberd6fnnrooo75iar4agj0wn` (`wish_list_id`)
) ;




