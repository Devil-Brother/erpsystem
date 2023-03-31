package com.myc.erpsystem.service.iae.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myc.erpsystem.mapper.iae.OrderProductMapper;
import com.myc.erpsystem.model.User;
import com.myc.erpsystem.model.iae.OrderProduct;
import com.myc.erpsystem.model.store.ProductAttachOrder;
import com.myc.erpsystem.service.iae.ProductAttachOrderService;
import com.myc.erpsystem.mapper.iae.ProductAttachOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author Administrator
* @description 针对表【product_attach_order】的数据库操作Service实现
* @createDate 2023-03-28 15:00:29
*/
@Service
public class ProductAttachOrderServiceImpl extends ServiceImpl<ProductAttachOrderMapper, ProductAttachOrder>
    implements ProductAttachOrderService{
@Autowired
ProductAttachOrderMapper productAttachOrderMapper;
    @Override
    public Integer insertProduct(ProductAttachOrder product) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        product.setUserId(user.getId());
        int insert = productAttachOrderMapper.insert(product);
        return insert;
    }
@Autowired
    OrderProductMapper orderProductMapper;
    @Override
    public List<ProductAttachOrder> getAllProduct(Integer id) {
        if(id==null){
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Integer userId = user.getId();
            LambdaQueryWrapper<ProductAttachOrder> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(ProductAttachOrder::getUserId,userId);
            List<ProductAttachOrder> productAttachOrders = productAttachOrderMapper.selectList(queryWrapper);
           return productAttachOrders;

        }
        LambdaQueryWrapper<OrderProduct> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderProduct::getOid,id);

        List<OrderProduct> orderProducts = orderProductMapper.selectList(queryWrapper);
        ArrayList<ProductAttachOrder> products = new ArrayList<>();
        for (OrderProduct orderProduct : orderProducts) {
            LambdaQueryWrapper<ProductAttachOrder> queryWrapperPro = new LambdaQueryWrapper<>();
            queryWrapperPro.eq(ProductAttachOrder::getId,orderProduct.getPid());
            ProductAttachOrder product = productAttachOrderMapper.selectOne(queryWrapperPro);
            if (product!=null){

            products.add(product);
            }
        }

return products;
    /*
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer id = user.getId();
     LambdaQueryWrapper<ProductAttachOrder> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ProductAttachOrder::getUserId,id);
        List<ProductAttachOrder> productAttachOrders = productAttachOrderMapper.selectList(queryWrapper);
        List<ProductAttachOrder> productAttachOrders = productAttachOrderMapper.selectProductPage(id);

        return productAttachOrders;*/
    }
}




