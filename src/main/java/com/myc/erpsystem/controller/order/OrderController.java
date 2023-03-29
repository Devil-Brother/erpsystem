package com.myc.erpsystem.controller.order;

import com.myc.erpsystem.model.*;
import com.myc.erpsystem.model.iae.Order;
import com.myc.erpsystem.model.iae.OrderProduct;
import com.myc.erpsystem.model.iae.ProductTemp;
import com.myc.erpsystem.model.iae.Supplier;
import com.myc.erpsystem.model.store.*;
import com.myc.erpsystem.service.basic.RoleService;
import com.myc.erpsystem.service.iae.OrderProductService;
import com.myc.erpsystem.service.iae.OrderService;
import com.myc.erpsystem.service.iae.ProductTempService;
import com.myc.erpsystem.service.iae.SupplierService;
import com.myc.erpsystem.service.store.ProductTypeService;
import com.myc.erpsystem.service.store.StoreService;
import com.myc.erpsystem.service.store.UnitMeasService;
import com.myc.erpsystem.service.store.UnitSpecService;
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
    OrderProductService orderProductService;
    @GetMapping("/")
    public RespPageBean getOrderByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Order order,NormalRequest normalRequest) {
        return orderService.getOrderByPage(page, size, order,normalRequest);
    }

    @GetMapping("/orderpro/{id}")
    public RespBean getOrderProductsById(@PathVariable Integer id){
       List<ProductAttachOrder> productOrders =orderProductService.getAllProductByOrderId(id);
       if (productOrders.size()!=0){
        return RespBean.ok("",productOrders);
       }
       return null;
    }
    @GetMapping("/{id}")
    public RespBean getOrderById(@PathVariable Integer id){
        Order order = orderService.getById(id);
        if (order!=null){
        return RespBean.ok("",order);
       }
       return null;
    }
//    提交
    @PostMapping("/{sign}/{id}")
    public RespBean revOrderById(@PathVariable Integer sign,@PathVariable Integer id) {
        if (sign == 0) {
            if (orderService.examineOrderById(id)) {

                return RespBean.ok("审核成功！");
            } else
                return RespBean.error("提交失败！");
        }
            if (sign == 1) {
                if (orderService.rejectOrderById(id)) {

                    return RespBean.ok("驳回成功！");
                } else
                    return RespBean.error("驳回失败！");
            }
            return null;
        }

/*    @PostMapping("/product/{id}")
    public RespBean submitAllProductByOrderId(@PathVariable Integer id, Product product){
        Integer i =productTempService.submitAllProductByOrderId(id,product);

        return null;
    }*/
   /* @PostMapping("/product")
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
    }*/
            @Autowired
            StoreService storeService;
            @Autowired
            ProductTypeService productTypeService;
            @Autowired
            UnitSpecService unitSpecService;
            @Autowired
            UnitMeasService unitMeasService;
            @Autowired
            SupplierService supplierService;

            @GetMapping("/protype")
            public List<ProductType> getAllProType () {
                return productTypeService.list();
            }
            @GetMapping("/prostore")
            public List<Store> getAllStore () {
                return storeService.list();
            }
            @GetMapping("/unitmea")
            public List<UnitMeas> getAllUnitMea () {
                return unitMeasService.list();
            }
            @GetMapping("/unitspe")
            public List<UnitSpec> getAllUnitSpe () {
                return unitSpecService.list();
            }
            @GetMapping("/supplier")
            public List<Supplier> getAllSupplier () {
                return supplierService.list();
            }





}
