package com.myc.erpsystem.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * @Author myc
 * @Date 2023/3/10 20:18
 * @PackageName:com.myc.erpsystem.config
 * @ClassName: MybatsiplusMeataConfig
 * @Description: TODO
 * @Version 1.0
 */
@Configuration
public class MybatisPlusMetaConfig implements MetaObjectHandler  {


    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createDate",new Date(),metaObject);
        this.setFieldValByName("enabled",true,metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
