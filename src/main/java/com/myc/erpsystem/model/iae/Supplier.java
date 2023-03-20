package com.myc.erpsystem.model.iae;

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
     * 供应商id
     */
    @TableId(value = "id")
    private Integer id;

    /**
     * 供应商名字
     */
    private String name;

    /**
     * 供应商地址
     */
    private String address;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}