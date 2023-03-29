package com.myc.erpsystem.model.store;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName product_material
 */
@TableName(value ="product_material")
@Data
public class ProductMaterial implements Serializable {
    /**
     * 商品管理
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品名称
     */
    @TableField(value = "name")
    private String name;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}