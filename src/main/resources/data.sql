create table towers (
    id bigint primary key,
    name varchar (255),
    height int
);

create sequence towers_id_s start with 1 increment by 1;

insert into towers values (next value for towers_id_s, 'well', -10);
insert into towers values (next value for towers_id_s, 'chessTower', 1);
insert into towers values (next value for towers_id_s, 'duzaWieza', 2137);

create table mages (
    id bigint primary key,
    name varchar (255) not null,
    level int,
    tower_id bigint
);

create sequence mages_id_s start 1 increment 1;

insert into mages values (next value for mages_id_s, 'Simmon', 311, (select id from towers where name = 'well'));
insert into mages values (next value for mages_id_s, 'Emil', 208, (select id from towers where name = 'chessTower'));
insert into mages values (next value for mages_id_s, 'Bartas', 210, (select id from towers where name = 'well'));
