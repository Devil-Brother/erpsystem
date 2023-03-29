package com.myc.erpsystem.model.iae;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName supplier
 */
@Data
@TableName(value ="supplier")
public class Supplier implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 客户名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 客户地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 联系电话
     */
    @TableField(value = "telephone")
    private String telephone;

    /**
     * 备注
     */
    @TableField(value = "remarks")
    private String remarks;

    /**
     * 是否删除
     */
    @TableField(value = "isDel")
    private Integer isDel;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}