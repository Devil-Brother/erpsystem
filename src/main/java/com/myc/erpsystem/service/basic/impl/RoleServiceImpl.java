package com.myc.erpsystem.service.basic.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myc.erpsystem.mapper.MenuRoleMapper;

import com.myc.erpsystem.mapper.RoleMapper;
import com.myc.erpsystem.model.MenuRole;
import com.myc.erpsystem.model.Role;
import com.myc.erpsystem.service.basic.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author myc
 * @Date 2023/3/7 15:20
 * @PackageName:com.myc.erpsystem.service.emp
 * @ClassName: RoleServiceImpl
 * @Description: TODO
 * @Version 1.0
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    MenuRoleMapper menuRoleMapper;

    @Override
    public boolean deleteRoleAndMRoleById(Integer rid) {
        LambdaQueryWrapper<Role> RoleQ = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<MenuRole> menuRoleQr = new LambdaQueryWrapper<>();
        menuRoleQr.eq(MenuRole::getRid,rid);
        int delete = menuRoleMapper.delete(menuRoleQr);
        RoleQ.eq(Role::getId,rid);
        int delete1 = roleMapper.delete(RoleQ);
        if(delete1>0)
            return true;

        return false;
    }

}
