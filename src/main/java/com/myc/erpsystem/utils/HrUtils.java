package com.myc.erpsystem.utils;

import com.myc.erpsystem.model.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Author myc
 * @Date 2023/3/5 14:33
 * @PackageName:com.myc.erpsystem.utils
 * @ClassName: HrUtils
 * @Description: TODO
 * @Version 1.0
 */

public class HrUtils {
    public static Hr getCurrentHr() {
        return ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
