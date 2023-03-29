package com.myc.erpsystem.service.store.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myc.erpsystem.config.exception.CustomSystemException;
import com.myc.erpsystem.mapper.store.ProductMapper;
import com.myc.erpsystem.model.RespBean;

import com.myc.erpsystem.model.store.Product;
import com.myc.erpsystem.model.store.Store;
import com.myc.erpsystem.service.store.StoreService;
import com.myc.erpsystem.mapper.store.StoreMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【store】的数据库操作Service实现
* @createDate 2023-03-15 15:09:23
*/
@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store>
    implements StoreService{
@Autowired
StoreMapper storeMapper;
    @Override
    public List<Store> getAllStore(String name) {
        LambdaQueryWrapper<Store> queryWrapper = new LambdaQueryWrapper<>();

            queryWrapper.like(StringUtils.isNotEmpty(name),Store::getName,name);
            List<Store> stores = storeMapper.selectList(queryWrapper);

        return stores;
    }

    @Override
    public Boolean updateStore(Store store) {
        int i = storeMapper.updateById(store);
        if (i==1)
            return true;
        else
            return false;
    }
@Autowired
    ProductMapper productMapper;
    @Override
    public boolean deleteStoreById(Integer storeId) {
        LambdaQueryWrapper<Product> productLambdaQueryWrapper = new LambdaQueryWrapper<>();
        productLambdaQueryWrapper.eq(Product::getStoreId,storeId);
        Product product = productMapper.selectOne(productLambdaQueryWrapper);
        if (product!=null){
            return false;
        }
        storeMapper.deleteById(storeId);
        return  true;

    }
}




