package cn.itcast.web.controller.cargo;

import cn.itcast.domain.cargo.ContractProduct;
import cn.itcast.domain.cargo.Factory;
import cn.itcast.domain.vo.ContractProductVo;
import cn.itcast.service.cargo.ContractProductService;
import cn.itcast.service.cargo.ContractService;
import cn.itcast.service.cargo.FactoryService;
import cn.itcast.web.controller.BaseController;
import com.alibaba.dubbo.config.annotation.Reference;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author cbh
 * @PackageName:cn.itcast.web.controller.cargo
 * @ClassName:OutProductController
 * @Description:
 * @date 2021-01-02 20:08
 */
@Controller
@RequestMapping("/cargo/contract")
public class OutProductController extends BaseController {

	@Reference
	private ContractService contractService;

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
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 8));

		//设置列宽
		sheet.setColumnWidth(0, 6 * 265);
		sheet.setColumnWidth(1, 21 * 265);
		sheet.setColumnWidth(2, 16 * 265);
		sheet.setColumnWidth(3, 29 * 265);
		sheet.setColumnWidth(4, 11 * 265);
		sheet.setColumnWidth(5, 11 * 265);
		sheet.setColumnWidth(6, 11 * 265);
		sheet.setColumnWidth(7, 11 * 265);
		sheet.setColumnWidth(8, 11 * 265);

		//设置表头
		String[] titles = {"客户", "订单号", "货号", "数量", "工厂", "工厂交期", "船期", "贸易条款"};

		//设定标题内容
		String title = inputDate.replaceAll("-0", "年").replaceAll("-", "年") + "月份出货表";

		//写入第一行
		Row row = sheet.createRow(0);

		//获取第一行第一个单元格
		Cell cell = row.createCell(1);

		CellStyle cellStyle = workbook.createCellStyle();
		/**
		 * 横向居中
		 */
		cellStyle.setAlignment(HorizontalAlignment.CENTER);

		/**
		 * 纵向居中
		 */
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

		cell.setCellStyle(cellStyle);

		//设置值
		cell.setCellValue(title);

		//日期格式化
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		//获取第二行
		row = sheet.createRow(1);

		for (int i = 0; i < titles.length; i++) {
			//创建单元格
			cell = row.createCell(i + 1);
			cell.setCellValue(titles[i]);
		}

		//定义一个索引
		int index = 2;

		//设置数据
		if (null != contractProductVoList) {
			for (int i = 0; i < 6000; i++) {
				//遍历所有货物数据
				for (ContractProductVo contractProductVo : contractProductVoList) {
					//每一个货物都是一行
					row = sheet.createRow(index++);

					//客户名称
					String customName = contractProductVo.getCustomName();
					if (null != customName) {
						cell = row.createCell(1);
						//设置内容
						cell.setCellValue(customName);
					}

					//订单号
					String contractNo = contractProductVo.getContractNo();
					if (null != contractNo) {
						cell = row.createCell(2);
						//设置内容
						cell.setCellValue(contractNo);
					}

					//货号
					String productNo = contractProductVo.getProductNo();
					if (null != productNo) {
						cell = row.createCell(3);
						//设置内容
						cell.setCellValue(productNo);
					}

					//数量
					Integer cnumber = contractProductVo.getCnumber();
					if (null != cnumber) {
						cell = row.createCell(4);
						cell.setCellValue(cnumber);
					}

					//工厂
					String factoryName = contractProductVo.getFactoryName();
					if (null != factoryName) {
						cell = row.createCell(5);
						cell.setCellValue(factoryName);
					}

					//工厂交期
					Date delivertPeriod = contractProductVo.getDelivertPeriod();
					if (null != delivertPeriod) {
						cell = row.createCell(6);
						cell.setCellValue(simpleDateFormat.format(delivertPeriod));
					}

					//船期
					Date shipTime = contractProductVo.getShipTime();
					if (null != shipTime) {
						cell = row.createCell(7);
						cell.setCellValue(simpleDateFormat.format(shipTime));
					}

					//货号
					String tradeTerms = contractProductVo.getTradeTerms();
					if (null != tradeTerms) {
						cell = row.createCell(8);
						cell.setCellValue(tradeTerms);
					}
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
}
