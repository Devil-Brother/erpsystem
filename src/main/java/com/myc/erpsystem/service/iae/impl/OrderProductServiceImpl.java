package com.myc.erpsystem.service.iae.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myc.erpsystem.mapper.iae.OrderProductMapper;
import com.myc.erpsystem.model.iae.OrderProduct;
import com.myc.erpsystem.service.iae.OrderProductService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【order_product】的数据库操作Service实现
* @createDate 2023-03-19 21:31:14
*/
@Service
public class OrderProductServiceImpl extends ServiceImpl<OrderProductMapper, OrderProduct>
    implements OrderProductService {

}




