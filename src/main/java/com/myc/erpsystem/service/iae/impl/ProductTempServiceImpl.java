package com.myc.erpsystem.service.iae.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myc.erpsystem.mapper.iae.ProductTempMapper;
import com.myc.erpsystem.model.iae.ProductTemp;
import com.myc.erpsystem.model.store.Product;
import com.myc.erpsystem.service.iae.ProductTempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【product_temp】的数据库操作Service实现
* @createDate 2023-03-19 21:31:07
*/
@Service
public class ProductTempServiceImpl extends ServiceImpl<ProductTempMapper, ProductTemp>
    implements ProductTempService {
@Autowired
ProductTempMapper productTempMapper;
    @Override
    public List<ProductTemp> getAllProductByOrderId(Integer id) {

        List<ProductTemp>  products =  productTempMapper.getAllProductByOrderId(id);
        return products;
    }



    @Override
    public List<ProductTemp> getAllProductBySaleId(Integer id) {

        List<ProductTemp>  products =  productTempMapper.getAllProductBySaleId(id);
        return products;
    }
}




