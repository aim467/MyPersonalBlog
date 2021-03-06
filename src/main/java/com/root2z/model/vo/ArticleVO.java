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

  private String categoryName;

  /** 文件对象 */
  private MultipartFile coverImage;

  /** 文件URL，删除会使用到 */
  private String cover;

  /** 非数据库字段 分类 */
  private String category;

  /** 非数据库字段，分类ID */
  private Integer categoryId;

  /** 非数据库字段 新标签列表 */
  private List<String> newTags;

  /** 非数据库字段，已存在标签ID列表 */
  private List<Integer> existTags;

  private List<String> tags;

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public List<String> getNewTags() {
    return newTags;
  }

  public void setNewTags(List<String> newTags) {
    this.newTags = newTags;
  }

  public List<Integer> getExistTags() {
    return existTags;
  }

  public void setExistTags(List<Integer> existTags) {
    this.existTags = existTags;
  }

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

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  @Override
  public String toString() {
    return "ArticleVO{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", author='" + author + '\'' +
            ", introduce='" + introduce + '\'' +
            ", status=" + status +
            ", content='" + content + '\'' +
            ", publishTime=" + publishTime +
            ", updateTime=" + updateTime +
            ", isTop=" + isTop +
            ", isRecommend=" + isRecommend +
            ", categoryName='" + categoryName + '\'' +
            ", coverImage=" + coverImage +
            ", cover='" + cover + '\'' +
            ", category='" + category + '\'' +
            ", categoryId=" + categoryId +
            ", newTags=" + newTags +
            ", existTags=" + existTags +
            ", tags=" + tags +
            '}';
  }
}
