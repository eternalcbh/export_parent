package cn.itcast.web.utils;

import cn.itcast.domain.system.SysLog;
import cn.itcast.domain.system.User;
import cn.itcast.service.system.SysLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author cbh
 * @PackageName:cn.itcast.service.utils
 * @ClassName:LogAspect
 * @Description:
 * @date 2020-12-25 11:36
 */
@Component
@Aspect
public class LogAspect {
	@Autowired
	private HttpServletRequest request;

	@Autowired
	private SysLogService sysLogService;

	@Autowired
	private HttpSession session;

	@Around("execution(* cn..controller.*.*.*(..))")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) {

		//1.获取结果
		Object result = null;

		//2.获取IP
		String ip = request.getRemoteAddr();
		User loginUser = (User) session.getAttribute("loginUser");

		//3.获取用户名
		String userName = loginUser.getUserName();

		//4.获取调用方法名
		String methodName = proceedingJoinPoint.getSignature().getName();

		//5.获取时间
		Date date = new Date();

		//6.获取执行的类
		String actionName = proceedingJoinPoint.getTarget().getClass().getName();

		//5.保存日志
		SysLog sysLog = new SysLog();
		sysLog.setIp(ip);
		sysLog.setMethod(methodName);
		sysLog.setAction(actionName);
		sysLog.setUserName(userName);
		sysLog.setTime(date);
		sysLog.setCompanyId(loginUser.getCompanyId());
		sysLog.setCompanyName(loginUser.getCompanyName());

		//6.保存日志
		sysLogService.save(sysLog);

		//7.执行方法
		try {
			result = proceedingJoinPoint.proceed();
			//8.返回结果
			return result;
		} catch (Throwable throwable) {
			throwable.printStackTrace();
			throw new RuntimeException(throwable);
		}
	}
}
