drop database exchangedb;
drop user exchange;
create user exchange with password 'pw';
create database exchangedb with template=template0 owner=exchange;
\connect exchangedb;
alter default privileges grant all on tables to exchange;
alter default privileges grant all on sequences to exchange;

create table currencies(
currency_id integer primary key not null,
symbol_from varchar(20) not null,
symbol_to varchar(20) not null,
rate integer not null,
);

create sequence currencies increment 1 start 1;