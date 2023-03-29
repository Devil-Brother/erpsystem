package com.myc.erpsystem.service.store;

import com.myc.erpsystem.model.RespBean;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myc.erpsystem.model.store.Store;

import java.util.List;

/**
* @author Administrator
* @description 针对表【store】的数据库操作Service
* @createDate 2023-03-15 15:09:23
*/
public interface StoreService extends IService<Store> {
    /**
     * 获取所有仓库
     * @param name
     * @return
     */
    List<Store> getAllStore(String name);

    /**
     * 禁用启用仓库
     * @param store
     * @return
     */
    Boolean updateStore(Store store);

    /**
     * 删除仓库
     * @param storeId
     * @return
     */
    boolean deleteStoreById(Integer storeId);
}
