package com.myc.erpsystem.controller.order;

import com.myc.erpsystem.model.Employee;
import com.myc.erpsystem.model.RespBean;
import com.myc.erpsystem.model.RespPageBean;
import com.myc.erpsystem.model.iae.Customer;
import com.myc.erpsystem.service.iae.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Author myc
 * @Date 2023/3/14 15:01
 * @PackageName:com.myc.erpsystem.controller.order
 * @ClassName: CustomerConstroller
 * @Description: TODO
 * @Version 1.0
 */
@RestController
@RequestMapping("/customer/basic")
public class CustomerController {
@Autowired
    CustomerService customerService;
    @GetMapping("/")
    public RespPageBean getEmployeeByPage( Customer customer, Date[] beginDateScope) {
        return customerService.getCustomerByPage(customer,beginDateScope);
    }

    @PostMapping("/")
    public RespBean addEmp(@RequestBody Customer customer) {
        if (customerService.save(customer)) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

}
