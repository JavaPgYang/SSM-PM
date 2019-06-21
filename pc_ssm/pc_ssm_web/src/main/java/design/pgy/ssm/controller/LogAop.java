package design.pgy.ssm.controller;

import design.pgy.ssm.domain.SysLog;
import design.pgy.ssm.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class LogAop {

    private Date visitTime; // 访问开始时间
    private Class clazz; // 访问的类
    private Method method;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogService sysLogService;

    // 前置通知，主要获取开始时间，执行的类和方法
    @Before("execution(* design.pgy.ssm.controller.*.*(..))")
    public void deBefore(JoinPoint jp) throws NoSuchMethodException {
        visitTime = new Date();
        clazz = jp.getTarget().getClass();
        String methodName = jp.getSignature().getName(); // 获取访问的方法名称

        Object[] args = jp.getArgs();
        if (args != null && args.length != 0) {
            Class[] classes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classes[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodName, classes);
        } else {
            method = clazz.getMethod(methodName);
        }
    }

    // 后置通知
    @After("execution(* design.pgy.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint jp) {
        // 获取执行的时长
        Long time = new Date().getTime() - visitTime.getTime();

        // 获取访问url
        // 获取类上的注解，方法上的注解
        if (clazz != null && method != null && clazz != LogAop.class && clazz != SysLogController.class) {
            RequestMapping clazzAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            String classValue = clazzAnnotation.value()[0];
            RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
            String methodValue = methodAnnotation.value()[0];
            // 拼接url
            String url = classValue + methodValue;

            // 获取访问的ip地址
            String ip = request.getRemoteAddr();

            // 获取当前操作的用户
            SecurityContext context = SecurityContextHolder.getContext();
            // 从上下文中获取当前登录的用户
            User user = (User) context.getAuthentication().getPrincipal();
            String username = user.getUsername();

            // 封装日志对象，存入数据库
            SysLog sysLog = new SysLog();
            sysLog.setVisitTime(visitTime);
            sysLog.setIp(ip);
            sysLog.setMethod("【类名】：" + clazz.getName() + "【方法名】：" + method.getName());
            sysLog.setUrl(url);
            sysLog.setUsername(username);
            sysLog.setExecutionTime(time);

            sysLogService.save(sysLog);

        }
    }
}
