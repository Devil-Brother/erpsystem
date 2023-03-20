package com.myc.erpsystem.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author myc
 * @Date 2023/3/7 20:40
 * @PackageName:com.myc.erpsystem.model
 * @ClassName: Department
 * @Description: TODO
 * @Version 1.0
 */
@Data
@TableName("department")
public class Department {
    @TableId(value = "id" ,type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer parentId;
    private String depPath;
    private Boolean enabled;
    private Boolean isParent;
    @TableField(exist = false)
    private List<Department> children = new ArrayList<>();
    @TableField(exist = false)
    private Integer result;


}
