package com.myc.erpsystem.service.store.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myc.erpsystem.mapper.store.UnitMeasMapper;
import com.myc.erpsystem.model.RespPageBean;
import com.myc.erpsystem.model.store.ProductMaterial;
import com.myc.erpsystem.mapper.store.ProductMaterialMapper;
import com.myc.erpsystem.model.store.UnitMeas;
import com.myc.erpsystem.service.store.ProductMaterialService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【product_material】的数据库操作Service实现
* @createDate 2023-03-28 17:05:54
*/
@Service
public class ProductMaterialServiceImpl extends ServiceImpl<ProductMaterialMapper, ProductMaterial>
    implements ProductMaterialService {

    @Autowired
    ProductMaterialMapper productTypeMapper;
    @Override
    public RespPageBean getProductTypePage(Integer page, Integer size, String name) {

        LambdaQueryWrapper<ProductMaterial> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotEmpty(name),ProductMaterial::getName,name);

        Page<ProductMaterial> UnitMeasPage = new Page<>(page,size);

        Page<ProductMaterial> typePage = productTypeMapper.selectPage(UnitMeasPage, queryWrapper);
        long total = typePage.getTotal();
        List<ProductMaterial> records = typePage.getRecords();
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(records);
        respPageBean.setTotal(total);
        return respPageBean;

    }


}




