package com.myc.erpsystem.model.store;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 
 * @TableName product
 */
@TableName(value ="product")
@Data
public class Product implements Serializable {
    /**
     * 产品id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 编号
     */
    @TableField(value = "code")
    private String code;

    /**
     * 产品名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 供应商id
     */
    @TableField(value = "supplierId")
    private Integer supplierId;

    /**
     * 产品类型
     */
    @TableField(value = "type")
    private String type;

    /**
     * 产品数量
     */
    @TableField(value = "number")
    private Integer number;

    /**
     * 计量单位
     */
    @TableField(value = "unitMeas")
    private String unitMeas;

    /**
     * 进货价格单价
     */
    @TableField(value = "price")
    private BigDecimal price;

    /**
     * 产品仓库表id
     */
    @TableField(value = "storeId")
    private Integer storeId;

    /**
     * 产品规格
     */
    @TableField(value = "norms")
    private String norms;

    /**
     * 规格单位
     */
    @TableField(value = "unitSpec")
    private String unitSpec;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;



    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;


    @TableField(exist = false)
    private String storeName;
   @TableField(exist = false)
    private String supplierName;


}