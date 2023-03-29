package com.myc.erpsystem.controller.store;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.myc.erpsystem.model.*;
import com.myc.erpsystem.model.iae.Supplier;
import com.myc.erpsystem.model.store.*;
import com.myc.erpsystem.service.iae.SupplierService;
import com.myc.erpsystem.service.store.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author myc
 * @Date 2023/3/15 15:21
 * @PackageName:com.myc.erpsystem.controller.store
 * @ClassName: ProductController
 * @Description: TODO
 * @Version 1.0
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public RespPageBean getProductPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Product product,NormalRequest normalRequest) {
        return productService.getProductPage(page, size, product,normalRequest);
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
    @Autowired
    ProductMaterialService productMaterialService;
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
    @GetMapping("/material")
    public List<ProductMaterial> getAllMaterial() {
        return productMaterialService.list();
    }

    @PostMapping("/")
    public RespBean addPro(@RequestBody Product product) {
        if (productService.save(product)) {
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

    @PutMapping("/")
    public RespBean updateEmp(@RequestBody Product product) {
        LambdaQueryWrapper<Product> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Product::getId,product.getId());
        if (productService.update(product,queryWrapper) ) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }



}
