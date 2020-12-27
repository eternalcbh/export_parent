package cn.itcast.web.controller;

import cn.itcast.domain.system.Module;
import cn.itcast.domain.system.User;
import cn.itcast.service.company.CompanyService;
import cn.itcast.service.system.ModuleService;
import cn.itcast.service.system.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LoginController extends BaseController {
	/**
	 * 注入公司服务层对象
	 */
	@Reference
	private CompanyService companyService;

	/**
	 * 注入用户业务层
	 */
	@Autowired
	private UserService userService;

	/**
	 * 注入用户权限模块
	 *
	 * @param email
	 * @param password
	 * @return
	 */
	@Autowired
	private ModuleService moduleService;

	@RequestMapping("/login")
	public String login(String email, String password) {
//        1.对登录数据进行校验
		if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password)) {
			request.setAttribute("error", "用户名或者密码不能为空");
			return "forward:login.jsp";
		}

		try{
			//		2.得到subject对象
			Subject subject = SecurityUtils.getSubject();

//		3.把邮箱与密码封装到Token对象
			UsernamePasswordToken token = new UsernamePasswordToken(email, password);

//		4.使用shiro发出登录的请求，并且把token传入，传递给realm
			subject.login(token);

			//5.如果登录成功，你可以获取一个登陆成功的一个对象，shiro登陆成功以后，shiro本身会往session中做很多登录成功标记
			User loginUser = (User)subject.getPrincipal();

			//6.自己做一些登录成功标记，并且可以加载模块
			session.setAttribute("loginUser",loginUser);

			List<Module> moduleList = moduleService.findModuleByUser(loginUser);
			session.setAttribute("modules", moduleList);
			return "/home/main";
		}catch (UnknownAccountException e){
			//如果一旦出现异常，代表用户名不存在
			request.setAttribute("error","用户名不存在");
			return "forward:/login.jsp";
		}catch (IncorrectCredentialsException e){
			//如果一旦出现该异常，密码错误
			request.setAttribute("error","密码不正确");
			return "forward:/login.jsp";
		}
	}

	@RequestMapping("/home")
	public String home() {
		return "home/home";
	}

	@RequestMapping("/logout")
	public String logout() {
		//1.得到subject对象
		Subject subject = SecurityUtils.getSubject();

		//2.退出
		subject.logout();

		//3.销毁session
		session.invalidate();

		return "redirect:login.jsp";
	}
}
