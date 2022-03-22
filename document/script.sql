create table brand
(
    id   int auto_increment
        primary key,
    name varchar(20) null
);

create table category
(
    id   int auto_increment
        primary key,
    name varchar(20) null
);

create table color
(
    id   int auto_increment
        primary key,
    name varchar(20) null
);

create table hibernate_sequence
(
    next_val bigint null
)
    engine = MyISAM;

create table product
(
    id          int auto_increment
        primary key,
    name        varchar(50)  null,
    description varchar(500) null,
    category_id int          not null,
    brand_id    int          null,
    quantity    int          null,
    unit_price  double       null,
    color_id    int          null,
    constraint product___fkc
        foreign key (color_id) references color (id),
    constraint product_brand_id_fk
        foreign key (brand_id) references brand (id),
    constraint product_category_id_fk
        foreign key (category_id) references category (id)
);

alter table brand
    add constraint FKap7k6606mb1t8ve3uw2hieyyo
        foreign key (id) references product (id);

alter table category
    add constraint FKokxp80sqio3lkrbbwjoyu15xr
        foreign key (id) references product (id);

create table user
(
    id    int         not null
        primary key,
    name  varchar(20) null,
    email varchar(50) null
);

create table shopping_cart
(
    id         int auto_increment
        primary key,
    user_id    int         null,
    product_id int         null,
    stock      int         null,
    amount     double      null,
    status     varchar(10) null,
    date       datetime    null,
    constraint FK254qp5akhuaaj9n5co4jww3fk
        foreign key (user_id) references user (id),
    constraint FKerqg5bwr2tdlwabwdn7r4n2xo
        foreign key (product_id) references product (id)
);


