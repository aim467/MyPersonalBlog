package com.root2z.model.vo;

/** 管理员View Object */
public class AdminVO {
  private Integer id;
  private String username;
  private String nickname;
  private String email;
  private String intro;
  private String avatar;
  private Integer status;
  private Integer isTop;
  private Integer isRecommend;

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
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

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
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

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  @Override
  public String toString() {
    return "AdminVO{"
        + "id="
        + id
        + ", username='"
        + username
        + '\''
        + ", nickname='"
        + nickname
        + '\''
        + ", email='"
        + email
        + '\''
        + ", intro='"
        + intro
        + '\''
        + ", avatar='"
        + avatar
        + '\''
        + ", status="
        + status
        + ", isTop="
        + isTop
        + ", isRecommend="
        + isRecommend
        + '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
