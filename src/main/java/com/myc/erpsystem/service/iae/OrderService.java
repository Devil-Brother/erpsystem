package com.myc.erpsystem.service.iae;

import com.myc.erpsystem.model.RespPageBean;
import com.myc.erpsystem.model.iae.Order;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;

/**
* @author Administrator
* @description 针对表【order】的数据库操作Service
* @createDate 2023-03-12 23:54:41
*/
public interface OrderService extends IService<Order> {
    /**
     * 获取审核订单
     * @param page
     * @param size
     * @param order
     * @param beginDateScope
     * @return
     */
    RespPageBean getOrderByPage(Integer page, Integer size, Order order, Date[] beginDateScope);

    /**
     * 审核
     * @param id
     * @return
     */
    boolean examineOrderById(Integer id);

    /**
     * 驳回
     * @param id
     * @return
     */
    boolean rejectOrderById(Integer id);
}
