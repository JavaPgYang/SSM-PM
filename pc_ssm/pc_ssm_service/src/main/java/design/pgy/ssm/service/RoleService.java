package design.pgy.ssm.service;

import design.pgy.ssm.domain.Permission;
import design.pgy.ssm.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    void save(Role role);

    List<Permission> findRoleByIdAndAllPermission(String rid);

    void addPermissionToRole(String[] pid, String rid);
}
