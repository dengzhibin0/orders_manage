package com.dzb.ssm.service.impl;

import com.dzb.ssm.dao.IMemberDao;
import com.dzb.ssm.domain.Member;
import com.dzb.ssm.service.IMemberService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/3/28 11:03
 */
@Service("memberService")
@Transactional
public class MemberServiceImpl implements IMemberService {
    @Autowired
    private IMemberDao memberDao;


    @Override
    public Member findById(Integer id) throws Exception {
        return memberDao.findById(id);
    }

    @Override
    public List<Member> findAll(int page, int size) throws Exception {
        //参数pageNum 是页码值   参数pageSize 代表是每页显示条数
        PageHelper.startPage(page, size);
        return memberDao.findAll();
    }

    @Override
    public void save(Member member) throws Exception {
        memberDao.save(member);
    }
}
