package cn.itcast.web.controller.system;

import cn.itcast.domain.system.Module;
import cn.itcast.domain.system.Role;
import cn.itcast.service.system.ModuleService;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Autowired
	ModuleService moduleService;

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

	@RequestMapping("/roleModule")
	public String roleModule(String roleid,Model model){
		Role role = roleService.findById(roleid);
		model.addAttribute("role",role);
		return "system/role/role-module";
	}

	@RequestMapping("/getTreeNodes")
	@ResponseBody
	public List<Map<String, Object>> getTreeNodes(String roleid,Model model){
		List<Map<String,Object>> resultList = new ArrayList<>();
		//遍历所有权限
		List<Module> moduleListAll = moduleService.findAll();

		//遍历当前角色所拥有的权限
		List<Module> moduleList = moduleService.findRoleModuleByRoleId(roleid);

		//遍历map集合，每个权限对应一个对象
		for (Module module : moduleListAll) {
			Map<String, Object> map = new HashMap<>();
			map.put("id",module.getId());
			map.put("pId",module.getParentId());
			map.put("name",module.getName());
			map.put("open","true");
			if (moduleList.contains(module)){
				map.put("checked",true);
			}
			resultList.add(map);
		}
		return resultList;
	}

	@RequestMapping("/updateRoleModule")
	public String updateRoleModule(String roleid, String[] moduleIds){
		System.out.println(moduleIds);
		roleService.updateRoleModule(roleid, moduleIds);

		return "redirect:/system/role/list";
	}
}
