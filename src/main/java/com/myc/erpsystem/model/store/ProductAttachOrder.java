package com.myc.erpsystem.model.store;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 
 * @TableName product_attach_order
 */
@TableName(value ="product_attach_order")
@Data
public class ProductAttachOrder implements Serializable {


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

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @TableField(value = "createDate",fill = FieldFill.INSERT)
    private Date createDate;

    /**
     * 创建者id
     */
    @TableField(value = "userId")
    private Integer userId;

    /**
     * 是否审核
     */
    @TableField(value = "enable")
    private Integer enable;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    private String storeName;
    @TableField(exist = false)
    private String supplierName;

}