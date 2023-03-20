package com.myc.erpsystem.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName salary
 */
@TableName(value ="salary")
@Data
public class Salary implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 基本工资
     */
    @TableField(value = "basicSalary")
    private Integer basicSalary;

    /**
     * 奖金
     */
    @TableField(value = "bonus")
    private Integer bonus;

    /**
     * 午餐补助
     */
    @TableField(value = "lunchSalary")
    private Integer lunchSalary;

    /**
     * 交通补助
     */
    @TableField(value = "trafficSalary")
    private Integer trafficSalary;

    /**
     * 应发工资
     */
    @TableField(value = "allSalary")
    private Integer allSalary;

    /**
     * 养老金基数
     */
    @TableField(value = "pensionBase")
    private Integer pensionBase;

    /**
     * 养老金比率
     */
    @TableField(value = "pensionPer")
    private Double pensionPer;

    /**
     * 启用时间
     */
    @TableField(value = "createDate")
    private Date createDate;

    /**
     * 医疗基数
     */
    @TableField(value = "medicalBase")
    private Integer medicalBase;

    /**
     * 医疗保险比率
     */
    @TableField(value = "medicalPer")
    private Double medicalPer;

    /**
     * 公积金基数
     */
    @TableField(value = "accumulationFundBase")
    private Integer accumulationFundBase;

    /**
     * 公积金比率
     */
    @TableField(value = "accumulationFundPer")
    private Double accumulationFundPer;

    /**
     * 
     */
    @TableField(value = "name")
    private String name;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Salary other = (Salary) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBasicSalary() == null ? other.getBasicSalary() == null : this.getBasicSalary().equals(other.getBasicSalary()))
            && (this.getBonus() == null ? other.getBonus() == null : this.getBonus().equals(other.getBonus()))
            && (this.getLunchSalary() == null ? other.getLunchSalary() == null : this.getLunchSalary().equals(other.getLunchSalary()))
            && (this.getTrafficSalary() == null ? other.getTrafficSalary() == null : this.getTrafficSalary().equals(other.getTrafficSalary()))
            && (this.getAllSalary() == null ? other.getAllSalary() == null : this.getAllSalary().equals(other.getAllSalary()))
            && (this.getPensionBase() == null ? other.getPensionBase() == null : this.getPensionBase().equals(other.getPensionBase()))
            && (this.getPensionPer() == null ? other.getPensionPer() == null : this.getPensionPer().equals(other.getPensionPer()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getMedicalBase() == null ? other.getMedicalBase() == null : this.getMedicalBase().equals(other.getMedicalBase()))
            && (this.getMedicalPer() == null ? other.getMedicalPer() == null : this.getMedicalPer().equals(other.getMedicalPer()))
            && (this.getAccumulationFundBase() == null ? other.getAccumulationFundBase() == null : this.getAccumulationFundBase().equals(other.getAccumulationFundBase()))
            && (this.getAccumulationFundPer() == null ? other.getAccumulationFundPer() == null : this.getAccumulationFundPer().equals(other.getAccumulationFundPer()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBasicSalary() == null) ? 0 : getBasicSalary().hashCode());
        result = prime * result + ((getBonus() == null) ? 0 : getBonus().hashCode());
        result = prime * result + ((getLunchSalary() == null) ? 0 : getLunchSalary().hashCode());
        result = prime * result + ((getTrafficSalary() == null) ? 0 : getTrafficSalary().hashCode());
        result = prime * result + ((getAllSalary() == null) ? 0 : getAllSalary().hashCode());
        result = prime * result + ((getPensionBase() == null) ? 0 : getPensionBase().hashCode());
        result = prime * result + ((getPensionPer() == null) ? 0 : getPensionPer().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getMedicalBase() == null) ? 0 : getMedicalBase().hashCode());
        result = prime * result + ((getMedicalPer() == null) ? 0 : getMedicalPer().hashCode());
        result = prime * result + ((getAccumulationFundBase() == null) ? 0 : getAccumulationFundBase().hashCode());
        result = prime * result + ((getAccumulationFundPer() == null) ? 0 : getAccumulationFundPer().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", basicSalary=").append(basicSalary);
        sb.append(", bonus=").append(bonus);
        sb.append(", lunchSalary=").append(lunchSalary);
        sb.append(", trafficSalary=").append(trafficSalary);
        sb.append(", allSalary=").append(allSalary);
        sb.append(", pensionBase=").append(pensionBase);
        sb.append(", pensionPer=").append(pensionPer);
        sb.append(", createDate=").append(createDate);
        sb.append(", medicalBase=").append(medicalBase);
        sb.append(", medicalPer=").append(medicalPer);
        sb.append(", accumulationFundBase=").append(accumulationFundBase);
        sb.append(", accumulationFundPer=").append(accumulationFundPer);
        sb.append(", name=").append(name);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}