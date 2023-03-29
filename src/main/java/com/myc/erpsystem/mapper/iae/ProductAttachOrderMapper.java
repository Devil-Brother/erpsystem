package com.myc.erpsystem.mapper.iae;

import com.myc.erpsystem.model.store.ProductAttachOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author Administrator
* @description 针对表【product_attach_order】的数据库操作Mapper
* @createDate 2023-03-28 15:00:29
* @Entity com.myc.erpsystem.model.store.ProductAttachOrder
*/
public interface ProductAttachOrderMapper extends BaseMapper<ProductAttachOrder> {
    List<ProductAttachOrder> selectProductPage(Integer userId);

    Integer selectProductCount(Integer userId);
}




