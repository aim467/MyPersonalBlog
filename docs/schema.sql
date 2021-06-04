-- MYBLOG.admin definition

CREATE TABLE `admin` (
                         `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员主键ID',
                         `nickname` varchar(20) DEFAULT NULL COMMENT '管理员昵称',
                         `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
                         `username` varchar(255) DEFAULT NULL COMMENT '用户名',
                         `password` varchar(255) DEFAULT NULL COMMENT '密码',
                         `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                         `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                         `status` int(11) DEFAULT NULL COMMENT '用户状态, 1:启用,0:禁用',
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- MYBLOG.article definition

CREATE TABLE `article` (
                           `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章的主键ID',
                           `title` varchar(255) DEFAULT NULL COMMENT '文章标题',
                           `introduce` varchar(500) DEFAULT NULL COMMENT '文章介绍，引言',
                           `content` longtext DEFAULT NULL COMMENT '正文',
                           `author` varchar(255) DEFAULT NULL COMMENT '作者名字',
                           `publish_time` datetime DEFAULT NULL COMMENT '发布时间',
                           `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                           `status` int(11) DEFAULT NULL COMMENT '文章状态。1:发布,0:草稿',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- MYBLOG.article_category definition

CREATE TABLE `article_category` (
                                    `article_id` int(11) NOT NULL DEFAULT 0 COMMENT '文章ID',
                                    `category_id` int(11) NOT NULL DEFAULT 0 COMMENT '分类ID',
                                    PRIMARY KEY (`article_id`,`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- MYBLOG.article_tag definition

CREATE TABLE `article_tag` (
                               `article_id` int(11) NOT NULL DEFAULT 0 COMMENT '文章ID',
                               `tag_id` int(11) NOT NULL DEFAULT 0 COMMENT '标签ID',
                               PRIMARY KEY (`article_id`,`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- MYBLOG.category definition

CREATE TABLE `category` (
                            `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类主键',
                            `name` varchar(255) DEFAULT NULL COMMENT '分类名字',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- MYBLOG.comment definition

CREATE TABLE `comment` (
                           `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论主键ID',
                           `commentator` varchar(255) DEFAULT NULL COMMENT '评论者',
                           `avatar` varchar(255) DEFAULT NULL COMMENT '评论者头像',
                           `content` varchar(255) DEFAULT NULL COMMENT '评论内容',
                           `article_id` int(11) DEFAULT NULL COMMENT '文章ID',
                           `parent_id` int(11) DEFAULT NULL COMMENT '评论父ID',
                           PRIMARY KEY (`id`),
                           KEY `article_id` (`article_id`),
                           CONSTRAINT `article_comment` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- MYBLOG.friend definition

CREATE TABLE `friend` (
                          `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '友链主键',
                          `name` varchar(255) DEFAULT NULL COMMENT '名字',
                          `url` varchar(255) DEFAULT NULL COMMENT '链接',
                          `avatar` varchar(255) DEFAULT NULL COMMENT '友链头像',
                          `description` varchar(255) DEFAULT NULL COMMENT '友链描述',
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- MYBLOG.message definition

CREATE TABLE `message` (
                           `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '留言主键ID',
                           `author` varchar(255) DEFAULT NULL COMMENT '留言者名字',
                           `avatar` varchar(255) DEFAULT NULL COMMENT '留言者头像',
                           `url` varchar(255) DEFAULT NULL COMMENT '留言者URL',
                           `content` varchar(255) DEFAULT NULL COMMENT '留言内容',
                           `create_time` datetime DEFAULT NULL COMMENT '留言时间',
                           `parent_id` int(11) DEFAULT NULL COMMENT '父留言ID',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- MYBLOG.tag definition

CREATE TABLE `tag` (
                       `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签主键ID',
                       `name` varchar(255) DEFAULT NULL COMMENT '标签名字',
                       PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- MYBLOG.log definition

create table `log`
(
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
    `username` VARCHAR(255) DEFAULT NULL COMMENT '登录用户',
    `ipaddress` VARCHAR(255) DEFAULT NULL COMMENT '登录IP',
    `login_time` datetime DEFAULT NULL COMMENT '登录时间',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;