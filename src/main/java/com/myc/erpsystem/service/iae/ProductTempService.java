package com.myc.erpsystem.service.iae;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myc.erpsystem.model.iae.ProductTemp;
import com.myc.erpsystem.model.store.Product;

import java.util.List;

/**
* @author Administrator
* @description 针对表【product_temp】的数据库操作Service
* @createDate 2023-03-19 21:31:07
*/
public interface ProductTempService extends IService<ProductTemp> {
    /**
     * 通过订单id获取下面的所有产品
     * @param id
     * @return
     */
    List<ProductTemp> getAllProductByOrderId(Integer id);

    /**
     * 通过销售订单id获取产品
     * @param id
     * @return
     */
    List<ProductTemp> getAllProductBySaleId(Integer id);
}
