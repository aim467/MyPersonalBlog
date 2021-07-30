package com.root2z.model.vo;

public class TagVO {

  private Integer id;
  private String name;

  private Boolean Selected;

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
    this.name = name;
  }

  public Boolean getSelected() {
    return Selected;
  }

  public void setSelected(Boolean selected) {
    Selected = selected;
  }

  @Override
  public String toString() {
    return "TagVO{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", Selected=" + Selected +
            '}';
  }
}
