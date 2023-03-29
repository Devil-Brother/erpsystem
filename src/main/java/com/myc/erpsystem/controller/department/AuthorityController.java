package com.myc.erpsystem.controller.department;

import com.myc.erpsystem.model.Menu;
import com.myc.erpsystem.model.RespBean;
import com.myc.erpsystem.model.Role;
import com.myc.erpsystem.service.basic.MenuService;
import com.myc.erpsystem.service.basic.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author myc
 * @Date 2023/3/9 16:32
 * @PackageName:com.myc.erpsystem.controller.department
 * @ClassName: AuthorityController
 * @Description: TODO
 * @Version 1.0
 */
@RestController
@RequestMapping("/dppo/authority")
public class AuthorityController {
    @Autowired
    RoleService roleService;
    @Autowired
    MenuService menuService;

    @GetMapping("/")
    public List<Role> getAllRoles() {
        return roleService.list();
    }

    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuService.list();
    }

    @GetMapping("/mids/{rid}")
    public List<Integer> getMidsByRid(@PathVariable Integer rid) {

        return menuService.getMidsByRid(rid);
    }

    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {

        if (menuService.updateMenuRole(rid, mids)) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role) {
        boolean save = roleService.save(role);
        if (save) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/role/{rid}")
    public RespBean deleteRoleById(@PathVariable Integer rid) {

        boolean b= roleService.deleteRoleAndMRoleById(rid);
        if (b) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}
