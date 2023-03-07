package com.myc.erpsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myc.erpsystem.model.Employee;
import org.springframework.stereotype.Repository;

/**
 * @Author myc
 * @Date 2023/3/7 15:15
 * @PackageName:com.myc.erpsystem.mapper
 * @ClassName: EmployeeMapper
 * @Description: TODO
 * @Version 1.0
 */
@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {
}
