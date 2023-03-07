package com.myc.erpsystem.model;

import java.io.Serializable;

/**
 * @Author myc
 * @Date 2023/3/5 14:07
 * @PackageName:com.myc.erpsystem.modle
 * @ClassName: Meta
 * @Description: TODO
 * @Version 1.0
 */


public class Meta implements Serializable {
    private Boolean keepAlive;
    private Boolean requireAuth;

    public Boolean getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(Boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public Boolean getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(Boolean requireAuth) {
        this.requireAuth = requireAuth;
    }
}
