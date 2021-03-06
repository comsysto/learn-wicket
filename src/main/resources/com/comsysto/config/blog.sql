drop table CATEGORY if exists
drop table USER if exists


create table CATEGORY (id bigint generated by default as identity (start with 1), created TIMESTAMP, updated TIMESTAMP, name varchar(20), description varchar(255), primary key (id))
create table USER (id bigint generated by default as identity (start with 1), created TIMESTAMP, updated TIMESTAMP, firstName varchar(30) not null, lastName varchar(30) not null, title varchar(40), organization varchar(80), website varchar(100), emailAddress varchar(100) not null, password varchar(30) not null, primary key (id))

insert into CATEGORY (created, updated, name, description) values (CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 'Wicket', 'Everything about wicket framework')
insert into CATEGORY (created, updated, name, description) values (CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 'Javascript', 'Javascript in frontend')
insert into CATEGORY (created, updated, name, description) values (CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 'Personal', 'Stuff from my life')

insert into USER (created, updated, firstName, lastName, emailAddress, password) values (CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 'Uli', 'Hoeneß', 'uli@fcb.de', 'wurst')
insert into USER (created, updated, firstName, lastName, emailAddress, password) values (CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 'Franz', 'Beckenbauer', 'kaiser@fcb.de', 'schaunmermal')
