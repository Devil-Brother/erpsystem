package com.myc.erpsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myc.erpsystem.model.Hr;
import com.myc.erpsystem.model.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author myc
 * @Date 2023/3/5 14:18
 * @PackageName:com.myc.erpsystem.mapper
 * @ClassName: MenuMapper
 * @Description: TODO
 * @Version 1.0
 */
@Repository
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 通过人事id查询对应菜单
     * @param hrid
     * @return
     */
    List<Menu> getMenusByHrId(Integer hrid);

    /**
     * 通过角色查询所有菜单
     * @return
     */
    List<Menu> getAllMenusWithRole();

}