package com.myc.erpsystem.service.iae;

import com.myc.erpsystem.model.store.ProductAttachOrder;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【product_attach_order】的数据库操作Service
* @createDate 2023-03-28 15:00:29
*/
public interface ProductAttachOrderService extends IService<ProductAttachOrder> {
    /**
     * 创建订单产品
     * @param product
     * @return
     */
    Integer insertProduct(ProductAttachOrder product);

    /**
     * 查询订单产品
     * @param id
     * @return
     */
    List<ProductAttachOrder> getAllProduct(Integer id);

}
