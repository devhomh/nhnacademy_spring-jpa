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
    `category_id`   INT	NOT NULL,
    `category_name`	varchar(50) NOT NULL,

    PRIMARY KEY(`category_id`)
);


MERGE INTO `Categories` KEY (`category_id`) VALUES (1, '전자제품');
MERGE INTO `Categories` KEY (`category_id`) VALUES (2, '의류');
MERGE INTO `Categories` KEY (`category_id`) VALUES (3, '가정용품');
MERGE INTO `Categories` KEY (`category_id`) VALUES (4, '장난감');
MERGE INTO `Categories` KEY (`category_id`) VALUES (5, '도서');


CREATE TABLE IF NOT EXISTS `Products` (
    `product_id`    INT	NOT NULL auto_increment,
    `category_id`   INT NOT NULL,
    `model_number`  nvarchar(10) NOT NULL,
    `model_name`    nvarchar(120) NOT NULL,
    `quantity`      INT DEFAULT 0,
    `unitcost`	    bigint NOT NULL,
    `description`	text,

    PRIMARY KEY(`product_id`),
    FOREIGN KEY(`category_id`) REFERENCES Categories(`category_id`)
);

MERGE INTO `Products` KEY (`product_id`) VALUES (1, 1, 'E001', '스마트폰 X', 50, 59999, '고급 기능을 갖춘 스마트폰');
MERGE INTO `Products` KEY (`product_id`) VALUES (2, 1, 'E002', '노트북 Pro', 30, 129999, '전문가를 위한 강력한 노트북');
MERGE INTO `Products` KEY (`product_id`) VALUES (3, 2, 'C001', '데님 청바지', 100, 4999, '클래식한 파란색 데님 청바지');
MERGE INTO `Products` KEY (`product_id`) VALUES (4, 2, 'C002', '캐주얼 티셔츠', 150, 1999, '편안한 면 소재 티셔츠');
MERGE INTO `Products` KEY (`product_id`) VALUES (5, 3, 'H001', '가든 도구 세트', 20, 7999, '필수 가든 도구의 완벽한 세트');
MERGE INTO `Products` KEY (`product_id`) VALUES (6, 3, 'H002', '주방용품 A', 80, 2999, '다용도 주방용품');
MERGE INTO `Products` KEY (`product_id`) VALUES (7, 4, 'T001', '보드게임 A1', 40, 2999, '재미있는 전략 보드게임');
MERGE INTO `Products` KEY (`product_id`) VALUES (8, 4, 'T002', '퍼즐 B1', 60, 1599, '다양한 테마의 퍼즐');
MERGE INTO `Products` KEY (`product_id`) VALUES (9, 5, 'B001', '소설 X1', 25, 3999, '인상적인 소설');
MERGE INTO `Products` KEY (`product_id`) VALUES (10, 5, 'B002', '자기개발서 Y1', 35, 2499, '자아개발을 위한 서적');
MERGE INTO `Products` KEY (`product_id`) VALUES (11, 1, 'E003', '태블릿 Z', 25, 34999, '고화질 디스플레이를 갖춘 태블릿');
MERGE INTO `Products` KEY (`product_id`) VALUES (12, 2, 'C003', '긴팔 셔츠', 120, 2999, '스타일리시한 디자인의 긴팔 셔츠');
MERGE INTO `Products` KEY (`product_id`) VALUES (13, 2, 'C004', '모자 A', 80, 1499, '다양한 스타일의 모자');
MERGE INTO `Products` KEY (`product_id`) VALUES (14, 3, 'H003', '청소기 B', 15, 19999, '강력한 성능의 청소기');
MERGE INTO `Products` KEY (`product_id`) VALUES (15, 3, 'H004', '화분 세트', 30, 1999, '다양한 크기의 화분 세트');
MERGE INTO `Products` KEY (`product_id`) VALUES (16, 4, 'T001', '보드게임 A', 40, 2999, '재미있는 전략 보드게임');
MERGE INTO `Products` KEY (`product_id`) VALUES (17, 4, 'T002', '퍼즐 B', 60, 1599, '다양한 테마의 퍼즐');
MERGE INTO `Products` KEY (`product_id`) VALUES (18, 5, 'B001', '소설 X', 25, 3999, '인상적인 소설');
MERGE INTO `Products` KEY (`product_id`) VALUES (19, 5, 'B002', '자기개발서 Y', 35, 2499, '자아개발을 위한 서적');
MERGE INTO `Products` KEY (`product_id`) VALUES (20, 5, 'B003', '컴퓨터 과학책 Z', 15, 4999, '최신 컴퓨터 과학 지식을 담은 책');

CREATE TABLE IF NOT EXISTS `Users` (
    `user_id`       varchar(50) NOT NULL,
    `user_name`     varchar(50) NOT NULL,
    `user_password` varchar(200) NOT NULL,

    PRIMARY KEY (`user_id`)
);

MERGE INTO `Users` KEY (`user_id`) VALUES
    ('jinwoo', '이진우', '1234'),
    ('jinwoo12', '김진우', '4567'),
    ('jinwoo34', '최진우', '7890');

CREATE TABLE IF NOT EXISTS `Reviews` (
    `review_id`	    int auto_increment NOT NULL,
    `product_id`	int NOT NULL,
    `user_id`	    varchar(50) NOT NULL,
    `rating`		int NOT NULL,
    `comments`	    text,

    PRIMARY KEY(`review_id`),
    FOREIGN KEY(`product_id`) REFERENCES Products(`product_id`),
    FOREIGN KEY(`user_id`) REFERENCES Users(`user_id`)
);

CREATE TABLE IF NOT EXISTS `Orders` (
    `order_id`		int auto_increment NOT NULL,
    `user_id`	    varchar(50) NOT NULL,
    `order_date`	Datetime,
    `ship_date`	    Datetime,

    PRIMARY KEY(`order_id`),
    FOREIGN KEY(`user_id`) REFERENCES Users(`user_id`)
);

CREATE TABLE IF NOT EXISTS `OrderDetails` (
    `order_id`      int NOT NULL,
    `product_id`	int NOT NULL,
    `quantity`	    int DEFAULT 0,
    `unitcost`	    decimal(15),

    PRIMARY KEY(`order_id`, `product_id`),
    FOREIGN KEY(`order_id`) REFERENCES Orders(`order_id`),
    FOREIGN KEY(`product_id`) REFERENCES Products(`product_id`)
);

CREATE TABLE IF NOT EXISTS `ShoppingCart` (
    `cart_id`	    int	auto_increment NOT NULL,
    `user_id`       varchar(50) NOT NULL,
    `created_at`	Datetime DEFAULT NOW(),

    PRIMARY KEY(`cart_id`),
    FOREIGN KEY(`user_id`) REFERENCES Users(`user_id`)
);

CREATE TABLE IF NOT EXISTS `ShoppingCartProduct` (
    `cart_id`	    int	NOT NULL,
    `product_id`    int NOT NULL,
    `quantity`	    int DEFAULT 0,

    PRIMARY KEY(`cart_id`, `product_id`),
    FOREIGN KEY(`cart_id`) REFERENCES ShoppingCart(`cart_id`),
    FOREIGN KEY(`product_id`) REFERENCES Products(`product_id`)
);
