package com.myc.erpsystem.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author myc
 * @Date 2023/3/5 14:21
 * @PackageName:com.myc.erpsystem.modle
 * @ClassName: HrRole
 * @Description: TODO
 * @Version 1.0
 */
@Data
@TableName("hr_role")
public class HrRole {
    @TableId(value = "id" ,type = IdType.AUTO)
    private Integer id;
    @TableField(value = "hr_id")
    private Integer hrId;
    private Integer rid;

}