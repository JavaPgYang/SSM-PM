package design.pgy.ssm.service.impl;

import design.pgy.ssm.domain.SysLog;
import design.pgy.ssm.mapper.SysLogMapper;
import design.pgy.ssm.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public void save(SysLog sysLog) {
        sysLogMapper.save(sysLog);
    }

    @Override
    public List<SysLog> findAll() {
        return sysLogMapper.findAll();
    }
}
