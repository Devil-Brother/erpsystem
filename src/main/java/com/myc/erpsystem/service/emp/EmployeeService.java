package com.myc.erpsystem.service.emp;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myc.erpsystem.model.Employee;
import com.myc.erpsystem.model.RespPageBean;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author myc
 * @Date 2023/3/7 15:14
 * @PackageName:com.myc.erpsystem.service.emp
 * @ClassName: EmployeeService
 * @Description: TODO
 * @Version 1.0
 */

public interface EmployeeService extends IService<Employee> {

    RespPageBean getEmployeeByPage(Integer page, Integer size, Employee employee, Date[] beginDateScope);

}
