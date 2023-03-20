package com.myc.erpsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myc.erpsystem.model.HrRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author myc
 * @Date 2023/3/5 14:17
 * @PackageName:com.myc.erpsystem.mapper
 * @ClassName: HrRoleMapper
 * @Description: TODO
 * @Version 1.0
 */
@Repository
public interface HrRoleMapper extends BaseMapper<HrRole> {
    int deleteByPrimaryKey(Integer id);

    int insert(HrRole record);

    int insertSelective(HrRole record);

    HrRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HrRole record);

    int updateByPrimaryKey(HrRole record);

    void deleteByHrid(Integer hrid);

    Integer addRole(@Param("hrid") Integer hrid, @Param("rids") Integer[] rids);

}