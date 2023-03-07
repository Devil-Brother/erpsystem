package com.myc.erpsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myc.erpsystem.model.Hr;
import com.myc.erpsystem.model.Menu;

import java.util.List;

/**
 * @Author myc
 * @Date 2023/3/5 14:18
 * @PackageName:com.myc.erpsystem.mapper
 * @ClassName: MenuMapper
 * @Description: TODO
 * @Version 1.0
 */

public interface MenuMapper extends BaseMapper<Menu> {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> getMenusByHrId(Integer hrid);

    List<Menu> getAllMenusWithRole();

    List<Menu> getAllMenus();

    List<Integer> getMidsByRid(Integer rid);
}