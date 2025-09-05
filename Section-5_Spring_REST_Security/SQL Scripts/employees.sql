create database if not exists `employee_directory`;

use `employee_directory`;

-- table structure for employee

create table employee(
	id int not null auto_increment,
    first_name varchar(50) default null,
    last_name varchar(50) default null, 
    email varchar(50) not null,
    primary key(id)
)engine=InnoDB auto_increment=10001 default charset=latin1;


insert into employee (first_name, last_name, email) values ('Leslie', 'Andrews', 'leslie@gmail.com');
insert into employee (first_name, last_name, email) values ('Emma', 'Baumgarten', 'emma@yahhoo.com');
insert into employee (first_name, last_name, email) values ('Avani', 'Gupta', 'avani@microsoft.com');
insert into employee (first_name, last_name, email) values ('Yuri', 'Petrov', 'yuri@amazon.com');
insert into employee (first_name, last_name, email) values ('Juan', 'Vega', 'juan@apple.com');


