package com.myc.erpsystem.controller.department;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.myc.erpsystem.mapper.DepartmentMapper;
import com.myc.erpsystem.model.Department;
import com.myc.erpsystem.model.RespBean;
import com.myc.erpsystem.service.basic.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author myc
 * @Date 2023/3/9 15:06
 * @PackageName:com.myc.erpsystem.controller.department
 * @ClassName: DepartmentController
 * @Description: TODO
 * @Version 1.0
 */
@RestController
@RequestMapping("/dppo/deps")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @GetMapping("/")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }
    @PostMapping("/")
    public RespBean addDep(@RequestBody Department dep) {
        dep.setId(123);
        boolean save = departmentService.save(dep);
        if (save) {
            return RespBean.ok("添加成功", dep);
        }
        return RespBean.error("添加失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteDepById(@PathVariable Integer id) {
        Department dep = new Department();
        dep.setId(id);
        departmentService.deleteDepById(dep);
        if (dep.getResult() == -2) {
            return RespBean.error("该部门下有子部门，删除失败");
        } else if (dep.getResult() == -1) {
            return RespBean.error("该部门下有员工，删除失败");
        } else if (dep.getResult() == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

}
