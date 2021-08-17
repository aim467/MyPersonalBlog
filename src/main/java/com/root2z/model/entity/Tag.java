package com.root2z.model.entity;

import java.io.Serializable;

public class Tag implements Serializable {
  private static final long serialVersionUID = -6003587943012655792L;
  private Integer id;

  private String name;

  /** 标签统计 */
  private Integer count;

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name == null ? null : name.trim();
  }

  @Override
  public String toString() {
    return "Tag{" + "id=" + id + ", name='" + name + '\'' + ", count=" + count + '}';
  }
}
