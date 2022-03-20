create table category
(
    category_id   int auto_increment
        primary key,
    category_name varchar(50) null
);

create table product
(
    id           int auto_increment
        primary key,
    product_name varchar(50)  null,
    product_des  varchar(500) null,
    category_id  int          not null,
    brand_id     int          null,
    constraint product_category_category_id_fk
        foreign key (category_id) references category (category_id)
);


