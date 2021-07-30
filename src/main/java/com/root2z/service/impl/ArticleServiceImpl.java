package com.root2z.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.root2z.dao.*;
import com.root2z.model.entity.*;
import com.root2z.model.vo.ArticleVO;
import com.root2z.model.vo.ResultVO;
import com.root2z.service.ArticleService;
import com.root2z.utils.AliyunOSSUtil;
import com.root2z.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

  @Resource private AliyunOSSUtil aliyunOSSUtil;

  private final HttpServletRequest request;

  private final ArticleMapper articleMapper;

  private final CategoryMapper categoryMapper;

  private final TagMapper tagMapper;

  private final ArticleCategoryMapper articleCategoryMapper;

  private final ArticleTagMapper articleTagMapper;

  private final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

  @Autowired
  public ArticleServiceImpl(
      ArticleMapper articleMapper,
      CategoryMapper categoryMapper,
      TagMapper tagMapper,
      HttpServletRequest request,
      ArticleCategoryMapper articleCategoryMapper,
      ArticleTagMapper articleTagMapper) {
    this.articleMapper = articleMapper;
    this.tagMapper = tagMapper;
    this.categoryMapper = categoryMapper;
    this.request = request;
    this.articleCategoryMapper = articleCategoryMapper;
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
    // 保存文章时，手动设置发布时间和更新时间为当前时间
    articleVO.setPublishTime(new Date());
    articleVO.setUpdateTime(new Date());

    // 设置当前发布文章的作者
    HttpSession session = request.getSession();
    articleVO.setAuthor((String) session.getAttribute("nickName"));

    String cover = aliyunOSSUtil.uploadFile(articleVO.getCoverImage(), "");
    articleVO.setCover(cover);

    // POJO与VO转换
    Article article = new Article();
    BeanUtils.copyProperties(articleVO, article);

    // 新标签非空判断
    if (!StringUtils.isEmpty(articleVO.getNewTags()) || null != articleVO.getNewTags()) {
      // 根据选中的标签ID查询存在标签
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
        // 先删除关联
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
    // 插入文章并且保存分类ID
    if (articleMapper.insert(article) == 0) {
      return ResultUtil.error("插入文章失败", null);
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
    // 拿到当前登录用户
    HttpSession session = request.getSession();
    articleVO.setAuthor((String) session.getAttribute("nickName"));
    // 只需要设置更新时间
    articleVO.setPublishTime(new Date());

    if (articleVO.getCoverImage() != null) {
      // 先删除文件
      aliyunOSSUtil.deleteFile(articleVO.getCover());
      // 再上传文件
      String cover = aliyunOSSUtil.uploadFile(articleVO.getCoverImage(), "");
      articleVO.setCover(cover);
    }

    Article article = new Article();
    BeanUtils.copyProperties(articleVO, article);

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
        // 先删除关联
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

    // 更新文章并且同时更新分类ID
    if (articleMapper.updateByPrimaryKeySelective(article) == 0) {
      return ResultUtil.error("更新文章失败!", null);
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
    return new PageInfo<Article>(articles);
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
    return articleMapper.updateStatusByPrimaryKey(articleId, status) == 1;
  }
}
