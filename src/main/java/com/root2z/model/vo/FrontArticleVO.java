package com.root2z.model.vo;

import com.root2z.model.entity.Category;
import com.root2z.model.entity.Tag;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FrontArticleVO {
  private Integer id;

  private String title;

  private String author;

  private String introduce;

  private String content;

  private Date publishTime;

  private Date updateTime;

  /** 文件URL，删除会使用到 */
  private String cover;

  /** 非数据库字段 分类 */
  private Category category;

  /** 非数据库字段，分类ID */
  private Integer categoryId;

  private List<Tag> tags;

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

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getIntroduce() {
    return introduce;
  }

  public void setIntroduce(String introduce) {
    this.introduce = introduce;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
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

  public String getCover() {
    return cover;
  }

  public void setCover(String cover) {
    this.cover = cover;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public List<Tag> getTags() {
    return tags;
  }

  public void setTags(List<Tag> tags) {
    this.tags = tags;
  }

  @Override
  public String toString() {
    return "FrontArticleVO{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", author='" + author + '\'' +
            ", introduce='" + introduce + '\'' +
            ", content='" + content + '\'' +
            ", publishTime=" + publishTime +
            ", updateTime=" + updateTime +
            ", cover='" + cover + '\'' +
            ", category=" + category +
            ", categoryId=" + categoryId +
            ", tags=" + tags +
            '}';
  }
}
