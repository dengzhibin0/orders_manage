package com.dzb.ssm.dao;

import com.dzb.ssm.domain.Member;
import com.dzb.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/3/28 10:59
 */
public interface IMemberDao {

    //根据id查询产品
    @Select("select * from member where id=#{id}")
    public Member findById(Integer id) throws Exception;

    //查询所有的产品信息
    @Select("select * from member")
    public List<Member> findAll() throws Exception;

    @Insert("insert into member(NAME,nickname,phoneNum,email) values(#{NAME},#{nickname},#{phoneNum},#{email})")
    void save(Member member);
}
