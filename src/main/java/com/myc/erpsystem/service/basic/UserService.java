package com.myc.erpsystem.service.basic;

import com.baomidou.mybatisplus.extension.service.IService;


import com.myc.erpsystem.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Service
* @createDate 2023-03-23 10:17:41
*/
public interface UserService  extends IService<User>, UserDetailsService {

    List<User> getAllHrs(String keywords);


    Integer updateHr(User user);

    boolean updateHrRole(Integer hrid, Integer[] rids);

    Integer deleteHrById(Integer id);


    Boolean addUser(User user, Integer role);
}
