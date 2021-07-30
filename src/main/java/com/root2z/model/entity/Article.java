package com.root2z.model.entity;

import java.util.Date;

public class Article {
  private Integer id;

  private String title;

  private String cover;

  private String introduce;

  private String author;

  private Date publishTime;

  private Date updateTime;

  private Integer status;

  private String content;

  private Integer isTop;

  private Integer isRecommend;

  private Integer categoryId;

  public Integer getIsTop() {
    return isTop;
  }

  public void setIsTop(Integer isTop) {
    this.isTop = isTop;
  }

  public Integer getIsRecommend() {
    return isRecommend;
  }

  public void setIsRecommend(Integer isRecommend) {
    this.isRecommend = isRecommend;
  }

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
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
    this.title = title == null ? null : title.trim();
  }

  public String getIntroduce() {
    return introduce;
  }

  public void setIntroduce(String introduce) {
    this.introduce = introduce == null ? null : introduce.trim();
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author == null ? null : author.trim();
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
    this.content = content == null ? null : content.trim();
  }

  public String getCover() {
    return cover;
  }

  public void setCover(String cover) {
    this.cover = cover;
  }

  @Override
  public String toString() {
    return "Article{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", cover='" + cover + '\'' +
            ", introduce='" + introduce + '\'' +
            ", author='" + author + '\'' +
            ", publishTime=" + publishTime +
            ", updateTime=" + updateTime +
            ", status=" + status +
            ", content='" + content + '\'' +
            ", isTop=" + isTop +
            ", isRecommend=" + isRecommend +
            ", categoryId=" + categoryId +
            '}';
  }
}
