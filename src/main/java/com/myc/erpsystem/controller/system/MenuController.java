package com.myc.erpsystem.controller.system;

import com.myc.erpsystem.model.Menu;
import com.myc.erpsystem.service.basic.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author myc
 * @Date 2023/3/7 13:10
 * @PackageName:com.myc.erpsystem.controller
 * @ClassName: MenuController
 * @Description: TODO
 * @Version 1.0
 */
@RestController
@RequestMapping("/system/config")
public class MenuController {
    @Autowired
    MenuService menuService;
    @GetMapping("/menu")
    public List<Menu> getMenusByHrId() {
        return menuService.getMenusByHrId();
    }
}