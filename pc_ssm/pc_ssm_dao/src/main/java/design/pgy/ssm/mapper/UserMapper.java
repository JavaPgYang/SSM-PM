package design.pgy.ssm.mapper;

import design.pgy.ssm.domain.Role;
import design.pgy.ssm.domain.UserInfo;

import java.util.List;

public interface UserMapper {

    UserInfo findByName(String username);

    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(String id);

    List<Role> findUserByIdAndAllRole(String uid);

    void addRoleToUser(String uid, String rid);
}
