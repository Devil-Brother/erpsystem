package com.myc.erpsystem.model.store;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 *
 * @TableName store
 */
@TableName(value ="store")
@Data
public class Store implements Serializable {
    /**
     * 仓库id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 仓库名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 仓库对应图片
     */
    @TableField(value = "image")
    private String image;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @TableField(value = "createDate",fill = FieldFill.INSERT)
    private Date createDate;

    /**
     * 容量
     */
    @TableField(value = "space")
    private Integer space;

    /**
     * 是否启用
     */
    @TableField(value = "enable")
    private Boolean enable;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}