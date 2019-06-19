package design.pgy.ssm.mapper;

import design.pgy.ssm.domain.Permission;

import java.util.List;

public interface PermissionMapper {

    List<Permission> findAll();

    void save(Permission permission);
}
