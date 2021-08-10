# 关于项目

该项目是基于 `SpringBoot` + `Mybatis` 实现的个人博客系统。

主要的使用的技术和软件如下：

* SpringBoot
* Mybatis
* Maven
* MySQL
* Idea

该项目的主要特性如下：

* 使用阿里云OSS管理静态资源
* 在编写文章时实现粘贴图片上传到阿里云OSS
* 后台管理提供多种样式选择
* ...

对于一个个人博客来说，这个博客系统还是有很多不完美的地方，只是达到了一个最基础最基础的博客系统该有的功能，在未来的话，我会持续为这个博客进行优化，争取做的更好。

## 效果预览

首页

![](docs/index.png)

分类页

![](docs/category.png)

文章详情页

![](docs/detail.png)

后台登录页

![](docs/login.png)

文章管理页

![](docs/backadmin.png)

## 如何使用

请在 `application.dev.yml` 中配置数据库信息，数据库脚本已经导入 `docs` 文件夹，在 `admin` 表内创建一个帐号，记得密码使用 `MD5Utils` 类加密；最后在 `application.yml`
中配置阿里云OSS配置属性，然后就可以运行了。
