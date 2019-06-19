package design.pgy.ssm.mapper;

import design.pgy.ssm.domain.UserInfo;

import java.util.List;

public interface UserMapper {

    UserInfo findByName(String username);

    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(String id);
}
