package com.myc.erpsystem.mapper;

import com.myc.erpsystem.model.MenuRole;
import org.apache.ibatis.annotations.Param;

/**
 * @Author myc
 * @Date 2023/3/5 14:18
 * @PackageName:com.myc.erpsystem.mapper
 * @ClassName: MenuRoleMapper
 * @Description: TODO
 * @Version 1.0
 */

public interface MenuRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MenuRole record);

    int insertSelective(MenuRole record);

    MenuRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenuRole record);

    int updateByPrimaryKey(MenuRole record);

    void deleteByRid(Integer rid);

    Integer insertRecord(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}