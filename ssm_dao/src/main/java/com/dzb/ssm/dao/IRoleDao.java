package com.dzb.ssm.dao;

import com.dzb.ssm.domain.Permission;
import com.dzb.ssm.domain.Role;
import com.github.pagehelper.ISelect;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/4/4 21:44
 */
public interface IRoleDao {
    //根据用户id查询出所有对应的角色
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions",column = "id",
                    javaType = java.util.List.class,
                    many = @Many(select = "com.dzb.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(int userId) throws Exception;

    @Select("select * from role")
    List<Role> findAll() throws Exception;

    @Insert("insert into role(roleName,roleDesc) " +
            "values(#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;


    @Select("select * from role where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions",column = "id",
                    javaType = java.util.List.class,
                    many = @Many(select = "com.dzb.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    Role findById(int id) throws Exception;

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermissions(Integer roleId);

    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") Integer roleId, @Param("permissionId") Integer permissionId) throws Exception;
}
