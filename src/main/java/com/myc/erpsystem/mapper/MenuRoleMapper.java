package com.myc.erpsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myc.erpsystem.model.MenuRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author myc
 * @Date 2023/3/5 14:18
 * @PackageName:com.myc.erpsystem.mapper
 * @ClassName: MenuRoleMapper
 * @Description: TODO
 * @Version 1.0
 */
@Repository
public interface MenuRoleMapper  extends BaseMapper<MenuRole> {
}