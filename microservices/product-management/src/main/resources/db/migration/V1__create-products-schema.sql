create sequence hibernate_sequence;

create table product (
    id bigint not null primary key,
    name varchar(255) not null,
    unit_price decimal(12, 2) not null check (unit_price >= 0)
);