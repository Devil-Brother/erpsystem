package com.myc.erpsystem.model;

import com.baomidou.mybatisplus.annotation.TableField;
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
    private Integer id;

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

//    private String engageForm;

    private String tiptopDegree;

    private String specialty;

    private String school;
//    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
//    private Date beginDate;

//    private String workState;

//    private String workID;

//    private Double contractTerm;

//    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
//    private Date conversionTime;

//    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
//    private Date notWorkDate;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date beginContract;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date endContract;

/*@TableField(exist = false)
    private Nation nation;
@TableField(exist = false)
    private Politicsstatus politicsstatus;
@TableField(exist = false)
    private Department department;
@TableField(exist = false)
    private Position position;
@TableField(exist = false)
    private Salary salary;*/

//@TableField(exist = false)
//    private Integer workAge;
//@TableField(exist = false)
//    private JobLevel jobLevel;



    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +


                '}';
    }


/*    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", idCard='" + idCard + '\'' +
                ", wedlock='" + wedlock + '\'' +
                ", nationId=" + nationId +
                ", nativePlace='" + nativePlace + '\'' +
                ", politicId=" + politicId +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", departmentId=" + departmentId +
                ", jobLevelId=" + jobLevelId +
                ", posId=" + posId +
                ", engageForm='" + engageForm + '\'' +
                ", tiptopDegree='" + tiptopDegree + '\'' +
                ", specialty='" + specialty + '\'' +
                ", school='" + school + '\'' +
                ", beginDate=" + beginDate +
                ", workState='" + workState + '\'' +
                ", workID='" + workID + '\'' +
                ", contractTerm=" + contractTerm +
                ", conversionTime=" + conversionTime +
                ", notWorkDate=" + notWorkDate +
                ", beginContract=" + beginContract +
                ", endContract=" + endContract +
                ", workAge=" + workAge +
                ", nation=" + nation +
                ", politicsstatus=" + politicsstatus +
                ", department=" + department +
                ", jobLevel=" + jobLevel +
                ", position=" + position +
                '}';
    }*/

}