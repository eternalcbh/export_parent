package cn.itcast.web.controller.cargo;

import cn.itcast.domain.cargo.ExtCproduct;
import cn.itcast.domain.cargo.ExtCproductExample;
import cn.itcast.domain.cargo.Factory;
import cn.itcast.domain.cargo.FactoryExample;
import cn.itcast.service.cargo.ExtCproductService;
import cn.itcast.service.cargo.FactoryService;
import cn.itcast.web.controller.BaseController;
import cn.itcast.web.utils.UploadFileUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author cbh
 * @PackageName:cn.itcast.web.controller.cargo
 * @ClassName:ExtCproductController
 * @Description:
 * @date 2020-12-28 22:45
 */
@Controller
@RequestMapping("/cargo/extCproduct")
public class ExtCproductController extends BaseController {
	@Reference
	private ExtCproductService extcProductService;

	@Reference
	private FactoryService factoryService;

	@Autowired
	private UploadFileUtil fileUtil;

	/**
	 * 列表查询
	 * 请求路径:http://localhost:8080/extc/list
	 * 响应路径:/WEB-INF/pages/extc/extc-list.jsp
	 */
	@RequestMapping("/list")
	public String list(String con,@RequestParam(defaultValue = "1")Integer pageNum, @RequestParam(defaultValue = "5")Integer pageSize,
	                   Model model,String contractId,String contractProductId){

		ExtCproductExample extcExample = new ExtCproductExample();

		//查找出工厂
		FactoryExample factoryExample = new FactoryExample();

		factoryExample.createCriteria().andCtypeEqualTo("附件");

		List<Factory> factoryList = factoryService.findAll(factoryExample);

		//查找出该合同下的附件
		extcExample.createCriteria().andContractIdEqualTo(contractId);
		extcExample.createCriteria().andContractProductIdEqualTo(contractProductId);
		PageInfo<ExtCproduct> pageInfo = extcProductService.findByPage(extcExample, pageNum, pageSize);

		//把id存储到域钟
		model.addAttribute("contractId",contractId);
		model.addAttribute("contractProductId",contractProductId);

		model.addAttribute("pageInfo",pageInfo);

		model.addAttribute("factoryList",factoryList);

		return "cargo/extc/extc-list";
	}

	@RequestMapping("/toAdd")
	public String toAdd(){
		return "cargo/extc/extc-add";
	}

	@RequestMapping("/edit")
	public String edit(ExtCproduct extCproduct, MultipartFile productPhoto){
		//设置附件创建人
		extCproduct.setCreateBy(getLoginUser().getId());

		//设置部门
		extCproduct.setCreateDept(getLoginUser().getDeptId());

		//设置企业id
		extCproduct.setCompanyId(getLoginCompanyId());

		//设置企业名称
		extCproduct.setCompanyName(getLoginCompanyName());

		//七牛云上传
		if (null != productPhoto){
			String url = fileUtil.upload(productPhoto);
			extCproduct.setProductImage(url);
		}

		if (StringUtils.isEmpty(extCproduct.getId())){
			//添加
			extcProductService.save(extCproduct);
		}else{
			//修改
			extcProductService.update(extCproduct);
		}
		//重定向列表
		return "redirect:/cargo/extCproduct/list?contractId="+extCproduct.getContractId() + "&contractProductId=" + extCproduct.getContractProductId();
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(String contractProductId,String id,Model model,String contractId){
		//根据id查询
		ExtCproduct extCproduct = extcProductService.findById(id);

		//查找所所有的附件gongc1
		FactoryExample factoryExample = new FactoryExample();
		factoryExample.createCriteria().andCtypeEqualTo("附件");

		//查找出下拉列表
		List<Factory> factoryList = factoryService.findAll(factoryExample);

		//存储查询结构
		model.addAttribute("contractProductId",contractProductId);
		model.addAttribute("contractId",contractId);
		model.addAttribute("factoryList",factoryList);
		model.addAttribute("extCproduct",extCproduct);
		return "cargo/extc/extc-update";
	}

	@RequestMapping("/delete")
	public String delete(String id, String contractId, String contractProductId){
		extcProductService.delete(id);
		return "redirect:/cargo/extCproduct/list?contractId="+contractId + "&contractProductId=" + contractProductId;
	}
}
