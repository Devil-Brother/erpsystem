package com.myc.erpsystem;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myc.erpsystem.mapper.EmployeeMapper;
import com.myc.erpsystem.mapper.HrMapper;
import com.myc.erpsystem.model.Employee;
import com.myc.erpsystem.model.Hr;
import com.myc.erpsystem.model.RespPageBean;
import com.myc.erpsystem.service.emp.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class ErpsystemApplicationTests {
@Autowired
private   HrMapper hrMapper;
    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    void contextLoads() {
    List<Hr> hrs = hrMapper.selectList(null);
    System.out.println("123");
    System.out.println(hrs);
}
//分页
@Test
void contextLoadsPage() {

//    public RespPageBean getEmployeeByPage(Integer page, Integer size, Employee employee, Date[] beginDateScope) {
//        LambdaQueryWrapper<Employee> userLambdaQueryWrapper = Wrappers.lambdaQuery();
//        userLambdaQueryWrapper.like(Employee::getUsername , "k");

    Page<Employee> userPage = new Page<>(1, 2);
//        IPage<Employee> userIPage = Employee.selectPage(userPage , userLambdaQueryWrapper);
    Page<Employee> employeePage = employeeMapper.selectPage(userPage,null);
    System.out.println("总页数： "+userPage.getPages());
    System.out.println("总记录数： "+userPage.getTotal());
//        userIPage.getRecords().forEach(System.out::println);
    System.out.println("====================分页查询");
    System.out.println(userPage);
}


}
