package com.root2z.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.root2z.dao.ArticleMapper;
import com.root2z.dao.ArticleTagMapper;
import com.root2z.dao.CategoryMapper;
import com.root2z.dao.TagMapper;
import com.root2z.model.entity.Article;
import com.root2z.model.entity.ArticleTag;
import com.root2z.model.entity.Tag;
import com.root2z.model.vo.ArticleVO;
import com.root2z.model.vo.ResultVO;
import com.root2z.service.ArticleService;
import com.root2z.utils.AliyunOSSUtil;
import com.root2z.utils.BlogUtils;
import com.root2z.utils.ResultUtil;
import com.youbenzi.mdtool.tool.MDTool;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/** @author root2z */
@Service
public class ArticleServiceImpl implements ArticleService {

  @Resource private AliyunOSSUtil aliyunOSSUtil;

  @Autowired private RedisTemplate redisTemplate;

  @Autowired private CategoryMapper categoryMapper;

  @Autowired private TagMapper tagMapper;

  private final HttpServletRequest request;

  private final ArticleMapper articleMapper;

  private final ArticleTagMapper articleTagMapper;

  @Autowired
  public ArticleServiceImpl(
      ArticleMapper articleMapper, HttpServletRequest request, ArticleTagMapper articleTagMapper) {
    this.articleMapper = articleMapper;
    this.request = request;
    this.articleTagMapper = articleTagMapper;
  }

  @Override
  public int countArticle() {
    return articleMapper.totalCount();
  }

  /**
   * 保存文章 保存ArticleCategory表 保存ArticleTag表
   *
   * @param articleVO 文章View Object
   * @return 保存标志
   */
  @Override
  @Transactional
  public ResultVO addArticle(ArticleVO articleVO) {
    // 清空Redis缓存
    cleanCache();

    if (articleVO.getCategoryId() == null) {
      return ResultUtil.error("未选择分类，请至少选择一个分类!", null);
    }

    if (articleVO.getExistTags() == null) {
      return ResultUtil.error("未选择标签，请至少确定一个标签!", null);
    }

    // 保存文章时，手动设置发布时间和更新时间为当前时间
    articleVO.setPublishTime(new Date());
    articleVO.setUpdateTime(new Date());

    // 设置当前发布文章的作者
    HttpSession session = request.getSession();
    articleVO.setAuthor((String) session.getAttribute("nickName"));

    // 如果上传了封面图，则上传到阿里云
    if (!articleVO.getCoverImage().isEmpty()) {
      String cover = aliyunOSSUtil.uploadFile(articleVO.getCoverImage(), "");
      // 拿到返回的图片地址
      articleVO.setCover(cover);
    }
    // 否则，使用一个随机封面图
    articleVO.setCover(BlogUtils.randomWallpaper());

    // POJO与VO转换
    Article article = new Article();
    BeanUtils.copyProperties(articleVO, article);

    // 插入文章并且保存分类ID
    if (articleMapper.insert(article) == 0) {
      return ResultUtil.error("插入文章失败", null);
    }

    // 新标签非空判断
    if (!StringUtils.isEmpty(articleVO.getNewTags()) || null != articleVO.getNewTags()) {
      // 根据选中的标签ID查询存在标签
      List<Tag> findTags = tagMapper.findByIds(articleVO.getExistTags());
      // 拿到所有的标签列表
      List<Tag> allTag = tagMapper.findAll();
      // 新标签的列表
      List<Tag> newTags = getTagListFromVO(articleVO.getNewTags());

      // 使用所有标签列表和新标签判断
      for (Tag tag : allTag) {
        for (Tag newTag : newTags) {
          if (tag.getName().equals(newTag.getName())) {
            return ResultUtil.error("不能输入已存在的标签!", null);
          }
        }
      }

      try {
        // 暴力删除此文章标签关联表的所有记录
        if (articleTagMapper.deleteByArticleId(articleVO.getId()) < 0) {
          return ResultUtil.error("删除关联表出错!", null);
        }

        // 在已知标签列表中插入 文章标签中间表记录
        for (Tag findTag : findTags) {
          ArticleTag articleTag = new ArticleTag(article.getId(), findTag.getId());
          articleTagMapper.insert(articleTag);
        }

        // 对于新的标签，先在新的标签表中插入记录，最后在中间表建立关联
        for (Tag newTag : newTags) {
          // 插入时返回ID
          if (tagMapper.insertByName(newTag) == 0) {
            return ResultUtil.error("插入新的标签失败!", null);
          }

          ArticleTag articleTag = new ArticleTag(article.getId(), newTag.getId());
          if (articleTagMapper.insert(articleTag) == 0) {
            return ResultUtil.error("插入中间表关联失败!", null);
          }
        }
        return ResultUtil.success("插入文章成功!", null);
      } catch (Exception e) {
        throw e;
      }
    }

    return ResultUtil.error("插入文章成功，无新标签插入", null);
  }

