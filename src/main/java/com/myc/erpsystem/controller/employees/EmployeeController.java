package com.myc.erpsystem.controller.employees;


import com.myc.erpsystem.model.Employee;
import com.myc.erpsystem.model.RespPageBean;
import com.myc.erpsystem.service.emp.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author myc
 * @Date 2023/3/7 15:01
 * @PackageName:com.myc.erpsystem.controller.employees
 * @ClassName: Employee
 * @Description: TODO
 * @Version 1.0
 */


@RestController
@RequestMapping("/employee/basic")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
//    @Autowired
//    NationService nationService;
//    @Autowired
//    PoliticsstatusService politicsstatusService;
//    @Autowired
//    JobLevelService jobLevelService;
//    @Autowired
//    PositionService positionService;
//    @Autowired
//    DepartmentService departmentService;

    @GetMapping("/")
    public RespPageBean getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employee employee, Date[] beginDateScope) {
        return employeeService.getEmployeeByPage(page, size, employee,beginDateScope);
    }
//
//    @PostMapping("/")
//    public RespBean addEmp(@RequestBody Employee employee) {
//        if (employeeService.addEmp(employee) == 1) {
//            return RespBean.ok("添加成功!");
//        }
//        return RespBean.error("添加失败!");
//    }
//
//    @DeleteMapping("/{id}")
//    public RespBean deleteEmpByEid(@PathVariable Integer id) {
//        if (employeeService.deleteEmpByEid(id) == 1) {
//            return RespBean.ok("删除成功!");
//        }
//        return RespBean.error("删除失败!");
//    }
//
//    @PutMapping("/")
//    public RespBean updateEmp(@RequestBody Employee employee) {
//        if (employeeService.updateEmp(employee) == 1) {
//            return RespBean.ok("更新成功!");
//        }
//        return RespBean.error("更新失败!");
//    }
//
//    @GetMapping("/nations")
//    public List<Nation> getAllNations() {
//        return nationService.getAllNations();
//    }
//
//    @GetMapping("/politicsstatus")
//    public List<Politicsstatus> getAllPoliticsstatus() {
//        return politicsstatusService.getAllPoliticsstatus();
//    }
//
//    @GetMapping("/joblevels")
//    public List<JobLevel> getAllJobLevels() {
//        return jobLevelService.getAllJobLevels();
//    }
//    @GetMapping("/positions")
//    public List<Position> getAllPositions() {
//        return positionService.getAllPositions();
//    }
//
//
//
//    @GetMapping("/deps")
//    public List<Department> getAllDepartments() {
//        return departmentService.getAllDepartments();
//    }



}
