package com.myc.erpsystem.service.store;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myc.erpsystem.model.RespPageBean;
import com.myc.erpsystem.model.store.UnitSpec;

/**
* @author Administrator
* @description 针对表【unit_spec】的数据库操作Service
* @createDate 2023-03-15 20:07:29
*/
public interface UnitSpecService extends IService<UnitSpec> {
    /**
     * 查询产品类型
     * @param page
     * @param size
     * @param name
     * @return
     */
    RespPageBean getProductTypePage(Integer page, Integer size, String name);

}
