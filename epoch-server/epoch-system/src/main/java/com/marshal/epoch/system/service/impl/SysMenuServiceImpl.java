package com.marshal.epoch.system.service.impl;


import com.marshal.epoch.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import com.marshal.epoch.system.entity.SysMenu;
import com.marshal.epoch.system.service.SysMenuService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenu> implements SysMenuService{

}