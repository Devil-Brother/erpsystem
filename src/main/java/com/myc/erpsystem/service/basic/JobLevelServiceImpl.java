package com.myc.erpsystem.service.basic;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myc.erpsystem.mapper.EmployeeMapper;
import com.myc.erpsystem.mapper.JobLevelMapper;
import com.myc.erpsystem.model.Employee;
import com.myc.erpsystem.model.JobLevel;
import com.myc.erpsystem.model.RespPageBean;
import com.myc.erpsystem.service.emp.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author myc
 * @Date 2023/3/7 15:20
 * @PackageName:com.myc.erpsystem.service.emp
 * @ClassName: EmployeeServiceImpl
 * @Description: TODO
 * @Version 1.0
 */
@Service
public class JobLevelServiceImpl extends ServiceImpl<JobLevelMapper, JobLevel> implements JobLevelService {
@Autowired
JobLevelMapper jobLevelMapper;
    @Override
    public int addJobLevel(JobLevel jobLevel) {
        if (jobLevel!=null){
        jobLevelMapper.insert(jobLevel);
        return 1;
        }
        return 0;
    }
}
