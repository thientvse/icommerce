create table brand
(
    id   int auto_increment
        primary key,
    name varchar(50) null
);

create table category
(
    id   int auto_increment
        primary key,
    name varchar(50) null
);

create table color
(
    id   int auto_increment
        primary key,
    name varchar(50) null
);

create table customer
(
    id               int auto_increment
        primary key,
    email            varchar(20) null,
    full_name        varchar(20) null,
    shipping_address varchar(50) null,
    billing_address  varchar(50) null,
    phone_number     varchar(20) null
);

create table hibernate_sequence
(
    next_val bigint null
)
    engine = MyISAM;

create table product
(
    id            int auto_increment
        primary key,
    product_name  varchar(50)  null,
    description   varchar(500) null,
    category_id   int          not null,
    brand_id      int          not null,
    color_id      int          not null,
    quantity      int          null,
    unit_price    double       null,
    constraint product_brand_id_fk
        foreign key (brand_id) references brand (id),
    constraint product_category_id_fk
        foreign key (category_id) references category (id),
    constraint product_color_id_fk
        foreign key (color_id) references color (id)
);

create table cart
(
    id         int auto_increment
        primary key,
    product_id int         null,
    price      double      null,
    quantity   int         null,
    status     varchar(20) null,
    created_at datetime    null,
    updated_at datetime    null,
    user_id    int         null,
    constraint cart_customer_id_fk
        foreign key (user_id) references customer (id),
    constraint cart_product_id_fk
        foreign key (product_id) references product (id)
);






