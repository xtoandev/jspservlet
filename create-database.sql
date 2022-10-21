create database jspservlet CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

use jspservlet;


CREATE TABLE `role` (
  id bigint NOT NULL PRIMARY KEY auto_increment,
  role_name VARCHAR(255) NOT NULL
);

CREATE TABLE `account` (
  `id` bigint NOT NULL PRIMARY KEY auto_increment,
  email VARCHAR(255) NULL,
  `password` VARCHAR(150) NOT NULL,
  role_id bigint NOT NULL,
  full_name VARCHAR(255) NOT NULL,
  dob Date NULL,
  avatar VARCHAR(255) NULL,
  `status` int NOT NULL
);
ALTER TABLE `account` ADD CONSTRAINT fk_account_role FOREIGN KEY (role_id) REFERENCES `role`(id);

CREATE TABLE category (
  id bigint NOT NULL PRIMARY KEY auto_increment,
  category_name VARCHAR(255) NOT NULL,
  `status` int NOT NULL
);


CREATE TABLE book (
  id bigint NOT NULL PRIMARY KEY auto_increment,
  title VARCHAR(255) NOT NULL,
  category_id bigint NOT NULL,
  `description` TEXT NOT NULL,
  content TEXT NOT NULL,
  background VARCHAR(255) NOT NULL,
  create_date Date NOT NULL,
  `status` int NOT NULL
);


ALTER TABLE book ADD CONSTRAINT fk_book_category FOREIGN KEY (category_id) REFERENCES category(id);



insert into `role`(role_name) values('admin');
insert into `role`(role_name) values('user');
insert into `account`(email ,`password` ,role_id ,full_name ,avatar ,`status`) values('admin@gmail.com','123',1,'Phạm Xuân Toán','https://i.ibb.co/GMbLW63/LOGO.png',1);
insert into `account`(email ,`password` ,role_id ,full_name ,avatar ,`status`) values('xuantoan@gmail.com','123',2,'Phạm Xuân Toán','https://i.ibb.co/GMbLW63/LOGO.png',1);
insert into `account`(email ,`password` ,role_id ,full_name ,avatar ,`status`) values('thanhtri@gmail.com','123',2,'Lê Thanh Trí','https://i.ibb.co/bJ8LBz4/avatar-06.jpg',1);
insert into `account`(email ,`password` ,role_id ,full_name ,avatar ,`status`) values('quocviet@gmail.com','123',2,'Nguyễn Quốc VIệt','https://i.ibb.co/bJ8LBz4/avatar-06.jpg',1);


insert into category(category_name,`status`) values('Sách kinh tế',1);
insert into category(category_name,`status`) values('Sách văn học',1);
insert into category(category_name,`status`) values('Sách phát triển bản thân',1);
insert into category(category_name,`status`) values('Tiểu thuyết',1);
insert into category(category_name,`status`) values('Ngoại ngữ',1);
insert into category(category_name,`status`) values('Sách nước ngoài',1);

