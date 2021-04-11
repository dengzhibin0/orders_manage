package com.dzb.ssm.dao;

import com.dzb.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/4/11 9:11
 */
public interface IPermissionDao {

    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id} )")
    public List<Permission> findPermissionByRoleId(int id) throws Exception;

    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    @Insert("insert into permission(permissionName,url) " +
            "values(#{permissionName},#{url})")
    void save(Permission permission) throws Exception;
}
