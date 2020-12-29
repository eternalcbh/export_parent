package cn.itcast.web.controller.cargo;

import cn.itcast.domain.cargo.Contract;
import cn.itcast.domain.cargo.ContractExample;
import cn.itcast.domain.cargo.ContractProduct;
import cn.itcast.domain.cargo.ContractProductExample;
import cn.itcast.service.cargo.ContractProductService;
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

import java.util.List;

/**
 * @author cbh
 * @PackageName:cn.itcast.web.controller.cargo
 * @ClassName:ContractProductController
 * @Description:
 * @date 2020-12-28 22:15
 */
@Controller
@RequestMapping("/cargo/product")
@Log4j
public class ContractProductController extends BaseController {
		@Reference
		private ContractProductService contractProductService;
	
		/**
		 * 列表查询
		 * 请求路径:http://localhost:8080/contractproduct/list
		 * 响应路径:/WEB-INF/pages/contractproduct/contractproduct-list.jsp
		 */
		@RequestMapping("/list")
		public String list(@RequestParam(defaultValue = "1")Integer pageNum, @RequestParam(defaultValue = "5")Integer pageSize, Model model){

			ContractProductExample contractProductExample = new ContractProductExample();

			PageInfo<ContractProduct> pageInfo = contractProductService.findByPage(contractProductExample, pageNum, pageSize);

			model.addAttribute("pageInfo",pageInfo);
	
			return "cargo/contract/contract-list";
		}
	
		@RequestMapping("/toAdd")
		public String toAdd(){
			return "cargo/contract/contract-add";
		}
	
		@RequestMapping("/edit.do")
		public String edit(ContractProduct contractProduct){
			if (StringUtils.isEmpty(contractProduct.getId())){

				contractProductService.save(contractProduct);
			}else{
				//修改
				contractProductService.update(contractProduct);
			}
			//重定向列表
			return "redirect:/cargo/product/list";
		}
	
		@RequestMapping("/toUpdate")
		public String toUpdate(String id,Model model){
			//根据id查询
			ContractProduct product = contractProductService.findById(id);
			//存储查询结构
			model.addAttribute("product",product);
			return "cargo/product/product-update";
		}
	
		@RequestMapping("/delete")
		public String delete(String id){
			contractProductService.delete(id);
			return "redirect:/cargo/product/list";
		}
}
