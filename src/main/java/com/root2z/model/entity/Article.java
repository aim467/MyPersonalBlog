package com.root2z.model.entity;

import java.util.Date;

public class Article {
  private Integer id;

  private String title;

  private String introduce;

  private String author;

  private Date publishTime;

  private Date updateTime;

  private Integer status;

  private String content;

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

  @Override
  public String toString() {
    return "Article{"
        + "id="
        + id
        + ", title='"
        + title
        + '\''
        + ", introduce='"
        + introduce
        + '\''
        + ", author='"
        + author
        + '\''
        + ", publishTime="
        + publishTime
        + ", updateTime="
        + updateTime
        + ", status="
        + status
        + ", content='"
        + content
        + '\''
        + '}';
  }
}
