package com.myc.erpsystem.controller.order;

import com.myc.erpsystem.model.*;
import com.myc.erpsystem.model.iae.Order;
import com.myc.erpsystem.model.iae.ProductTemp;
import com.myc.erpsystem.model.store.Product;
import com.myc.erpsystem.service.iae.OrderService;
import com.myc.erpsystem.service.iae.ProductTempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author myc
 * @Date 2023/3/12 23:31
 * @PackageName:com.myc.erpsystem.controller.order
 * @ClassName: OrderController
 * @Description: TODO
 * @Version 1.0
 */
@RequestMapping("/order")
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    ProductTempService productTempService;
    @GetMapping("/")
    public RespPageBean getOrderByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Order order, Date[] beginDateScope) {
        return orderService.getOrderByPage(page, size, order,beginDateScope);
    }
    @GetMapping("/product/{id}")
    public RespBean getOrderProductsById(@PathVariable Integer id){
       List<ProductTemp> productOrders =productTempService.getAllProductByOrderId(id);
       if (productOrders.size()!=0){
        return RespBean.ok("",productOrders);
       }
       return null;
    }
/*    @PostMapping("/product/{id}")
    public RespBean submitAllProductByOrderId(@PathVariable Integer id, Product product){
        Integer i =productTempService.submitAllProductByOrderId(id,product);

        return null;
    }*/
    @PostMapping("/product")
    public RespBean examineOrderById(@RequestParam() Integer id,@RequestParam()Integer sign){
        if (sign == 1) {
            if (orderService.examineOrderById(id)) {

                return RespBean.ok("审核成功！");
            } else

                return RespBean.error("提交失败！");

        } else if (sign == 2) {
            if (orderService.rejectOrderById(id)) {

                return RespBean.ok("驳回！");
            } else

                return RespBean.error("提交失败！");
        }
        return RespBean.error("提交失败！");
    }




}
