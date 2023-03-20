package com.myc.erpsystem.model.store;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
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
     * 产品类型id
     */
    @TableField(value = "typeId")
    private String typeId;

    /**
     * 产品数量
     */
    @TableField(value = "number")
    private Integer number;

    /**
     * 计量单位id
     */
    @TableField(value = "unitMeasId")
    private Integer unitMeasId;

    /**
     * 产品单价
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
     * 规格单位id
     */
    @TableField(value = "unitSpecId")
    private Integer unitSpecId;



    @TableField(exist = false)
    private String type;
    @TableField(exist = false)
    private String unitMeas;
    @TableField(exist = false)
    private String unitSpec;
    @TableField(exist = false)
    private String storeName;


    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getUnitMeasId() == null) ? 0 : getUnitMeasId().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getStoreId() == null) ? 0 : getStoreId().hashCode());
        result = prime * result + ((getNorms() == null) ? 0 : getNorms().hashCode());
        result = prime * result + ((getUnitSpecId() == null) ? 0 : getUnitSpecId().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", typeId=").append(typeId);
        sb.append(", number=").append(number);
        sb.append(", unitMeasId=").append(unitMeasId);
        sb.append(", price=").append(price);
        sb.append(", storeId=").append(storeId);
        sb.append(", norms=").append(norms);
        sb.append(", unitSpecId=").append(unitSpecId);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}