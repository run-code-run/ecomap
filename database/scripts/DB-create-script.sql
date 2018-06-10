-- USERS AND THEIR ROLES TABLES

create table users
(id serial not null,
 username varchar(50) not null unique,
 password varchar(50) not null,
 email varchar(50),
 phone varchar(50),
 enabled boolean default true,
  primary key (id));;

create table authorities(
  username varchar(50) not null,
  authority varchar(50) not null,
  constraint fk_authorities_users foreign key(username) references users(username),
  primary key (username));

create unique index ix_auth_username on authorities (username, authority);