package com.myc.erpsystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author myc
 * @Date 2023/3/27 13:55
 * @PackageName:com.myc.erpsystem.model
 * @ClassName: NomalRequest
 * @Description: TODO
 * @Version 1.0
 */
@Data
public class NormalRequest {
   private Integer beginPrice;
   private  Integer endPrice;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date beginTime;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date endTime;
}
