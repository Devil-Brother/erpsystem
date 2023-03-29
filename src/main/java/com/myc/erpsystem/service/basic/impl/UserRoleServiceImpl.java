package com.myc.erpsystem.service.basic.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myc.erpsystem.mapper.UserRoleMapper;
import com.myc.erpsystem.model.UserRole;
import com.myc.erpsystem.service.basic.UserRoleService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【user_role】的数据库操作Service实现
* @createDate 2023-03-23 10:18:07
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService {

}




