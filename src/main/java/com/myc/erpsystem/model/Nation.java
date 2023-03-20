package com.myc.erpsystem.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Objects;

/**
 * @Author myc
 * @Date 2023/3/7 20:23
 * @PackageName:com.myc.erpsystem.model
 * @ClassName: Nation
 * @Description: TODO
 * @Version 1.0
 */
@Data
@TableName("nation")
public class Nation {
    @TableId(value = "id" ,type = IdType.AUTO)

    private Integer id;
    private String name;

}
