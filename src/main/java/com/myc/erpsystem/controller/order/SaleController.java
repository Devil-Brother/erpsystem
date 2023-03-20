package com.myc.erpsystem.controller.order;

import com.myc.erpsystem.model.RespBean;
import com.myc.erpsystem.model.RespPageBean;
import com.myc.erpsystem.model.iae.Order;
import com.myc.erpsystem.model.iae.ProductTemp;
import com.myc.erpsystem.model.iae.Sales;
import com.myc.erpsystem.service.iae.OrderService;
import com.myc.erpsystem.service.iae.ProductTempService;
import com.myc.erpsystem.service.iae.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author myc
 * @Date 2023/3/20 23:49
 * @PackageName:com.myc.erpsystem.controller.order
 * @ClassName: SaleController
 * @Description: TODO
 * @Version 1.0
 */
@RequestMapping("/sales")
@RestController
public class SaleController {
    @Autowired
    SalesService salesService;
    @Autowired
    ProductTempService productTempService;
    @GetMapping("/")
    public RespPageBean getSalesByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Sales sales, Date[] beginDateScope) {
        return salesService.getSalesByPage(page, size, sales,beginDateScope);
    }
    @GetMapping("/product/{id}")
    public RespBean getOrderProductsById(@PathVariable Integer id){
        List<ProductTemp> productOrders =productTempService.getAllProductBySaleId(id);
        if (productOrders.size()!=0){
            return RespBean.ok("",productOrders);
        }
        return null;
    }
/*
    @PostMapping("/product")
    public RespBean examineOrderById(@RequestParam() Integer id,@RequestParam()Integer sign){
        if (sign == 1) {
            if (salesService.examineOrderById(id)) {

                return RespBean.ok("审核成功！");
            } else

                return RespBean.error("提交失败！");

        } else if (sign == 2) {
            if (salesService.rejectOrderById(id)) {

                return RespBean.ok("驳回！");
            } else

                return RespBean.error("提交失败！");
        }
        return RespBean.error("提交失败！");
    }*/

}
