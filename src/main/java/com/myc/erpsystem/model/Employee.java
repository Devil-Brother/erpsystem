package com.myc.erpsystem.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author myc
 * @Date 2023/3/7 15:07
 * @PackageName:com.myc.erpsystem.model
 * @ClassName: Employee
 * @Description: TODO
 * @Version 1.0
 */

@Data
@TableName("employee")
public class Employee implements Serializable {
    @TableId(value = "id" ,type = IdType.AUTO)
    private Integer id;

    private String workID;

    private String name;

    private String gender;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date birthday;

    private String idCard;

    private String wedlock;

     private Integer nationId;

    private String nativePlace;

    private Integer politicId;

    private String email;

    private String phone;

    private String address;

    private Integer departmentId;

    private Integer jobLevelId;

    private Integer posId;

    private String specialty;

    private String school;
    @TableField(exist = false)
    private Integer salaryTotal;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date beginContract;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date endContract;

//关联其他表的字段
@TableField(exist = false)
    private Nation nation;
@TableField(exist = false)
    private Politicsstatus politicsstatus;
@TableField(exist = false)
    private Department department;
@TableField(exist = false)
    private Position position;
@TableField(exist = false)
    private JobLevel jobLevel;
@TableField(exist = false)
    private Salary salary;





}