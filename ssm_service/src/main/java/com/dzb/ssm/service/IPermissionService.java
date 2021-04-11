package com.dzb.ssm.service;

import com.dzb.ssm.domain.Permission;

import java.util.List;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/4/11 10:28
 */
public interface IPermissionService {

    List<Permission> findAll(int page,int size) throws Exception;

    void save(Permission permission) throws Exception;
}
