package com.myc.erpsystem.service.basic.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.myc.erpsystem.mapper.UserMapper;
import com.myc.erpsystem.mapper.UserRoleMapper;

import com.myc.erpsystem.model.Role;
import com.myc.erpsystem.model.User;
import com.myc.erpsystem.service.basic.UserService;

import com.myc.erpsystem.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2023-03-23 10:17:41
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    @Autowired
    UserMapper hrMapper;
    @Autowired
    UserRoleMapper hrRoleMapper;

    //验证数据库中是否有这个员工
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, username);
        User hr = hrMapper.selectOne(wrapper);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不存在!");
        }
        List<Role> hrRolesById = hrMapper.getHrRolesById(hr.getId());
        hr.setRoles(hrRolesById);

        return hr;
    }


    public List<User> getAllHrs(String keywords) {
        return hrMapper.getAllHrs(UserUtils.getCurrentHr().getId(), keywords);
    }

    public Integer updateHr(User hr) {
        return hrMapper.updateByPrimaryKeySelective(hr);
    }

    @Transactional
    public boolean updateHrRole(Integer hrid, Integer[] rids) {
        hrRoleMapper.deleteByHrid(hrid);
        return hrRoleMapper.addRole(hrid, rids) == rids.length;
    }
    @Autowired
    UserRoleMapper userRoleMapper;
    public Integer deleteHrById(Integer id) {
    userRoleMapper.deleteByHrid(id);
        return hrMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Boolean addUser(User user, Integer role) {
//        设置改用户角色
        user.setEnabled(true);
        int insert = hrMapper.insert(user);

        userRoleMapper.deleteByHrid(user.getId());
        Integer integer = userRoleMapper.addRole(user.getId(), new Integer[]{role});
        return true;
    }

    public List<User> getAllHrsExceptCurrentHr() {
        return hrMapper.getAllHrsExceptCurrentHr(UserUtils.getCurrentHr().getId());
    }

    public Integer updateHyById(User hr) {
        return hrMapper.updateByPrimaryKeySelective(hr);
    }

    public boolean updateHrPasswd(String oldpass, String pass, Integer hrid) {
        User hr = hrMapper.selectByPrimaryKey(hrid);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(oldpass, hr.getPassword())) {
            String encodePass = encoder.encode(pass);
            Integer result = hrMapper.updatePasswd(hrid, encodePass);
            if (result == 1) {
                return true;
            }
        }
        return false;
    }

    public Integer updateUserface(String url, Integer id) {
        return hrMapper.updateUserface(url, id);
    }


}




