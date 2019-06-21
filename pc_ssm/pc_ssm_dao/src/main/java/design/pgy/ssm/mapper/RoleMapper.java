package design.pgy.ssm.mapper;

import design.pgy.ssm.domain.Permission;
import design.pgy.ssm.domain.Role;

import java.util.List;

public interface RoleMapper {

    List<Role> findAll();

    void save(Role role);

    List<Permission> findRoleByIdAndAllPermission(String rid);

    void addPermissionToRole(String pid, String rid);
}
