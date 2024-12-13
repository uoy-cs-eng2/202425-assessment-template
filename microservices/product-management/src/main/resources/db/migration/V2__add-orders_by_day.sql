create table orders_by_day (
    id bigint not null auto_increment primary key,
    product_id bigint not null references product (id),
    day date not null,
    count int default 0 check (count >= 0),
    constraint uk_unique_product_day unique (product_id, day)
);