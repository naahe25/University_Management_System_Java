-- Active: 1714068689435@@127.0.0.1@3306@universitymanagementsystem


create database UniversityManagementSystem;

show databases;

use universitymanagementsystem;

create table login(username varchar(25), password varchar(25));

show tables;

insert into login values('admin','12345');

show columns from login;

select * from login;