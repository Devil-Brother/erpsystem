package com.myc.erpsystem.model.iae;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.myc.erpsystem.model.Hr;
import lombok.Data;

/**
 * 
 * @TableName order
 */
@TableName(value ="orders")
@Data
public class Order implements Serializable {


    /**
     * 供应商
     */
    @TableField(exist = false)
    private Supplier supplier;

    /**
     * 审核人员
     */
    @TableField(exist = false)
    private String hr;


    /**
     * 订单id
     */
    @TableId(value = "id")
    private Integer id;

    /**
     *  订单产品编号id
     */

    @TableField(value = "productId")
    private Integer productId;

    /**
     * 供应商id
     */
    @TableField(value = "supplierId")
    private Integer supplierId;
    /**
     * 订单编号
     */
    @TableField(value = "orderNo")
    private String orderNo;

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
    @TableField(value = "date")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
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
     * 审核，0未审核，1审核通过
     */
    @TableField(value = "complete")
    private Integer complete;

    /**
     * 备注
     */
    @TableField(value = "remarks")
    private String remarks;

    /**
     * 订单金额
     */
    @TableField(value = "money")
    private String money;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}