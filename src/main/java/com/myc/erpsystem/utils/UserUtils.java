package com.myc.erpsystem.utils;

import com.myc.erpsystem.model.Hr;
import com.myc.erpsystem.model.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Author myc
 * @Date 2023/3/5 14:33
 * @PackageName:com.myc.erpsystem.utils
 * @ClassName: HrUtils
 * @Description: TODO
 * @Version 1.0
 */

public class UserUtils {
    public static User getCurrentHr() {
        return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
