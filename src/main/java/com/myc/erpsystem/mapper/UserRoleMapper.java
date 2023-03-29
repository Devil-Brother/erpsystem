package com.myc.erpsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.myc.erpsystem.model.UserRole;
import org.apache.ibatis.annotations.Param;

/**
* @author Administrator
* @description 针对表【user_role】的数据库操作Mapper
* @createDate 2023-03-23 10:18:07
* @Entity cen.domain.UserRole
*/
public interface UserRoleMapper extends BaseMapper<UserRole> {

    int insert(UserRole record);


    void deleteByHrid(Integer hrid);

    Integer addRole(@Param("hrid") Integer hrid, @Param("rids") Integer[] rids);

}




