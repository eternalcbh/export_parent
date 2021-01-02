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
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
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
	public String list(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize,
	                   Model model, String contractId) {

		model.addAttribute("contractId", contractId);

		FactoryExample factoryExample = new FactoryExample();

		ContractProductExample contractProductExample = new ContractProductExample();

		contractProductExample.createCriteria().andContractIdEqualTo(contractId);

		PageInfo<ContractProduct> pageInfo = contractProductService.findByPage(contractProductExample, pageNum, pageSize);

		//查找出所有的工厂
		factoryExample.createCriteria().andCtypeEqualTo("货物");

		List<Factory> factoryList = factoryService.findAll(factoryExample);

		model.addAttribute("factoryList", factoryList);

		model.addAttribute("pageInfo", pageInfo);

		return "cargo/product/product-list";
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
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

		if (null != productPhoto) {
			String imgUrl = uploadFileUtil.upload(productPhoto);
			contractProduct.setProductImage(imgUrl);
		}

		if (StringUtils.isEmpty(contractProduct.getId())) {
			//添加
			contractProductService.save(contractProduct);
		} else {
			//修改
			contractProductService.update(contractProduct);
		}

		//重定向列表
		return "redirect:/cargo/contractProduct/list.do?contractId=" + contractProduct.getContractId();
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(String id, Model model) {
		//根据id查询
		ContractProduct product = contractProductService.findById(id);

		//查找出所有的商家
		FactoryExample factoryExample = new FactoryExample();
		List<Factory> factoryList = factoryService.findAll(factoryExample);

		//存储查询结构
		model.addAttribute("factoryList", factoryList);
		model.addAttribute("contractProduct", product);
		return "cargo/product/product-update";
	}

	@RequestMapping("/delete")
	public String delete(String id, String contractId) {
		contractProductService.delete(id);
		return "redirect:/cargo/contractProduct/list.do?contractId=" + contractId;
	}

	@RequestMapping("/toImport")
	public String toImport(String contractId){
		request.setAttribute("contractId",contractId);
		return "cargo/product/product-import";
	}

	@RequestMapping("/import")
	public String importExcel(MultipartFile file,String contractId) throws IOException {
		//1.读取excel数据
		//1.1获取文件输入流
		InputStream inputStream = file.getInputStream();

		//1.2创建工作
		Workbook workbook = new XSSFWorkbook(inputStream);

		//1.3获取单元格内容
		Sheet sheet = workbook.getSheetAt(0);

		//1.4获取所有行
		int rows = sheet.getPhysicalNumberOfRows();

		//1.5遍历所有行读取数据
		for (int i = 0; i < rows; i++){
			//每一行数据
			Row row = sheet.getRow(i);

			//每一行对应一个订单下的货物
			ContractProduct contractProduct = new ContractProduct();

			//1.5.1生成厂家
			if (null != row.getCell(1)){
				String factoryName = row.getCell(1).getStringCellValue();
				contractProduct.setFactoryName(factoryName);
			}

			//1.5.2货号
			if (null != row.getCell(2)){
				String productNo = row.getCell(2).getStringCellValue();
				contractProduct.setProductNo(productNo);
			}

			//1.5.3数量
			if (null != row.getCell(3)){
				double cnumber = row.getCell(3).getNumericCellValue();
				contractProduct.setCnumber((long) cnumber);
			}

			//1.5.4包装单位
			if (null != row.getCell(4)){
				String packingUnit = row.getCell(4).getStringCellValue();
				contractProduct.setPackingUnit(packingUnit);
			}

			//1.5.5装率
			if (null != row.getCell(5)){
				double loadingRate = row.getCell(5).getNumericCellValue();
				contractProduct.setLoadingRate(loadingRate + "");
			}


			//1.5.6箱数
			if (null != row.getCell(6)){
				double boxNum = row.getCell(6).getNumericCellValue();
				contractProduct.setBoxNum((long) boxNum);
			}

			//1.5.7单价
			if (null != row.getCell(7)){
				double price = row.getCell(7).getNumericCellValue();
				contractProduct.setPrice(new BigDecimal(price));
			}

			//1.5.8货物描诉
			if (null != row.getCell(8)){
				String productDesc = row.getCell(8).getStringCellValue();
				contractProduct.setProductDesc(productDesc);
			}

			//1.5.9要求
			if (null != row.getCell(9)){
				String request = row.getCell(9).getStringCellValue();
				contractProduct.setProductDesc(request);
			}

			//补充销售合同
			contractProduct.setContractId(contractId);

			//补充该货物生产的生产厂家id
			if (null != contractProduct.getFactoryName()){
				Factory factory = factoryService.findByFactoryName(contractProduct.getFactoryName());
				contractProduct.setFactoryId(factory.getId());
			}
			//保存数据
			contractProductService.save(contractProduct);
		}


		return "redirect:/cargo/contractProduct/list?contractId=" + contractId;
	}

}
