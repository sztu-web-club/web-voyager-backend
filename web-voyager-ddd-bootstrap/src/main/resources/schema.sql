drop table if exists `problem`;

create table problem
(
    id           bigint auto_increment comment '题目id'
        primary key,
    title        varchar(200)       not null comment '题目标题',
    description  text               not null comment '题目描述',
    hint         text               null comment '题目提示',
    time_limit   double default 1   not null comment '题目时间限制(s)',
    memory_limit int    default 256 not null comment '题目内存限制(MB)',
    total_solved int    default 0   not null comment '平台上解出本题的用户数',
    total_submit int    default 0   not null comment '平台上本题的提交数',
    author_id    int                not null comment '本题作者的id'
);

drop table if exists `user`;

create table user
(
    id         bigint auto_increment comment '主键ID'
        primary key,
    username   varchar(30)                         not null comment '姓名',
    entry_year  int                                 not null comment '年龄',
    userid     varchar(50)                         not null comment '邮箱',
    password   varchar(30)                         not null comment '密码',
    nickname   varchar(30)                         not null comment '用户昵称',
    create_time timestamp default CURRENT_TIMESTAMP not null comment '账号创建时间',
    sso_id      varchar(30)                         null comment '统一认证用户id',
    real_name   varchar(30)                         null comment '统一认证真实姓名',
    major      varchar(30)                         null comment '专业',
    role       enum ('user', 'admin', 'system')    not null comment '用户角色'
);

