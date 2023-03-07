package com.myc.erpsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers;
import com.myc.erpsystem.model.Hr;
import com.myc.erpsystem.model.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author myc
 * @Date 2023/3/5 14:16
 * @PackageName:com.myc.erpsystem.mapper
 * @ClassName: hrMapper
 * @Description: TODO
 * @Version 1.0
 */
@Repository
public interface HrMapper extends BaseMapper<Hr> {


    List<Role> getHrRolesById(Integer id);
}