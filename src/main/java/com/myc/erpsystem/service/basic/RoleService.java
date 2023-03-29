package com.myc.erpsystem.service.basic;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myc.erpsystem.model.Role;
import org.springframework.stereotype.Repository;

/**
 * @Author myc
 * @Date 2023/3/7 20:38
 * @PackageName:com.myc.erpsystem.mapper
 * @ClassName:
 * @Description: TODO
 * @Version 1.0
 */
@Repository
public interface RoleService extends IService<Role> {
    /**
     * 删除角色，一同删除角色对应的menu_role表内容
     * @return
     */
    boolean deleteRoleAndMRoleById(Integer rid);

}
