package com.myc.erpsystem.service.store.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myc.erpsystem.mapper.store.ProStoMapper;
import com.myc.erpsystem.model.RespPageBean;
import com.myc.erpsystem.model.store.ProSto;
import com.myc.erpsystem.model.store.Product;
import com.myc.erpsystem.service.store.ProStoService;
import com.myc.erpsystem.service.store.ProductService;
import com.myc.erpsystem.mapper.store.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【product】的数据库操作Service实现
* @createDate 2023-03-15 15:04:53
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService{
@Autowired
ProductMapper productMapper;
@Autowired
    ProStoMapper proStoMapper;
    @Override
    public RespPageBean getProductPage(Integer page, Integer size, Product product) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
       List<Product> products =  productMapper.selectProductPage(page,size,product);
      Integer total =  productMapper.selectProductCount(page,size,product);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(products);
        respPageBean.setTotal(Long.valueOf(total));
        return respPageBean;
    }
/*
    @Override
    public boolean addProduct(Product product) {
        int insert = productMapper.insert(product);

        LambdaQueryWrapper<Product> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Product::getCode, product.getCode());


        Integer sid = product.getStoreId();
        Integer pid = product.getId();
        ProSto proSto = new ProSto();
        proSto.setSid(sid);
        proSto.setPid(pid);
        int insert1 = proStoMapper.insert(proSto);
        if (insert1!=1){
            return false;
        }
        return true;
    }*/
}




