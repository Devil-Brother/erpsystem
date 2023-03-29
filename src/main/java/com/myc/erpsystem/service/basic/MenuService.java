package com.myc.erpsystem.service.basic;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myc.erpsystem.model.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author myc
 * @Date 2023/3/9 19:44
 * @PackageName:com.myc.erpsystem.service.basic
 * @ClassName: MenuService
 * @Description: TODO
 * @Version 1.0
 */
@Repository
public interface MenuService extends IService<Menu> {
    /**
     * 通过hrid获取菜单
     * @return
     */
    List<Menu> getMenusByHrId();

    /**
     * 获取所有角色对应的菜单
     * @return
     */
     List<Menu> getAllMenusWithRole() ;

    /**
     * 通过角色id查询角色所有菜单权限
     * @param rid
     * @return
     */
    List<Integer> getMidsByRid(Integer rid);

    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    boolean updateMenuRole(Integer rid, Integer[] mids);
}
