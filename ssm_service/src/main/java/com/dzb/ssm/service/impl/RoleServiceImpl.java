package com.dzb.ssm.service.impl;

import com.dzb.ssm.dao.IRoleDao;
import com.dzb.ssm.domain.Permission;
import com.dzb.ssm.domain.Role;
import com.dzb.ssm.service.IRoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/4/11 9:42
 */
@Service("roleService")
@Transactional
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page, size);
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public Role findById(int id) throws Exception {
        return roleDao.findById(id);
    }

    @Override
    public List<Permission> findOtherPermissions(Integer roleId) throws Exception {
        return roleDao.findOtherPermissions(roleId);
    }

    @Override
    public void addPermissionToRole(Integer roleId, Integer[] permissionIds) throws Exception {
        for (Integer permissionId : permissionIds) {
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }


}
