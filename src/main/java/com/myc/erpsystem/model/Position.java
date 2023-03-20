package com.myc.erpsystem.model;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.Objects;

/**
 * @Author myc
 * @Date 2023/3/7 20:23
 * @PackageName:com.myc.erpsystem.model
 * @ClassName: Position
 * @Description: TODO
 * @Version 1.0
 */
@Data
@TableName("position")
public class Position {
    @TableId(value = "id" ,type = IdType.AUTO)
    private Integer id;

    private String name;
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date createDate;
    @TableField(fill = FieldFill.INSERT)
    private Boolean enabled;

}
