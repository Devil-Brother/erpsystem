package com.myc.erpsystem.service.store;

import com.myc.erpsystem.model.RespPageBean;
import com.myc.erpsystem.model.store.Product;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【product】的数据库操作Service
* @createDate 2023-03-15 15:04:53
*/
public interface ProductService extends IService<Product> {
    /**
     * 分页查询所有产品
     * @param page
     * @param size
     * @param product
     * @return
     */
    RespPageBean getProductPage(Integer page, Integer size, Product product);
/*
    *//**
     * 添加产品
     * @param product
     * @return
     *//*
    boolean addProduct(Product product);*/
}
