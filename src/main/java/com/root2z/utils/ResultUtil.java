package com.root2z.utils;

import com.root2z.model.vo.ResultVO;

/** 通用返回结果工具类 */
public class ResultUtil {

  public static ResultVO success(Object object) {
    ResultVO result = new ResultVO();
    result.setCode(200);
    result.setMessage("成功");
    result.setData(object);
    return result;
  }

  public static ResultVO success(String message, Object object) {
    ResultVO result = new ResultVO();
    result.setCode(200);
    result.setMessage(message);
    result.setData(object);
    return result;
  }

  public static ResultVO success() {
    return success(null);
  }

  public static ResultVO error(Integer code, String msg) {
    ResultVO result = new ResultVO();
    result.setCode(code);
    result.setMessage(msg);
    return result;
  }

  public static ResultVO error(String msg, Object object) {
    ResultVO result = new ResultVO();
    result.setCode(400);
    result.setMessage(msg);
    result.setData(object);
    return result;
  }

  public static ResultVO error() {
    return error(400, "请求错误");
  }
}
