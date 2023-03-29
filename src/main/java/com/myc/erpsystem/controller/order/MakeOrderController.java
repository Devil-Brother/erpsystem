package com.myc.erpsystem.controller.order;

import com.myc.erpsystem.model.RespBean;
import com.myc.erpsystem.model.iae.Order;
import com.myc.erpsystem.service.iae.OrderService;
import com.myc.erpsystem.service.iae.ProductTempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

/**
 * @Author myc
 * @Date 2023/3/27 19:28
 * @PackageName:com.myc.erpsystem.controller.order
 * @ClassName: MakeOrderController
 * @Description: TODO
 * @Version 1.0
 */
@RestController
@RequestMapping("/order/make")
public class MakeOrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    ProductTempService productTempService;
    @PostMapping("/")
    public RespBean makeOrder(@RequestBody Order order){

        Boolean b=  orderService.saveOrder(order);
        if (b) {

            return RespBean.ok("订单创建成功");
        } else{

            return RespBean.error("订单创建失败！");
        }

    }
}
