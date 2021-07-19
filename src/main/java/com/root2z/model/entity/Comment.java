package com.root2z.model.entity;

import java.util.Date;

public class Comment {
  private Integer id;

  private String commentator;

  private String avatar;

  private String content;

  private Integer isActive;

  private Date createTime;

  private Integer articleId;

  private Integer parentId;

  private String email;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getIsActive() {
    return isActive;
  }

  public void setIsActive(Integer isActive) {
    this.isActive = isActive;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCommentator() {
    return commentator;
  }

  public void setCommentator(String commentator) {
    this.commentator = commentator == null ? null : commentator.trim();
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar == null ? null : avatar.trim();
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content == null ? null : content.trim();
  }

  public Integer getArticleId() {
    return articleId;
  }

  public void setArticleId(Integer articleId) {
    this.articleId = articleId;
  }

  public Integer getParentId() {
    return parentId;
  }

  public void setParentId(Integer parentId) {
    this.parentId = parentId;
  }

  @Override
  public String toString() {
    return "Comment{"
        + "id="
        + id
        + ", commentator='"
        + commentator
        + '\''
        + ", avatar='"
        + avatar
        + '\''
        + ", content='"
        + content
        + '\''
        + ", isActive="
        + isActive
        + ", createTime="
        + createTime
        + ", articleId="
        + articleId
        + ", parentId="
        + parentId
        + ", email='"
        + email
        + '\''
        + '}';
  }
}
