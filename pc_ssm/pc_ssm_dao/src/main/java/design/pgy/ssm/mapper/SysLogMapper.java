package design.pgy.ssm.mapper;

import design.pgy.ssm.domain.SysLog;

import java.util.List;

public interface SysLogMapper {

    void save(SysLog sysLog);

    List<SysLog> findAll();

}
