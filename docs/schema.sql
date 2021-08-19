use blog;

create table admin
(
    id          int auto_increment comment '管理员主键ID'
        primary key,
    nickname    varchar(20) null comment '管理员昵称',
    avatar      varchar(255) null comment '头像',
    username    varchar(255) null comment '用户名',
    password    varchar(255) null comment '密码',
    email       varchar(255) null comment '邮箱',
    intro       varchar(255) null comment '个人简介',
    create_time datetime null comment '创建时间',
    update_time datetime null comment '修改时间',
    status      int null comment '用户状态, 1:启用,0:禁用'
) charset=utf8;

create table article_tag
(
    article_id int default 0 not null comment '文章ID',
    tag_id     int default 0 not null comment '标签ID',
    primary key (article_id, tag_id)
) charset=utf8;

create table category
(
    id   int auto_increment comment '分类主键'
        primary key,
    name varchar(255) null comment '分类名字'
) charset=utf8;

create table friend
(
    id          int auto_increment comment '友链主键'
        primary key,
    name        varchar(255) null comment '名字',
    url         varchar(255) null comment '链接',
    avatar      varchar(255) null comment '友链头像',
    description varchar(255) null comment '友链描述'
) charset=utf8;

create table log
(
    id         int auto_increment comment '日志ID'
        primary key,
    username   varchar(255) null comment '登录用户',
    ipaddress  varchar(255) null comment '登录IP',
    login_time datetime null comment '登录时间'
) charset=utf8;


create table message
(
    id          int auto_increment comment '留言主键ID'
        primary key,
    author      varchar(255) null comment '留言者名字',
    email       varchar(255) null comment '留言人邮箱',
    avatar      varchar(255) null comment '留言者头像',
    url         varchar(255) null comment '留言者URL',
    content     varchar(255) null comment '留言内容',
    create_time datetime default current_timestamp() null comment '留言时间',
    is_active   int(2) default 1 null,
    parent_id   int null comment '父留言ID'
) charset=utf8;

create table tag
(
    id   int auto_increment comment '标签主键ID'
        primary key,
    name varchar(255) null comment '标签名字',
    constraint name
        unique (name)
) charset=utf8;


create table article
(
    id           int auto_increment comment '文章的主键ID'
        primary key,
    title        varchar(255) null comment '文章标题',
    cover        varchar(255) null comment '文章封面图',
    introduce    varchar(500) null comment '文章介绍，引言',
    content      longtext null comment '正文',
    author       varchar(255) null comment '作者名字',
    publish_time datetime null comment '发布时间',
    update_time  datetime null comment '更新时间',
    status       int null comment '文章状态。1:发布,0:草稿',
    is_top       int default 0 null comment '是否置顶文章，1为是，0为否',
    is_recommend int default 0 null comment '是否为推荐文章，1为是，0为否',
    category_id  int null comment '分类ID',
    constraint articleCategory
        foreign key (category_id) references category (id)
            on update set null on delete set null
) charset=utf8;

create table comment
(
    id          int auto_increment comment '评论主键ID'
        primary key,
    commentator varchar(255) null comment '评论者',
    avatar      varchar(255) null comment '评论者头像',
    content     varchar(255) null comment '评论内容',
    is_active   int(2) default 1 null comment '删除状态位',
    email       varchar(255) null comment '邮箱',
    create_time datetime default current_timestamp() null comment '创建时间',
    article_id  int null comment '文章ID',
    parent_id   int null comment '评论父ID',
    constraint article_comment
        foreign key (article_id) references article (id)
            on update set null on delete set null
) charset=utf8;

create
index article_id
	on comment (article_id);


