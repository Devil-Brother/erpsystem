package com.myc.erpsystem.mapper.iae;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myc.erpsystem.model.iae.ProductTemp;

import java.util.List;

/**
* @author Administrator
* @description 针对表【product_temp】的数据库操作Mapper
* @createDate 2023-03-19 21:31:07
* @Entity cen.domain.ProductTemp
*/
public interface ProductTempMapper extends BaseMapper<ProductTemp> {
    /**
     * 查询未审核订单的产品
     * @param oid
     * @return
     */
    List<ProductTemp> getAllProductByOrderId(Integer oid);
}




