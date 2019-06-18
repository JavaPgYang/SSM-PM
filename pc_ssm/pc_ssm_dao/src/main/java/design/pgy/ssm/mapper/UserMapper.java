package design.pgy.ssm.mapper;

import design.pgy.ssm.domain.UserInfo;

public interface UserMapper {

    UserInfo findByName(String username);

}
