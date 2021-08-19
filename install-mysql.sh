#!/bin/bash

echo "开始创建mysql容器"

# 容器的名字
name=blog-mysql
# 数据库的名字
database=blog
# mysql root 账户密码
root_pass=123456
# mysql 普通账户用户名
user_name=sa
# mysql 普通账户密码
user_pass=sa

# 运行一个mysql容器
docker run -d --name ${name} -e MYSQL_ROOT_PASSWORD=${root_pass} -e MYSQL_DATABASE=${database} -e MYSQL_USER=${user_name} -e MYSQL_PASSWORD=${user_pass} mysql:5.6 --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
echo "配置字符编码"

# 拷贝当前mysql配置到容器
docker cp ./docs/mysqld.cnf ${name}:/etc/mysql/mysql.conf.d/mysqld.cnf
