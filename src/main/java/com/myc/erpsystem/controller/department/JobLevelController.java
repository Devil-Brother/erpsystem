package com.myc.erpsystem.controller.department;

import com.myc.erpsystem.model.JobLevel;
import com.myc.erpsystem.model.RespBean;
import com.myc.erpsystem.service.basic.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author myc
 * @Date 2023/3/9 16:16
 * @PackageName:com.myc.erpsystem.controller.JobLevelController
 * @ClassName: JobLevelController
 * @Description: TODO
 * @Version 1.0
 */
@RestController
@RequestMapping("/dppo/joblevel")
public class JobLevelController {
    @Autowired
    JobLevelService jobLevelService;
    @GetMapping("/")
    public List<JobLevel> getAllJobLevels() {
        return jobLevelService.list();
    }

    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.addJobLevel(jobLevel) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @PutMapping("/")
    public RespBean updateJobLevelById(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.updateById(jobLevel)) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteJobLevelById(@PathVariable Integer id) {
        if (jobLevelService.removeById(id)) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @DeleteMapping("/")
    public RespBean deleteJobLevelsByIds(Integer[] ids) {

        if (jobLevelService.removeByIds(Arrays.asList(ids))) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}
