drop table if exists item;
drop table if exists itemType;
create table itemType(id int(11) primary key,detail varchar(255),name varchar(255));
create table item(id int(11) primary key,cost double,name varchar(255),itemTypeId int(11),foreign key(itemTypeId) references itemType(id));