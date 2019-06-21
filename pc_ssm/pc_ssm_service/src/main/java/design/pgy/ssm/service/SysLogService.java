package design.pgy.ssm.service;

import design.pgy.ssm.domain.SysLog;

import java.util.List;

public interface SysLogService {

    void save(SysLog sysLog);

    List<SysLog> findAll();
}
