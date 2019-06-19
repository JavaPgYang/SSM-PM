package design.pgy.ssm.service;

import design.pgy.ssm.domain.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> findAll();

    void save(Permission permission);
}
