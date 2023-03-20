package com.myc.erpsystem.mapper.iae;

import com.myc.erpsystem.model.iae.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
* @author Administrator
* @description 针对表【order】的数据库操作Mapper
* @createDate 2023-03-12 23:54:41
* @Entity com.myc.erpsystem.model.iae.Order
*/
@Repository
public interface OrderMapper extends BaseMapper<Order> {
    /**
     * 查询所有未审核订单
     * @param page
     * @param size
     * @param order
     * @param beginDateScope
     * @return
     */
    List<Order> getOrderByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("ord") Order order,@Param("beginDateScope") Date[] beginDateScope);
    Integer getEmployeeByPageCount(@Param("page") Integer page, @Param("size") Integer size, @Param("ord") Order order,@Param("beginDateScope") Date[] beginDateScope);
}




