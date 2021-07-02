package com.root2z.controller.admin;

import com.github.pagehelper.PageInfo;
import com.root2z.model.entity.Category;
import com.root2z.model.vo.ResultVO;
import com.root2z.service.CategoryService;
import com.root2z.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/** 后台管理分类视图 */
@Controller
@RequestMapping("/admin")
public class AdminCategoryController {

  private final CategoryService categoryService;

  @Autowired
  public AdminCategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  /**
   * 返回分类视图
   *
   * @return String 视图地址
   */
  @RequestMapping("/category")
  public String categoryView() {
    return "admin/category/categories";
  }

  /**
   * 分类列表视图
   *
   * @param pageNum 当前页码
   * @param pageSize 当前页面显示的数量
   * @return <code>Map<String,Object></code> 返回前端表格需要的对象
   */
  @RequestMapping("/categories")
  @ResponseBody
  public Map<String, Object> categoryList(
      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
      @RequestParam(value = "pageSize", defaultValue = "3", required = false) Integer pageSize) {
    PageInfo<Category> categoryListPage = categoryService.pageQueryCategory(pageNum, pageSize);

    Map<String, Object> result = new HashMap<>();
    result.put("total", categoryListPage.getTotal());
    result.put("rows", categoryListPage.getList());
    return result;
  }

  /**
   * 删除指定的分类
   *
   * @param id
   * @return
   */
  @RequestMapping("/category/delete/{id}")
  @ResponseBody
  public ResultVO deleteCategory(@PathVariable("id") Integer id) {
    if (categoryService.deleteCategoryById(id)) {
      return ResultUtil.success("删除分类成功!", null);
    }
    return ResultUtil.error("删除分类失败！", null);
  }

  /**
   * 增加标签
   *
   * @param category
   * @return
   */
  @RequestMapping(value = "/category/add", method = RequestMethod.POST)
  @ResponseBody
  public ResultVO addCategory(Category category) {
    if (categoryService.addCategory(category)) {
      return ResultUtil.success("新增分类成功!", null);
    }
    return ResultUtil.error("新增分类失败！", null);
  }

  /**
   * 编辑指定的分类
   *
   * @param category
   * @return
   */
  @RequestMapping("/category/edit")
  @ResponseBody
  public ResultVO deleteCategory(Category category) {
    if (categoryService.updateCategoryById(category)) {
      return ResultUtil.success("修改分类成功!", null);
    }
    return ResultUtil.error("修改分类失败！", null);
  }
}
