create database if not exists icommerce;

use icommerce;



create table brand
(
    id   int auto_increment,
    name varchar(50) null,
    constraint Brand_id_uindex
        unique (id)
)
    charset = latin1;




alter table brand
    add primary key (id);

INSERT INTO icommerce.brand (id, name)
VALUES (1, 'Samsung');
INSERT INTO icommerce.brand (id, name)
VALUES (2, 'Apple');

create table category
(
    id   int auto_increment,
    name varchar(50) null,
    constraint Category_categoryId_uindex
        unique (id)
);

alter table category
    add primary key (id);

INSERT INTO icommerce.category (id, name)
VALUES (1, 'Điện thoại');
INSERT INTO icommerce.category (id, name)
VALUES (2, 'Điện tử');

create table color
(
    id   int auto_increment
        primary key,
    name varchar(20) null
)
    charset = latin1;

INSERT INTO icommerce.color (id, name)
VALUES (1, 'Red');
INSERT INTO icommerce.color (id, name)
VALUES (2, 'Blue');

create table customer
(
    id           bigint   auto_increment    not null
        primary key,
    email        varchar(255) null,
    phone_number varchar(255) null
)
    engine = MyISAM;

INSERT INTO icommerce.customer (id, email, phone_number)
VALUES (1, 'thientvse@gmail.com','0389937014');


create table product
(
    id            int auto_increment,
    product_name  varchar(50)   not null,
    description   varchar(1000) null,
    category_id   int           not null,
    brand_id      int           null,
    color_id      int           null,
    quantity      int           null,
    unit_price int           null,
    constraint Products_productId_uindex
        unique (id),
    constraint Products_Brand_id_fk
        foreign key (brand_id) references brand (id),
    constraint Products_Category_id_fk
        foreign key (category_id) references category (id),
    constraint product_color_color_id_fk
        foreign key (color_id) references color (id)
);

alter table product
    add primary key (id);

INSERT INTO icommerce.product (id, product_name, description, category_id, brand_id, color_id, quantity, unit_price) VALUES (1, 'Điện thoại Samsung', 'Một sản phẩm của Samsung', 1, 1, 1, 100, 1000);
INSERT INTO icommerce.product (id, product_name, description, category_id, brand_id, color_id, quantity, unit_price) VALUES (2, 'Iphone 13', 'Một sản phẩm của Apple', 1, 2, 2, 50, 1000);
INSERT INTO icommerce.product (id, product_name, description, category_id, brand_id, color_id, quantity, unit_price) VALUES (3, 'Tủ lạnh Samsung', 'Một sản phẩm của Samsung', 2, 1, 2, 50, 500);



create table cart
(
    id    int auto_increment
        primary key,
    product_id int      not null,
    user_id    int      null,
    quantity   int      null,
    price      int      null,
    updated_at  datetime null,
    created_at datetime null,
    constraint Order_Products_productId_fk
        foreign key (product_id) references product (id),
    constraint Order_User_userId_fk
        foreign key (user_id) references customer (id)
)
    charset = latin1;


FLUSH PRIVILEGES;

