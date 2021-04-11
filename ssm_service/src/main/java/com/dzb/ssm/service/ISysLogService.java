package com.dzb.ssm.service;

import com.dzb.ssm.domain.SysLog;

import java.util.List;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/4/11 16:19
 */
public interface ISysLogService {
    void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll(int page, int size) throws Exception;
}
