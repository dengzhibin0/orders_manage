package com.dzb.ssm.service.impl;

import com.dzb.ssm.dao.IUserDao;
import com.dzb.ssm.domain.Role;
import com.dzb.ssm.domain.UserInfo;
import com.dzb.ssm.service.IUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/4/4 20:57
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo=null;
        try {
            userInfo=userDao.findByUserName(username);
//            System.out.println(username);
//            System.out.println(userInfo);
        }catch (Exception e){
            e.printStackTrace();
        }

        // 处理自己的用户对象封装成UserDetails
//        User user=new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        User user=new User(userInfo.getUsername(),userInfo.getPassword(), userInfo.getStatus() != 0,true,true,true
                ,getAuthority(userInfo.getRoles()));
        return user;
    }


    //作用就是返回一个List集合，集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {

            // 注意：spring security在检索用户权限的时候，必须"ROLE_"开头
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }

    @Override
    public List<UserInfo> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page, size);
        return userDao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) throws Exception {
        // 对密码进行加密处理
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    @Override
    public UserInfo findById(int id) throws Exception {
        return userDao.findById(id);
    }

    @Override
    public List<Role> findOtherRoles(int userid) throws Exception {
        return userDao.findOtherRoles(userid);
    }

    @Override
    public void addRoleToUser(Integer userId, Integer[] roleIds) throws Exception {
        for(Integer roleId:roleIds){
            userDao.addRoleToUser(userId,roleId);
        }
    }
}
