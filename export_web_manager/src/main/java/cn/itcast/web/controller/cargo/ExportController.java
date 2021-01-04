package cn.itcast.web.controller.cargo;

import cn.itcast.domain.cargo.*;
import cn.itcast.domain.vo.ExportProductVo;
import cn.itcast.domain.vo.ExportResult;
import cn.itcast.domain.vo.ExportVo;
import cn.itcast.service.cargo.ContractService;
import cn.itcast.service.cargo.ExportProductService;
import cn.itcast.service.cargo.ExportService;
import cn.itcast.web.controller.BaseController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import java.io.InputStream;
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
	                   @RequestParam(defaultValue = "5") Integer pageSize) {
		//设置属于什么公司
		ExportExample exportExample = new ExportExample();
		exportExample.setOrderByClause("create_time desc");
		exportExample.createCriteria().andCompanyIdEqualTo(getLoginCompanyId());
		PageInfo<Export> pageInfo = exportService.findByPage(exportExample, pageNum, pageSize);
		request.setAttribute("pageInfo", pageInfo);
		return "cargo/export/export-list";
	}

	@RequestMapping("/toExport")
	public String toExport(String id) {
		Export export = exportService.findById(id);
		request.setAttribute("export", export);
		request.setAttribute("id", id);
		return "cargo/export/export-toExport";
	}

	@RequestMapping("/edit")
	public String edit(Export export) {
		//报运单创建人
		export.setCreateBy(getLoginCompanyId());
		//报运单所属于的部门
		export.setCreateDept(getLoginUser().getDeptId());
		//报运单所属企业名称和id
		export.setCompanyId(getLoginCompanyId());
		export.setCompanyName(getLoginCompanyName());

		if (StringUtils.isEmpty(export.getId())) {
			exportService.save(export);
		} else {
			exportService.update(export);
		}

		return "redirect:/cargo/export/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(String id) {
		//回显报运单数据
		Export export = exportService.findById(id);
		request.setAttribute("export", export);

		//查找出该报运单下所有的货物
		ExportProductExample exportProductExample = new ExportProductExample();
		exportProductExample.createCriteria().andExportIdEqualTo(id);
		List<ExportProduct> exportProductList = exportProductService.findAll(exportProductExample);

		request.setAttribute("eps", exportProductList);

		return "cargo/export/export-update";
	}

	@RequestMapping("/toView")
	public String toView(String id) {
		//报运单搜索对象
		Export export = exportService.findById(id);
		request.setAttribute("export", export);
		return "cargo/export/export-view";
	}

	@RequestMapping("/contractList")
	public String contractList(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {
		//创建合同搜索对象
		ContractExample contractExample = new ContractExample();

		//排序
		contractExample.setOrderByClause("create_time desc");
		contractExample.createCriteria().andStateEqualTo(1);

		PageInfo<Contract> pageInfo = contractService.findByPage(contractExample, pageNum, pageSize);

		//存到域中
		request.setAttribute("pageInfo", pageInfo);

		return "cargo/export/export-contractList";
	}

	@RequestMapping("/submit")
	public String submit(String id) {
		//根据id查询出报运单
		Export export = exportService.findById(id);

		//修改报运状态
		export.setState(1);

		//修改报运单
		exportService.update(export);

		return "redirect:/cargo/export/list";
	}

	@RequestMapping("/cancel")
	public String cancel(String id) {
		//根据id查询报运单
		Export export = exportService.findById(id);

		//修改报运状态
		export.setState(0);

		//修改报运单
		exportService.update(export);

		return "redirect:/cargo/export/list";
	}

	@RequestMapping("/exportE")
	public String exportE(String id) {

		//找到报运单
		Export export = exportService.findById(id);

		//找到报运单下的所有货物
		ExportProductExample exportProductExample = new ExportProductExample();

		exportProductExample.createCriteria().andExportIdEqualTo(id);

		List<ExportProduct> exportProductList = exportProductService.findAll(exportProductExample);

		//进行值拷贝
		ExportVo exportVo = new ExportVo();
		BeanUtils.copyProperties(export, exportVo);

		//补全id
		exportVo.setExportId(export.getId());

		//遍历set集合
		if (null != exportProductList) {
			for (ExportProduct exportProduct : exportProductList) {
				ExportProductVo exportProductVo = new ExportProductVo();
				//对货物进行值拷贝
				BeanUtils.copyProperties(exportProduct, exportProductVo);

				//补全id
				exportProductVo.setExportId(export.getId());

				exportProductVo.setExportProductId(exportProduct.getId());

				exportVo.getProducts().add(exportProductVo);
			}
		}


		//发送数据给海关平台
		WebClient.create("http://localhost:6888/ws/export/user").post(exportVo);

		//获取海关给回来的数据
		ExportResult exportResult = WebClient.create("http://localhost:6888/ws/export/user/" + id).get(ExportResult.class);

		if (null != exportResult) {
			exportService.updateState(exportResult);
		}

		return "redirect:/cargo/export/list";
	}

	@RequestMapping("/exportPdf")
	@ResponseBody
	public void exportPdf(String id) {
		//读取文件模板
		InputStream resourceAsStream = session.getServletContext().getResourceAsStream("/jasper/export.jasper");

		//2.把模板与数据填充， 拿到JasperPrint对象（数据+模板结合）
        /*
        fillReport(InputStream inputStream, Map<String, Object> parameters, JRDataSource dataSource)
                inputStream: 模板的输入流
                parameters: 需要被填充的参数，不需要被遍历的
                dataSource: 数据源，需要被遍历的数据
         */



		//3. 把pdf文件输出
        /*
            exportReportToPdfStream(JasperPrint jasperPrint, OutputStream outputStream)
                    jasperPrint： jasperprint的对象
                    outputStream: 输出的目标地址的输出流对象
         */
	}
}
