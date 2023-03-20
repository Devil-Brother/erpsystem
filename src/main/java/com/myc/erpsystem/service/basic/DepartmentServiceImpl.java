package com.myc.erpsystem.service.basic;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myc.erpsystem.mapper.DepartmentMapper;
import com.myc.erpsystem.mapper.EmployeeMapper;
import com.myc.erpsystem.model.Department;
import com.myc.erpsystem.model.Employee;
import com.myc.erpsystem.model.RespPageBean;
import com.myc.erpsystem.service.emp.EmployeeService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author myc
 * @Date 2023/3/7 15:20
 * @PackageName:com.myc.erpsystem.service.emp
 * @ClassName: EmployeeServiceImpl
 * @Description: TODO
 * @Version 1.0
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;


    @Override
    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartmentsByParentId(-1);
    }

    @Override
    public void deleteDepById(Department dep) {
        departmentMapper.deleteDepById(dep);
    }


}
