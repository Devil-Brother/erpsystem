package com.myc.erpsystem.model.iae;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName sales
 */
@TableName(value ="sales")
@Data
public class Sales implements Serializable {
    /**
     * 客户
     */
    @TableField(exist = false)
    private Customer customer;
    /**
     * 销售订单
     */
    @TableId(value = "id")
    private Integer id;

    /**
     * 订单编号
     */
    @TableField(value = "saleNo")
    private String saleNo;

    /**
     * 产品编号
     */
    @TableField(value = "productid")
    private Integer productid;

    /**
     * 客户id
     */
    @TableField(value = "customerId")
    private Integer customerId;

    /**
     * 审核人员id
     */
    @TableField(value = "examineId")
    private Integer examineId;

    /**
     * 销售人员
     */
    @TableField(value = "people")
    private String people;

    /**
     * 申请日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @TableField(value = "date")
    private Date date;

    /**
     * 联系方式
     */
    @TableField(value = "telephone")
    private String telephone;

    /**
     * 交货地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 审核，0未审核，1审核通过，2审核未通过
     */
    @TableField(value = "complete")
    private Integer complete;

    /**
     * 备注
     */
    @TableField(value = "remarks")
    private String remarks;

    /**
     * 金额
     */
    @TableField(value = "money")
    private String money;

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
        Sales other = (Sales) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSaleNo() == null ? other.getSaleNo() == null : this.getSaleNo().equals(other.getSaleNo()))
            && (this.getProductid() == null ? other.getProductid() == null : this.getProductid().equals(other.getProductid()))
            && (this.getCustomerId() == null ? other.getCustomerId() == null : this.getCustomerId().equals(other.getCustomerId()))
            && (this.getExamineId() == null ? other.getExamineId() == null : this.getExamineId().equals(other.getExamineId()))
            && (this.getPeople() == null ? other.getPeople() == null : this.getPeople().equals(other.getPeople()))
            && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()))
            && (this.getTelephone() == null ? other.getTelephone() == null : this.getTelephone().equals(other.getTelephone()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getComplete() == null ? other.getComplete() == null : this.getComplete().equals(other.getComplete()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSaleNo() == null) ? 0 : getSaleNo().hashCode());
        result = prime * result + ((getProductid() == null) ? 0 : getProductid().hashCode());
        result = prime * result + ((getCustomerId() == null) ? 0 : getCustomerId().hashCode());
        result = prime * result + ((getExamineId() == null) ? 0 : getExamineId().hashCode());
        result = prime * result + ((getPeople() == null) ? 0 : getPeople().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        result = prime * result + ((getTelephone() == null) ? 0 : getTelephone().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getComplete() == null) ? 0 : getComplete().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", saleNo=").append(saleNo);
        sb.append(", productid=").append(productid);
        sb.append(", customerId=").append(customerId);
        sb.append(", examineId=").append(examineId);
        sb.append(", people=").append(people);
        sb.append(", date=").append(date);
        sb.append(", telephone=").append(telephone);
        sb.append(", address=").append(address);
        sb.append(", complete=").append(complete);
        sb.append(", remarks=").append(remarks);
        sb.append(", money=").append(money);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}