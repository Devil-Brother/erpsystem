package com.myc.erpsystem.service.iae.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myc.erpsystem.mapper.iae.OrderProductMapper;
import com.myc.erpsystem.mapper.iae.ProductAttachOrderMapper;
import com.myc.erpsystem.model.iae.OrderProduct;
import com.myc.erpsystem.model.store.ProductAttachOrder;
import com.myc.erpsystem.service.iae.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author Administrator
* @description 针对表【order_product】的数据库操作Service实现
* @createDate 2023-03-19 21:31:14
*/
@Service
public class OrderProductServiceImpl extends ServiceImpl<OrderProductMapper, OrderProduct>
    implements OrderProductService {
@Autowired
OrderProductMapper orderProductMapper;
@Autowired
    ProductAttachOrderMapper productAttachOrderMapper;
    @Override
    public List<ProductAttachOrder> getAllProductByOrderId(Integer id) {
        LambdaQueryWrapper<OrderProduct> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderProduct::getOid,id);
        List<OrderProduct> orderProducts = orderProductMapper.selectList(queryWrapper);
//        查询产品
        ArrayList<ProductAttachOrder> productAttachOrders = new ArrayList<>();
        for (OrderProduct orderProduct : orderProducts) {
        LambdaQueryWrapper<ProductAttachOrder> productAttachOrderLambdaQueryWrapper = new LambdaQueryWrapper<>();
            productAttachOrderLambdaQueryWrapper.eq(ProductAttachOrder::getId,orderProduct.getPid());
            ProductAttachOrder product = productAttachOrderMapper.selectOne(productAttachOrderLambdaQueryWrapper);
            productAttachOrders.add(product);
        }
        System.out.println(1);
        return productAttachOrders;
    }
}




