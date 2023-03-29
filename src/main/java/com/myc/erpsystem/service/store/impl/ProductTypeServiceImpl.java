package com.myc.erpsystem.service.store.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myc.erpsystem.model.RespPageBean;
import com.myc.erpsystem.model.store.Product;
import com.myc.erpsystem.model.store.ProductType;
import com.myc.erpsystem.service.store.ProductTypeService;
import com.myc.erpsystem.mapper.store.ProductTypeMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【product_type】的数据库操作Service实现
* @createDate 2023-03-15 15:15:18
*/
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType>
    implements ProductTypeService{
@Autowired
ProductTypeMapper productTypeMapper;
    @Override
    public RespPageBean getProductTypePage(Integer page, Integer size, String name) {

        LambdaQueryWrapper<ProductType> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotEmpty(name),ProductType::getName,name);

        Page<ProductType> productTypePage = new Page<>(page,size);

        Page<ProductType> typePage = productTypeMapper.selectPage(productTypePage, queryWrapper);
        long total = typePage.getTotal();
        List<ProductType> records = typePage.getRecords();
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(records);
        respPageBean.setTotal(total);
        return respPageBean;

    }
}




