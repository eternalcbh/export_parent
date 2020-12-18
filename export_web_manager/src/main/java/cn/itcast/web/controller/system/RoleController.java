package cn.itcast.web.controller.system;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
public class RoleController {
	@RequestMapping("/list")
	public String list(){
		return "system/role/role-list";
	}
}
