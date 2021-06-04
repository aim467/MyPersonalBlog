package com.root2z.model.vo;

/**
 * 通用返回结果 View Object
 *
 * @param <T>
 */
public class ResultVO<T> {
  /** 返回状态码 */
  private Integer code;

  /** 返回信息 */
  private String message;

  /** 返回数据 */
  private T data;

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "ResultVO{" + "code=" + code + ", message='" + message + '\'' + ", data=" + data + '}';
  }
}
