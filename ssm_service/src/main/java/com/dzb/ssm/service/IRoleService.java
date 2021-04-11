package com.dzb.ssm.service;

import com.dzb.ssm.domain.Permission;
import com.dzb.ssm.domain.Role;

import java.util.List;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/4/11 9:42
 */
public interface IRoleService{

    List<Role> findAll(int page,int size) throws Exception;

    void save(Role role) throws Exception;

    Role findById(int id) throws Exception;

    List<Permission> findOtherPermissions(Integer roleId) throws Exception;

    void addPermissionToRole(Integer roleId, Integer[] permissionIds) throws Exception;
}
