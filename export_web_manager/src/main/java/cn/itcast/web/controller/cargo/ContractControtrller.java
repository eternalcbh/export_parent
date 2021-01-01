package cn.itcast.web.controller.cargo;

import cn.itcast.domain.cargo.Contract;
import cn.itcast.domain.cargo.ContractExample;
import cn.itcast.domain.company.Company;
import cn.itcast.service.cargo.ContractService;
import cn.itcast.web.controller.BaseController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * @author cbh
 * @PackageName:cn.itcast.web.controller.cargo
 * @ClassName:ContractControtrller
 * @Description:
 * @date 2020-12-28 21:39
 */
@Controller
@RequestMapping("/cargo/contract")
@Log4j
public class ContractControtrller extends BaseController {
	@Reference
	private ContractService contractService;

	/**
	 * 列表查询
	 * 请求路径:http://localhost:8080/company/list
	 * 响应路径:/WEB-INF/pages/company/company-list.jsp
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize, Model model) {

		ContractExample contractExample = new ContractExample();

		//按照时间倒序查询
		contractExample.setOrderByClause("create_time desc");

		//查出登录者的登录等级
		if (getLoginUser().getDegree() == 1) {
			contractExample.createCriteria().andCompanyIdEqualTo(getLoginCompanyId());
		} else if (getLoginUser().getDegree() == 2) {
			PageInfo<Contract> pageInfo = contractService.findPageByDeptId(getLoginUser().getDeptId(), pageNum, pageSize, getLoginCompanyId());
			model.addAttribute("pageInfo", pageInfo);
			return "cargo/contract/contract-list";
		} else if (getLoginUser().getDegree() == 3) {
			contractExample.createCriteria().andCreateDeptEqualTo(getLoginUser().getDeptId()).andCompanyIdEqualTo(getLoginCompanyId());
		} else if (getLoginUser().getDegree() == 4) {
			contractExample.createCriteria().andCreateByEqualTo(getLoginUser().getId()).andCompanyIdEqualTo(getLoginCompanyId());
		}

		PageInfo<Contract> pageInfo = contractService.findByPage(contractExample, pageNum, pageSize);

		model.addAttribute("pageInfo", pageInfo);

		return "cargo/contract/contract-list";
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "cargo/contract/contract-add";
	}

	@RequestMapping("/edit")
	public String edit(Contract contract) {
		//设置企业信息
		contract.setCompanyId(getLoginCompanyId());
		contract.setCompanyName(getLoginCompanyName());

		//设置创建人和创建人的部门
		contract.setCreateBy(getLoginUser().getId());
		contract.setCreateDept(getLoginUser().getDeptId());
		if (StringUtils.isEmpty(contract.getId())) {
			//添加
			contractService.save(contract);
		} else {
			//修改
			contractService.update(contract);
		}
		//重定向列表
		return "redirect:/cargo/contract/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(String id, Model model) {
		//根据id查询
		Contract contract = contractService.findById(id);
		//存储查询结构
		model.addAttribute("contract", contract);
		return "cargo/contract/contract-update";
	}

	@RequestMapping("/delete")
	public String delete(String id) {
		contractService.delete(id);
		return "redirect:/cargo/contract/list";
	}

	@RequestMapping("/toView")
	public String toView(String id) {
		//1.根据销售合同的id查找购销合同
		Contract contract = contractService.findById(id);

		//2.存储到request域
		request.setAttribute("contract", contract);

		//3.请求转发到contract-update
		return "cargo/contract/contract-view";
	}

	@RequestMapping("/cancel")
	public String cancel(String id) {
//		1.根据合同id查找销售合同
		Contract contract = contractService.findById(id);

		//2.修改购销合同的状态为0，更新购销合同
		contract.setState(0);
		contractService.update(contract);

		//3.返回购销合同列表
		return "redirect:/cargo/contract/list";
	}

	@RequestMapping("/submit")
	public String submit(String id) {
		//1.根据购销合同id查找销售合同
		Contract contract = contractService.findById(id);

		//2.修改销售合同的状态为0
		contract.setState(1);
		contractService.update(contract);

		//3.返回销售合同列表
		return "redirect:/cargo/contract/list";
	}
}
