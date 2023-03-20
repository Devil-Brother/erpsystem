package com.myc.erpsystem.service.basic;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myc.erpsystem.model.Department;
import com.myc.erpsystem.model.JobLevel;
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
public interface JobLevelService extends IService<JobLevel> {
    int addJobLevel(JobLevel jobLevel);
}
