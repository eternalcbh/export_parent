package cn.itcast.web.controller;

import cn.itcast.domain.system.Module;
import cn.itcast.domain.system.User;
import cn.itcast.service.company.CompanyService;
import cn.itcast.service.system.ModuleService;
import cn.itcast.service.system.UserService;
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
	@Autowired
	private CompanyService companyService;

	/**
	 * 注入用户业务层
	 */
	@Autowired
	private UserService userService;

	/**
	 * 注入用户权限模块
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
			request.setAttribute("error","用户名或者密码不能为空");
			return "forward:login.jsp";
		}

		//2.根据用户邮箱去查找用户,如果用户对象为空，用户名不存在
		User user = userService.findByEmail(email);
		if (null != user){
			//3.用户存在比较密码
			if (user.getPassword().equals(password)){
				//4.登录成功
				session.setAttribute("loginUser",user);
				List<Module> moduleList = moduleService.findModuleByUser(user);
				request.setAttribute("modules",moduleList);
				return "/home/main";
			}else {
				//5.密码错误
				request.setAttribute("error","密码错误");
			}
		}else {
			//不存在该用户名
			request.setAttribute("error","用户名不存在");
		}
		return "forward:login.jsp";
	}

	@RequestMapping("/home")
	public String home() {
		return "home/home";
	}

	@RequestMapping("/logout")
	public String logout(){
		session.invalidate();
		return "redirect:login.jsp";
	}
}
