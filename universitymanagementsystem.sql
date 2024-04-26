-- Active: 1714068689435@@127.0.0.1@3306


create database UniversityManagementSystem;

show databases;

use universitymanagementsystem;

create table login(username varchar(25), password varchar(25));

create table student(name varchar(40), fname varchar(40), rollno varchar(20), dob varchar(40), address varchar(100), phone varchar(20), email varchar(40), nid varchar(20), sscgpa varchar(20), hscgpa varchar(20), course varchar(40), batch varchar(40)); 

create table teacher(name varchar(40), fname varchar(40), empId varchar(20), dob varchar(40), address varchar(100), phone varchar(20), email varchar(40), nid varchar(20), sscgpa varchar(20), hscgpa varchar(20), education varchar(40), department varchar(40)); 
show tables;

insert into login values('admin','12345');

show columns from login;

show columns from student;

show columns from teacher;

select * from login;