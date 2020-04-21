create database product_db;

use product_db;

create table product(
    num int primary key auto_increment,
    title varchar(50) not null,
	price int,
    descrip varchar(50) not null
);

CREATE TABLE `user` (
	`userid`	VARCHAR(20) 	PRIMARY KEY,
	`username`	VARCHAR(20) 	NOT NULL,
	`userpwd`	VARCHAR(100) 	NOT NULL,
	`email`		VARCHAR(2000),
	`address` 	VARCHAR(2000),
	`joindate` 	TIMESTAMP		NOT NULL DEFAULT current_timestamp
);

INSERT INTO user (userid, username, userpwd, email, address)
VALUES('ssafy', '공싸피', '1111', 'admin@ssafy.com','서울시 역삼동');

select * from user;