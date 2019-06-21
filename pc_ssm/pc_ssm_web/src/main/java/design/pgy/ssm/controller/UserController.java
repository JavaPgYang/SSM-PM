package design.pgy.ssm.controller;

import design.pgy.ssm.domain.Role;
import design.pgy.ssm.domain.UserInfo;
import design.pgy.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RolesAllowed("ADMIN")
    @RequestMapping("/findAll")
    public ModelAndView findAllUser(ModelAndView modelAndView) {
        List<UserInfo> userInfoList = userService.findAll();
        modelAndView.addObject("userList", userInfoList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(UserInfo userInfo) {
        userService.save(userInfo);
        return "redirect:findAll";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping("/findById")
    public ModelAndView findById(String id, ModelAndView modelAndView) {
        UserInfo userInfo = userService.findById(id);
        modelAndView.addObject("user", userInfo);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id", required = true) String uid, ModelAndView modelAndView) {
        modelAndView.addObject("uid", uid);
        List<Role> roleList = userService.findUserByIdAndAllRole(uid);
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }

    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId", required = true) String uid, @RequestParam(name = "ids", required = true) String[] rids) {
        userService.addRoleToUser(uid, rids);
        return "redirect:findAll";
    }

}
