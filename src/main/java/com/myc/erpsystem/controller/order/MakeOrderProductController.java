package com.myc.erpsystem.controller.order;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.myc.erpsystem.model.RespBean;
import com.myc.erpsystem.model.User;
import com.myc.erpsystem.model.store.ProductAttachOrder;
import com.myc.erpsystem.model.iae.Supplier;
import com.myc.erpsystem.model.store.*;
import com.myc.erpsystem.service.iae.ProductAttachOrderService;
import com.myc.erpsystem.service.iae.SupplierService;
import com.myc.erpsystem.service.store.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author myc
 * @Date 2023/3/28 15:18
 * @PackageName:com.myc.erpsystem.controller.order
 * @ClassName: MakeOrderProductController
 * @Description: TODO
 * @Version 1.0
 */

@RestController
@RequestMapping("/order/product/")
public class MakeOrderProductController {
    @Autowired
    ProductAttachOrderService productService;

    @GetMapping("/")
    public List<ProductAttachOrder> getProductPage(@RequestParam Integer orderId) {
      List<ProductAttachOrder> productAttachOrders =productService.getAllProduct(orderId);
        return productAttachOrders ;
    }
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
    public List<ProductType> getAllProType() {
        return productTypeService.list();
    }
    @GetMapping("/prostore")
    public List<Store> getAllStore() {
        return storeService.list();
    }
    @GetMapping("/unitmea")
    public List<UnitMeas> getAllUnitMea() {
        return unitMeasService.list();
    }
    @GetMapping("/unitspe")
    public List<UnitSpec> getAllUnitSpe() {
        return unitSpecService.list();
    }
    @GetMapping("/supplier")
    public List<Supplier> getAllSupplier() {
        return supplierService.list();
    }

    @PostMapping("/")
    public RespBean addPro(@RequestBody ProductAttachOrder product) {
        if ( productService.insertProduct(product)==1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteProductByEid(@PathVariable Integer id) {

        if (productService.removeById(id)) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
    @DeleteMapping("/deleteall")
    public RespBean deleteAllProductByEid() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LambdaQueryWrapper<ProductAttachOrder> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ProductAttachOrder::getUserId,user.getId());
        if (productService.remove(queryWrapper)) {
            return RespBean.ok("");
        }
        return RespBean.error("");
    }

/*
    @PutMapping("/")
    public RespBean updateEmp(@RequestBody Product product) {
        LambdaQueryWrapper<Product> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Product::getId,product.getId());
        if (productService.update(product,queryWrapper) ) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
*/

}