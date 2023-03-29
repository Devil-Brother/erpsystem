package com.myc.erpsystem.controller.store;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.myc.erpsystem.model.RespBean;
import com.myc.erpsystem.model.RespPageBean;
import com.myc.erpsystem.model.store.ProductMaterial;
import com.myc.erpsystem.model.store.UnitMeas;
import com.myc.erpsystem.service.store.ProductMaterialService;
import com.myc.erpsystem.service.store.UnitMeasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author myc
 * @Date 2023/3/15 15:21
 * @PackageName:com.myc.erpsystem.controller.store
 * @ClassName: ProductController
 * @Description: TODO
 * @Version 1.0
 */
@RestController
@RequestMapping("/product/material")
public class ProductMaterialController {
    @Autowired
    ProductMaterialService productService;

    @GetMapping("/")
    public RespPageBean getProductTypePage(@RequestParam Integer page, @RequestParam Integer size, String name) {
        return productService.getProductTypePage(page, size, name);
    }


    @PostMapping("/")
    public RespBean addPro(@RequestBody ProductMaterial product) {
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
    public RespBean updateEmp(@RequestBody ProductMaterial product) {
        LambdaQueryWrapper<ProductMaterial> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ProductMaterial::getId,product.getId());
        if (productService.update(product,queryWrapper) ) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }



}
