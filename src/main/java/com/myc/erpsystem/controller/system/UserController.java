package com.myc.erpsystem.controller.system;

import com.myc.erpsystem.model.*;
import com.myc.erpsystem.service.basic.RoleService;
import com.myc.erpsystem.service.basic.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author myc
 * @Date 2023/3/29 9:48
 * @PackageName:com.myc.erpsystem.controller.system
 * @ClassName: UserController
 * @Description: TODO
 * @Version 1.0
 */
@RestController
@RequestMapping("/user/basic")
public class UserController {
    @Autowired
    UserService hrService;
    @Autowired
    RoleService roleService;
    @GetMapping("/")
    public List<User> getAllHrs(@RequestParam String name) {
            return hrService.getAllHrs(name);
    }
    @PostMapping("/")
        public  RespBean addUser(@RequestBody User user){

        if (hrService.addUser(user, 1)) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");

    }

    @PutMapping("/")
    public RespBean updateHr(@RequestBody User hr) {
        if (hrService.updateHr(hr) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.list();
    }

    @PutMapping("/role")
    public RespBean updateHrRole(Integer hrid, Integer[] rids) {
        if (hrService.updateHrRole(hrid, rids)) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteHrById(@PathVariable Integer id) {
        if (hrService.deleteHrById(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}
