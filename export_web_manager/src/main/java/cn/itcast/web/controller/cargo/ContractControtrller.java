package cn.itcast.web.controller.cargo;

import cn.itcast.domain.cargo.Contract;
import cn.itcast.domain.cargo.ContractExample;
import cn.itcast.domain.vo.ContractProductVo;
import cn.itcast.service.cargo.ContractService;
import cn.itcast.web.controller.BaseController;
import cn.itcast.web.handler.Factory;
import cn.itcast.web.handler.Handler;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import lombok.extern.log4j.Log4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

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
		//策略模式+工厂模式,返回调用的策略
		Handler invokeStrategy = Factory.getInvokeStrategy(getLoginUser().getDegree());

		PageInfo<Contract> pageInfo = invokeStrategy.strategy(contractService, contractExample, pageNum, pageSize, getLoginUser(), getLoginCompanyId());

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

	@RequestMapping("/print")
	public String print() {
		return "cargo/print/contract-print";
	}

//	/**
//	 * 1.返回值为void
//	 * 2.也需要@ResponseBody
//	 * 模板方法
//	 * @param inputDate
//	 * @throws IOException
//	 */
//	@RequestMapping("/printExcel")
//	@ResponseBody
//	public void printExcel(String inputDate) throws IOException, ClassNotFoundException {
//		//1.读取模板的输入流
//		InputStream inputStream = Class.forName(ContractControtrller.class.getName()).getResourceAsStream("/template/tOUTPRODUCT.xlsx");
//
//		//2.使用创建的输入流创建一个工作簿
//		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
//
//		//查找出该日期下所有的订单
//		List<ContractProductVo> contractProductVoList = contractService.findByShipTime(getLoginCompanyId(), inputDate);
//
//		//得到工作单
//		Sheet sheet = workbook.getSheetAt(0);
//
//		//设定标题内容
//		String title = inputDate.replaceAll("-0", "年").replaceAll("-", "年") + "月份出货表";
//
//		//获取第0行
//		Row row = sheet.getRow(0);
//
//		//获取一个单元格
//		Cell cell = row.getCell(1);
//
//		//设置单元格内容
//		cell.setCellValue(title);
//
//		//提取第二行样式放到数组中
//		CellStyle[] cellStyles = new CellStyle[8];
//
//		//获取第二行
//		row = sheet.getRow(2);
//
//		//遍历数组
//		for (int i = 0; i < cellStyles.length; i++) {
//			cell = row.getCell(i + 1);
//			cellStyles[i] = cell.getCellStyle();
//		}
//
//		//定义一个遍历保存索引
//		int index = 2;
//
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//		//设置数据
//		if (null != contractProductVoList) {
//			//遍历所有货物数据
//			for (ContractProductVo contractProductVo : contractProductVoList) {
//				//每一个货物都是一行
//				row = sheet.createRow(index++);
//
//				//客户名称
//				String customName = contractProductVo.getCustomName();
//				if (null != customName){
//					cell = row.createCell(1);
//					//设置单元格样式
//					cell.setCellStyle(cellStyles[0]);
//					//设置内容
//					cell.setCellValue(customName);
//				}
//
//				//订单号
//				String contractNo = contractProductVo.getContractNo();
//				if (null != contractNo){
//					cell = row.createCell(2);
//					//设置单元格样式
//					cell.setCellStyle(cellStyles[1]);
//					//设置内容
//					cell.setCellValue(contractNo);
//				}
//
//				//货号
//				String productNo = contractProductVo.getProductNo();
//				if (null != productNo){
//					cell = row.createCell(3);
//					//设置单元格样式
//					cell.setCellStyle(cellStyles[2]);
//					//设置内容
//					cell.setCellValue(productNo);
//				}
//
//				//数量
//				Integer cnumber = contractProductVo.getCnumber();
//				if (null != cnumber){
//					cell = row.createCell(4);
//					//设置单元格样式
//					cell.setCellStyle(cellStyles[3]);
//					cell.setCellValue(cnumber);
//				}
//
//				//工厂
//				String factoryName = contractProductVo.getFactoryName();
//				if (null != factoryName){
//					cell = row.createCell(5);
//					cell.setCellStyle(cellStyles[4]);
//					cell.setCellValue(factoryName);
//				}
//
//				//工厂交期
//				Date delivertPeriod = contractProductVo.getDelivertPeriod();
//				if (null != delivertPeriod){
//					cell = row.createCell(6);
//					cell.setCellStyle(cellStyles[5]);
//					cell.setCellValue(simpleDateFormat.format(delivertPeriod));
//				}
//
//				//船期
//				Date shipTime = contractProductVo.getShipTime();
//				if (null != shipTime){
//					cell = row.createCell(7);
//					cell.setCellStyle(cellStyles[6]);
//					cell.setCellValue(simpleDateFormat.format(shipTime));
//				}
//
//				//货号
//				String tradeTerms = contractProductVo.getTradeTerms();
//				if (null != tradeTerms){
//					cell = row.createCell(8);
//					cell.setCellStyle(cellStyles[7]);
//					cell.setCellValue(tradeTerms);
//				}
//			}
//
//		}
//		//设置url编码
//		String fileName = "出货表.xlsx";
//		fileName = URLEncoder.encode(fileName, "UTF-8");
//
//		//通知浏览器以附件形式下载
//		response.setHeader("content-disposition","attachment;filename="+fileName);
//
//		//获取文件输出流
//		ServletOutputStream outputStream = response.getOutputStream();
//		workbook.write(outputStream);
//	}


	/**
	 * 1.返回值为void
	 * 2.也需要@ResponseBody
	 * 模拟百万数据
	 *
	 * @param inputDate
	 * @throws IOException
	 */
	@RequestMapping("/printExcel")
	@ResponseBody
	public void printExcel(String inputDate) throws IOException, ClassNotFoundException {
		//创建工作簿
		SXSSFWorkbook workbook = new SXSSFWorkbook();

		//查找出该日期下所有的订单
		List<ContractProductVo> contractProductVoList = contractService.findByShipTime(getLoginCompanyId(), inputDate);

		//创建工作单
		SXSSFSheet sheet = workbook.createSheet("出货表");

		//合并单元格
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,8));

		//设置列宽
		sheet.setColumnWidth(0,6*265);
		sheet.setColumnWidth(1,21*265);
		sheet.setColumnWidth(2,16*265);
		sheet.setColumnWidth(3,29*265);
		sheet.setColumnWidth(4,11*265);
		sheet.setColumnWidth(5,11*265);
		sheet.setColumnWidth(6,11*265);
		sheet.setColumnWidth(7,11*265);
		sheet.setColumnWidth(8,11*265);

		//设置标题的内容


		//设定标题内容
		String title = inputDate.replaceAll("-0", "年").replaceAll("-", "年") + "月份出货表";

		//获取第0行
		Row row = sheet.getRow(0);

		//获取一个单元格
		Cell cell = row.getCell(1);

		//设置单元格内容
		cell.setCellValue(title);

		//提取第二行样式放到数组中
		CellStyle[] cellStyles = new CellStyle[8];

		//获取第二行
		row = sheet.getRow(2);

		//遍历数组
		for (int i = 0; i < cellStyles.length; i++) {
			cell = row.getCell(i + 1);
			cellStyles[i] = cell.getCellStyle();
		}

		//定义一个遍历保存索引
		int index = 2;

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		//设置数据
		if (null != contractProductVoList) {
			//遍历所有货物数据
			for (ContractProductVo contractProductVo : contractProductVoList) {
				//每一个货物都是一行
				row = sheet.createRow(index++);

				//客户名称
				String customName = contractProductVo.getCustomName();
				if (null != customName) {
					cell = row.createCell(1);
					//设置单元格样式
					cell.setCellStyle(cellStyles[0]);
					//设置内容
					cell.setCellValue(customName);
				}

				//订单号
				String contractNo = contractProductVo.getContractNo();
				if (null != contractNo) {
					cell = row.createCell(2);
					//设置单元格样式
					cell.setCellStyle(cellStyles[1]);
					//设置内容
					cell.setCellValue(contractNo);
				}

				//货号
				String productNo = contractProductVo.getProductNo();
				if (null != productNo) {
					cell = row.createCell(3);
					//设置单元格样式
					cell.setCellStyle(cellStyles[2]);
					//设置内容
					cell.setCellValue(productNo);
				}

				//数量
				Integer cnumber = contractProductVo.getCnumber();
				if (null != cnumber) {
					cell = row.createCell(4);
					//设置单元格样式
					cell.setCellStyle(cellStyles[3]);
					cell.setCellValue(cnumber);
				}

				//工厂
				String factoryName = contractProductVo.getFactoryName();
				if (null != factoryName) {
					cell = row.createCell(5);
					cell.setCellStyle(cellStyles[4]);
					cell.setCellValue(factoryName);
				}

				//工厂交期
				Date delivertPeriod = contractProductVo.getDelivertPeriod();
				if (null != delivertPeriod) {
					cell = row.createCell(6);
					cell.setCellStyle(cellStyles[5]);
					cell.setCellValue(simpleDateFormat.format(delivertPeriod));
				}

				//船期
				Date shipTime = contractProductVo.getShipTime();
				if (null != shipTime) {
					cell = row.createCell(7);
					cell.setCellStyle(cellStyles[6]);
					cell.setCellValue(simpleDateFormat.format(shipTime));
				}

				//货号
				String tradeTerms = contractProductVo.getTradeTerms();
				if (null != tradeTerms) {
					cell = row.createCell(8);
					cell.setCellStyle(cellStyles[7]);
					cell.setCellValue(tradeTerms);
				}
			}

		}
		//设置url编码
		String fileName = "出货表.xlsx";
		fileName = URLEncoder.encode(fileName, "UTF-8");

		//通知浏览器以附件形式下载
		response.setHeader("content-disposition", "attachment;filename=" + fileName);

		//获取文件输出流
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
	}
}
