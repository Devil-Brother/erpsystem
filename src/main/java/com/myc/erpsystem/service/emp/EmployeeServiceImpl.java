package com.myc.erpsystem.service.emp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myc.erpsystem.mapper.EmployeeMapper;
import com.myc.erpsystem.model.Employee;
import com.myc.erpsystem.model.RespPageBean;
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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements EmployeeService{
@Autowired
EmployeeMapper employeeMapper;
    @Override
    public RespPageBean getEmployeeByPage(Integer current, Integer size, Employee employee, Date[] beginDateScope) {

        if (current != null && size != null) {
            current = (current - 1) * size;
        }
        List<Employee> data = employeeMapper.getEmployeeByPage(current, size, employee, beginDateScope);
        Integer total = employeeMapper.getEmployeeTotal(employee, beginDateScope);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setTotal(Long.valueOf(total));
        respPageBean.setData(data);
        return respPageBean;
    }




    /**
     * 添加员工
     * @param employee
     * @return
     */
    @Override
    public int addEmp(Employee employee) {
/*
  LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        employeeLambdaQueryWrapper.eq(Employee::getId,employee.getId());
        */
        int insert = employeeMapper.insert(employee);
        return insert;
    }

    /**
     *  删除员工
     * @param id
     * @return
     */
    @Override
    public int deleteEmpByEid(Integer id) {
        int i = employeeMapper.deleteById(id);
        System.out.println(i);
        return i;
    }

    /**
     * 更新员工
     * @param employee
     * @return
     */
    @Override
    public int updateEmp(Employee employee) {
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getId,employee.getId());
        int update = employeeMapper.update(employee, queryWrapper);
        return update;
    }

    @Override
    public RespPageBean getEmployeeByPageWithSalary(Integer page, Integer size) {

            if (page != null && size != null) {
                page = (page - 1) * size;
            }
            List<Employee> list = employeeMapper.getEmployeeByPageWithSalary(page, size);
            RespPageBean respPageBean = new RespPageBean();
            respPageBean.setData(list);
            respPageBean.setTotal(employeeMapper.getTotal(null, null));
            return respPageBean;
        }

    @Override
    public Integer updateEmployeeSalaryById(Integer eid, Integer sid) {
        return employeeMapper.updateEmployeeSalaryById(eid, sid);

    }

    @Override
    public Integer maxWorkID() {
        return employeeMapper.maxWorkID();
    }

}
