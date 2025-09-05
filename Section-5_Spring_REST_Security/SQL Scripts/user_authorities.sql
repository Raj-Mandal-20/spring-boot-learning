use `employee_directory`;

drop table if exists `users`;
drop table if exists `authorities`;
-- table structure of 'users'

create table `users` (
	`username` varchar(50) not null,
    `password` varchar(68) not null, 
    `enabled` tinyint not null,
    primary key(`username`)
)engine=InnoDB default charset=latin1;


-- insert data into table

insert into `users`(`username`, `password`, `enabled`) values('jhon', '{bcrypt}$2a$12$2iGppvDGqivtb/gLl1jz2..u.Ip8YlIMFPfGpxrc4/vnW9rC8IiSy', 1);
insert into `users`(`username`, `password`, `enabled`) values('mary', '{bcrypt}$2a$12$gjkklnysG7rQBuYlgIwxHutqvZdR.2gEY6rU5qreTB02Xj7N7uMW6', 1);
insert into `users`(`username`, `password`, `enabled`) values('susan', '{bcrypt}$2a$12$oqXVFTDzUkWPuEMPkucNMeQmlCRcYVXTTsOnO2ehnBGnjyHetNazW', 1);


-- structure of authorities table

create table `authorities`(
	`username` varchar(50) not null, 
    `authority` varchar(50) not null, 
    unique key `authorities_idx_1` (`username`, `authority`),
    constraint `authorities_ibfk_1` foreign key `authorities` (`username`) references `users` (`username`)   
)engine=InnoDB default charset=latin1;

-- drop table `authorities`;



-- inserting data to authorities
insert into `authorities`
values ('jhon', 'ROLE_EMPLOYEE'),
	   ('mary', 'ROLE_EMPLOYEE'),
	   ('mary', 'ROLE_MANAGER'),
	   ('susan', 'ROLE_EMPLOYEE'),
	   ('susan', 'ROLE_MANAGER'),
	   ('susan', 'ROLE_ADMIN');
 
