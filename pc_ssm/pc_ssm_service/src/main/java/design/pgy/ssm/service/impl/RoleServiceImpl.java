package design.pgy.ssm.service.impl;

import design.pgy.ssm.domain.Permission;
import design.pgy.ssm.domain.Role;
import design.pgy.ssm.mapper.RoleMapper;
import design.pgy.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }

    @Override
    public void save(Role role) {
        roleMapper.save(role);
    }

    @Override
    public List<Permission> findRoleByIdAndAllPermission(String rid) {
        return roleMapper.findRoleByIdAndAllPermission(rid);
    }

    @Override
    public void addPermissionToRole(String[] pids, String rid) {
        for (String pid : pids) {
            roleMapper.addPermissionToRole(pid, rid);
        }
    }
}
