package com.myc.erpsystem.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author myc
 * @Date 2023/3/5 14:26
 * @PackageName:com.myc.erpsystem.modle
 * @ClassName: MenuRole
 * @Description: TODO
 * @Version 1.0
 */
@Data
@TableName("menu_role")
public class MenuRole {
    private Integer id;

    private Integer mid;

    private Integer rid;

}