package com.myc.erpsystem.model.store;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName unit_spec
 */
@TableName(value ="unit_spec")
@Data
public class UnitSpec implements Serializable {
    /**
     * 规格单位
     */
    @TableId(value = "id", type = IdType.AUTO)    private Integer id;

    /**
     * 
     */
    @TableField(value = "unit")
    private String unit;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}