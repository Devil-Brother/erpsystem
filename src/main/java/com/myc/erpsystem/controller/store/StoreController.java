package com.myc.erpsystem.controller.store;

import com.myc.erpsystem.model.RespBean;
import com.myc.erpsystem.model.store.Store;
import com.myc.erpsystem.service.store.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author myc
 * @Date 2023/3/29 17:18
 * @PackageName:com.myc.erpsystem.controller.store
 * @ClassName: StoreController
 * @Description: TODO
 * @Version 1.0
 */
@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    StoreService storeService;
    @GetMapping("/")
    public RespBean getAllStore(String name){
        List<Store> stores= storeService.getAllStore(name);
return RespBean.ok("",stores);
    }
    @PostMapping("/")
    public RespBean addStore(@RequestBody Store store){
        Boolean sto =  storeService.save(store);
        if (sto) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");

    }
    @PutMapping("/")
    public RespBean updateStore(@RequestBody Store store){
       Boolean sto =  storeService.updateStore(store);
        if (sto) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");

    }
    @DeleteMapping("/{storeId}")
    public RespBean deleteStore(@PathVariable Integer storeId){
        boolean b = storeService.deleteStoreById(storeId);
        if ( b) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("改仓库下有产品!");
    }

}
