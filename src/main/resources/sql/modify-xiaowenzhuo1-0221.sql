create table user
(
    id       int auto_increment comment '主键id 自增',
    name     varchar(255) null comment '用户名字',
    age      int          null comment '年龄',
    password varchar(255) null comment '密码',
    constraint user_pk
        primary key (id)
)
    comment '用户表';