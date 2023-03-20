package com.myc.erpsystem.service.iae;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myc.erpsystem.model.RespPageBean;
import com.myc.erpsystem.model.iae.Customer;

import java.util.Date;

/**
* @author Administrator
* @description 针对表【customer(客户表)】的数据库操作Service
* @createDate 2023-03-14 15:05:42
*/
public interface CustomerService extends IService<Customer> {

    RespPageBean getCustomerByPage(Integer page,Integer size,Customer customer, Date[] beginDateScope);
}
