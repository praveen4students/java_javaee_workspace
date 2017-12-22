create database students_app;

create table students_info
( regno int(10) not null,
  firstname varchar(50),
  middlename varchar(50),
  lastname varchar(50),
  primary key(regno)
);

create table guardian_info
( regno int(10) not null,
  gfirstname varchar(50),
  gmiddlename varchar(50),
  glastname varchar(50),
  primary key(regno)
);

create table students_otherinfo
( regno int(10) not null,
  isadmin varchar(1),
  password varchar(50),
  primary key(regno)
);