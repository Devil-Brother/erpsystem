package com.myc.erpsystem.service.iae;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myc.erpsystem.model.iae.OrderProduct;
import com.myc.erpsystem.model.store.ProductAttachOrder;

import java.util.List;

/**
* @author Administrator
* @description 针对表【order_product】的数据库操作Service
* @createDate 2023-03-19 21:31:14
*/
public interface OrderProductService extends IService<OrderProduct> {
    /**
     * 通过订单查询产品
     * @param id
     * @return
     */
    List<ProductAttachOrder> getAllProductByOrderId(Integer id);
}
