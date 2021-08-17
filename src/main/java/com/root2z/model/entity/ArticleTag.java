package com.root2z.model.entity;

import java.io.Serializable;

public class ArticleTag implements Serializable {

  private static final long serialVersionUID = 7867207432205480286L;

  public ArticleTag() {}

  public ArticleTag(Integer articleId, Integer tagId) {
    this.articleId = articleId;
    this.tagId = tagId;
  }

  private Integer articleId;

  private Integer tagId;

  public Integer getArticleId() {
    return articleId;
  }

  public void setArticleId(Integer articleId) {
    this.articleId = articleId;
  }

  public Integer getTagId() {
    return tagId;
  }

  public void setTagId(Integer tagId) {
    this.tagId = tagId;
  }
}
