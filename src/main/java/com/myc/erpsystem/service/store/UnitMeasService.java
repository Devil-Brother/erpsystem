package com.myc.erpsystem.service.store;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myc.erpsystem.model.RespPageBean;
import com.myc.erpsystem.model.store.UnitMeas;

/**
* @author Administrator
* @description 针对表【unit_meas】的数据库操作Service
* @createDate 2023-03-15 20:07:22
*/
public interface UnitMeasService extends IService<UnitMeas> {
    /**
     * 查询产品类型
     * @param page
     * @param size
     * @param name
     * @return
     */
    RespPageBean getProductTypePage(Integer page, Integer size, String name);

}
