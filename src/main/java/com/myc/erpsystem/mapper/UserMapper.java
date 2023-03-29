package com.myc.erpsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.myc.erpsystem.model.Role;
import com.myc.erpsystem.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-03-23 10:17:40
* @Entity cen.domain.User
*/
public interface UserMapper extends BaseMapper<User> {
    List<Role> getHrRolesById(Integer id);


    int deleteByPrimaryKey(Integer id);


    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);



    List<User> getAllHrs(@Param("hrid") Integer hrid, @Param("keywords") String keywords);

    List<User> getAllHrsExceptCurrentHr(Integer id);

    Integer updatePasswd(@Param("hrid") Integer hrid, @Param("encodePass") String encodePass);

    Integer updateUserface(@Param("url") String url, @Param("id") Integer id);

}




