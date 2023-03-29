package com.myc.erpsystem.service.store.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myc.erpsystem.mapper.store.ProductTypeMapper;
import com.myc.erpsystem.mapper.store.UnitMeasMapper;
import com.myc.erpsystem.model.RespPageBean;
import com.myc.erpsystem.model.store.ProductType;
import com.myc.erpsystem.model.store.UnitMeas;
import com.myc.erpsystem.service.store.UnitMeasService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【unit_meas】的数据库操作Service实现
* @createDate 2023-03-15 20:07:22
*/
@Service
public class UnitMeasServiceImpl extends ServiceImpl<UnitMeasMapper, UnitMeas>
    implements UnitMeasService {
    @Autowired
    UnitMeasMapper productTypeMapper;
    @Override
    public RespPageBean getProductTypePage(Integer page, Integer size, String name) {

        LambdaQueryWrapper<UnitMeas> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotEmpty(name),UnitMeas::getUnit,name);

        Page<UnitMeas> UnitMeasPage = new Page<>(page,size);

        Page<UnitMeas> typePage = productTypeMapper.selectPage(UnitMeasPage, queryWrapper);
        long total = typePage.getTotal();
        List<UnitMeas> records = typePage.getRecords();
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(records);
        respPageBean.setTotal(total);
        return respPageBean;

    }

}




