package com.dssm.mapper.manage;

import java.util.List;

import com.dssm.domain.manage.Permission;
import com.dssm.mapper.BaseMapper;

public interface PermissionMapper extends BaseMapper<Permission> {
    
    public List<Permission> selectByRole(Long roleId);
    
}
