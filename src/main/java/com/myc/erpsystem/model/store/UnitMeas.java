package com.myc.erpsystem.model.store;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName unit_meas
 */
@TableName(value ="unit_meas")
@Data
public class UnitMeas implements Serializable {
    /**
     * 计量单位
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