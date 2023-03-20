package com.myc.erpsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myc.erpsystem.model.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author myc
 * @Date 2023/3/7 20:38
 * @PackageName:com.myc.erpsystem.mapper
 * @ClassName: DepartmentMapper
 * @Description: TODO
 * @Version 1.0
 */
@Repository
public interface DepartmentMapper extends BaseMapper<Department> {
    List<Department> getAllDepartmentsByParentId(Integer pid);
    void deleteDepById(Department dep);
}