  /**
   * 删除文章表，删除articleTag表，删除articleCategory表
   *
   * @param articleId
   * @return
   */
  @Override
  @Transactional
  public boolean deleteArticle(Integer articleId) {
    // 清空Redis缓存
    cleanCache();
    // 删除文章表
    if (articleMapper.deleteByPrimaryKey(articleId) == 0) {
      return false;
    }
    // 删除文章标签表
    if (articleTagMapper.deleteByArticleId(articleId) == 0) {
      return false;
    }
    return true;
  }

  private List<Tag> getTagListFromVO(List<String> tagNames) {
    // 中间工作，插入标签
    // 设置新插入的标签列表
    List<Tag> newTags = new ArrayList<>();
    for (String name : tagNames) {
      Tag tag = new Tag();
      tag.setName(name);
      newTags.add(tag);
    }
    return newTags;
  }

  /**
   * 获得文章信息
   *
   * @param articleVO 文章视图层对象
   * @return
   */
  @Override
  @Transactional
  public ResultVO editArticle(ArticleVO articleVO) {
    // 清空Redis缓存
    cleanCache();
    if (articleVO.getCategoryId() == null) {
      return ResultUtil.error("未选择分类，请至少选择一个分类!", null);
    }

    if (articleVO.getExistTags() == null) {
      return ResultUtil.error("未选择标签，请至少选择一个标签!", null);
    }

    // 拿到当前登录用户
    HttpSession session = request.getSession();
    articleVO.setAuthor((String) session.getAttribute("nickName"));
    // 只需要设置更新时间
    articleVO.setUpdateTime(new Date());

    // 如果上传了封面图，那么上传到阿里云
    if (!articleVO.getCoverImage().isEmpty()) {
      // 先删除文件
      aliyunOSSUtil.deleteFile(articleVO.getCover());
      // 再上传文件
      String cover = aliyunOSSUtil.uploadFile(articleVO.getCoverImage(), "");
      articleVO.setCover(cover);
    }
    // 否则使用随机壁纸
    articleVO.setCover(BlogUtils.randomWallpaper());

    Article article = new Article();
    BeanUtils.copyProperties(articleVO, article);

    // 更新文章并且同时更新分类ID
    if (articleMapper.updateByPrimaryKeySelective(article) == 0) {
      return ResultUtil.error("更新文章失败!", null);
    }

    if (!StringUtils.isEmpty(articleVO.getNewTags()) || null != articleVO.getNewTags()) {
      List<Tag> findTags = tagMapper.findByIds(articleVO.getExistTags());
      List<Tag> allTag = tagMapper.findAll();
      List<Tag> newTags = getTagListFromVO(articleVO.getNewTags());

      // 已存在标签列表和新标签列表判断
      for (Tag tag : allTag) {
        for (Tag newTag : newTags) {
          if (tag.getName().equals(newTag.getName())) {
            return ResultUtil.error("不能输入已存在的标签!", null);
          }
        }
      }

      try {
        // 暴力删除法
        if (articleTagMapper.deleteByArticleId(articleVO.getId()) < 0) {
          return ResultUtil.error("删除关联表出错!", null);
        }

        // 在已知标签列表中插入 文章标签中间表记录
        for (Tag findTag : findTags) {
          ArticleTag articleTag = new ArticleTag(article.getId(), findTag.getId());
          articleTagMapper.insert(articleTag);
        }

        // 处理新标签
        // 对于新的标签，先在新的标签表中插入记录，最后在中间表建立关联
        for (Tag newTag : newTags) {
          if (tagMapper.insertByName(newTag) == 0) {
            return ResultUtil.error("插入新的标签失败!", null);
          }
          ArticleTag articleTag = new ArticleTag(article.getId(), newTag.getId());
          if (articleTagMapper.insert(articleTag) == 0) {
            return ResultUtil.error("插入中间表关联失败!", null);
          }
        }
        return ResultUtil.success("更新文章成功!", null);

      } catch (Exception e) {
        throw e;
      }
    }

    return ResultUtil.error("更新文章成功，无新标签插入", null);
  }

