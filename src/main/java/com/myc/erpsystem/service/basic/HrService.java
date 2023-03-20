package com.myc.erpsystem.service.basic;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.myc.erpsystem.mapper.HrMapper;
import com.myc.erpsystem.mapper.HrRoleMapper;
import com.myc.erpsystem.model.Hr;
import com.myc.erpsystem.model.Role;
import com.myc.erpsystem.utils.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;


/**
 * @Author myc
 * @Date 2023/3/5 14:03
 * @PackageName:com.myc.erpsystem.service
 * @ClassName: HrService
 * @Description: TODO
 * @Version 1.0
 *//*
*/



@Service
public class HrService implements UserDetailsService, IService<Hr> {
    @Autowired
    HrMapper hrMapper;
    @Autowired
    HrRoleMapper hrRoleMapper;
    //验证数据库中是否有这个员工
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<Hr> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Hr::getUsername,username);
        Hr hr = hrMapper.selectOne(wrapper);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不存在!");
        }
        List<Role> hrRolesById = hrMapper.getHrRolesById(hr.getId());
        hr.setRoles(hrRolesById);

        return hr;
    }


    public List<Hr> getAllHrs(String keywords) {
        return hrMapper.getAllHrs(HrUtils.getCurrentHr().getId(),keywords);
    }

    public Integer updateHr(Hr hr) {
        return hrMapper.updateByPrimaryKeySelective(hr);
    }

    @Transactional
    public boolean updateHrRole(Integer hrid, Integer[] rids) {
        hrRoleMapper.deleteByHrid(hrid);
        return hrRoleMapper.addRole(hrid, rids) == rids.length;
    }

    public Integer deleteHrById(Integer id) {
        return hrMapper.deleteByPrimaryKey(id);
    }

    public List<Hr> getAllHrsExceptCurrentHr() {
        return hrMapper.getAllHrsExceptCurrentHr(HrUtils.getCurrentHr().getId());
    }

    public Integer updateHyById(Hr hr) {
        return hrMapper.updateByPrimaryKeySelective(hr);
    }

    public boolean updateHrPasswd(String oldpass, String pass, Integer hrid) {
        Hr hr = hrMapper.selectByPrimaryKey(hrid);
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
















    @Override
    public boolean saveBatch(Collection<Hr> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Hr> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<Hr> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Hr entity) {
        return false;
    }

    @Override
    public Hr getOne(Wrapper<Hr> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<Hr> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<Hr> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<Hr> getBaseMapper() {
        return null;
    }
}


