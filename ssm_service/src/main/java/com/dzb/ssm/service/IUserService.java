package com.dzb.ssm.service;

import com.dzb.ssm.domain.Role;
import com.dzb.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/4/4 20:56
 */
public interface IUserService extends UserDetailsService {

    List<UserInfo> findAll(int page, int size) throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(int id) throws Exception;

    List<Role> findOtherRoles(int userid) throws Exception;

    void addRoleToUser(Integer userId, Integer[] roleIds) throws Exception;
}
