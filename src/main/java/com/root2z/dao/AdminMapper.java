package com.root2z.dao;

import com.root2z.model.entity.Admin;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(Admin record);

  int insertSelective(Admin record);

  Admin selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Admin record);

  int updateByPrimaryKey(Admin record);

  /**
   * 根据用户名查询用户，并且是查询已激活的
   *
   * @param username
   * @return
   */
  Admin selectByUserNameAndPassword(String username, String password);

  /**
   * 统计用户数
   *
   * @return
   */
  Integer totalCount();

  /**
   * 根据用户ID更新密码
   * @param ReNewPassword
   * @param loginUserId
   * @return
   */
  int updateById(
      @Param("ReNewPassword") String ReNewPassword, @Param("loginUserId") Integer loginUserId);
}
