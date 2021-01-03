package cn.itcast.service.cargo.impl;

import cn.itcast.dao.cargo.*;
import cn.itcast.domain.cargo.*;
import cn.itcast.service.cargo.ExportService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @author cbh
 * @PackageName:cn.itcast.service.cargo.impl
 * @ClassName:ExportService
 * @Description:
 * @date 2021-01-02 22:21
 */
@Service
public class ExportServiceImpl implements ExportService {

	@Autowired
	private ExportDao exportDao;

	@Autowired
	private ExportProductDao exportProductDao;

	@Autowired
	private ContractProductDao contractProductDao;

	@Autowired
	private ExtCproductDao extCproductDao;

	@Autowired
	private ContractDao contractDao;

	@Autowired
	private ExtEproductDao extEproductDao;

	/**
	 * 根据报运id查找报运单
	 *
	 * @param id
	 * @return
	 */
	@Override
	public Export findById(String id) {
		ExportExample exportExample = new ExportExample();
		return exportDao.selectByPrimaryKey(id);
	}

	/**
	 * 修改报运单
	 *
	 * @param export
	 */
	@Override
	public void update(Export export) {
		//设置修改时间
		export.setUpdateTime(new Date());

		exportDao.updateByPrimaryKeySelective(export);

		//更新报运的商品信息
		List<ExportProduct> exportProducts = export.getExportProducts();
		if (null != exportProducts){
			for (ExportProduct exportProduct : exportProducts) {
				exportProductDao.updateByPrimaryKeySelective(exportProduct);
			}
		}
	}

	/**
	 * 保存报运单
	 *
	 * @param export
	 */
	@Override
	public void save(Export export) {
		//设置制单日期
		export.setInputDate(new Date());

		//根据购销合同找到所有id
		String[] contractIds = export.getContractIds().split(",");

		//存储合同号
		String contractNos = "";

		//总货件种类
		double totalProNum = 0;

		//总附件总类
		double totalExtNum = 0;

		ContractExample contractExample = new ContractExample();
		contractExample.createCriteria().andIdIn(Arrays.asList(contractIds));

		//找出该报运单下所有的合同
		List<Contract> contractList = contractDao.selectByExample(contractExample);

		for (Contract contract : contractList) {
			//把状态转为生成报运合同
			contract.setState(2);

			//修改数据
			contractDao.updateByPrimaryKeySelective(contract);

			//保存合同号
			contractNos += contract.getContractNo() + " ";

			//总货件总类
			totalProNum += contract.getProNum();

			//总附件总数
			totalExtNum += contract.getExtNum();
		}

		//设置合同号
		export.setCustomerContract(contractNos);

		//修改合同状态
		export.setState(0);

		//设置货物数量
		export.setProNum((int) totalProNum);

		//设置附件数量
		export.setExtNum((int) totalExtNum);

		//设置创建时间
		export.setCreateTime(new Date());

		//设置修改时间
		export.setUpdateTime(new Date());

		//设置id
		export.setId(UUID.randomUUID().toString());

		//插入报运单
		exportDao.insertSelective(export);

		Map<String, String> map = new HashMap<>();

		//找出该报运单下所有的订单
		ContractProductExample contractProductExample = new ContractProductExample();
		contractProductExample.createCriteria().andContractIdIn(Arrays.asList(contractIds));

		List<ContractProduct> contractProductList = contractProductDao.selectByExample(contractProductExample);

		if (null != contractProductList) {
			//将货物列表存入
			for (ContractProduct contractProduct : contractProductList) {
				//报运单下的
				ExportProduct exportProduct = new ExportProduct();

				//复制属性
				BeanUtils.copyProperties(contractProduct, exportProduct);

				//复制id
				exportProduct.setId(UUID.randomUUID().toString());

				//设置该商品的报运单
				exportProduct.setExportId(export.getId());

				//添加商品
				exportProductDao.insert(exportProduct);

				//将键值对存入
				map.put(contractProduct.getId(), exportProduct.getId());
			}
		}

		//找出该报运单下的附件
		ExtCproductExample extCproductExample = new ExtCproductExample();
		extCproductExample.createCriteria().andContractIdIn(Arrays.asList(contractIds));

		extCproductExample.createCriteria().andContractIdIn(Arrays.asList(contractIds));

		List<ExtCproduct> extCproductList = extCproductDao.selectByExample(extCproductExample);

		if (extCproductList.size() != 0) {
			for (ExtCproduct extCproduct : extCproductList) {
				//报运单下的附件属性
				ExtEproduct extEproduct = new ExtEproduct();

				//复制属性
				BeanUtils.copyProperties(extCproduct, extEproduct);

				//设置id
				extEproduct.setId(UUID.randomUUID().toString());

				//设置附件所属的报运单
				extEproduct.setExportId(export.getId());

				//设置附件所属的报运商品
				extEproduct.setExportProductId(map.get(extCproduct.getContractProductId()));

				//插入数据
				extEproductDao.insertSelective(extEproduct);
			}
		}
	}

	/**
	 * 删除报运单
	 *
	 * @param id
	 */
	@Override
	public void delete(String id) {

	}

	/**
	 * 分页查找报运单
	 *
	 * @param exportExample
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@Override
	public PageInfo<Export> findByPage(ExportExample exportExample, int pageNum, int pageSize) {
		//查找报运单
		PageHelper.startPage(pageNum, pageSize);

		List<Export> exportList = exportDao.selectByExample(exportExample);

		return new PageInfo<>(exportList);
	}
}
