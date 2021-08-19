use blog;

insert into blog.admin (id, nickname, avatar, username, password, email, intro, create_time, update_time, status)
values (1, 'Kaby', '/Image/1836320210607.jpeg', 'admin', 'd16f5d0247e4c6aa97f6bb4477b85c32', 'admin@qq.com',
        '这个人很懒，什么都没留下', '2017-07-26 00:38:14', '2017-07-26 00:38:14', 1);


insert into blog.tag (id, name)
values (43, 'Django');
insert into blog.tag (id, name)
values (42, 'Flask');
insert into blog.tag (id, name)
values (48, 'Mybatis');
insert into blog.tag (id, name)
values (49, 'Python');
insert into blog.tag (id, name)
values (45, 'Spring');
insert into blog.tag (id, name)
values (47, 'SpringBoot');
insert into blog.tag (id, name)
values (46, 'SpringCloud');
insert into blog.tag (id, name)
values (50, 'SSH');
insert into blog.tag (id, name)
values (44, 'SSM');

insert into blog.category (id, name)
values (20, '读书笔记');
insert into blog.category (id, name)
values (21, '技术杂烩');
insert into blog.category (id, name)
values (22, '生活记录');
insert into blog.category (id, name)
values (23, '源码阅读');
insert into blog.category (id, name)
values (24, '后端开发');
insert into blog.category (id, name)
values (25, '前端开发');

insert into blog.article_tag (article_id, tag_id)
values (14, 42);
insert into blog.article_tag (article_id, tag_id)
values (14, 43);
insert into blog.article_tag (article_id, tag_id)
values (15, 42);
insert into blog.article_tag (article_id, tag_id)
values (15, 49);
insert into blog.article_tag (article_id, tag_id)
values (16, 42);
insert into blog.article_tag (article_id, tag_id)
values (17, 42);
insert into blog.article_tag (article_id, tag_id)
values (18, 47);
insert into blog.article_tag (article_id, tag_id)
values (19, 47);
insert into blog.article_tag (article_id, tag_id)
values (20, 44);
insert into blog.article_tag (article_id, tag_id)
values (20, 50);


insert into blog.friend (id, name, url, avatar, description)
values (3, 'test1', 'https://www.baidu.com', 'https://p.qqan.com/up/2021-2/16137992358831160.jpg', '暂无');



