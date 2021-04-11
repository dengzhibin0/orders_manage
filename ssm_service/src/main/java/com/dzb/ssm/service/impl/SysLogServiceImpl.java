package com.dzb.ssm.service.impl;

import com.dzb.ssm.dao.ISysLogDao;
import com.dzb.ssm.domain.SysLog;
import com.dzb.ssm.service.ISysLogService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/4/11 16:19
 */
@Service("sysLogService")
@Transactional
public class SysLogServiceImpl implements ISysLogService {
    @Autowired
    private ISysLogDao sysLogDao;

    @Override
    public void save(SysLog sysLog) throws Exception {

        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page, size);
        return sysLogDao.findAll();
    }
}
