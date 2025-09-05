use `employee_directory`;

drop table if exists `members`;
drop table if exists `roles`;
-- table structure of 'users'

create table `members` (
	`user_id` varchar(50) not null,
    `pw` varchar(68) not null, 
    `active` tinyint not null,
    primary key(`user_id`)
)engine=InnoDB default charset=latin1;


-- insert data into table

insert into `members`(`user_id`, `pw`, `active`) values('john', '{bcrypt}$2a$12$2iGppvDGqivtb/gLl1jz2..u.Ip8YlIMFPfGpxrc4/vnW9rC8IiSy', 1);
insert into `members`(`user_id`, `pw`, `active`) values('mary', '{bcrypt}$2a$12$gjkklnysG7rQBuYlgIwxHutqvZdR.2gEY6rU5qreTB02Xj7N7uMW6', 1);
insert into `members`(`user_id`, `pw`, `active`) values('susan', '{bcrypt}$2a$12$oqXVFTDzUkWPuEMPkucNMeQmlCRcYVXTTsOnO2ehnBGnjyHetNazW', 1);


-- structure of authorities table

create table `roles`(
	`user_id` varchar(50) not null, 
    `role` varchar(50) not null, 
    unique key `roles_idx_1` (`user_id`, `role`),
    constraint `roles_ibfk_1` foreign key `roles` (`user_id`) references `members` (`user_id`)   
)engine=InnoDB default charset=latin1;

-- drop table `authorities`;



-- inserting data to authorities
insert into `roles`
values ('john', 'ROLE_EMPLOYEE'),
	   ('mary', 'ROLE_EMPLOYEE'),
	   ('mary', 'ROLE_MANAGER'),
	   ('susan', 'ROLE_EMPLOYEE'),
	   ('susan', 'ROLE_MANAGER'),
	   ('susan', 'ROLE_ADMIN');
 
