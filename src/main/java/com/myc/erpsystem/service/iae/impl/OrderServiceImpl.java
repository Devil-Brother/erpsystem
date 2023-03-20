package com.myc.erpsystem.service.iae.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myc.erpsystem.mapper.iae.OrderProductMapper;
import com.myc.erpsystem.mapper.iae.ProductTempMapper;
import com.myc.erpsystem.mapper.iae.SupplierMapper;
import com.myc.erpsystem.mapper.store.ProductMapper;
import com.myc.erpsystem.model.Hr;
import com.myc.erpsystem.model.RespPageBean;
import com.myc.erpsystem.model.iae.Order;
import com.myc.erpsystem.mapper.iae.OrderMapper;
import com.myc.erpsystem.model.iae.ProductTemp;
import com.myc.erpsystem.model.iae.Supplier;
import com.myc.erpsystem.model.store.Product;
import com.myc.erpsystem.service.iae.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Array;
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
    @Override
    public RespPageBean getOrderByPage(Integer page, Integer size, Order order, Date[] beginDateScope) {

        long total;
        if (page != null && size != null) {
            page = (page - 1) * size;
        }

        List<Order> data = orderMapper.getOrderByPage(page, size, order, beginDateScope);
           total = orderMapper.getEmployeeByPageCount(page, size, order, beginDateScope);
/*//           用户id
        Integer id = ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
//供应商
        LambdaQueryWrapper<Supplier> supplierLambdaQueryWrapper = new LambdaQueryWrapper<>();
        supplierLambdaQueryWrapper.eq(Supplier::getId,order.getSupplier());
        Supplier supplier = supplierMapper.selectOne(supplierLambdaQueryWrapper);*/


        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setTotal((long) total);
        respPageBean.setData(data);


        return respPageBean;
    }

    @Override
    public boolean examineOrderById(Integer id) {
  //           用户id
        Integer userid = ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
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
    private void putInStorage(Integer id) {

        ArrayList<Product> products = new ArrayList<>();
        List<ProductTemp> productOrders =productTemp.getAllProductByOrderId(id);
        for (ProductTemp productOrder : productOrders) {
            Product product = new Product();
            BeanUtils.copyProperties(productOrder, product);
            product.setId(null);
            products.add(product);
        productMapper.insert(product);
        }
        System.out.println(products);
        return;

    }


    @Override
    public boolean rejectOrderById(Integer id) {
        Integer userid = ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();

        Order order = new Order();
        order.setId(id);
        order.setComplete(2);
        order.setExamineId(userid);

        int i = orderMapper.updateById(order);
        return true;
    }
}




