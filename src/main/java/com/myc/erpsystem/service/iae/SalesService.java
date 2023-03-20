package com.myc.erpsystem.service.iae;


import com.baomidou.mybatisplus.extension.service.IService;
import com.myc.erpsystem.model.RespPageBean;
import com.myc.erpsystem.model.iae.Order;
import com.myc.erpsystem.model.iae.Sales;

import java.util.Date;

/**
* @author Administrator
* @description 针对表【sales】的数据库操作Service
* @createDate 2023-03-21 00:08:48
*/
public interface SalesService extends IService<Sales> {
    /**
     * 获取审核订单
     * @param page
     * @param size
     * @param sales
     * @param beginDateScope
     * @return
     */
    RespPageBean getSalesByPage(Integer page, Integer size, Sales sales, Date[] beginDateScope);
}
