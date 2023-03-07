package com.myc.erpsystem.model;

import lombok.Data;

import java.util.List;

/**
 * @Author myc
 * @Date 2023/3/7 15:06
 * @PackageName:com.myc.erpsystem.model
 * @ClassName: RespPageBean
 * @Description: TODO
 * @Version 1.0
 */
@Data
public class RespPageBean {
    private Long total;
    private List<?> data;
}
