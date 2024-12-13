create sequence hibernate_sequence;

create table customer (
    id bigint primary key not null,
    email varchar(255) not null unique,
    first_name varchar(255) not null,
    family_name varchar(255) not null
);

create table orders (
    id bigint primary key not null,
    date_created date not null,
    address text not null,
    paid boolean not null default false,
    delivered boolean not null default false,
    total_amount decimal(12, 2) not null,
    customer_id bigint not null,
    constraint fk_order_customer
        foreign key (customer_id)
            references customer (id)
            on delete cascade
);

create table order_item (
    id bigint primary key not null,
    product_id bigint not null,
    order_id bigint not null,
    quantity mediumint not null,
    unit_price decimal(12, 2) not null,
    constraint fk_item_order foreign key (order_id) references orders (id) on delete cascade,
    constraint ck_item_qty check (quantity >= 1)
);
