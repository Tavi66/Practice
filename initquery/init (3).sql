drop table if exists exhibition;
drop table if exists stageEvent;
create table exhibition(id int(11) primary key,name varchar(255),numberOfStalls int(11),occupied int(11));
create table stageEvent(id int(11) primary key,name varchar(255),coordinator varchar(255),seatAvailable int(11),showDate datetime);