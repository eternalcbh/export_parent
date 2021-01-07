package cn.itcast.web.controller.system;

import cn.itcast.domain.system.Dept;
import cn.itcast.domain.system.Role;
import cn.itcast.domain.system.User;
import cn.itcast.service.system.DeptService;
import cn.itcast.service.system.RoleService;
import cn.itcast.service.system.UserService;
import cn.itcast.web.controller.BaseController;
import com.github.pagehelper.PageInfo;
import lombok.extern.log4j.Log4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/system/user")
@Log4j
public class UserController extends BaseController {
	@Autowired
	private UserService userService;

	@Autowired
	private DeptService deptService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	/**
	 * 列表查询
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(defaultValue = "1") Integer pageNum,
	                    @RequestParam(defaultValue = "5") Integer pageSize) {
		log.info("执行用户列表查询开始");
		String companyId = getLoginCompanyId();
		PageInfo<User> pageInfo = userService.findByPage(companyId, pageNum, pageSize);
		request.setAttribute("pageInfo", pageInfo);
		return "system/user/user-list";
	}

	/**
	 * 进入添加页面
	 */
	@RequestMapping("/toAdd")
	public String toAdd(Model model) {
		//根据企业id查询
		List<User> userList = userService.findAll(getLoginCompanyId());
		model.addAttribute("userList", userList);

		//查询所有部门,页面下拉列表显示
		List<Dept> deptList = deptService.findAll(getLoginCompanyId(),null);
		model.addAttribute("deptList", deptList);

		return "system/user/user-add";
	}

	/**
	 * 添加或修改
	 */
	@RequestMapping("/edit")
	public String edit(User user) {
		//设置企业信息
		user.setCompanyId(getLoginCompanyId());
		user.setCompanyName(getLoginCompanyName());
		if (StringUtils.isEmpty(user.getId())) {
			userService.save(user);
			//给mq发信息
			rabbitTemplate.convertAndSend("email-exchanger","user.add",user);
		} else {
			userService.update(user);
		}
		//重定向到列表
		return "redirect:/system/user/list";
	}

	/**
	 * 进入修改页面
	 */
	@RequestMapping("/toUpdate")
	public String toUpdate(String id, Model model) {
		//1.根据id查询
		User user = userService.findById(id);

		//查询所有部门
		List<Dept> deptList = deptService.findAll(getLoginCompanyId(),id);
		model.addAttribute("deptList", deptList);

		//3.保存
		model.addAttribute("user", user);
		model.addAttribute("deptList", deptList);
		return "system/user/user-update";
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(String id) {
		String message = null;
		if (userService.delete(id) != 0) {
			message = "true";
		} else {
			message = "false";
		}
		return message;
	}

	@RequestMapping("/roleList")
	public String roleList(String id){
		//1.查找出所有的用户列表
		List<Role> roleListAll = roleService.findAll(getLoginCompanyId());

		//2.查找用户对应的角色
		List<Role> roleList = roleService.findRoleByUid(id);

		User user = userService.findById(id);

		request.setAttribute("user",user);
		request.setAttribute("roleList",roleListAll);
		request.setAttribute("userRoleStr",roleList.toString());
		return "system/user/user-role";
	}

	@RequestMapping("/changeRoles")
	public String changeRoles(String userid,String[] roleIds){
		userService.changeRoles(userid,roleIds);
		return "redirect:/system/user/list";
	}
}
