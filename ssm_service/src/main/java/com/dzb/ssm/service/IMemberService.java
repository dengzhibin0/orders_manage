package com.dzb.ssm.service;

import com.dzb.ssm.domain.Member;

import java.util.List;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/3/28 11:02
 */
public interface IMemberService {

    public Member findById(Integer id) throws Exception;

    public List<Member> findAll(int page, int size) throws Exception;

    void save(Member member) throws Exception;
}
