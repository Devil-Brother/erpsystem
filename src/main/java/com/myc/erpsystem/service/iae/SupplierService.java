package com.myc.erpsystem.service.iae;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myc.erpsystem.model.RespPageBean;
import com.myc.erpsystem.model.iae.Supplier;

import java.util.Date;


/**
* @author Administrator
* @description 针对表【supplier】的数据库操作Service
* @createDate 2023-03-13 00:07:43
*/
public interface SupplierService extends IService<Supplier> {
     RespPageBean getCustomerByPage(Integer current, Integer size , String name, Date[] beginDateScope) ;


    }
