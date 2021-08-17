package com.root2z.model.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/** 登录实体类 */
public class LoginUserVO {
  @NotNull(message = "用户名不能为空")
  @Size(min = 5, max = 10, message = "用户名在5-10个字符内!")
  private String username;

  @NotNull(message = "密码不能为空")
  @Size(min = 8, max = 20, message = "密码在8-20个字符内!")
  private String password;

  @NotNull(message = "验证码不能为空")
  @Size(min = 4, max = 4, message = "验证码为4个字符!")
  private String verifyCode;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getVerifyCode() {
    return verifyCode;
  }

  public void setVerifyCode(String verifyCode) {
    this.verifyCode = verifyCode;
  }

  @Override
  public String toString() {
    return "LoginUserVO{"
        + "username='"
        + username
        + '\''
        + ", password='"
        + password
        + '\''
        + ", verifyCode='"
        + verifyCode
        + '\''
        + '}';
  }
}
