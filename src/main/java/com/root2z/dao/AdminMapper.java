package com.root2z.dao;

import com.root2z.model.entity.Admin;
import com.root2z.model.vo.AdminVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(Admin record);

  int insertSelective(Admin record);

  Admin selectByUserName(String loginUser);

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
   *
   * @param reNewPassword 新密码
   * @param username 用户名
   */
  int updateByUserName(
      @Param("ReNewPassword") String reNewPassword, @Param("username") String username);

  /**
   * 更新用户信息
   *
   * @param adminVO
   * @return
   */
  int updateUserById(AdminVO adminVO);
}
