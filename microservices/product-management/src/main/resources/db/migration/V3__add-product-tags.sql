create table tag (
    id bigint not null primary key,
    name varchar(255) unique not null
);

create table product_tag (
    products_id bigint not null references product (id),
    tags_id bigint not null references tag (id),
    constraint primary key (products_id, tags_id)
);
