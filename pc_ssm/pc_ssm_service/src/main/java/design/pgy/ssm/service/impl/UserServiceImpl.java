package design.pgy.ssm.service.impl;

import design.pgy.ssm.domain.Role;
import design.pgy.ssm.domain.UserInfo;
import design.pgy.ssm.mapper.UserMapper;
import design.pgy.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) {

        UserInfo userInfo = userMapper.findByName(s);
        if (userInfo == null) {
            return null;
        }

        // User user = new User(userInfo.getUserName(), "{noop}" + userInfo.getPassword(), getAuthority(userInfo.getRoleList()));
        User user = new User(userInfo.getUserName(), userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoleList()));

        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roleList) {
        List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
        for (Role role : roleList) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }

    @Override
    public List<UserInfo> findAll() {
        return userMapper.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userMapper.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) {
        return userMapper.findById(id);
    }

    @Override
    public List<Role> findUserByIdAndAllRole(String uid) {
        return userMapper.findUserByIdAndAllRole(uid);
    }

    @Override
    public void addRoleToUser(String uid, String[] rids) {
        for (String rid : rids) {
            userMapper.addRoleToUser(uid,rid);
        }
    }
}
