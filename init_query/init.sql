drop table if exists item;
create table item(id int(11) primary key,category varchar(255),name varchar(255),number int(11),price float);
insert into item values(11,'furniture','chair',30,1500);
insert into item values(22,'sports','ball',20,200);
insert into item values(33,'electronics','keyboard',10,5000);
insert into item values(44,'electronics','calculator',10,3000);
insert into item values(55,'sports','board',5,1000);