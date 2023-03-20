package com.myc.erpsystem.mapper.iae;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myc.erpsystem.model.iae.Sales;

import java.util.Date;
import java.util.List;

/**
* @author Administrator
* @description 针对表【sales】的数据库操作Mapper
* @createDate 2023-03-21 00:08:48
* @Entity cen.domain.Sales
*/
public interface SalesMapper extends BaseMapper<Sales> {
    /**
     * 查询未审核销售单
     * @param page
     * @param size
     * @param sales
     * @param beginDateScope
     * @return
     */
    List<Sales> getSaleByPage(Integer page, Integer size, Sales sales, Date[] beginDateScope);

    /**
     * 销售单数量
     * @param page
     * @param size
     * @param sales
     * @param beginDateScope
     * @return
     */
    long getSaleByPageCount(Integer page, Integer size, Sales sales, Date[] beginDateScope);
}




