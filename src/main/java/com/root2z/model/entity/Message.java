package com.root2z.model.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Message {
  private Integer id;

  @NotNull(message = "昵称不能为空")
  @Size(min = 5, max = 10, message = "用户名在5-15个字符内!")
  private String author;

  private String avatar;

  private String url;

  @NotNull(message = "邮箱不能为空")
  @Size(min = 5, max = 20, message = "邮箱长度不合法!")
  @Email
  private String email;

  @NotNull(message = "内容不能为空")
  private String content;

  private Date createTime;

  private Integer isActive;

  private Integer parentId;

  /** 非数据字段，子留言集合 */
  private List<Message> replyMessages = new ArrayList<>();

  /** 非数据库字段，父留言 */
  private Message parentMessage;

  /** 非数据库字段，父留言昵称 */
  private String parentNickname;

  public List<Message> getReplyMessages() {
    return replyMessages;
  }

  public void setReplyMessages(List<Message> replyMessages) {
    this.replyMessages = replyMessages;
  }

  public Message getParentMessage() {
    return parentMessage;
  }

  public void setParentMessage(Message parentMessage) {
    this.parentMessage = parentMessage;
  }

  public String getParentNickname() {
    return parentNickname;
  }

  public void setParentNickname(String parentNickname) {
    this.parentNickname = parentNickname;
  }

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
    final StringBuilder sb = new StringBuilder("{");
    sb.append("\"id\":").append(id);
    sb.append(",\"author\":\"").append(author).append('\"');
    sb.append(",\"avatar\":\"").append(avatar).append('\"');
    sb.append(",\"url\":\"").append(url).append('\"');
    sb.append(",\"email\":\"").append(email).append('\"');
    sb.append(",\"content\":\"").append(content).append('\"');
    sb.append(",\"createTime\":\"").append(createTime).append('\"');
    sb.append(",\"isActive\":").append(isActive);
    sb.append(",\"parentId\":").append(parentId);
    sb.append(",\"replyMessages\":").append(replyMessages);
    sb.append(",\"parentMessage\":").append(parentMessage);
    sb.append(",\"parentNickname\":\"").append(parentNickname).append('\"');
    sb.append('}');
    return sb.toString();
  }
}
