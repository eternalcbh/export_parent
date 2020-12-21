package cn.itcast.web.controller.system;

import cn.itcast.domain.system.Module;
import cn.itcast.service.system.ModuleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cbh
 * @PackageName:cn.itcast.web.controller.company
 * @ClassName:ModuleController
 * @Description:
 * @date 2020-12-21 20:01
 */
@Controller
@RequestMapping("/system/module")
public class ModuleController {

	@Autowired
	ModuleService moduleService;

	/**
	 * 分页显示
	 * @param pageNum
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(defaultValue = "1") int pageNum,
	                   @RequestParam(defaultValue = "5") int pageSize,
	                   Model model){
		PageInfo<Module> pageInfo = moduleService.findByPage(pageNum, pageSize);
		model.addAttribute("pageInfo",pageInfo);
		return "/system/module/module-list";
	}

	/**
	 * 需要查找出所有的上级模块
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/toAdd")
	public ModelAndView list(ModelAndView modelAndView){
		List<Module> moduleList = moduleService.findAll();
		//回显所有模块
		modelAndView.addObject("menus",moduleList);
		modelAndView.setViewName("/system/module/module-add");
		return modelAndView;
	}

	/**
	 * 添加或删除模块
	 * @param module
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(Module module){
		if (StringUtils.isEmpty(module.getId())){
			moduleService.add(module);
		}else {
			moduleService.update(module);
		}
		return "redirect:/system/module/list";
	}

	/**
	 * 转发到编辑模块
	 * 根据id回显数据
	 * @return
	 */
	@RequestMapping("/toUpdate")
	public ModelAndView toUpdate(String id){
		Module module = moduleService.findById(id);
		List<Module> menus = moduleService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("module",module);
		modelAndView.addObject("menus",menus);
		modelAndView.setViewName("/system/module/module-update");
		return modelAndView;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, String> delete(String id){
		Boolean flag = moduleService.delete(id);
		Map<String,String> map = new HashMap<>();
		if (flag == true){
			map.put("status","true");
		}else {
			map.put("status","false");
		}
		return map;
	}
}
