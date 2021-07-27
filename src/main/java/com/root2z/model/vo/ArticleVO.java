package com.root2z.model.vo;

import org.springframework.web.multipart.MultipartFile;

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

  private Integer isTop;

  private Integer isRecommend;

  /** 文件对象 */
  private MultipartFile coverImage;

  /** 文件URL，删除会使用到 */
  private String cover;

  /** 非数据库字段 分类 */
  private String category;

  /** 非数据库字段 标签列表 */
  private List<String> tags;

  public String getAuthor() {
    return author;
  }

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

  public MultipartFile getCoverImage() {
    return coverImage;
  }

  public void setCoverImage(MultipartFile coverImage) {
    this.coverImage = coverImage;
  }

  public String getCover() {
    return cover;
  }

  public void setCover(String cover) {
    this.cover = cover;
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
        + ", introduce='"
        + introduce
        + '\''
        + ", status="
        + status
        + ", content='"
        + content
        + '\''
        + ", publishTime="
        + publishTime
        + ", updateTime="
        + updateTime
        + ", isTop="
        + isTop
        + ", isRecommend="
        + isRecommend
        + ", coverImage="
        + coverImage
        + ", cover='"
        + cover
        + '\''
        + ", category='"
        + category
        + '\''
        + ", tags="
        + tags
        + '}';
  }
}
