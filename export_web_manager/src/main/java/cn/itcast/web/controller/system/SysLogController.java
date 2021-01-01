package cn.itcast.web.controller.system;

import cn.itcast.domain.system.SysLog;
import cn.itcast.service.system.SysLogService;
import cn.itcast.web.controller.BaseController;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author cbh
 * @PackageName:cn.itcast.web.controller.system
 * @ClassName:SysLogController
 * @Description:
 * @date 2020-12-25 0:07
 */
@RequestMapping("/system/log")
@Controller
public class SysLogController extends BaseController {

	/**
	 * 注入业务层
	 */
	@Autowired
	private SysLogService sysLogService;

	@RequestMapping("/list")
	public String list(@RequestParam(defaultValue = "1") int pageNum,
	                   @RequestParam(defaultValue = "5") int pageSize,
	                   Model model){
		PageInfo<SysLog> pageInfo = sysLogService.findByPage(getLoginCompanyId(),pageNum, pageSize);
		model.addAttribute("pageInfo",pageInfo);
		return "/system/log/log-list";
	}
}
