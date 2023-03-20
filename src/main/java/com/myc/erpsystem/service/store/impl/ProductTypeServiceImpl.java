package com.myc.erpsystem.service.store.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myc.erpsystem.model.store.ProductType;
import com.myc.erpsystem.service.store.ProductTypeService;
import com.myc.erpsystem.mapper.store.ProductTypeMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【product_type】的数据库操作Service实现
* @createDate 2023-03-15 15:15:18
*/
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType>
    implements ProductTypeService{

}




