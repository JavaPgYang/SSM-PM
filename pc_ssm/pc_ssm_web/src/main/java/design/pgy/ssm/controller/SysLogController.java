package design.pgy.ssm.controller;

import design.pgy.ssm.domain.SysLog;
import design.pgy.ssm.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(ModelAndView modelAndView) {
        List<SysLog> sysLogs = sysLogService.findAll();
        modelAndView.addObject("sysLogs", sysLogs);
        modelAndView.setViewName("syslog-list");
        return modelAndView;
    }

}
