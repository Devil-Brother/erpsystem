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
     * 提交产品到产品库
     * @param id
     * @return
     */
    Integer submitAllProductByOrderId(Integer id, Product product);
}
