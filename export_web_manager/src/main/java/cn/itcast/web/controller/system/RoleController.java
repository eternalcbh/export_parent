package cn.itcast.web.controller.system;

import cn.itcast.domain.system.Role;
import cn.itcast.service.system.RoleService;
import cn.itcast.web.controller.BaseController;
import com.github.pagehelper.PageInfo;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author cbh
 * @PackageName:cn.itcast.web.controller.system
 * @ClassName:RoleController
 * @Description:
 * @date 2020-12-18 8:37
 */
@Controller
@RequestMapping("/system/role")
@Log4j
public class RoleController extends BaseController {
	@Autowired
	RoleService roleService;

	@RequestMapping("/list")
	public String list(@RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "1") Integer pageNum, Model model) {
		String companyId = getLoginCompanyId();
		PageInfo<Role> pageInfo = roleService.findByPage(pageNum, pageSize,companyId);
		model.addAttribute("pageInfo",pageInfo);
		return "system/role/role-list";
	}

	@RequestMapping("/edit")
	public String eidt(String id,Model model){
		Role role = roleService.findById(id);
		model.addAttribute("role",role);
		return "system/role/role-update";
	}

	@RequestMapping("/update")
	public String update(Role role){
		if (StringUtils.isEmpty(role.getId())){
			String companyId = getLoginCompanyId();
			String companyName = getLoginCompanyName();
			role.setCompanyId(companyId);
			role.setCompanyName(companyName);
			roleService.insert(role);
		}else {
			roleService.update(role);
		}

		return "redirect:/system/role/list";
	}

	@RequestMapping("/toAdd")
	public String toAdd(){
		return "system/role/role-add";
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, String> delete(String id){
		//先根据id查询是否有被依赖
		boolean flag = roleService.delete(id);
		Map<String, String> map = new HashMap<>();
		if (flag == true){
			map.put("status","true");
		}else {
			map.put("status","false");
		}
		return map;
	}
}
