package com.myc.erpsystem.service.iae.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myc.erpsystem.mapper.iae.CustomerMapper;
import com.myc.erpsystem.mapper.iae.SupplierMapper;
import com.myc.erpsystem.model.RespPageBean;
import com.myc.erpsystem.model.iae.Customer;
import com.myc.erpsystem.model.iae.Supplier;

import com.myc.erpsystem.service.iae.SupplierService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author Administrator
* @description 针对表【supplier】的数据库操作Service实现
* @createDate 2023-03-13 00:07:43
*/
@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier>
    implements SupplierService {
    @Autowired
    SupplierMapper customerMapper;

    @Override
    public RespPageBean getCustomerByPage(Integer current, Integer size , String name, Date[] beginDateScope) {
        if (current != null && size != null) {
            current = (current - 1) * size;
        }
        LambdaQueryWrapper<Supplier> que = new LambdaQueryWrapper<>();
        que.like(StringUtils.isNotEmpty(name),Supplier::getName,name);
        Page<Supplier> page = new Page<>(current,size);
        customerMapper.selectPage(page,que);
        List<Supplier> records = page.getRecords();
        long total = page.getTotal();

        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(records);
        respPageBean.setTotal(total);
        return respPageBean;

    }

}




