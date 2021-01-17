create table if not exists accident
(
    id      serial primary key,
    name    varchar(500),
    text    varchar(2000),
    address varchar(1000)
);

create table if not exists accident_rules
(
    id   serial primary key,
    name varchar(255)
);

create table if not exists accident_types
(
    id   serial primary key,
    name varchar(255)
);

alter table accident
    add column type_id integer references accident_types;

create table if not exists accident_accident_rules
(
    accident_id integer not null references accident,
    rules_id    integer not null references accident_rules,
    primary key (accident_id, rules_id)
);

insert into accident_types (name)
values ('Две машины'),
       ('Машина и человек'),
       ('Машина и велосипед');
insert into accident_rules (name)
values ('Статья 1.'),
       ('Статья 2.'),
       ('Статья 3.');
