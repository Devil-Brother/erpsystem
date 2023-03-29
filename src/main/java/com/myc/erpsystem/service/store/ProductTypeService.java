package com.myc.erpsystem.service.store;

import com.myc.erpsystem.model.RespPageBean;
import com.myc.erpsystem.model.store.ProductType;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【product_type】的数据库操作Service
* @createDate 2023-03-15 15:15:18
*/
public interface ProductTypeService extends IService<ProductType> {
    /**
     * 查询产品类型
     * @param page
     * @param size
     * @param name
     * @return
     */
    RespPageBean getProductTypePage(Integer page, Integer size, String name);
}
