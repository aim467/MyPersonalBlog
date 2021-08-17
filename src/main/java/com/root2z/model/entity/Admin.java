package com.root2z.model.entity;

import java.io.Serializable;
import java.util.Date;

public class Admin implements Serializable {

  private static final long serialVersionUID = -388293204730444162L;

  private Integer id;

  private String nickname;

  private String avatar;

  private String username;

  private String password;

  private String email;

  private String intro;

  private Date createTime;

  private Date updateTime;

  private Integer status;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname == null ? null : nickname.trim();
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar == null ? null : avatar.trim();
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username == null ? null : username.trim();
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password == null ? null : password.trim();
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getIntro() {
    return intro;
  }

  public void setIntro(String intro) {
    this.intro = intro;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
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

  @Override
  public String toString() {
    return "Admin{" +
            "id=" + id +
            ", nickname='" + nickname + '\'' +
            ", avatar='" + avatar + '\'' +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", email='" + email + '\'' +
            ", intro='" + intro + '\'' +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", status=" + status +
            '}';
  }
}
