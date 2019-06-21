package design.pgy.ssm.service;

import design.pgy.ssm.domain.Role;
import design.pgy.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(String id);

    List<Role> findUserByIdAndAllRole(String uid);

    void addRoleToUser(String uid, String[] rids);
}
