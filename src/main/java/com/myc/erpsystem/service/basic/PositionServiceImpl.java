package com.myc.erpsystem.service.basic;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myc.erpsystem.mapper.DepartmentMapper;
import com.myc.erpsystem.mapper.PoliticsstatusMapper;
import com.myc.erpsystem.mapper.PositionMapper;
import com.myc.erpsystem.model.Department;
import com.myc.erpsystem.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author myc
 * @Date 2023/3/7 15:20
 * @PackageName:com.myc.erpsystem.service.emp
 * @ClassName: EmployeeServiceImpl
 * @Description: TODO
 * @Version 1.0
 */
@Service
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements PositionService{
    @Autowired
    PositionMapper positionMapper;
    @Override
    public int addPosition(Position position) {
        if (position!=null){
            positionMapper.insert(position);
            return 1;
        }

        return 0;
    }
}
