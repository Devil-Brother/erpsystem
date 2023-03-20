package com.myc.erpsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myc.erpsystem.model.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

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
    List<Employee> getEmployeeByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);


    List<Employee> getEmployeeByPageWithSalary(@Param("page") Integer page, @Param("size") Integer size);
    Long getTotal(@Param("emp") Employee employee,@Param("beginDateScope") Date[] beginDateScope);

    Integer updateEmployeeSalaryById(@Param("eid") Integer eid, @Param("sid") Integer sid);

    Integer getEmployeeTotal( @Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    Integer maxWorkID();

}
