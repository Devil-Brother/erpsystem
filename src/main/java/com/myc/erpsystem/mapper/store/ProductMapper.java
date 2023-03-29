package com.myc.erpsystem.mapper.store;

import com.myc.erpsystem.model.NormalRequest;
import com.myc.erpsystem.model.store.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author Administrator
* @description 针对表【product】的数据库操作Mapper
* @createDate 2023-03-15 15:04:53
* @Entity com.myc.erpsystem.model.store.Product
*/
public interface ProductMapper extends BaseMapper<Product> {

    List<Product> selectProductPage(Integer page, Integer size, Product product, NormalRequest normalRequest);

    Integer selectProductCount(Integer page, Integer size, Product product, NormalRequest normalRequest);
}




