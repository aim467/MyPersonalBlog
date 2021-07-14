package com.root2z.model.vo;

import java.util.Date;
import java.util.List;

/** 文章视图类 */
public class ArticleVO {
  private Integer id;

  private String title;

  private String author;

  private String introduce;

  private Integer status;

  private String content;

  private Date publishTime;

  private Date updateTime;

  /** 非数据库字段 分类 */
  private String category;

  /** 非数据库字段 标签列表 */
  private List<String> tags;

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Date getPublishTime() {
    return publishTime;
  }

  public void setPublishTime(Date publishTime) {
    this.publishTime = publishTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getIntroduce() {
    return introduce;
  }

  public void setIntroduce(String introduce) {
    this.introduce = introduce;
  }

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  @Override
  public String toString() {
    return "ArticleVO{"
        + "id="
        + id
        + ", title='"
        + title
        + '\''
        + ", author='"
        + author
        + '\''
        + ", category='"
        + category
        + '\''
        + ", introduce='"
        + introduce
        + '\''
        + ", tags="
        + tags
        + ", status="
        + status
        + ", content='"
        + content
        + '\''
        + ", publishTime="
        + publishTime
        + ", updateTime="
        + updateTime
        + '}';
  }
}
