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
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
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

	/**
	 * 1.返回值为void
	 * 2.也需要@ResponseBody
	 * @param inputDate
	 * @throws IOException
	 */
	@RequestMapping("/printExcel")
	@ResponseBody
	public void printExcel(String inputDate) throws IOException {
		//查找出该日期下所有的订单
		List<ContractProductVo> contractProductVoList = contractService.findByShipTime(getLoginCompanyId(), inputDate);

		//创建工作空间
		Workbook workbook = new XSSFWorkbook();

		//创建工作单
		Sheet sheet = workbook.createSheet("出货表");

		//合并单元格
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 8));

		//设置列宽
		sheet.setColumnWidth(0, 6 * 256);
		sheet.setColumnWidth(1, 21 * 256);
		sheet.setColumnWidth(2, 16 * 256);
		sheet.setColumnWidth(3, 29 * 256);
		sheet.setColumnWidth(4, 11 * 256);
		sheet.setColumnWidth(5, 11 * 256);
		sheet.setColumnWidth(6, 11 * 256);
		sheet.setColumnWidth(7, 11 * 256);
		sheet.setColumnWidth(8, 11 * 256);
		sheet.setColumnWidth(9, 11 * 256);

		//设置标题
		String title = inputDate.replace("-0", "年").replace("-", "年") + "月份出货表";
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(1);

		//设置单元格样式
		cell.setCellStyle(bigTitle(workbook));

		//设置内容
		cell.setCellValue(title);

		//表头部分
		String[] titles = {"客户", "订单号", "货号", "数量", "工厂", "工厂交期", "船期", "贸易条款"};

		for (int i = 0; i < titles.length; i++) {
			//创建单元格
			cell = row.createCell(i + 1);

			//设置样式
			cell.setCellStyle(title(workbook));

			//设置内容
			cell.setCellValue(titles[i]);
		}

		//记录第几行的索引
		int index = 2;

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		if (null != contractProductVoList) {
			//遍历所有货物数据
			for (ContractProductVo contractProductVo : contractProductVoList) {
				//每一个货物都是一行
				row = sheet.createRow(index++);

				//客户名称
				String customName = contractProductVo.getCustomName();
				if (null != customName){
					cell = row.createCell(1);
					//设置单元格样式
					cell.setCellStyle(text(workbook));
					//设置内容
					cell.setCellValue(customName);
				}

				//订单号
				String contractNo = contractProductVo.getContractNo();
				if (null != contractNo){
					cell = row.createCell(2);
					//设置单元格样式
					cell.setCellStyle(text(workbook));
					//设置内容
					cell.setCellValue(contractNo);
				}

				//货号
				String productNo = contractProductVo.getProductNo();
				if (null != productNo){
					cell = row.createCell(3);
					//设置单元格样式
					cell.setCellStyle(text(workbook));
					//设置内容
					cell.setCellValue(productNo);
				}

				//数量
				Integer cnumber = contractProductVo.getCnumber();
				if (null != cnumber){
					cell = row.createCell(4);
					//设置单元格样式
					cell.setCellStyle(text(workbook));
					cell.setCellValue(cnumber);
				}

				//工厂
				String factoryName = contractProductVo.getFactoryName();
				if (null != factoryName){
					cell = row.createCell(5);
					cell.setCellStyle(text(workbook));
					cell.setCellValue(factoryName);
				}

				//工厂交期
				Date delivertPeriod = contractProductVo.getDelivertPeriod();
				if (null != delivertPeriod){
					cell = row.createCell(6);
					cell.setCellStyle(text(workbook));
					cell.setCellValue(simpleDateFormat.format(delivertPeriod));
				}

				//船期
				Date shipTime = contractProductVo.getShipTime();
				if (null != shipTime){
					cell = row.createCell(7);
					cell.setCellStyle(text(workbook));
					cell.setCellValue(simpleDateFormat.format(shipTime));
				}

				//货号
				String tradeTerms = contractProductVo.getTradeTerms();
				if (null != tradeTerms){
					cell = row.createCell(8);
					cell.setCellStyle(text(workbook));
					cell.setCellValue(tradeTerms);
				}
			}

		}

		//设置url编码
		String fileName = "出货表.xlsx";
		fileName = URLEncoder.encode(fileName, "UTF-8");

		//通知浏览器以附件形式下载
		response.setHeader("content-disposition","attachment;filename="+fileName);

		//获取文件输出流
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
	}

	/**
	 * 大标题样式
	 *
	 * @param wb
	 * @return
	 */
	public CellStyle bigTitle(Workbook wb) {
		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
		font.setFontName("宋体");
		font.setFontHeightInPoints((short) 16);
		//字体加粗
		font.setBold(true);
		style.setFont(font);
		//横向居中
		style.setAlignment(HorizontalAlignment.CENTER);
		//纵向居中
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		return style;
	}

	/**
	 * 小标题的样式
	 *
	 * @param wb
	 * @return
	 */
	public CellStyle title(Workbook wb) {
		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
		font.setFontName("黑体");
		font.setFontHeightInPoints((short) 12);
		style.setFont(font);
		//横向居中
		style.setAlignment(HorizontalAlignment.CENTER);
		//纵向居中
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		//上细线
		style.setBorderTop(BorderStyle.THIN);
		//下细线
		style.setBorderBottom(BorderStyle.THIN);
		//左细线
		style.setBorderLeft(BorderStyle.THIN);
		//右细线
		style.setBorderRight(BorderStyle.THIN);
		return style;
	}

	/**
	 * 文字样式
	 *
	 * @param wb
	 * @return
	 */
	public CellStyle text(Workbook wb) {
		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
		font.setFontName("Times New Roman");
		font.setFontHeightInPoints((short) 10);

		style.setFont(font);
		//横向居左
		style.setAlignment(HorizontalAlignment.LEFT);
		//纵向居中
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		//上细线
		style.setBorderTop(BorderStyle.THIN);
		//下细线
		style.setBorderBottom(BorderStyle.THIN);
		//左细线
		style.setBorderLeft(BorderStyle.THIN);
		//右细线
		style.setBorderRight(BorderStyle.THIN);

		return style;
	}
}
