package com.root2z.model.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PasswordVO {

  @NotBlank(message = "旧密码不能为空")
  private String oldPassword;

  @Size(min = 8, max = 20, message = "新密码长度必须在8-20位之间")
  @NotNull
  @NotBlank(message = "新密码不能为空")
  @Pattern(
      regexp =
          "^(?![a-zA-Z]+$)(?![A-Z0-9]+$)(?![A-Z\\W_!@#$%^&*`~()-+=]+$)(?![a-z0-9]+$)(?![a-z\\W_!@#$%^&*`~()-+=]+$)(?![0-9\\W_!@#$%^&*`~()-+=]+$)[a-zA-Z0-9\\W_!@#$%^&*`~()-+=]{7,20}$",
      message = "密码不符合要求")
  private String newPassword;

  @Size(min = 8, max = 20, message = "重复密码长度必须在8-20位之间")
  @NotNull
  @NotBlank(message = "重复密码不能为空")
  @Pattern(
      regexp =
          "^(?![a-zA-Z]+$)(?![A-Z0-9]+$)(?![A-Z\\W_!@#$%^&*`~()-+=]+$)(?![a-z0-9]+$)(?![a-z\\W_!@#$%^&*`~()-+=]+$)(?![0-9\\W_!@#$%^&*`~()-+=]+$)[a-zA-Z0-9\\W_!@#$%^&*`~()-+=]{7,20}$",
      message = "密码不符合要求")
  private String reNewPassword;

  public String getOldPassword() {
    return oldPassword;
  }

  public void setOldPassword(String oldPassword) {
    this.oldPassword = oldPassword;
  }

  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }

  public String getReNewPassword() {
    return reNewPassword;
  }

  public void setReNewPassword(String reNewPassword) {
    this.reNewPassword = reNewPassword;
  }

  @Override
  public String toString() {
    return "PasswordVO{" +
            "oldPassword='" + oldPassword + '\'' +
            ", newPassword='" + newPassword + '\'' +
            ", reNewPassword='" + reNewPassword + '\'' +
            '}';
  }
}
