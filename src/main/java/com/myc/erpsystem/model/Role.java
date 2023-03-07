package com.myc.erpsystem.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author myc
 * @Date 2023/3/5 13:56
 * @PackageName:com.myc.erpsystem.modle
 * @ClassName: Role
 * @Description: TODO
 * @Version 1.0
 */
@Data
@TableName("role")
public class Role implements Serializable {
    private Integer id;

    private String name;

    private String nameZh;

}