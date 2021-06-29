package com.root2z.controller.admin;

import com.github.pagehelper.PageInfo;
import com.root2z.model.entity.Tag;
import com.root2z.model.vo.ResultVO;
import com.root2z.service.TagService;
import com.root2z.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminTagController {

  private final Logger logger = LoggerFactory.getLogger(AdminTagController.class);

  private final TagService tagService;

  @Autowired
  public AdminTagController(TagService tagService) {
    this.tagService = tagService;
  }

  @RequestMapping("/tag")
  public String tagePge() {
    return "admin/tag/tags";
  }

  @RequestMapping("/tags")
  @ResponseBody
  public Map<String, Object> getTagList(
      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
      @RequestParam(value = "pageSize", defaultValue = "3", required = false) Integer pageSize) {
    PageInfo<Tag> tagList = tagService.PageQueryTag(pageNum, pageSize);

    Map<String, Object> result = new HashMap();
    result.put("total", tagList.getTotal());
    result.put("rows", tagList.getList());
    return result;
  }

  @RequestMapping("/tag/delete/{id}")
  @ResponseBody
  public ResultVO deleteTag(@PathVariable("id") Integer id) {
    logger.info(id.toString());
    if (tagService.deleteTag(id)) {
      return ResultUtil.success("删除成功!", null);
    }
    return ResultUtil.error("删除失败", null);
  }

  @RequestMapping(value = "/tag/edit", method = RequestMethod.POST)
  @ResponseBody
  public ResultVO editTag(Tag tag) {
    if (tagService.updateTag(tag)) {
      return ResultUtil.success("更新标签成功!", null);
    }
    return ResultUtil.error("更新标签失败!", null);
  }

  @RequestMapping(value = "/tag/add", method = RequestMethod.POST)
  @ResponseBody
  public ResultVO addTag(String name) {
    if (tagService.addTag(name)) {
      return ResultUtil.success("添加标签成功!", null);
    }
    return ResultUtil.error("添加标签失败!", null);
  }
}
