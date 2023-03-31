package com.myc.erpsystem.service.iae.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myc.erpsystem.mapper.UserMapper;
import com.myc.erpsystem.mapper.iae.*;
import com.myc.erpsystem.mapper.store.ProductMapper;
import com.myc.erpsystem.model.Hr;
import com.myc.erpsystem.model.NormalRequest;
import com.myc.erpsystem.model.RespPageBean;
import com.myc.erpsystem.model.User;
import com.myc.erpsystem.model.iae.Order;
import com.myc.erpsystem.model.iae.OrderProduct;
import com.myc.erpsystem.model.iae.ProductTemp;
import com.myc.erpsystem.model.iae.Supplier;
import com.myc.erpsystem.model.store.Product;
import com.myc.erpsystem.model.store.ProductAttachOrder;
import com.myc.erpsystem.service.iae.OrderService;
import com.myc.erpsystem.service.iae.ProductAttachOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @author Administrator
* @description 针对表【order】的数据库操作Service实现
* @createDate 2023-03-12 23:54:41
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService {
@Autowired
OrderMapper orderMapper;
@Autowired
    SupplierMapper supplierMapper;
@Autowired
ProductTempMapper productTemp;
@Autowired
    UserMapper userMapper;
    @Override
    public RespPageBean getOrderByPage(Integer page, Integer size, Order order, NormalRequest normalRequest) {

        long total;
        if (page != null && size != null) {
            page = (page - 1) * size;
        }

        List<Order> data = orderMapper.getOrderByPage(page, size, order, normalRequest);
           total = orderMapper.getEmployeeByPageCount(page, size, order, normalRequest);


        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setTotal((long) total);
        respPageBean.setData(data);


        return respPageBean;
    }

    @Override
    public boolean examineOrderById(Integer id) {
  //           用户id
        Integer userid = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
//审核人员
/*        LambdaQueryWrapper<Supplier> supplierLambdaQueryWrapper = new LambdaQueryWrapper<>();

        Supplier supplier = supplierMapper.selectOne(supplierLambdaQueryWrapper);*/
        Order order = new Order();
        order.setId(id);
        order.setComplete(1);
        order.setExamineId(userid);

        int i = orderMapper.updateById(order);
//        如果审核成功，那么就进行入库处理
        if (i==1){
            putInStorage(id);
        }
        return true;
    }
@Autowired
    ProductMapper productMapper;
    @Autowired
    ProductAttachOrderMapper proMapper;
    private void putInStorage(Integer id) {

        ArrayList<Product> products = new ArrayList<>();
        Order order = orderMapper.selectById(id);
        List<ProductAttachOrder> allProductByOrderId = proMapper.getAllProductByOrderId(order.getId());

        for (ProductAttachOrder productOrder : allProductByOrderId) {
            Product product = new Product();
            BeanUtils.copyProperties(productOrder, product);
            product.setId(null);
            product.setSupplierId(order.getSupplierId());
            product.setStoreId(order.getSupplierId());

            products.add(product);
        productMapper.insert(product);
        }
        System.out.println(products);
        return;

    }


    @Override
    public boolean rejectOrderById(Integer id) {
        Integer userid = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        Order order = new Order();
        order.setId(id);
        order.setComplete(2);
        order.setExamineId(userid);
        int i = orderMapper.updateById(order);
        return true;
    }
@Autowired
    ProductAttachOrderMapper productAttachOrderMapper;
    @Autowired
    OrderProductMapper orderProductMapper;
    @Override
    public Boolean saveOrder(Order order) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

//        新建订单
        order.setExamineId(user.getId());
        order.setPeople(user.getName());
        order.setDate(new Date());
        order.setComplete(0);
        int insert = orderMapper.insert(order);
//        查询出产品
        LambdaQueryWrapper<ProductAttachOrder> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ProductAttachOrder::getUserId,user.getId());
        List<ProductAttachOrder> productAttachOrders = productAttachOrderMapper.selectList(queryWrapper);
//        productAttachOrderMapper.delete(queryWrapper);
//
        System.out.println(order);

//        将订单和当前的产品表进行关联关联的
        LambdaQueryWrapper<OrderProduct> queryWrapperOrderProduct = new LambdaQueryWrapper<>();
        for (ProductAttachOrder productAttachOrder : productAttachOrders) {
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setOid(order.getId());
            orderProduct.setPid(productAttachOrder.getId());
            orderProductMapper.insert(orderProduct);
//            更新产品
            productAttachOrder.setUserId(0);
            productAttachOrderMapper.updateById(productAttachOrder);
        }

        if (insert==1)
            return true;
        return false;
    }
}