  @Override
  public ArticleVO getArticleInfo(Integer articleId) {
    ArticleVO articleVO = new ArticleVO();
    // 拿到文章对象，文章对象里面已经有
    Article article = articleMapper.selectByPrimaryKey(articleId);
    BeanUtils.copyProperties(article, articleVO);
    // 设置标签
    List<String> tags = tagMapper.selectNameByArticleId(articleId);
    articleVO.setTags(tags);
    return articleVO;
  }

  /**
   * 文章分页查询
   *
   * @param pageNum
   * @param pageSize
   * @return
   */
  @Override
  public PageInfo<Article> pageQuery(Integer pageNum, Integer pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    List<Article> articles = articleMapper.findAll();
    return new PageInfo<>(articles);
  }

  /**
   * 更新文章状态
   *
   * @param articleId
   * @param status
   * @return
   */
  @Override
  public boolean updateArticleStatus(Integer articleId, Integer status) {
    // 清除缓存
    cleanCache();
    redisTemplate.delete("newsComment");
    return articleMapper.updateStatusByPrimaryKey(articleId, status) == 1;
  }

  /**
   * 获取置顶的博客，设置分类名字，设置标签列表
   *
   * @return
   */
  @Override
  public List<Article> getTopArticle(Integer top) {
    // 获得前4个置顶博客
    return articleMapper.selectAllByTop(top);
  }

  /**
   * 根据文章的更新时间进行分页
   *
   * @param page
   * @param size
   */
  @Override
  public PageInfo<Article> getArticleByTime(Integer page, Integer size) {
    // 设定分页
    PageHelper.startPage(page, size);
    List<Article> articles = articleMapper.selectAllByUpdateTime();

    // 设置分类
    for (Article article : articles) {
      article.setCategory(categoryMapper.selectByPrimaryKey(article.getCategoryId()));
    }
    // 设置标签
    for (Article article : articles) {
      List<Tag> tags = tagMapper.selectAllByArticleId(article.getId());
      article.setTags(tags);
    }
    return new PageInfo<>(articles);
  }
  /**
   * 获取指定的推荐文章数量
   *
   * @param recommendNumber 指定要显示的推荐文章数量
   * @return 返回的结果集合
   */
  @Override
  public List<Article> getRecommendArticle(Integer recommendNumber) {
    List<Article> recommendArticleCache =
        (List<Article>) redisTemplate.opsForValue().get("recommendArticle");
    if (recommendArticleCache == null || StringUtils.isEmpty(recommendArticleCache)) {
      List<Article> articleList = articleMapper.selectAllByRecommend(recommendNumber);
      redisTemplate.opsForValue().set("recommendArticle", articleList);
      return articleList;
    }
    return recommendArticleCache;
  }

  @Override
  public Article getArticleById(Integer articleId) {
    Article article = articleMapper.selectByArticleId(articleId);
    article.setContent(MDTool.markdown2Html(article.getContent()));
    return article;
  }

  @Override
  public Map<String, List<Article>> getArchives() {
    Map<String, List<Article>> archives = new TreeMap<>();
    List<String> years = articleMapper.getYears();
    for (String year : years) {
      archives.put(year, articleMapper.findByYear(year));
    }
    return archives;
  }

  @Override
  public PageInfo<Article> getAllByCategory(Integer categoryId, Integer page, Integer size) {
    PageHelper.startPage(page, size);
    List<Article> articles = articleMapper.selectAllCategoryId(categoryId);
    return new PageInfo<>(articles);
  }

  /**
   * 根据对应的标签ID拿到对应的文章数据并且进行分页
   *
   * @param tagId 标签ID
   * @param page 页码
   * @param size 页面大小
   * @return 分页结果集
   */
  @Override
  public PageInfo<Article> getAllByTagId(Integer tagId, Integer page, Integer size) {
    PageHelper.startPage(page, size);
    List<Article> articles = articleMapper.selectAllTagId(tagId);
    return new PageInfo<>(articles);
  }

  /** 清除缓存 */
  private void cleanCache() {
    redisTemplate.delete("categoryCount");
    redisTemplate.delete("tagCount");
    redisTemplate.delete("recommendArticle");
  }
}
