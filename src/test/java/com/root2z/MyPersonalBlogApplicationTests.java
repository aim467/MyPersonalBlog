package com.root2z;

import com.youbenzi.mdtool.tool.MDTool;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyPersonalBlogApplicationTests {


  @Test
  void contextLoads() {
    String about = "![](https://w.wallhaven.cc/full/xl/wallhaven-xlg3po.png)\n" +
            "\n" +
            "本站采用了 `SpringBoot` + `Mybatis` 所编写的第一个版本的个人博客，特性如下：\n" +
            "\n" +
            "* 使用阿里云 `OSS` 对象存储来管理静态资源\n" +
            "* 基于 `EditorMd` 的在线 `Markdown` 编辑器\n" +
            "* 可在写博客时实现图片上传到阿里云图床\n" +
            "* 后台提供多种样式选择\n" +
            "* ...\n" +
            "\n" +
            "对于一个个人博客来说，这个博客的功能还不是非常完善，只是实现了最基础最基础的功能，但是我会继续优化这个博客，争取把这个博客做的更完完美。\n" +
            "\n" +
            "本人呢，目前也只是一个 `Java/Python` 小菜鸡，平时喜欢看看美剧，玩玩单机游戏，也喜欢和人交流技术，欢迎随时来我的小站！";
    System.out.println(MDTool.markdown2Html(about));
  }
}
