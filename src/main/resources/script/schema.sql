/*
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * + Copyright 2023. NHN Academy Corp. All rights reserved.
 * + * While every precaution has been taken in the preparation of this resource,  assumes no
 * + responsibility for errors or omissions, or for damages resulting from the use of the information
 * + contained herein
 * + No part of this resource may be reproduced, stored in a retrieval system, or transmitted, in any
 * + form or by any means, electronic, mechanical, photocopying, recording, or otherwise, without the
 * + prior written permission.
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */

CREATE TABLE IF NOT EXISTS `Categories` (
                            `category_id`		INT	auto_increment NOT NULL,
                            `category_name`	varchar(50) NOT NULL,

                            PRIMARY KEY(`category_id`)
);

CREATE TABLE IF NOT EXISTS `Products` (
                          `product_id`	INT	auto_increment NOT NULL,
                          `category_id`	INT NOT NULL,
                          `model_number`	nvarchar(10) NOT NULL,
                          `model_name`	nvarchar(120) NOT NULL,
                          `quantity` INT DEFAULT 0,
                          `prouduct_image`	nvarchar(30) NOT NULL,
                          `unitcost`	decimal(15) NOT NULL,
                          `description`	text,

                          PRIMARY KEY(`product_id`),
                          FOREIGN KEY(`category_id`) REFERENCES Categories(`category_id`)
);

CREATE TABLE IF NOT EXISTS `Users` (
                       `user_id` varchar(50) NOT NULL,
                       `user_name` varchar(50) NOT NULL,
                       `user_password` varchar(200) NOT NULL,
                       `user_birth` varchar(8) NOT NULL,
                       `user_auth` varchar(10) NOT NULL,
                       `user_point` int DEFAULT 0,
                       `created_at` datetime,
                       `latest_at` datetime,
                       PRIMARY KEY (`user_id`)
);

CREATE TABLE IF NOT EXISTS `Reviews` (
                         `review_id`	int auto_increment NOT NULL,
                         `product_id`	int NOT NULL,
                         `user_id`	    varchar(50) NOT NULL,
                         `rating`		int NOT NULL,
                         `comments`	text,

                         PRIMARY KEY(`review_id`),
                         FOREIGN KEY(`product_id`) REFERENCES Products(`product_id`),
                         FOREIGN KEY(`user_id`) REFERENCES Users(`user_id`)
);

CREATE TABLE IF NOT EXISTS `Orders` (
                        `order_id`		int auto_increment NOT NULL,
                        `user_id`	    varchar(50) NOT NULL,
                        `order_date`	Datetime,
                        `ship_date`	Datetime,

                        CONSTRAINT pk_Orders PRIMARY KEY(OrderID),
                        CONSTRAINT fk_Orders_Users FOREIGN KEY(UserID) REFERENCES Users(UserID)
);

CREATE TABLE IF NOT EXISTS `OrderDetails` (
                              `order_id`    int NOT NULL,
                              `product_id`	int NOT NULL,
                              `quantity`	int DEFAULT 0,
                              `unitcost`	decimal(15),

                              PRIMARY KEY(`order_id`, `product_id`),
                              FOREIGN KEY(`order_id`) REFERENCES Orders(`order_id`),
                              FOREIGN KEY(ProductID) REFERENCES Products(`product_id`)
);

CREATE TABLE IF NOT EXISTS `ShoppingCart` (
                              `record_id`	int	auto_increment NOT NULL,
                              `cart_id`		nvarchar(150) NOT NULL,
                              `quantity`	int,
                              `product_id`	int,
                              `created_at`	Datetime DEFAULT NOW(),

                              PRIMARY KEY(record_id),
                              FOREIGN KEY(`product_id`) REFERENCES Products(`product_id`)
);