package com.root2z.model.entity;

import java.util.Date;

public class Message {
  private Integer id;

  private String author;

  private String avatar;

  private String url;

  private String email;

  private String content;

  private Date createTime;

  private Integer isActive;

  private Integer parentId;

  public Integer getIsActive() {
    return isActive;
  }

  public void setIsActive(Integer isActive) {
    this.isActive = isActive;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author == null ? null : author.trim();
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar == null ? null : avatar.trim();
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url == null ? null : url.trim();
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content == null ? null : content.trim();
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Integer getParentId() {
    return parentId;
  }

  public void setParentId(Integer parentId) {
    this.parentId = parentId;
  }

  @Override
  public String toString() {
    return "Message{"
        + "id="
        + id
        + ", author='"
        + author
        + '\''
        + ", avatar='"
        + avatar
        + '\''
        + ", url='"
        + url
        + '\''
        + ", email='"
        + email
        + '\''
        + ", content='"
        + content
        + '\''
        + ", createTime="
        + createTime
        + ", isActive="
        + isActive
        + ", parentId="
        + parentId
        + '}';
  }
}
