package com.myc.erpsystem.service.basic;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myc.erpsystem.mapper.MenuMapper;
import com.myc.erpsystem.mapper.MenuRoleMapper;
import com.myc.erpsystem.model.Hr;
import com.myc.erpsystem.model.Menu;
import com.myc.erpsystem.model.MenuRole;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author myc
 * @Date 2023/3/5 14:02
 * @PackageName:com.myc.erpsystem.service
 * @ClassName: MenuService
 * @Description: TODO
 * @Version 1.0
 */


@Service
//@CacheConfig(cacheNames = "menus_cache")
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    MenuRoleMapper menuRoleMapper;

    @Override
    public List<Menu> getMenusByHrId() {
        //        菜单需要用户权限才可以获取到，所以需用用SecurityContextHolder获取登录的用户
//        只要获取到菜单，那么就会有对应的路径来访问其他资源
        Integer id = ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        List<Menu> menusByHrId = menuMapper.getMenusByHrId(id);
        return menusByHrId;
    }

    public List<Menu> getAllMenusWithRole() {
        return menuMapper.getAllMenusWithRole();
    }

    @Override
    public List<Integer> getMidsByRid(Integer rid) {
        LambdaQueryWrapper<MenuRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MenuRole::getRid, rid);
        List<MenuRole> menuRoles = menuRoleMapper.selectList(queryWrapper);
        ArrayList<Integer> integers = new ArrayList<>();
        for (MenuRole menuRole : menuRoles) {
            integers.add(menuRole.getMid());
        }
        return integers;
    }

    @Override
    public boolean updateMenuRole(Integer rid, Integer[] mids) {
        LambdaQueryWrapper<MenuRole> queryWrapper = new LambdaQueryWrapper<>();
        if (mids != null && rid != null) {
        queryWrapper.eq(MenuRole::getRid,rid);
//        先删除所有权限
            int delete = menuRoleMapper.delete(queryWrapper);
            MenuRole menuRole = new MenuRole();
            for (Integer mid : mids) {
                menuRole.setMid(mid);
                menuRole.setRid(rid);
                 menuRoleMapper.insert(menuRole);
            }
            return true;
        }

        return false;


    }
}
