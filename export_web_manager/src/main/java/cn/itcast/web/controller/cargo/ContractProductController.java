package cn.itcast.web.controller.cargo;

import cn.itcast.domain.cargo.ContractProduct;
import cn.itcast.domain.cargo.ContractProductExample;
import cn.itcast.domain.cargo.Factory;
import cn.itcast.domain.cargo.FactoryExample;
import cn.itcast.service.cargo.ContractProductService;
import cn.itcast.service.cargo.FactoryService;
import cn.itcast.web.controller.BaseController;
import cn.itcast.web.utils.UploadFileUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import lombok.extern.log4j.Log4j;
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
 * @ClassName:ContractProductController
 * @Description:
 * @date 2020-12-28 22:15
 */
@Controller
@RequestMapping("/cargo/contractProduct")
@Log4j
public class ContractProductController extends BaseController {
		@Reference
		private ContractProductService contractProductService;

		@Reference
		private FactoryService factoryService;

		@Autowired
		private UploadFileUtil uploadFileUtil;
	
		/**
		 * 列表查询
		 * 请求路径:http://localhost:8080/contractproduct/list
		 * 响应路径:/WEB-INF/pages/contractproduct/contractproduct-list.jsp
		 */
		@RequestMapping("/list")
		public String list(@RequestParam(defaultValue = "1")Integer pageNum, @RequestParam(defaultValue = "5")Integer pageSize,
		                   Model model, String contractId){

			model.addAttribute("contractId",contractId);

			FactoryExample factoryExample = new FactoryExample();

			ContractProductExample contractProductExample = new ContractProductExample();

			contractProductExample.createCriteria().andContractIdEqualTo(contractId);

			PageInfo<ContractProduct> pageInfo = contractProductService.findByPage(contractProductExample, pageNum, pageSize);

			//查找出所有的工厂
			factoryExample.createCriteria().andCtypeEqualTo("货物");

			List<Factory> factoryList = factoryService.findAll(factoryExample);

			model.addAttribute("factoryList",factoryList);

			model.addAttribute("pageInfo",pageInfo);
	
			return "cargo/product/product-list";
		}
	
		@RequestMapping("/toAdd")
		public String toAdd(){
			return "cargo/product/product-add";
		}
	
		@RequestMapping("/edit")
		public String edit(ContractProduct contractProduct, MultipartFile productPhoto) throws Exception {

			//设置创建公司id
			contractProduct.setCompanyId(getLoginCompanyId());

			//设置创建公司名字
			contractProduct.setCompanyName(getLoginCompanyName());

			//设置创建者id
			contractProduct.setCreateBy(getLoginUser().getId());

			//设置创建者部门
			contractProduct.setCreateBy(getLoginUser().getDeptId());

			if (null != productPhoto){
				String imgUrl = uploadFileUtil.upload(productPhoto);
				contractProduct.setProductImage(imgUrl);
			}

			if (StringUtils.isEmpty(contractProduct.getId())){
				//添加
				contractProductService.save(contractProduct);
			}else {
				//修改
				contractProductService.update(contractProduct);
			}

			//重定向列表
			return "redirect:/cargo/contractProduct/list.do?contractId=" + contractProduct.getContractId();
		}
	
		@RequestMapping("/toUpdate")
		public String toUpdate(String id,Model model){
			//根据id查询
			ContractProduct product = contractProductService.findById(id);

			//查找出所有的商家
			FactoryExample factoryExample = new FactoryExample();
			List<Factory> factoryList = factoryService.findAll(factoryExample);

			//存储查询结构
			model.addAttribute("factoryList",factoryList);
			model.addAttribute("contractProduct",product);
			return "cargo/product/product-update";
		}
	
		@RequestMapping("/delete")
		public String delete(String id, String contractId){
			contractProductService.delete(id);
			return "redirect:/cargo/contractProduct/list.do?contractId=" + contractId;
		}
}
