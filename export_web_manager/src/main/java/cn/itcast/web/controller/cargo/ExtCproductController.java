package cn.itcast.web.controller.cargo;

import cn.itcast.domain.cargo.Contract;
import cn.itcast.domain.cargo.ContractExample;
import cn.itcast.domain.cargo.ExtCproduct;
import cn.itcast.domain.cargo.ExtCproductExample;
import cn.itcast.service.cargo.ContractService;
import cn.itcast.service.cargo.ExtCproductService;
import cn.itcast.web.controller.BaseController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author cbh
 * @PackageName:cn.itcast.web.controller.cargo
 * @ClassName:ExtCproductController
 * @Description:
 * @date 2020-12-28 22:45
 */

public class ExtCproductController extends BaseController {
	@Reference
	private ExtCproductService extcProductService;

	/**
	 * 列表查询
	 * 请求路径:http://localhost:8080/extc/list
	 * 响应路径:/WEB-INF/pages/extc/extc-list.jsp
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(defaultValue = "1")Integer pageNum, @RequestParam(defaultValue = "5")Integer pageSize, Model model){

		ExtCproductExample extcExample = new ExtCproductExample();

		//按照时间倒序查询
		extcExample.setOrderByClause("create_time desc");

		PageInfo<ExtCproduct> pageInfo = extcProductService.findByPage(extcExample, pageNum, pageSize);

		model.addAttribute("pageInfo",pageInfo);

		return "cargo/extc/extc-list";
	}

	@RequestMapping("/toAdd")
	public String toAdd(){
		return "cargo/extc/extc-add";
	}

	@RequestMapping("/edit")
	public String edit(ExtCproduct extc){
		if (StringUtils.isEmpty(extc.getId())){
			//添加
			extcProductService.save(extc);
		}else{
			//修改
			extcProductService.update(extc);
		}
		//重定向列表
		return "redirect:/cargo/extc/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(String id,Model model){
		//根据id查询
		ExtCproduct extc = extcProductService.findById(id);
		//存储查询结构
		model.addAttribute("extc",extc);
		return "cargo/extc/extc-update";
	}

	@RequestMapping("/delete")
	public String delete(String id){
		extcProductService.delete(id);
		return "redirect:/cargo/extc/list";
	}
}
