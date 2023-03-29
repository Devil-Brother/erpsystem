package com.myc.erpsystem.service.store.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myc.erpsystem.mapper.store.UnitMeasMapper;
import com.myc.erpsystem.mapper.store.UnitSpecMapper;
import com.myc.erpsystem.model.RespPageBean;
import com.myc.erpsystem.model.store.UnitMeas;
import com.myc.erpsystem.model.store.UnitSpec;
import com.myc.erpsystem.service.store.UnitSpecService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【unit_spec】的数据库操作Service实现
* @createDate 2023-03-15 20:07:29
*/
@Service
public class UnitSpecServiceImpl extends ServiceImpl<UnitSpecMapper, UnitSpec>
    implements UnitSpecService {
    @Autowired
    UnitSpecMapper productTypeMapper;
    @Override
    public RespPageBean getProductTypePage(Integer page, Integer size, String name) {

        LambdaQueryWrapper<UnitSpec> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotEmpty(name),UnitSpec::getUnit,name);

        Page<UnitSpec> UnitSpecMapperPage = new Page<>(page,size);

        Page<UnitSpec> typePage = productTypeMapper.selectPage(UnitSpecMapperPage, queryWrapper);
        long total = typePage.getTotal();
        List<UnitSpec> records = typePage.getRecords();
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(records);
        respPageBean.setTotal(total);
        return respPageBean;

    }
}




