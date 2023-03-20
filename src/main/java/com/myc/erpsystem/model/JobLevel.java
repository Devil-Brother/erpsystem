package com.myc.erpsystem.model;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.Date;
import java.util.Objects;

/**
 * @Author myc
 * @Date 2023/3/7 20:23
 * @PackageName:com.myc.erpsystem.model
 * @ClassName: JobLevel
 * @Description: TODO
 * @Version 1.0
 */
@Data
@TableName("joblevel")
public class JobLevel {
    @TableId(value = "id" ,type = IdType.AUTO)
    private Integer id;
    private String name;
    private String titleLevel;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;
    @TableField(fill = FieldFill.INSERT)
    private Boolean enabled;


}
