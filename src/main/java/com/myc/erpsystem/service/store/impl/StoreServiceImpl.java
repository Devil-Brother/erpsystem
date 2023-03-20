package com.myc.erpsystem.service.store.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myc.erpsystem.model.store.Store;
import com.myc.erpsystem.service.store.StoreService;
import com.myc.erpsystem.mapper.store.StoreMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【store】的数据库操作Service实现
* @createDate 2023-03-15 15:09:23
*/
@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store>
    implements StoreService{

}




