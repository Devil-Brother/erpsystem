package com.myc.erpsystem.service.basic;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myc.erpsystem.model.Department;
import com.myc.erpsystem.model.Position;
import org.springframework.stereotype.Repository;

/**
 * @Author myc
 * @Date 2023/3/7 20:38
 * @PackageName:com.myc.erpsystem.mapper
 * @ClassName:
 * @Description: TODO
 * @Version 1.0
 */
@Repository
public interface PositionService extends IService<Position> {
    /**
     * 添加职位
     * @param position
     * @return
     */
    int addPosition(Position position);
}