insert into blog.message (id, author, email, avatar, url, content, create_time, is_active, parent_id)
values (1, 'owenzhang24', 'admin@qq.com', 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJAAAACQAQMAAADdiHD7AAAABlBMVEVQZ5bw8PAGFcRsAAAAP0lEQVRIx2P4jwEYhp/QBwYGfhgPzB4VGhUaFRpIIQawKIwxKjQkhZAiFbX0HRUaUkKQGIUD/lGhoSk0/NtyAAeWKiuFqzdLAAAAAElFTkSuQmCC
', 'https://www.baidu.com', '感谢你的分享', '2021-07-15 10:11:59', 1, -1);
insert into blog.message (id, author, email, avatar, url, content, create_time, is_active, parent_id)
values (2, 'zzzvvvxxxd', 'admin@qq.com', 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJAAAACQAQMAAADdiHD7AAAABlBMVEVQUFDw8PBGMhEgAAAAPElEQVRIx2P4jwEYhp/QBwYUwD8qNDSFgOADgg+L7VGhoSb0AcxCIkeFhqTQSKg7Rkj9OJqiR/PjEBACALC0KiubQXtsAAAAAElFTkSuQmCC
', 'https://www.baidu.com', '招聘必须base杭州么', '2021-07-15 10:22:41', 1, -1);
insert into blog.message (id, author, email, avatar, url, content, create_time, is_active, parent_id)
values (3, 'owenzhang24', 'admin@qq.com', 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJAAAACQAQMAAADdiHD7AAAABlBMVEVQpFDw8PD7hue9AAAAQ0lEQVRIx2P4jwEYhp/QBwYG/v/I5KjQkBQaCWl1hAgBYxQC+EeFhqzQBxgHxhgVGpJCEPABGq9IuXZUaAgKDee6AwDFjAFimbdqBgAAAABJRU5ErkJggg==
', 'https://www.baidu.com', '不，我在厦门工作', '2021-07-15 10:23:34', 1, -1);
insert into blog.message (id, author, email, avatar, url, content, create_time, is_active, parent_id)
values (4, 'barretlee', 'admin@qq.com', 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJAAAACQAQMAAADdiHD7AAAABlBMVEVQUFDw8PBGMhEgAAAAOElEQVRIx2P4jwEYhqXQBwYGfhg5KjR0hUZCWh32QsjxCiZHhYawEASMCg1pIWQwKjREhYZ/3QEAyWG5m2f69o8AAAAASUVORK5CYII=
', 'https://www.baidu.com', '也不是，如果对阿里感兴趣，可以帮你推其他 BU 的。淘宝这边主要是杭州。', '2021-07-15 10:24:30', 1, 2);
insert into blog.message (id, author, email, avatar, url, content, create_time, is_active, parent_id)
values (5, 'suzhigao', 'admin@qq.com', 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJAAAACQAQMAAADdiHD7AAAABlBMVEWXdcrw8PCRA56YAAAAPElEQVRIx2P4jwEYhp/QBwYUwD8qNDSFgOADgg+L7VGhoSb0AcxCIkeFhqTQSKg7RuvHUaEhVD8O87QKAGGLmqxtQaOEAAAAAElFTkSuQmCC
', 'https://www.baidu.com', '你好大佬。我最近建了一个博客 http://suzhigao66.top/， 可以加个友链吗？希望有机会跟大佬学习，谢谢。已添加您为友链。',
        '2021-07-15 11:07:50', 1, -1);
insert into blog.message (id, author, email, avatar, url, content, create_time, is_active, parent_id)
values (6, 'yejr', 'admin@qq.com', 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJAAAACQAQMAAADdiHD7AAAABlBMVEWeslDw8PA/xPpbAAAAPUlEQVRIx2P4jwEYhp/QBwYG/v/I5KjQkBQaCWl15AhBonZUaKgLjaboYVA/MsDKWQZ46TsqNNSEhn9aBQD2M9iKAFwdlQAAAABJRU5ErkJggg==
', 'https://www.baidu.com',
        'Hi 小胡子哥，首先感谢 https://md.rmiao.top/。也给个建议哈，就是能不能记住客户端的cookie，用户提交过的内容，记住方便多次反复修改，要不然一不小心刷新浏览器，就啥都没了，再次感谢。',
        '2021-07-15 11:08:39', 1, -1);
insert into blog.message (id, author, email, avatar, url, content, create_time, is_active, parent_id)
values (16, 'dsds', 'admin@qq.com', 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJAAAACQAQMAAADdiHD7AAAABlBMVEVQ02nw8PA9V2xJAAAAOUlEQVRIx2P4jwEYRoVGhQat0AcGBn4YOSo0dIX+I/ijQkNVCMhhgEUtmDEqNCSFRlP0cBIazm0AAISz2IpkTNOJAAAAAElFTkSuQmCC
', 'https://www.baidu.com', '大佬，链接失效了，麻烦再补下', '2021-07-15 15:39:27', 1, -1);
insert into blog.message (id, author, email, avatar, url, content, create_time, is_active, parent_id)
values (19, 'DopamineLCY ', 'admin@qq.com', 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJAAAACQAQMAAADdiHD7AAAABlBMVEXczlDw8PBBdlzyAAAAOElEQVRIx2P4jwEYhqvQBwYG/lGhoSyExIGwR4WGqhAyGBUaukKjKXrY5Ef+/3DGqNCQFBr+bTkAzscqK0ZUmCYAAAAASUVORK5CYII=
', 'https://www.baidu.com', '狂おしいほど僕には美しい', '2021-07-15 19:11:10', 1, -1);
insert into blog.message (id, author, email, avatar, url, content, create_time, is_active, parent_id)
values (20, '睡不醒的十九月', 'admin@qq.com', 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJAAAACQAQMAAADdiHD7AAAABlBMVEXczlDw8PBBdlzyAAAAOElEQVRIx2P4jwEYhqvQBwYG/lGhoSyExIGwR4WGqhAyGBUaukKjKXrY5Ef+/3DGqNCQFBr+bTkAzscqK0ZUmCYAAAAASUVORK5CYII=
', 'https://www.baidu.com', '这首歌太狂太好听了', '2021-07-15 19:12:07', 1, 19);
insert into blog.message (id, author, email, avatar, url, content, create_time, is_active, parent_id)
values (21, '三屰', 'admin@qq.com', 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJAAAACQAQMAAADdiHD7AAAABlBMVEXczlDw8PBBdlzyAAAAOElEQVRIx2P4jwEYhqvQBwYG/lGhoSyExIGwR4WGqhAyGBUaukKjKXrY5Ef+/3DGqNCQFBr+bTkAzscqK0ZUmCYAAAAASUVORK5CYII=
', 'https://www.baidu.com', ' 【まじ娘】majiko - 狂おしいほど僕には美しい [MV] 这个mv有人搬过！真的绝', '2021-07-15 19:12:07', 1, 19);
insert into blog.message (id, author, email, avatar, url, content, create_time, is_active, parent_id)
values (22, '
水煮硝酸钾 ', 'admin@qq.com', 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJAAAACQAQMAAADdiHD7AAAABlBMVEXczlDw8PBBdlzyAAAAOElEQVRIx2P4jwEYhqvQBwYG/lGhoSyExIGwR4WGqhAyGBUaukKjKXrY5Ef+/3DGqNCQFBr+bTkAzscqK0ZUmCYAAAAASUVORK5CYII=
', 'https://www.baidu.com', '+1！！', '2021-07-15 19:12:07', 1, 19);
insert into blog.message (id, author, email, avatar, url, content, create_time, is_active, parent_id)
values (23, '
uni_樱奈', 'admin@qq.com', 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJAAAACQAQMAAADdiHD7AAAABlBMVEXczlDw8PBBdlzyAAAAOElEQVRIx2P4jwEYhqvQBwYG/lGhoSyExIGwR4WGqhAyGBUaukKjKXrY5Ef+/3DGqNCQFBr+bTkAzscqK0ZUmCYAAAAASUVORK5CYII=
', 'https://www.baidu.com', ' 这首入坑！！！', '2021-07-15 19:12:07', 1, 19);
insert into blog.message (id, author, email, avatar, url, content, create_time, is_active, parent_id)
values (24, '彻夜疯歌', 'admin@qq.com', 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJAAAACQAQMAAADdiHD7AAAABlBMVEXczlDw8PBBdlzyAAAAOElEQVRIx2P4jwEYhqvQBwYG/lGhoSyExIGwR4WGqhAyGBUaukKjKXrY5Ef+/3DGqNCQFBr+bTkAzscqK0ZUmCYAAAAASUVORK5CYII=
', 'https://www.baidu.com', '感谢，有被安利到。', '2021-07-15 19:12:07', 1, 21);
insert into blog.message (id, author, email, avatar, url, content, create_time, is_active, parent_id)
values (29, 'aweweee', '709544711@qq.com', 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJAAAACQAQMAAADdiHD7AAAABlBMVEXczlDw8PBBdlzyAAAAOElEQVRIx2P4jwEYhqvQBwYG/lGhoSyExIGwR4WGqhAyGBUaukKjKXrY5Ef+/3DGqNCQFBr+bTkAzscqK0ZUmCYAAAAASUVORK5CYII=
', 'https://www.baidu.com', 'waeaweeeeeeeeeeeeee', '2021-08-02 17:19:34', 1, -1);


insert into blog.article (id, title, cover, introduce, content, author, publish_time, update_time, status, is_top,
                          is_recommend, category_id)
values (14, 'Mybatis笔记', 'https://tva1.sinaimg.cn/large/87c01ec7gy1frmrxuzha8j21hc0u0gur.jpg', 'Mybatis笔记',
        '# Mybatis https://www.kancloud.cn/digest/andyalien-mybatis https://juejin.cn/post/6844903858477481992 https://www.letianbiji.com/mybatis/ https://aiden-dong.github.io/2018/08/26/Mybatis%E7%AF%87%E4%B9%8BMybatis%E6%B3%A8%E8%A7%A3%E5%BC%80%E5%8F%91/ https://blog.csdn.net/u010858605/article/details/70157980 ## 全局配置 &gt; 这里只记录顶层节点下的字节点。 ### `environments` ```xml              ``` * 一个 `environments` 可以包含多个 `environment` * `environments` 的 `defualt` 决定了使用哪个环境，这个属性值对应了 `environment` 的 `id` 属性 * `transactionManager` 可以使用 `jdbc` 和 `managed` 两种事务管理方式 * `datasource` 可以指定3种数据库连接池 * POOLED：使用Mybatis自带的数据库连接池来管理数据库连接 * UNPOOLED：不使用任何数据库连接池来管理数据库连接 * JNDI：jndi形式使用数据库连接、主要用于项目正常使用的时候 ### `properties` ```xml    ``` 此配置用于从外部文件中引用配置，从外部引入配置之后，使用 `${}` 就可以访问配置，同时，如果在 `properteis` 里面定义了相同的属性，那么还是外部配置文件中的配置优先级更高。 ### `settings` ```xml    ``` 一个 `settings` 可以有多个 `setting`，每个 `setting` 使用一个 `name` 和 一个 `value` 来指定键值对。 ### `mappers` `mappers` 里面存放多个 `mapper` 用于映射 `dao` 层。 &gt; 四种 `mapper` 文件配置方式。 1、当mapper文件与java文件在同一目录下 ( 非注解方式 )，且 mapper文件和 java文件名一致，配置如下： ```xml        ``` 2、当 mapper文件与java文件在同一包下，且mapper文件与java文件名一致，配置如下： ```xml      ``` 3、Mapper 的xml配置文件单独放置到 resources 中，和Mapper 类分开了，这种方式的好处是便于统一管理 xml 配置文件，不好的的地方是无法使用注解模式了 ```xml        ``` ### `typeAliases` `mybatis` 提供的 `typeAlias` | 别名 | 映射的类型 | | ---------- | ---------- | | _byte | byte | | _long | long | | _short | short | | _int | int | | _integer | integer | | _double | double | | _float | float | | _boolean | boolan | | string | String | | byte | Byte | | long | Long | | short | Short | | int | Integer | | integer | Integer | | double | Double | | float | Float | | boolean | Boolean | | object | Object | | map | Map | | hashMap | HashMap | | list | List | | arraylist | ArrayList | | collection | Collection | | iterator | Iterator | `typeAliases` 为根元素类型，底下有两个元素， `typeAlias/packae`。 * `typeAlias` 提供一个 `type`属性填写需要别名的类，使用 `alias` 属性来定义别名，在查看源码的时候我发现 `alias` 为 `implied`，也就是隐式，可以说默认不填为类名小写。 * `package` 则是针对包扫描的别名，而不是像 `typeAlias` 需要一个类一个类去配置别名。 基于上面的配置完成之后，`resultType/paramaterType`就可以传递别名了，而不必写确切的名字。 &gt; 那如果为多个包下的类配置类型别名，但是不同的包下有相同的类名，导致别名对应到的类不唯一，怎么办？ &gt; &gt; 这个时候就需要使用 `@Alias` 注解了，这个注解注解在类上。 ### 总结 ```xml                                         ``` ## 分页 分页无非就两种形式，一种是逻辑分页，一种是物理分页。 #### 物理分页 物理分页就是使用 `limit` 进行操作，而通常在 `mapper` 里面传递这两个参数就行。 ```java @Test public void getUserByLimit() { SqlSession sqlSession = MybatisUtils.getSqlSession(); UserMapper mapper = sqlSession.getMapper(UserMapper.class); HashMap stringObjectHashMap = new HashMap(); stringObjectHashMap.put("index", 0); stringObjectHashMap.put("pagesize", 2); List userList = mapper.getUserByLimit(stringObjectHashMap); for (User user : userList) { System.out.println(user); } sqlSession.close(); } ``` ```xml  select * from mybatis.user limit #{index},#{pagesize}  ``` #### RowBounds 分页 ```java /** 使用RowBounds只需要在参数中传递一个RowBounds对象就行了 */ @Test public void getsUserByRowBounds() { SqlSession sqlSession = MybatisUtils.getSqlSession(); UserMapper mapper = sqlSession.getMapper(UserMapper.class); List userList = mapper.getUseByRowBounds(new RowBounds(0, 3)); for (User user : userList) { System.out.println(user); } sqlSession.close(); } ``` ```xml  select * from user;  ``` ```java public class RowBounds { public static final int NO_ROW_OFFSET = 0; public static final int NO_ROW_LIMIT = Integer.MAX_VALUE; public static final RowBounds DEFAULT = new RowBounds(); private final int offset; private final int limit; public RowBounds() { this.offset = NO_ROW_OFFSET; this.limit = NO_ROW_LIMIT; } public RowBounds(int offset, int limit) { this.offset = offset; this.limit = limit; } public int getOffset() { return offset; } public int getLimit() { return limit; } } ``` `RowBounds` 其实也是传递一个 `limit` 参数来进行物理分页。 #### 逻辑分页 ## 一对多/多对多/一对一 按照结果嵌套处理： &gt; 先使用sql语句查询出结果，设置一个 as 别名 &gt; &gt; 然后利用 `` 来设置值，其实效果就等同于下方的注释里面的方法。 ```xml  select s.id sid,s.name sname,t.name as tname from mybatis.student s,mybatis.teacher t where s.tid=t.id          ``` 不使用结果嵌套处理，直接 `resultMap` 里面嵌套 `select` 查询： ```xml   select * from student          select * from teacher where id = #{id}  ``` ```xml      select s.name sname, s.id sid, t.name tname, t.id tid from mybatis.student s, mybatis.teacher t where s.tid = t.id and t.id = #{tid}               select * from teacher where id = #{tid}       select * from student where tid = #{tid}   ``` ```xml       select s.id sid, s.name sname, t.name as tname from mybatis.student s, mybatis.teacher t where s.tid = t.id            select * from student          select * from teacher where id = #{id}   ``` ## 缓存 ### 一级缓存 &gt; 一级缓存也叫本地缓存 - 与数据库同一次会话期间查询到的数据会在本地缓存中 - 以后如果需要获取相同的数据，直接从缓存中拿，没必须再去查询数据库 重点：同一 `session` &gt; 总结：一级缓存默认是开启的，只在一次 `SqlSession` 中有效，也就是拿到连接到关闭连接这个区间段！ ### 二级缓存 &gt; 二级缓存也叫全局缓存，一级缓存作用于太低了，所以诞生了二级缓存 &gt; &gt; 基于 `namespace` 级别的缓存，一个名称空间，对应一个二级缓存 工作机制 * 一个会话查询一条数据，这个数据就会被放在当前会话的一级缓存中 * 如果当前会话关闭了，这个会话对应的一级缓存就没了；但是我们想要的是，会话关闭了，一级缓存中的数据被保存到二级缓存中 * 新的会话查询信息，就可以从二级缓存中获取内容 * 不同的 `mapper` 查出的数据会放在自己对应的缓存（map）中 ```xml     ``` 在映射文件中开启缓存： ```xml           ``` 开启缓存后要将实体类序列化 ### 缓存原理 ![](https://img-blog.csdnimg.cn/20200528164008881.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmdsZWkxOTg5MTIxMA==,size_16,color_FFFFFF,t_70)',
        'rootz', '2020-07-30 07:45:04', '2021-08-13 16:33:32', 1, 1, 1, 22);
insert into blog.article (id, title, cover, introduce, content, author, publish_time, update_time, status, is_top,
                          is_recommend, category_id)
values (15, 'aiohttp翻译', 'https://tva1.sinaimg.cn/large/0060lm7Tly1ftg6xaqdu6j31hc0u0x4k.jpg', 'aiohttp翻译', '# Client Quickstart

想开始吗? 这个页面很好的介绍了如何使用 aiohttp 客户端 api。

第一，确保 aiohttp 已经被安装和更新。

让我们从一些简单的例子开始。

## 发起请求

首先导入 aiohttp 模块:

```Python
import aiohttp
```

现在，让我们尝试获取一个 web 页面，例如：查询 `http://httpbin.org/get`:

```Python
async with aiohttp.ClientSession() as session:
    async with session.get(''http://httpbin.org/get'') as resp:
        print(resp.status)
        print(await resp.text())
```

现在，我们有一个名为`session`的 **ClientSession** 和一个名为`resp`的**ClientResponse**对象。我们可以从 response 中获取我们需要的所有信息。`ClientSession.get()`协程的强制参数是一个HTTP `url` `(str or class:yarl.URL instance)。`

为了发起 `HTTP POST` 请求，请使用 `ClientSession.post()` 协同程序:

```Python
session.post(''http://httpbin.org/post'', data=b''data'')
```

其他的 `HTTP` 方法也可以用:

```Python
session.put(''http://httpbin.org/put'', data=b''data'')
session.delete(''http://httpbin.org/delete'')
session.head(''http://httpbin.org/get'')
session.options(''http://httpbin.org/get'')
session.patch(''http://httpbin.org/patch'', data=b''data'')
```

> **Note**
>
> 不要为每个请求创建会话。很可能每个应用程序都需要一个会话来完成所有请求。
>
> 更复杂的情况可能需要每个站点的会话，例如，一个用于Github，另一个用于Facebook API。无论如何，为每个请求进行会话是一个非常糟糕的主意。
>
> 会话内部包含连接池。连接重用和保持活动（两者都默认打开）可以加快总体性能。

使用会话管理上下文不是必须的，但是 `await session.close()` 方法应该被调用，就像下面的例子一样：

```Python
session = aiohttp.ClientSession()
async with session,get(''.....'')

await session.close()
```

## 在URL中传递参数

你通常希望在URL的查询字符串中发送某种类型的数据。如果你手工构造URL，这个数据将在问号后作为URL中的键/值对给出，例如：`httpbin.org/get?key=val`。请求允许你使用params关键字参数将这些参数作为dict提供。例如，如果要将 `key1 = value1` 和 `key2 = value2` 传递给 `httpbin.org/get` ，则可以使用以下代码：

```Python
params = {''key1'': ''value1'', ''key2'': ''value2''}
async with session.get(''http://httpbin.org/get'',
                       params=params) as resp:
    expect = ''http://httpbin.org/get?key2=value2&key1=value1''
    assert str(resp.url) == expect
```

你可以通过打印URL看到URL已正确编码。

对于为同一个键发送具有多个值的数据，也可以使用`MultiDict`。

也可以将2个项元组的列表作为参数传递，在这种情况下，你可以为每个键指定多个值：

```Python
params = [(''key'', ''value1''), (''key'', ''value2'')]
async with session.get(''http://httpbin.org/get'',
                       params=params) as r:
    expect = ''http://httpbin.org/get?key=value2&key=value1''
    assert str(r.url) == expect
```

你也可以将字符串内容作为参数传递，但要注意 - 内容不是由库编码的。请注意，+未编码：

```Python
async with session.get(''http://httpbin.org/get'',
                       params=''key=value+1'') as r:
        assert str(r.url) == ''http://httpbin.org/get?key=value+1''
```

## 响应内容和状态码

我们可以阅读服务器响应的内容及其状态代码。再次考虑GitHub时间线：

```Python
async with session.get(''https://api.github.com/events'') as resp:
    print(resp.status)
    print(await resp.text())
```

打印出如下内容：

```Python
200
''[{"created_at":"2015-06-12T14:06:22Z","public":true,"actor":{...
```

aiohttp自动解码服务器中的内容。你可以为 `text()` 方法指定自定义编码：

```Python
await resp.text(encoding=''windows-1251'')
```

## 二进制响应内容

对于非文本请求，你还可以以字节为单位访问响应正文：

```Python
print(await resp.read())
b''[{"created_at":"2015-06-12T14:06:22Z","public":true,"actor":{...
```

`gzip` 和 `deflate` 传输编码会自动为您解码。

你可以启用 `brotli transfer-encodings` 支持，只需安装 `brotlipy` 即可。

## JSON 请求

任何会话的请求方法，如 `request()`，`ClientSession.get()` ，`ClientSesssion.post()` 等，都接受json参数：

```Python
async with aiohttp.ClientSession() as session:
    async with session.post(url, json={''test'': ''object''})
```

默认情况下，会话使用`python`的标准`json`模块进行序列化。但是可以使用不同的序列化器。 `ClientSession`接受`json_serialize`参数：

```python
import ujson

async with aiohttp.ClientSession(
        json_serialize=ujson.dumps) as session:
    await session.post(url, json={''test'': ''object''})
```

> **Note**
>
> `ujson` 比标准 `json` 库更快但是两者不兼容

## JSON 响应内容

如果你正在处理`JSON`数据，还有一个内置的`JSON`解码器：

```Python
async with session.get(''https://api.github.com/events'') as resp:
    print(await resp.json())
```

如果 `json` 解码失败，`json()` 方法将会引发异常，可以为`json()`调用指定自定义编码和解码器函数。

## 流体响应内容

方法`read()`，`json()`和`text()`非常方便，你应该仔细使用它们。所有这些方法都将整个响应加载到内存中。例如，如果要下载几千兆字节大小的文件，这些方法将加载内存中的所有数据。相反，您可以使用content属性。它是`aiohttp.StreamReader`类的一个实例。 `gzip`和`deflate`传输编码会自动为你解码：

```Python
async with session.get(''https://api.github.com/events'') as resp:
    await resp.content.read(10)
```

但是，一般情况下，您应该使用这样的模式来保存流式传输到文件的内容：

```python
with open(filename, ''wb'') as fd:
    while True:
        chunk = await resp.content.read(chunk_size)
        if not chunk:
            break
        fd.write(chunk)
```

## 更复杂的 POST 请求

通常，你想发送一些表单数据 - 很像 HTML 表单，为此，只需要将字典传递给`data`参数即可，在发出请求时，你的字典数据将自动进行表单编码：

```Python
payload = {''key1'': ''value1'', ''key2'': ''value2''}
async with session.post(''http://httpbin.org/post'',
                        data=payload) as resp:
    print(await resp.text())
```

```Python
{
  ...
  "form": {
    "key2": "value2",
    "key1": "value1"
  },
  ...
}
```

如果要发送非表单编码的数据，可以通过传递字节而不是字典来完成。数据将直接被发送，内容类型默认设置为 `application / octet-stream`：

```Python
async with session.post(url, data=b''\\x00Binary-data\\x00'') as resp:
    ...
```

如果你想发送 `json`数据：

```Python
async with session.post(url, json={''example'': ''test''}) as resp:
    ...
```

要使用适当的内容类型发送文本，只需使用文本属性：

```Python
async with session.post(url, data=''Тест'') as resp:
    ...
```

## 发送多编码文件

上传多编码文件：

```Python
url = ''http://httpbin.org/post''
files = {''file'': open(''report.xls'', ''rb'')}

await session.post(url, data=files)
```

你可以明确的设置文件名和内容类型

```Python
url = ''http://httpbin.org/post''
data = FormData()
data.add_field(''file'',
               open(''report.xls'', ''rb''),
               filename=''report.xls'',
               content_type=''application/vnd.ms-excel'')

await session.post(url, data=data)
```

如果将文件对象作为数据参数传递，`aiohttp`将自动将其传输到服务器。检查`StreamReader`以获取支持的格式信息。

## 流式上传

`aiohttp`支持多种类型的流式上传，允许你发送大型文件而无需将其读入内存。

作为一个简单的例子，只需为你的请求体提供类似文件的对象：

```Python
with open(''massive-body'', ''rb'') as f:
   await session.post(''http://httpbin.org/post'', data=f)
```

或者你也可以使用异步生成器：

```Python
async def file_sender(file_name=None):
    async with aiofiles.open(file_name, ''rb'') as f:
        chunk = await f.read(64*1024)
        while chunk:
            yield chunk
            chunk = await f.read(64*1024)

# Then you can use file_sender as a data provider:

async with session.post(''http://httpbin.org/post'',
                        data=file_sender(file_name=''huge_file'')) as resp:
    print(await resp.text())
```

由于`content`属性是`StreamReader`（提供异步迭代器协议），因此你可以将获取和发布请求链接在一起：

```Python
resp = await session.get(''http://python.org'')
await session.post(''http://httpbin.org/post'',
                   data=resp.content)
```

## WebSockets

aiohttp可与开箱即用的客户端`websockets`配合使用。', 'rootz', '2019-07-31 00:26:39', '2021-07-31 00:29:49', 1, 1, 0, 21);
insert into blog.article (id, title, cover, introduce, content, author, publish_time, update_time, status, is_top,
                          is_recommend, category_id)
values (16, 'Flask源码阅读1', 'https://tva2.sinaimg.cn/large/0060lm7Tly1ftg6xehevfj31hc0u0b29.jpg', 'Flask源码阅读1', 'Contents
===

- [Local](https://github.com/Microndgt/dive-in-Flask/blob/master/Context.md#local)
- [LocalProxy](https://github.com/Microndgt/dive-in-Flask/blob/master/Context.md#localproxy)
- [LocalStack](https://github.com/Microndgt/dive-in-Flask/blob/master/Context.md#localstack)
- [上下文栈](https://github.com/Microndgt/dive-in-Flask/blob/master/Context.md#上下文栈)
  - [请求上下文](https://github.com/Microndgt/dive-in-Flask/blob/master/Context.md#请求上下文)
  - [应用上下文](https://github.com/Microndgt/dive-in-Flask/blob/master/Context.md#应用上下文)

Contents Created by [Toggle](https://github.com/Microndgt/toggle)

flask中有应用上下文和请求上下文，关于请求上下文在上一节Request已经介绍过了。本节主要关注上下文栈是如何运作的，以及应用上下文的相关东西。

> 每一段程序都有很多外部变量。只有像Add这种简单的函数才是没有外部变量的。一旦你的一段程序有了外部变量，这段程序就不完整，不能独立运行。你为了使他们运行，就要给所有的外部变量一个一个写一些值进去。这些值的集合就叫上下文。 – vzch

在 flask 中，视图函数需要知道它执行情况的请求信息（请求的 url，参数，方法等）以及应用信息（应用中初始化的数据库以及一些参数等），才能够正确运行。

最直观地做法是把这些信息封装成一个对象，作为参数传递给视图函数。但是这样的话，所有的视图函数都需要添加对应的参数，即使该函数内部并没有使用到它。

那么另外一种思路就是类似全局变量的东西，需要的时候使用`from flask import request`获取，但是这个全局变量必须是线程独立的，也就是每个请求所在的线程得到的请求对象必须是不一样的，不会互相干扰。

Werkzeug中实现了类似于本地线程`threading.local`的类Local，通过这个Local实现了LocalStack和LocalProxy，而上下文栈则是使用LocalStack来建立起来的。

Local
===

多线程中有个非常类似的概念 threading.local，可以实现多线程访问某个变量的时候只看到自己的数据。这个对象有一个字典，保存了线程 id 对应的数据，读取该对象的时候，它动态地查询当前线程 id 对应的数据。下面的Local实现了一个类似线程独立的数据访问，代码如下：

```
try:
  from greenlet import getcurrent as get_ident
except ImportError:
  try:
    from thread import get_ident
  except ImportError:
    from _thread import get_ident
class Local(object):
  __slots__ = (''__storage__'', ''__ident_func__'')

  def __init__(self):
    # 存储的key是每一个线程的id
    object.__setattr__(self, ''__storage__'', {})
    # 这个属性是一个函数对象
    object.__setattr__(self, ''__ident_func__'', get_ident)

  def __iter__(self):
    return iter(self.__storage__.items())

  def __call__(self, proxy):
    """Create a proxy for a name."""
    return LocalProxy(self, proxy)

  def __release_local__(self):
    # 将当前线程id代表的key-value pop掉
    self.__storage__.pop(self.__ident_func__(), None)

  def __getattr__(self, name):
    # 获取当前线程的数据
    try:
      return self.__storage__[self.__ident_func__()][name]
    except KeyError:
      raise AttributeError(name)

  def __setattr__(self, name, value):
    # 为当前线程设置属性
    ident = self.__ident_func__()
    storage = self.__storage__
    try:
      storage[ident][name] = value
    except KeyError:
      storage[ident] = {name: value}

  def __delattr__(self, name):
    try:
      del self.__storage__[self.__ident_func__()][name]
    except KeyError:
      raise AttributeError(name)
```

可以看到这个类暴露了两个属性`__storage__`和`__ident_func__`，其中`__storage__`保存了线程状态，其key为线程（或者协程）id，对应的值是一个包含线程内部信息的字典。而`__ident_func__`是根据不同情况的获取线程（或者协程）id的函数。实现了析构，`__getattr__`, `__setattr__`, `__delattr__`等操作，但是都是对于某一个线程id来操作的。其中`__getattr__`和`__getattribute__`都是访问属性的方法，区别在于，默认情况会调用`__getattribute__`，若没有找到这个属性则会调用`__getattr__`。

`__call__` 操作来创建一个 LocalProxy 对象，比如`local = Local();test_proxy = local(''test'');test_proxy.__repr__`，这样就把对test属性的访问做成了一个LocalProxy。LocalProxy的作用是可以动态的去产生相应的对象，而不是一开始定义好之后就不能变化了。

LocalProxy
===

LocalProxy 是一个Local对象的代理，负责把所有对自己的操作转发给内部的Local对象。LocalProxy 的构造函数接受一个callable的参数或者直接是一个Local对象，而这个callable 调用之后需要返回一个Local实例，后续所有的属性操作都会转发给 callable 返回的对象。

```
@implements_bool
class LocalProxy(object):
  # 私有对象在类中存储的名字为 _类名__属性名,这样的属性不会派生给子类
  __slots__ = (''__local'', ''__dict__'', ''__name__'')

  def __init__(self, local, name=None):
    # 将获取local的可调用对象传入或者是local对象，并且设置要代理对象的名字，_LocalProxy__local表示的对于这个目前这个类的属性，不会继承
    object.__setattr__(self, ''_LocalProxy__local'', local)
    object.__setattr__(self, ''__name__'', name)

  def _get_current_object(self):
    """
    返回目前的对象，如果基于性能原因想要在代理之后真实的对象或者你想传递一个对象到不同的上下文中
    """
    # 获取当前代理的实际对象，如果没有__release_local__则说明是一个函数对象，直接返回函数返回的对象
    # 可以看出来，如果实例化传递的是一个函数，那么该方法会返回函数调用后产生的对象，也就是说代理到函数返回的对象上了
    # 如果是传递一个对象和属性名的话，就会返回该对象中该name的属性
    if not hasattr(self.__local, ''__release_local__''):
      return self.__local()
    try:
      return getattr(self.__local, self.__name__)
    except AttributeError:
      raise RuntimeError(''no object bound to %s'' % self.__name__)

  # 后面的所有属性都代理到了self._get_current_object()上，也就是当前的local对象上
  @property
  def __dict__(self):
    try:
      return self._get_current_object().__dict__
    except RuntimeError:
      raise AttributeError(''__dict__'')

  def __repr__(self):
    try:
      obj = self._get_current_object()
    except RuntimeError:
      return ''<%s unbound>'' % self.__class__.__name__
    return repr(obj)

  def __bool__(self):
    try:
      return bool(self._get_current_object())
    except RuntimeError:
      return False

  def __unicode__(self):
    try:
      return unicode(self._get_current_object())  # noqa
    except RuntimeError:
      return repr(self)

  def __dir__(self):
    try:
      return dir(self._get_current_object())
    except RuntimeError:
      return []

  def __getattr__(self, name):
    if name == ''__members__'':
      return dir(self._get_current_object())
    return getattr(self._get_current_object(), name)

  def __setitem__(self, key, value):
    self._get_current_object()[key] = value

  def __delitem__(self, key):
    del self._get_current_object()[key]
```

LocalProxy可以接受一个函数，也可以接受一个对象和相应其中的属性名。对于接受函数对象来说，传入属性名就没有意义了，因为这时候就是对该函数返回对象的代理。另一种方式则就是对对象的属性的代理。比如`a = LocalProxy(get_a)`,`get_a`是一个函数对象，此时a对象，就是对`get_a`中返回的对象的代理，并且`a.b`则会取`get_a`返回的对象的b属性。

LocalProxy的好处就是可以动态的取到相应的值，而不是对象创建好了就不变了。

在Flask中`request = LocalProxy(partial(_look_req_object, ''request''))`中`_look_req_object(name)`会返回一个请求上下文相应的属性比如request，那么是如何实现线程独立的呢

```
def _lookup_req_object(name):
    top = _request_ctx_stack.top
    if top is None:
        raise RuntimeError(_request_ctx_err_msg)
    return getattr(top, name)
```

因为`_request_ctx_stack`，上下文栈是LocalStack()实现的，而LocalStack是基于Local实现的栈，所以其是线程独立的，所以在`_request_ctx_stack.top`就是基于本线程取出来的请求上下文。因此返回的request属性也是基于当前线程，当前请求的了。

LocalStack
===

LocalStack 是基于 Local 实现的栈结构。如果说 Local 提供了多线程或者多协程隔离的属性访问，那么 LocalStack 就提供了隔离的栈访问。下面是它的实现代码，可以看到它提供了 push、pop 和 top 方法。

`__release_local__` 可以用来清空当前线程或者协程的栈数据，`__call__` 方法返回当前线程或者协程栈顶元素的代理对象。

```
class LocalStack(object):
  def __init__(self):
    self._local = Local()

  def __release_local__(self):
    self._local.__release_local__()

  def _get__ident_func__(self):
    return self._local.__ident_func__

  def _set__ident_func__(self, value):
    # 设置相应的ident_func，即获取线程id的函数
    object.__setattr__(self._local, ''__ident_func__'', value)

  # 作为一个属性，get和set，stack.__indent_func__等
  __ident_func__ = property(_get__ident_func__, _set__ident_func__)

  # 删除函数对象，只是消除了LocalStack对象对于这些函数的引用
  # 防止直接去引用，现在必须使用属性来访问和写入
  del _get__ident_func__, _set__ident_func__

  # LocalStack的对象是可以调用的，返回一个代理对象，代理的是栈顶对象
  def __call__(self):
    def _lookup():
      rv = self.top
      if rv is None:
        raise RuntimeError(''object unbound'')
      return rv
    return LocalProxy(_lookup)

  def push(self, obj):
    """Pushes a new item to the stack"""
    rv = getattr(self._local, ''stack'', None)
    # 设置local对象的栈
    if rv is None:
      # 线程独立的栈
      self._local.stack = rv = []
    rv.append(obj)
    return rv

  def pop(self):
    """Removes the topmost item from the stack, will return the
    old value or `None` if the stack was already empty.
    """
    stack = getattr(self._local, ''stack'', None)
    if stack is None:
      return None
    elif len(stack) == 1:
      release_local(self._local)
      return stack[-1]
    else:
      return stack.pop()

  @property
  def top(self):
    """The topmost item on the stack.  If the stack is empty,
    `None` is returned.
    """
    try:
      return self._local.stack[-1]
    except (AttributeError, IndexError):
      return None
```

整个LocalStack就是基于线程的Local对象实现了一个栈，同时可以设置对应local对象的获取线程id的方法。可以看到应用上下文和请求上下文都是LocalStack()对象,`_request_ctx_stack = LocalStack()`, `_app_ctx_stack = LocalStack()`，这样访问就会自动定位到相应的线程中，取相应的数据。

上下文栈
===

在flask.globals中定义了请求上下文和应用上下文

```
from functools import partial
from werkzeug.local import LocalStack, LocalProxy


_request_ctx_err_msg = ''''''\\
Working outside of request context.

This typically means that you attempted to use functionality that needed
an active HTTP request.  Consult the documentation on testing for
information about how to avoid this problem.\\
''''''
_app_ctx_err_msg = ''''''\\
Working outside of application context.

This typically means that you attempted to use functionality that needed
to interface with the current application object in a way.  To solve
this set up an application context with app.app_context().  See the
documentation for more information.\\
''''''


def _lookup_req_object(name):
  # 获取请求上下文的栈顶对象
  top = _request_ctx_stack.top
  if top is None:
    raise RuntimeError(_request_ctx_err_msg)
  # 得到栈顶对象后，栈顶对象是一个请求对象，再获取请求对象的属性
  return getattr(top, name)


def _lookup_app_object(name):
  top = _app_ctx_stack.top
  if top is None:
    raise RuntimeError(_app_ctx_err_msg)
  return getattr(top, name)


def _find_app():
  # 获取应用上下文栈顶对象
  top = _app_ctx_stack.top
  if top is None:
    raise RuntimeError(_app_ctx_err_msg)
  return top.app


# context locals
# localStack对象
_request_ctx_stack = LocalStack()
_app_ctx_stack = LocalStack()
#
current_app = LocalProxy(_find_app)
request = LocalProxy(partial(_lookup_req_object, ''request''))
session = LocalProxy(partial(_lookup_req_object, ''session''))
g = LocalProxy(partial(_lookup_app_object, ''g''))
```

request的每次调用每次都会调用 `_lookup_req_object`获取栈顶数据（线程独立）来获取保存在里面的requst context，从请求上下文中获取相应的请求对象。

请求上下文
---

见[请求上下文](https://github.com/Microndgt/dive-in-Flask/blob/master/Request.md#请求上下文)

应用上下文
---

```
class AppContext(object):
    ''''''应用上下文隐式绑定到一个目前线程或者协程的应用对象，和请求上下文绑定到请求信息的方式类似。
    当一个请求上下文创建的时候应用上下文也会隐式的建立，但是应用不是在该独立应用上下文顶部。''''''
    def __init__(self, app):
        self.app = app
        self.url_adapter = app.create_url_adapter(None)
        self.g = app.app_ctx_globals_class()
        # 和请求上下文一样，请求上下文可能被多次入栈，有一个基本的refcount足够去跟踪他们
        self._refcnt = 0

    def push(self):
        """Binds the app context to the current context."""
        self._refcnt += 1
        if hasattr(sys, ''exc_clear''):
            sys.exc_clear()
        _app_ctx_stack.push(self)
        # 发送应用上下文进栈的信号
        appcontext_pushed.send(self.app)

    def pop(self, exc=_sentinel):
        """Pops the app context."""
        try:
            self._refcnt -= 1
            if self._refcnt <= 0:
                if exc is _sentinel:
                    exc = sys.exc_info()[1]
                self.app.do_teardown_appcontext(exc)
        finally:
            rv = _app_ctx_stack.pop()
        assert rv is self, ''Popped wrong app context.  (%r instead of %r)'' \\
            % (rv, self)
        appcontext_popped.send(self.app)

    def __enter__(self):
        self.push()
        return self

    def __exit__(self, exc_type, exc_value, tb):
        self.pop(exc_value)

        if BROKEN_PYPY_CTXMGR_EXIT and exc_type is not None:
            reraise(exc_type, exc_value, tb)
```

可以使用Local或者LocalStack或者LocalProxy来基于这些原理来实现自己希望的东西。', 'rootz', '2021-07-31 00:28:17', '2021-07-31 00:28:33', 1, 0, 0,
        23);
insert into blog.article (id, title, cover, introduce, content, author, publish_time, update_time, status, is_top,
                          is_recommend, category_id)
values (17, 'Flask源码阅读2', 'https://tva3.sinaimg.cn/large/0060lm7Tly1ftg6wuhgywj31hc0u0wjr.jpg', 'Flask源码阅读2', 'update_wrapper
===

```
# 要进行赋值的属性，qualname是函数或者方法的合法名(类似唯一名的意思)，__annotations__是包含参数注解的字典，key是参数，value是注解
WRAPPER_ASSIGNMENTS = (''__module__'', ''__name__'', ''__qualname__'', ''__doc__'',
                       ''__annotations__'')
# 要进行更新的属性
WRAPPER_UPDATES = (''__dict__'',)
def update_wrapper(wrapper, wrapped,
                   assigned = WRAPPER_ASSIGNMENTS,
                   updated = WRAPPER_UPDATES):
    ''''''更新新的wrapper函数 让其 和之前的函数基本信息一致
    wrapper是要更新信息的函数
    wrapped是原始函数
    assigned是一个元组，里面包含了所有直接赋值的属性
    updated是一个元组，里面是要从原始函数到现在函数要更新的属性
    ''''''
    for attr in assigned:
        try:
            value = getattr(wrapped, attr)
        except AttributeError:
            pass
        else:
            setattr(wrapper, attr, value)
    for attr in updated:
        getattr(wrapper, attr).update(getattr(wrapped, attr, {}))
    #
    wrapper.__wrapped__ = wrapped
    # 返回新的wrapper函数
    return wrapper
```

wraps
===

```
def wraps(wrapped,
          assigned = WRAPPER_ASSIGNMENTS,
          updated = WRAPPER_UPDATES):
    return partial(update_wrapper, wrapped=wrapped,
                  assigned=assigned, updated=updated)
```', 'rootz', '2021-07-31 00:29:10', '2021-07-31 00:29:10', 1, 0, 0, 23);
insert into blog.article (id, title, cover, introduce, content, author, publish_time, update_time, status, is_top,
                          is_recommend, category_id)
values (18, 'SpringBoot常用注解', 'https://tva2.sinaimg.cn/large/87c01ec7gy1frmrtnq32hj21hc0u0wnl.jpg', 'SpringBoot常用注解', '# 概述

记录Spring Boot的所有注解

| @Controller                     | 组合注解（组合了@Component注解），应用在MVC层（控制层）, DispatcherServlet会自动扫描注解了此注解的类，然后将web请求映射到注解了@RequestMapping的方法上。 |
| ------------------------------- | ------------------------------------------------------------ |
| @Service                        | 组合注解（组合了@Component注解），应用在service层（业务逻辑层） |
| @Reponsitory                    | 组合注解（组合了@Component注解），应用在dao层（数据访问层）  |
| @Component                      | 表示一个带注释的类是一个“组件”，成为Spring管理的Bean。当使用基于注解的配置和类路径扫描时，这些类被视为自动检测的候选对象。同时@Component还是一个元注解。 |
| @Autowired                      | Spring提供的工具（由Spring的依赖注入工具（BeanPostProcessor、BeanFactoryPostProcessor）自动注入。） |
| @Resource                       | JSR-250提供的注解                                            |
| @Inject                         | JSR-330提供的注解                                            |
| @Configuration                  | 声明当前类是一个配置类（相当于一个Spring配置的xml文件）      |
| @ComponentScan                  | 自动扫描指定包下所有使用@Service,@Component,@Controller,@Repository的类并注册 |
| @Bean                           | 注解在方法上，声明当前方法的返回值为一个Bean。返回的Bean对应的类中可以定义init()方法和destroy()方法，然后在@Bean(initMethod=“init”,destroyMethod=“destroy”)定义，在构造之后执行init，在销毁之前执行destroy。 |
| @Aspect                         | 声明一个切面（就是说这是一个额外功能）                       |
| @After                          | 后置建言（advice），在原方法前执行。                         |
| @Before                         | 前置建言（advice），在原方法后执行。                         |
| @Around                         | 环绕建言（advice），在原方法执行前执行，在原方法执行后再执行（@Around可以实现其他两种advice） |
| @PointCut                       | 声明切点，即定义拦截规则，确定有哪些方法会被切入             |
| @Transactional                  | 声明事务（一般默认配置即可满足要求，当然也可以自定义）       |
| @Cacheable                      | 声明数据缓存                                                 |
| @EnableAspectJAutoProxy         | 开启Spring对AspectJ的支持                                    |
| @Value                          | 值得注入。经常与Sping EL表达式语言一起使用，注入普通字符，系统属性，表达式运算结果，其他Bean的属性，文件内容，网址请求内容，配置文件属性值等等 |
| @PropertySource                 | 指定文件地址。提供了一种方便的、声明性的机制，用于向Spring的环境添加PropertySource。与@configuration类一起使用。 |
| @PostConstruct                  | 标注在方法上，该方法在构造函数执行完成之后执行。             |
| @PreDestroy                     | 标注在方法上，该方法在对象销毁之前执行。                     |
| @Profile                        | 表示当一个或多个指定的文件是活动的时，一个组件是有资格注册的。使用@Profile注解类或者方法，达到在不同情况下选择实例化不同的Bean。@Profile(“dev”)表示为dev时实例化。 |
| @EnableAsync                    | 开启异步任务支持。注解在配置类上。                           |
| @Async                          | 注解在方法上标示这是一个异步方法，在类上标示这个类所有的方法都是异步方法。 |
| @EnableScheduling               | 注解在配置类上，开启对计划任务的支持。                       |
| @Scheduled                      | 注解在方法上，声明该方法是计划任务。支持多种类型的计划任务：cron,fixDelay,fixRate |
| @Conditional                    | 根据满足某一特定条件创建特定的Bean                           |
| @Enable*                        | 通过简单的@Enable*来开启一项功能的支持。所有@Enable*注解都有一个@Import注解，@Import是用来导入配置类的，这也就意味着这些自动开启的实现其实是导入了一些自动配置的Bean(1.直接导入配置类2.依据条件选择配置类3.动态注册配置类) |
| @RunWith                        | 这个是Junit的注解，springboot集成了junit。一般在测试类里使用:@RunWith(SpringJUnit4ClassRunner.class) — SpringJUnit4ClassRunner在JUnit环境下提供Sprng TestContext Framework的功能 |
| @ContextConfiguration           | 用来加载配置ApplicationContext，其中classes属性用来加载配置类:@ContextConfiguration(classes = {TestConfig.class(自定义的一个配置类)}) |
| @ActiveProfiles                 | 用来声明活动的profile–@ActiveProfiles(“prod”(这个prod定义在配置类中)) |
| @EnableWebMvc                   | 用在配置类上，开启SpringMvc的Mvc的一些默认配置：如ViewResolver，MessageConverter等。同时在自己定制SpringMvc的相关配置时需要做到两点：1.配置类继承WebMvcConfigurerAdapter类2.就是必须使用这个@EnableWebMvc注解。 |
| @RequestMapping                 | 用来映射web请求（访问路径和参数），处理类和方法的。可以注解在类和方法上，注解在方法上的@RequestMapping路径会继承注解在类上的路径。同时支持Serlvet的request和response作为参数，也支持对request和response的媒体类型进行配置。其中有value(路径)，produces(定义返回的媒体类型和字符集)，method(指定请求方式)等属性。 |
| @GetMapping                     | GET方式的@RequestMapping                                     |
| @PostMapping                    | POST方式的@RequestMapping                                    |
| @ResponseBody                   | 将返回值放在response体内。返回的是数据而不是页面             |
| @RequestBody                    | 允许request的参数在request体中，而不是在直接链接在地址的后面。此注解放置在参数前。 |
| @PathVariable                   | 放置在参数前，用来接受路径参数。                             |
| @RestController                 | 组合注解，组合了@Controller和@ResponseBody,当我们只开发一个和页面交互数据的控制层的时候可以使用此注解。 |
| @ControllerAdvice               | 用在类上，声明一个控制器建言，它也组合了@Component注解，会自动注册为Spring的Bean。 |
| @ExceptionHandler               | 用在方法上定义全局处理，通过他的value属性可以过滤拦截的条件：@ExceptionHandler(value=Exception.class)–表示拦截所有的Exception。 |
| @ModelAttribute                 | 将键值对添加到全局，所有注解了@RequestMapping的方法可获得次键值对（就是在请求到达之前，往model里addAttribute一对name-value而已）。 |
| @InitBinder                     | 通过@InitBinder注解定制WebDataBinder（用在方法上，方法有一个WebDataBinder作为参数，用WebDataBinder在方法内定制数据绑定，例如可以忽略request传过来的参数Id等）。 |
| @WebAppConfiguration            | 一般用在测试上，注解在类上，用来声明加载的ApplicationContext是一个WebApplicationContext。他的属性指定的是Web资源的位置，默认为src/main/webapp,我们可以修改为：@WebAppConfiguration(“src/main/resources”)。 |
| @EnableAutoConfiguration        | 此注释自动载入应用程序所需的所有Bean——这依赖于Spring Boot在类路径中的查找。该注解组合了@Import注解，@Import注解导入了EnableAutoCofigurationImportSelector类，它使用SpringFactoriesLoader.loaderFactoryNames方法来扫描具有META-INF/spring.factories文件的jar包。而spring.factories里声明了有哪些自动配置。 |
| @SpingBootApplication           | SpringBoot的核心注解，主要目的是开启自动配置。它也是一个组合注解，主要组合了@Configurer，@EnableAutoConfiguration（核心）和@ComponentScan。可以通过@SpringBootApplication(exclude={想要关闭的自动配置的类名.class})来关闭特定的自动配置。 |
| @ImportResource                 | 虽然Spring提倡零配置，但是还是提供了对xml文件的支持，这个注解就是用来加载xml配置的。例：@ImportResource({"classpath |
| @ConfigurationProperties        | 将properties属性与一个Bean及其属性相关联，从而实现类型安全的配置。例：@ConfigurationProperties(prefix=“authot”，locations={"classpath |
| @ConditionalOnBean              | 条件注解。当容器里有指定Bean的条件下。                       |
| @ConditionalOnClass             | 条件注解。当类路径下有指定的类的条件下。                     |
| @ConditionalOnExpression        | 条件注解。基于SpEL表达式作为判断条件。                       |
| @ConditionalOnJava              | 条件注解。基于JVM版本作为判断条件。                          |
| @ConditionalOnJndi              | 条件注解。在JNDI存在的条件下查找指定的位置。                 |
| @ConditionalOnMissingBean       | 条件注解。当容器里没有指定Bean的情况下。                     |
| @ConditionalOnMissingClass      | 条件注解。当类路径下没有指定的类的情况下。                   |
| @ConditionalOnNotWebApplication | 条件注解。当前项目不是web项目的条件下。                      |
| @ConditionalOnResource          | 条件注解。类路径是否有指定的值。                             |
| @ConditionalOnSingleCandidate   | 条件注解。当指定Bean在容器中只有一个，后者虽然有多个但是指定首选的Bean。 |
| @ConditionalOnWebApplication    | 条件注解。当前项目是web项目的情况下。                        |
| @EnableConfigurationProperties  | 注解在类上，声明开启属性注入，使用@Autowired注入。例：@EnableConfigurationProperties(HttpEncodingProperties.class)。 |
| @AutoConfigureAfter             | 在指定的自动配置类之后再配置。例：@AutoConfigureAfter(WebMvcAutoConfiguration.class) |', 'rootz',
        '2021-08-01 00:33:32', '2021-08-01 00:33:32', 1, 0, 0, 20);
insert into blog.article (id, title, cover, introduce, content, author, publish_time, update_time, status, is_top,
                          is_recommend, category_id)
values (19, 'SpringBoot常用配置', 'https://tva2.sinaimg.cn/large/87c01ec7gy1frmrsr7j0yj21hc0u0dox.jpg', 'SpringBoot常用配置', '# 记录一些springboot的常用配置项



## 配置文件常用配置项

### 1. Server

* server.address：指定server绑定的地址

* server.compression.enabled：是否开启压缩，默认为false.
* server.compression.excluded-user-agents
  指定不压缩的user-agent，多个以逗号分隔，默认值为:text/html,text/xml,text/plain,text/css

* server.compression.mime-types
  指定要压缩的MIME type，多个以逗号分隔.

* server.compression.min-response-size
  执行压缩的阈值，默认为2048

* server.context-parameters.[param name]
  设置servlet context 参数

* server.context-path
  设定应用的context-path.（如设置context-path=/springboot，所以访问的路径前缀都要有/springboot。）

* server.display-name
  设定应用的展示名称，默认: application

* server.jsp-servlet.class-name
  设定编译JSP用的servlet，默认: org.apache.jasper.servlet.JspServlet)

* server.jsp-servlet.init-parameters.[param name]
  设置JSP servlet 初始化参数.

* server.jsp-servlet.registered
  设定JSP servlet是否注册到内嵌的servlet容器，默认true

* server.port
  设定http监听端口

* server.servlet-path
  设定dispatcher servlet的监听路径，默认为: /

## 2. MVC

* spring.mvc.async.request-timeout
  设定async请求的超时时间，以毫秒为单位，如果没有设置的话，以具体实现的超时时间为准，比如tomcat的servlet3的话是10秒.

* spring.mvc.date-format
  设定日期的格式，比如dd/MM/yyyy.

* spring.mvc.favicon.enabled
  是否支持favicon.ico，默认为: true

* spring.mvc.ignore-default-model-on-redirect
  在重定向时是否忽略默认model的内容，默认为true

* spring.mvc.locale
  指定使用的Locale.

* spring.mvc.message-codes-resolver-format
  指定message codes的格式化策略(PREFIX_ERROR_CODE,POSTFIX_ERROR_CODE).

* spring.mvc.view.prefix
  指定mvc视图的前缀.

* spring.mvc.view.suffix
  指定mvc视图的后缀.

##  3. Messages

* spring.messages.basename
  指定message的basename，多个以逗号分隔，如果不加包名的话，默认从classpath路径开始，默认: messages

* spring.messages.cache-seconds
  设定加载的资源文件缓存失效时间，-1的话为永不过期，默认为-1

* spring.messages.encoding
  设定Message bundles的编码，默认: UTF-8

## 4. Mobile

* spring.mobile.devicedelegatingviewresolver.enable-fallback
  是否支持fallback的解决方案，默认false

* spring.mobile.devicedelegatingviewresolver.enabled
  是否开始device view resolver，默认为: false

* spring.mobile.devicedelegatingviewresolver.mobile-prefix
  设定mobile端视图的前缀，默认为:mobile/

* spring.mobile.devicedelegatingviewresolver.mobile-suffix
  设定mobile视图的后缀

* spring.mobile.devicedelegatingviewresolver.normal-prefix
  设定普通设备的视图前缀

* spring.mobile.devicedelegatingviewresolver.normal-suffix
  设定普通设备视图的后缀

* spring.mobile.devicedelegatingviewresolver.tablet-prefix
  设定平板设备视图前缀，默认:tablet/

* spring.mobile.devicedelegatingviewresolver.tablet-suffix
  设定平板设备视图后缀.

* spring.mobile.sitepreference.enabled
  是否启用SitePreferenceHandler，默认为: true', 'rootz', '2018-08-01 00:34:09', '2021-08-01 00:34:09', 1, 0, 0, 21);
insert into blog.article (id, title, cover, introduce, content, author, publish_time, update_time, status, is_top,
                          is_recommend, category_id)
values (20, 'JSP', 'https://tva3.sinaimg.cn/large/87c01ec7gy1frmrpt6l5pj21hc0u011e.jpg', 'JSP',
        '# `JSP`的四种作用域范围 首先要声明一点，所谓"作用域"就是信息共享的范围，也就是说一个信息能够在多大的范围内有效。 JSP的四种作用域范围，四种作用域范围从小到大: 1. page 2. session 3. request 4. application Web交互的最基本单位为HTTP请求。每个用户从进入网站到离开网站这段时间都称为一个HTTP会话，一个服务器的运行过程当中可能会有多个用户访问，就是多个HTTP会话。每个作用域解释如下 ## application &gt; 服务器启动到停止这段时间。Application的作用范围在服务器一开始执行服务，到服务器关闭为止Application的范围最大，停留的时间也最久，所以使用时要特别注意不然可能会造成服务器负载越来越重的情况。只要将数据存入application对象，数据的范围就为Application。 application作用域上的信息传递是通过 `ServletContext` 实现的，它提供的主要方法如下所示: * `Object getAtribute(String name)` 从application中获取信息 * ` void setAtribute(String name, Object value) ` 向application作用域中设置信息。 ## session &gt; HTTP会话开始到结束这段时间。Session 的作用范围为一段用户持续和服务器所连接的时间，但与服务 器断线 ，这个属性就无效。只要将数据存入session对象，数据的范围就为Session `session`是通过 `HttpSession` 接口实现的，它提供的主要方法如下所示。 * `Object HttpSession.getAttribute(String name)`：从session中获取信息。 * `void HttpSession.setAttribute(String name, Object value)`：向session中保存信息。 &gt; `HttpSession HttpServletRequest.getSession()`：获取当前请求所在的session的对象。 session的开始时刻比较容易判断，它从浏览器发出第一个HTTP请求即可认为会话开始。但结束时刻就不好判断了，因为浏览器关闭时并不会通知服务器，所以只能通过如下这种方法判断：如果一定的时间内客户端没有反应，则认为会话结束。Tomcat的默认值为120分钟，但这个值也可以通过 `HttpSession` 的`setMaxInactiveInterval()`方法来设置 ## request &gt;HTTP请求开始到结束这段时间。Request 的范围是指在一JSP 网页发出请求到另一个JSP 网页之间，随后这个属性就失效。设定Request 的范围时可利用request 对象中的setAttribute( )和getAttribute()； 一个HTTP请求的处理可能需要多个Servlet合作，而这几个Servlet之间可以通过某种方式传递信息，但这个信息在请求结束后就无效了。Servlet之间的信息共享是通过 `HttpServletRequest` 接口的两个方法来实现的。 * `void setAttribute(String name, Object value)`：将对象value以name为名称保存到request作用域中。 * `Object getAttribute(String name)`：从request作用域中取得指定名字的信息。 因此，只需要在当前Servlet中先通过setAttribute()方法设置相应的属性，然后使用forward()方法进行跳转，最后在跳转到的Servlet中通过使用getAttribute()方法即可实现信息传递。 ## page &gt; 当前页面从打开到关闭这段时间。标名pageContext.setAttribute("","");它只能在同一个页面中有效；request和page的生命周期都是短暂的，它们之间的区别：一个request可以包含多个page页（include，forward及filter）为了避免与Servlet API耦合在一起，方便Action类做单元测试，Struts 2对HttpServletRequest、HttpSession和ServletContext进行了封装，构造了三个Map对象来替代这三种对象，在Action中，直接使用HttpServletRequest、HttpSession和ServletContext对应的Map对象来保存和读取数据。 要获取这三个Map对象，可以使用com.opensymphony.xwork2.ActionContext类，ActionContext是action执行的上下文，在ActionContext中保存了action执行所需的一组对象，包括parameters、request、session、application和locale等。ActionContext类定义了如下方法，用于获取HttpServletRequest、HttpSession和ServletContext对应的Map对象。 * `public Object get(Object key)`， ActionContext类没有提供类似getRequest()这样的方法来获取封装了HttpServletRequest的Map对象。要得到请求Map对象，你需要为get()方法传递参数“request”。 * `public Map getSession()` 获取封装了HttpSession的Map对象。 * `public Map getApplication()` 获取封装了ServletContext的Map对象。 ## 内置对象 内置对象 | 类型 | 作用域 ---- | ---- | ---- pageContext | javax.servlet.jsp.pageContext | page request | javax.servlet.http.HttpServletRequest | request response | javax.servlet.http.HttpServletResponse | response session | javax.servlet.http.HttpSession | session application | javax.servlet.ServletContext | application config | javax.servlet.ServletConfig | page out | java.servlet.jsp.JspWriter | page page | java.lang.Object | page exception | java.lang.Throwable | page',
        'rootz', '2021-08-13 15:57:42', '2021-08-13 16:09:45', 1, 1, 1, 20);



insert into blog.comment (id, commentator, avatar, content, is_active, email, create_time, article_id, parent_id)
values (1, 'neo', 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJAAAACQAQMAAADdiHD7AAAABlBMVEV83FDw8PBCSon+AAAAQklEQVRIx2P4jwEYhqXQBwYGfhg5KjREhYAsZMA/KjRkhfhhufPDqNCQFULioJa+o0JDSugDNGfCGaNCQ1Jo+LflACNlKiuOYsYOAAAAAElFTkSuQmCC
', '测试', 1, 'admin@qq.com', '2021-07-16 08:21:00', 14, -1);
insert into blog.comment (id, commentator, avatar, content, is_active, email, create_time, article_id, parent_id)
values (4, 'rootz', 'https://p3-tt-ipv6.byteimg.com/origin/pgc-image/10d1842054d0455d894e5289d3d81c91', '你说的对', 1,
        '709544711@qq.com', '2021-07-19 11:26:52', 14, 1);
insert into blog.comment (id, commentator, avatar, content, is_active, email, create_time, article_id, parent_id)
values (5, 'a1', 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJAAAACQAQMAAADdiHD7AAAABlBMVEV83FDw8PBCSon+AAAAQklEQVRIx2P4jwEYhqXQBwYGfhg5KjREhYAsZMA/KjRkhfhhufPDqNCQFULioJa+o0JDSugDNGfCGaNCQ1Jo+LflACNlKiuOYsYOAAAAAElFTkSuQmCC
', '我觉得也是', 1, 'admin@qq.com', '2021-08-01 21:02:50', 14, -1);
insert into blog.comment (id, commentator, avatar, content, is_active, email, create_time, article_id, parent_id)
values (6, 'a2', 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJAAAACQAQMAAADdiHD7AAAABlBMVEV83FDw8PBCSon+AAAAQklEQVRIx2P4jwEYhqXQBwYGfhg5KjREhYAsZMA/KjRkhfhhufPDqNCQFULioJa+o0JDSugDNGfCGaNCQ1Jo+LflACNlKiuOYsYOAAAAAElFTkSuQmCC
', '嗯呢', 1, 'admin@qq.com', '2021-08-01 21:03:29', 14, 5);
insert into blog.comment (id, commentator, avatar, content, is_active, email, create_time, article_id, parent_id)
values (7, 'a4', 'https://api.prodless.com/avatar.png', '1', 1, 'admin@qq.com', '2021-08-01 21:12:17', 14, 4);
insert into blog.comment (id, commentator, avatar, content, is_active, email, create_time, article_id, parent_id)
values (8, 'a5', 'https://api.prodless.com/avatar.png', '1', 1, 'admin@qq.com', '2021-08-01 21:12:19', 14, 4);
insert into blog.comment (id, commentator, avatar, content, is_active, email, create_time, article_id, parent_id)
values (9, 'a6', 'https://api.prodless.com/avatar.png', '1', 1, 'admin@qq.com', '2021-08-01 21:12:23', 14, 4);
insert into blog.comment (id, commentator, avatar, content, is_active, email, create_time, article_id, parent_id)
values (10, 'a7', 'https://api.prodless.com/avatar.png', '1', 1, 'admin@qq.com', '2021-08-01 21:13:49', 14, 5);
insert into blog.comment (id, commentator, avatar, content, is_active, email, create_time, article_id, parent_id)
values (11, 'admin', 'http://n.sinaimg.cn/translate/w402h363/20180213/bg7r-fyrpeie1413753.jpg', '&amp;glt;', 1,
        '709544711@qq.com', '2021-08-02 10:47:29', 14, -1);
insert into blog.comment (id, commentator, avatar, content, is_active, email, create_time, article_id, parent_id)
values (12, '牛比21212', 'http://n.sinaimg.cn/translate/w402h363/20180213/bg7r-fyrpeie1413753.jpg', '卧曹', 1,
        '709544711@qq.com', '2021-08-02 10:48:54', 14, 11);
insert into blog.comment (id, commentator, avatar, content, is_active, email, create_time, article_id, parent_id)
values (13, 'hhhhh', 'http://n.sinaimg.cn/translate/w402h363/20180213/bg7r-fyrpeie1413753.jpg', 'ewewewe', 1,
        '709544711@qq.com', '2021-08-02 10:54:47', 14, -1);
insert into blog.comment (id, commentator, avatar, content, is_active, email, create_time, article_id, parent_id)
values (14, 'waewaee', 'http://n.sinaimg.cn/translate/w402h363/20180213/bg7r-fyrpeie1413753.jpg', 'aweaewaeae', 1,
        '709544711@qq.com', '2021-08-02 10:56:03', 14, -1);
insert into blog.comment (id, commentator, avatar, content, is_active, email, create_time, article_id, parent_id)
values (15, 'eeeeawe', 'http://n.sinaimg.cn/translate/w402h363/20180213/bg7r-fyrpeie1413753.jpg', 'eeee', 1,
        '709544711@qq.com', '2021-08-02 10:56:51', 14, -1);
