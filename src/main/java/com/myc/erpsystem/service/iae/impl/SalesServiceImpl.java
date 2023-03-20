package com.myc.erpsystem.service.iae.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myc.erpsystem.mapper.iae.OrderMapper;
import com.myc.erpsystem.mapper.iae.ProductTempMapper;
import com.myc.erpsystem.mapper.iae.SalesMapper;
import com.myc.erpsystem.mapper.iae.SupplierMapper;
import com.myc.erpsystem.model.RespPageBean;
import com.myc.erpsystem.model.iae.Order;
import com.myc.erpsystem.model.iae.Sales;
import com.myc.erpsystem.service.iae.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author Administrator
* @description 针对表【sales】的数据库操作Service实现
* @createDate 2023-03-21 00:08:48
*/
@Service
public class SalesServiceImpl extends ServiceImpl<SalesMapper, Sales>
    implements SalesService {
    @Autowired
    SalesMapper salesMapper;
    @Autowired
    SupplierMapper supplierMapper;
    @Autowired
    ProductTempMapper productTemp;

    @Override
    public RespPageBean getSalesByPage(Integer page, Integer size, Sales sales, Date[] beginDateScope) {

        long total;
        if (page != null && size != null) {
            page = (page - 1) * size;
        }

        List<Sales> data = salesMapper.getSaleByPage(page, size, sales, beginDateScope);
        total = salesMapper.getSaleByPageCount(page, size, sales, beginDateScope);


        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setTotal((long) total);
        respPageBean.setData(data);

        return respPageBean;
    }
}




