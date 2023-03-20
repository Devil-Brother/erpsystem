package com.myc.erpsystem.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * @Author myc
 * @Date 2023/3/5 14:07
 * @PackageName:com.myc.erpsystem.modle
 * @ClassName: Menu
 * @Description: TODO
 * @Version 1.0
 */

@Data
@TableName("menu")
public class Menu implements Serializable {
    @TableId(value = "id" ,type = IdType.AUTO)

    private Integer id;

    private String url;

    private String path;

    private String component;

    private String name;

    private String iconCls;
    @TableField(exist = false)
    private Meta meta;

    private Integer parentId;

    private Boolean enabled;
    @TableField(exist = false)
    private List<Menu> children;
    @TableField(exist = false)

    private List<Role> roles;


}