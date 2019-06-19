package design.pgy.ssm.service.impl;

import design.pgy.ssm.domain.Permission;
import design.pgy.ssm.mapper.PermissionMapper;
import design.pgy.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> findAll() {
        return permissionMapper.findAll();
    }

    @Override
    public void save(Permission permission) {
        permissionMapper.save(permission);
    }
}
