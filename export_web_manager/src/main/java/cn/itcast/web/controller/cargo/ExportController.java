package cn.itcast.web.controller.cargo;

import cn.itcast.domain.cargo.*;
import cn.itcast.service.cargo.ContractService;
import cn.itcast.service.cargo.ExportProductService;
import cn.itcast.service.cargo.ExportService;
import cn.itcast.web.controller.BaseController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author cbh
 * @PackageName:cn.itcast.web.controller.cargo
 * @ClassName:ExportController
 * @Description:3
 */
@Controller
@RequestMapping("/cargo/export")
public class ExportController extends BaseController {
	@Reference
	private ContractService contractService;

	@Reference
	private ExportService exportService;

	@Reference
	private ExportProductService exportProductService;

	@RequestMapping("/list")
	public String list(@RequestParam(defaultValue = "1") Integer pageNum,
	                   @RequestParam(defaultValue = "5") Integer pageSize){
		//设置属于什么公司
		ExportExample exportExample = new ExportExample();
		exportExample.setOrderByClause("create_time desc");
		exportExample.createCriteria().andCompanyIdEqualTo(getLoginCompanyId());
		PageInfo<Export> pageInfo = exportService.findByPage(exportExample, pageNum, pageSize);
		request.setAttribute("pageInfo",pageInfo);
		return "cargo/export/export-list";
	}

	@RequestMapping("/toExport")
	public String toExport(String id){
		Export export = exportService.findById(id);
		request.setAttribute("export",export);
		request.setAttribute("id",id);
		return "cargo/export/export-toExport";
	}

	@RequestMapping("/edit")
	public String edit(Export export){
		//报运单创建人
		export.setCreateBy(getLoginCompanyId());
		//报运单所属于的部门
		export.setCreateDept(getLoginUser().getDeptId());
		//报运单所属企业名称和id
		export.setCompanyId(getLoginCompanyId());
		export.setCompanyName(getLoginCompanyName());

		if (StringUtils.isEmpty(export.getId())){
			exportService.save(export);
		}else {
			exportService.update(export);
		}

		return "redirect:/cargo/export/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(String id){
		//回显报运单数据
		Export export = exportService.findById(id);
		request.setAttribute("export",export);

		//查找出该报运单下所有的货物
		ExportProductExample exportProductExample = new ExportProductExample();
		exportProductExample.createCriteria().andExportIdEqualTo(id);
		List<ExportProduct> exportProductList = exportProductService.findAll(exportProductExample);

		request.setAttribute("eps",exportProductList);

		return "cargo/export/export-update";
	}

	@RequestMapping("/toView")
	public String toView(String id){
		//报运单搜索对象
		Export export = exportService.findById(id);
		request.setAttribute("export",export);
		return "cargo/export/export-view";
	}



	@RequestMapping("/contractList")
	public String contractList(@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "5") Integer pageSize){
		//创建合同搜索对象
		ContractExample contractExample = new ContractExample();

		//排序
		contractExample.setOrderByClause("create_time desc");
		contractExample.createCriteria().andStateEqualTo(1);

		//工厂
//		Handler invokeStrategy = Factory.getInvokeStrategy(getLoginUser().getDegree());
//		PageInfo<Contract> pageInfo = invokeStrategy.strategy(contractService, contractExample,
//		pageNum, pageSize, getLoginUser(),
//		getLoginCompanyId());

		PageInfo<Contract> pageInfo = contractService.findByPage(contractExample, pageNum, pageSize);

		//存到域中
		request.setAttribute("pageInfo",pageInfo);

		return "cargo/export/export-contractList";
	}
}
