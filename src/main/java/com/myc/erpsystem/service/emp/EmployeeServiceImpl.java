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
        Page<Employee> page = new Page<>(current, size);
//        LambdaQueryWrapper<Employee> objectLambdaQueryWrapper = new LambdaQueryWrapper<>();
        employeeMapper.selectPage(page,null);
        long allPages = page.getPages();
        long total =  page.getTotal();
        List<Employee> records = page.getRecords();


        System.out.println("====================分页查询");
        System.out.println("总页数： "+allPages);
        System.out.println("总记录数： "+total);
        System.out.println("总记录数： "+records);

        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setTotal((long) total);
        respPageBean.setData(records);

        return respPageBean;
    }
}
