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

create table category
(
    id   int auto_increment,
    name varchar(50) null,
    constraint Category_categoryId_uindex
        unique (id)
);

alter table category
    add primary key (id);

create table color
(
    color_id   int auto_increment
        primary key,
    color_name varchar(20) null
)
    charset = latin1;

create table product
(
    id            int auto_increment,
    product_name  varchar(50)   not null,
    product_des   varchar(1000) null,
    product_price int           null,
    category_id   int           not null,
    brand_id      int           null,
    color_id      int           null,
    constraint Products_productId_uindex
        unique (id),
    constraint Products_Brand_id_fk
        foreign key (brand_id) references brand (id),
    constraint Products_Category_id_fk
        foreign key (category_id) references category (id),
    constraint product_color_color_id_fk
        foreign key (color_id) references color (color_id)
);

alter table product
    add primary key (id);

create table user
(
    user_id           int auto_increment
        primary key,
    first_name        varchar(20)  null,
    last_name         varchar(20)  null,
    email             varchar(20)  null,
    address           varchar(50)  null,
    phone_number      varchar(15)  null,
    gender            varchar(10)  null,
    encryted_password varchar(128) null,
    user_name         varchar(20)  null
)
    charset = latin1;

create table cart
(
    cart_id    int auto_increment
        primary key,
    product_id int      not null,
    user_id    int      null,
    quantity   int      null,
    price      int      null,
    createdAt  datetime null,
    created_at datetime null,
    constraint Order_Products_productId_fk
        foreign key (product_id) references product (id),
    constraint Order_User_userId_fk
        foreign key (cart_id) references user (user_id)
)
    charset = latin1;


