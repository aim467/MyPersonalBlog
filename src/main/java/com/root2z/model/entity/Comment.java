package com.root2z.model.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Comment {
  private Integer id;

  @NotNull(message = "昵称不能为空")
  @Size(min = 5, max = 10, message = "用户名在5-15个字符内!")
  private String commentator;

  private String avatar;

  @NotNull(message = "内容不能为空")
  private String content;

  private Integer isActive;

  private Date createTime;

  private Integer articleId;

  private Integer parentId;

  @NotNull(message = "邮箱不能为空")
  @Size(min = 5, max = 20, message = "邮箱长度不合法!")
  @Email
  private String email;

  /** 非数据库字段，子回复评论集合 */
  private List<Comment> replyComments = new ArrayList<>();
  /** 父评论 */
  private Comment parentComment;
  /** 父评论昵称 */
  private String parentNickname;

  public List<Comment> getReplyComments() {
    return replyComments;
  }

  public void setReplyComments(List<Comment> replyComments) {
    this.replyComments = replyComments;
  }

  public Comment getParentComment() {
    return parentComment;
  }

  public void setParentComment(Comment parentComment) {
    this.parentComment = parentComment;
  }

  public String getParentNickname() {
    return parentNickname;
  }

  public void setParentNickname(String parentNickname) {
    this.parentNickname = parentNickname;
  }

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
        + ", replyComments="
        + replyComments
        + ", parentComment="
        + parentComment
        + ", parentNickname='"
        + parentNickname
        + '\''
        + '}';
  }
}
