package com.myc.erpsystem.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author myc
 * @Date 2023/3/5 14:07
 * @PackageName:com.myc.erpsystem.modle
 * @ClassName: Meta
 * @Description: TODO
 * @Version 1.0
 */

@Data
public class Meta implements Serializable {

    private Boolean keepAlive;
    private Boolean requireAuth;
}
