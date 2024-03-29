package com.myc.erpsystem.service.iae.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myc.erpsystem.model.RespPageBean;
import com.myc.erpsystem.model.iae.Customer;

import com.myc.erpsystem.mapper.iae.CustomerMapper;
import com.myc.erpsystem.service.iae.CustomerService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
* @author Administrator
* @description 针对表【customer(客户表)】的数据库操作Service实现
* @createDate 2023-03-14 15:05:42
*/
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer>
    implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public RespPageBean getCustomerByPage(Integer current, Integer size ,String name, Date[] beginDateScope) {
        if (current != null && size != null) {
            current = (current - 1) * size;
        }
        LambdaQueryWrapper<Customer> que = new LambdaQueryWrapper<>();
        que.like(StringUtils.isNotEmpty(name),Customer::getName,name);
        Page<Customer> page = new Page<>(current,size);
        customerMapper.selectPage(page,que);
        List<Customer> records = page.getRecords();
        long total = page.getTotal();

        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(records);
        respPageBean.setTotal(total);
        return respPageBean;

    }


}




