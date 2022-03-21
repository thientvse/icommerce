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



create table roles
(
    id   int auto_increment
        primary key,
    name varchar(20) null
);

create table users
(
    id            bigint auto_increment
        primary key,
    email         varchar(50)                                             not null,
    password      varchar(120)                                            not null,
    username      varchar(20)                                             not null,
    phone         varchar(15)                                             null,
    company_name  varchar(255)                                            null,
    company_phone varchar(15)                                             null,
    logo_url      varchar(255)                                            null,
    create_at     datetime                    default current_timestamp() not null,
    update_at     datetime                    default current_timestamp() not null on update current_timestamp(),
    status        enum ('active', 'inactive') default 'active'            not null,
    constraint UK6dotkott2kjsp8vw4d0m25fb7
        unique (email),
    constraint UKdu5v5sr43g5bfnji4vb8hg5s3
        unique (phone),
    constraint UKr43af9ap4edm43mmtq01oddj6
        unique (username),
    constraint users_phone_uindex
        unique (phone)
);

create table refresh_token
(
    id          bigint       not null
        primary key,
    expiry_date datetime     not null,
    token       varchar(255) not null,
    user_id     bigint       null,
    constraint UK_r4k4edos30bx9neoq81mdvwph
        unique (token),
    constraint FKjtx87i0jvq2svedphegvdwcuy
        foreign key (user_id) references users (id)
            on delete cascade
);

create table user_roles
(
    user_id bigint not null,
    role_id int    not null,
    primary key (user_id, role_id),
    constraint FKh8ciramu9cc9q3qcqiv4ue8a6
        foreign key (role_id) references roles (id),
    constraint FKhfh9dx7w3ubf1co1vdev94g3f
        foreign key (user_id) references users (id)
            on delete cascade
);


