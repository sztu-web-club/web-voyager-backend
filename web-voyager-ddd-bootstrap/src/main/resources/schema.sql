create table if not exists contest
(
    id         bigint auto_increment
        primary key,
    name       varchar(200) not null comment '比赛名字',
    start_time datetime     not null comment '开始时间',
    end_time   datetime     not null comment '结束时间',
    desp       text         not null comment '比赛描述',
    private    tinyint(1)   not null comment '是否不公开'
);

create table if not exists problem
(
    id           bigint auto_increment comment '题目id'
        primary key,
    title        varchar(200)       not null comment '题目标题',
    description  text               not null comment '题目描述',
    hint         text               not null comment '题目提示',
    time_limit   double default 1   not null comment '题目时间限制(s)',
    memory_limit int    default 256 not null comment '题目内存限制(MB)',
    total_solved int    default 0   not null comment '平台上解出本题的用户数',
    total_submit int    default 0   not null comment '平台上本题的提交数',
    author_id    int                not null comment '本题作者的id',
    author_name  int                not null comment '本题作者的昵称'
);

create table if not exists solution
(
    id          bigint auto_increment
        primary key,
    problem_id  int           not null comment '题解对应的题目id',
    user_id     int           not null comment '提交题解的用户id',
    contest_id  int default 0 not null comment '归属的比赛id，如果不属于任何比赛则为0',
    time        int           not null comment '所用时间，ms',
    memory      int           not null comment '所用内存，kb',
    result      int           not null comment '执行结果',
    language    varchar(15)   not null comment '题解编程语言',
    code        text          not null comment '题解代码',
    passed_test int           null comment '通过的测试数',
    total_test  int           null comment '总共的测试数',
    judger_id   int           not null comment '评测机的id'
);

create table if not exists user
(
    id              bigint auto_increment comment '主键ID'
        primary key,
    username        varchar(30)                         not null comment '姓名',
    entry_year      int                                 not null comment '年龄',
    userid          varchar(50)                         not null comment '邮箱',
    password        varchar(30)                         not null comment '密码',
    nickname        varchar(30)                         not null comment '用户昵称',
    create_time     timestamp default CURRENT_TIMESTAMP not null comment '账号创建时间',
    sso_id          varchar(30)                         null comment '统一认证用户id',
    real_name       varchar(30)                         null comment '统一认证真实姓名',
    major           varchar(30)                         null comment '专业',
    role            enum ('user', 'admin', 'system')    not null comment '用户角色',
    solve_problem   int       default 0                 not null comment '已解决的问题',
    submit_solution int       default 0                 not null comment '已提交的次数'
);

