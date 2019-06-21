package design.pgy.ssm.controller;

import design.pgy.ssm.domain.Permission;
import design.pgy.ssm.domain.Role;
import design.pgy.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll")
    @PreAuthorize("authentication.principal.username == 'tom'")
    public ModelAndView findAll(ModelAndView modelAndView) {
        List<Role> roleList = roleService.findAll();
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Role role) {
        roleService.save(role);
        return "redirect:findAll";
    }

    @RequestMapping("/findRoleByIdAndAllPermission")
    public ModelAndView findRoleByIdAndAllPermission(ModelAndView modelAndView, @RequestParam(name = "id", required = true) String rid) {
        List<Permission> permissionList = roleService.findRoleByIdAndAllPermission(rid);
        modelAndView.addObject("rid", rid);
        modelAndView.addObject("permissionList", permissionList);
        modelAndView.setViewName("role-permission-add");
        return modelAndView;
    }

    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(@RequestParam(name = "roleId", required = true) String rid, @RequestParam(name = "ids", required = true) String[] pids) {
        roleService.addPermissionToRole(pids, rid);
        return "redirect:findAll";
    }

}

