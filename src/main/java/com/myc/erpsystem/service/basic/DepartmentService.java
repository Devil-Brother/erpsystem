package com.myc.erpsystem.service.basic;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.myc.erpsystem.model.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author myc
 * @Date 2023/3/7 20:38
 * @PackageName:com.myc.erpsystem.mapper
 * @ClassName:
 * @Description: TODO
 * @Version 1.0
 */
@Repository
public interface DepartmentService extends IService<Department> {
    /**
     * 查询所有部门
     * @return
     */
    List<Department> getAllDepartments();

    /**
     * 删除部门
     * @param dep
     */
    void deleteDepById(Department dep);


}
