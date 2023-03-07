package com.myc.erpsystem.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.myc.erpsystem.mapper.MenuMapper;
import com.myc.erpsystem.mapper.MenuRoleMapper;
import com.myc.erpsystem.model.Hr;
import com.myc.erpsystem.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @Author myc
 * @Date 2023/3/5 14:02
 * @PackageName:com.myc.erpsystem.service
 * @ClassName: MenuService
 * @Description: TODO
 * @Version 1.0
 */


@Service
@CacheConfig(cacheNames = "menus_cache")
public class MenuService implements IService<Menu> {
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    MenuRoleMapper menuRoleMapper;
    public List<Menu> getMenusByHrId() {
//        菜单需要用户权限才可以获取到，所以需用用SecurityContextHolder获取登录的用户
//        只要获取到菜单，那么就会有对应的路径来访问其他资源
        Integer id = ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();

        return menuMapper.getMenusByHrId(id);
    }

    @Cacheable
    public List<Menu> getAllMenusWithRole() {
        return menuMapper.getAllMenusWithRole();
    }

    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }

//  ......................

    @Override
    public boolean saveBatch(Collection<Menu> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Menu> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<Menu> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Menu entity) {
        return false;
    }

    @Override
    public Menu getOne(Wrapper<Menu> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<Menu> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<Menu> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<Menu> getBaseMapper() {
        return null;
    }
}
