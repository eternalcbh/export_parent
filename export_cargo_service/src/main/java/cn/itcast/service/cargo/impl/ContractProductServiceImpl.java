package cn.itcast.service.cargo.impl;

import cn.itcast.dao.cargo.ContractDao;
import cn.itcast.dao.cargo.ContractProductDao;
import cn.itcast.dao.cargo.ExtCproductDao;
import cn.itcast.domain.cargo.*;
import cn.itcast.service.cargo.ContractProductService;
import cn.itcast.service.cargo.ExtCproductService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author cbh
 * @PackageName:cn.itcast.service.cargo.impl
 * @ClassName:ContractProductServiceImpl
 * @Description:
 * @date 2020-12-28 21:54
 */
@Service
public class ContractProductServiceImpl implements ContractProductService {
	@Autowired
	private ContractProductDao contractProductDao;

	@Autowired
	private ContractDao contractDao;

	@Autowired
	private ExtCproductDao extCproductDao;

	/**
	 * 分页查询订单
	 *
	 * @param contractProductExample
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@Override
	public PageInfo<ContractProduct> findByPage(ContractProductExample contractProductExample, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		List<ContractProduct> contractProductList = contractProductDao.selectByExample(contractProductExample);

		return new PageInfo<>(contractProductList);
	}

	/**
	 * 修改订单合同
	 *
	 * @param contractProduct
	 */
	@Override
	public void update(ContractProduct contractProduct) {

		//1.获取出订单
		Contract contract = contractDao.selectByPrimaryKey(contractProduct.getContractId());

		//2.设置总价
		double amount = 0;

		//3.查找出旧商品的价格
		ContractProduct oldContractProduct = contractProductDao.selectByPrimaryKey(contractProduct.getId());

		//4.旧总价
		double oldamount = oldContractProduct.getCnumber() * oldContractProduct.getPrice().doubleValue();

		//5.修改订单价格
		if (contractProduct.getPrice() != null && contractProduct.getCnumber() != null){
			//3.计算出货品修改后的总价
			amount = contractProduct.getPrice().doubleValue() * contractProduct.getCnumber();

			contractProduct.setAmount(new BigDecimal(amount));

			contract.setTotalAmount(new BigDecimal(contract.getTotalAmount().doubleValue() + amount - oldamount));
		}

		//6.修改货品
		contractProductDao.updateByPrimaryKeySelective(contractProduct);

		//7.修改订单
		contractDao.updateByPrimaryKeySelective(contract);
	}

	/**
	 * 新增货物
	 *
	 * @param contractProduct
	 */
	@Override
	public void save(ContractProduct contractProduct) {
		//设置id
		contractProduct.setId(UUID.randomUUID().toString());

		//设置修改时间和创建时间
		contractProduct.setCreateTime(new Date());
		contractProduct.setUpdateTime(new Date());

		//获取合同id
		String contractId = contractProduct.getContractId();

		//找到合同
		Contract contract = contractDao.selectByPrimaryKey(contractId);

		double amount = 0;

		if (null != contractProduct.getCnumber() && null != contractProduct.getPrice()) {
			//获取货物总价
			amount = contractProduct.getPrice().doubleValue() * contractProduct.getCnumber();
			contractProduct.setAmount(new BigDecimal(amount));
		}

		//插入货物
		contractProductDao.insertSelective(contractProduct);

		//获取合同价格

		if (null != contract.getTotalAmount()){
			//如果不是第一次添加合同
			contract.setTotalAmount(new BigDecimal(contract.getTotalAmount().doubleValue() + amount));
		}else {
			//第一次添加合同
			contract.setTotalAmount(new BigDecimal(amount));
		}

		//修改货物数量
		if (null != contract.getProNum()){
			contract.setProNum(contract.getProNum() + 1);
		}else {
			contract.setProNum(1);
		}

		//修改合同
		contractDao.updateByPrimaryKeySelective(contract);
	}

	/**
	 * 根据id查询订单
	 *
	 * @param id
	 * @return
	 */
	@Override
	public ContractProduct findById(String id) {
		return contractProductDao.selectByPrimaryKey(id);
	}

	/**
	 * 订单删除
	 *
	 * @param id
	 */
	@Override
	public void delete(String id) {
		//获取删除的货物
		//1.获取出要被删除的货物
		ContractProduct contractProduct = contractProductDao.selectByPrimaryKey(id);

		//2.计算出要被删除货物的总价
		double amount = contractProduct.getAmount().doubleValue();

		//2.1删除货物所有的附件
		ExtCproductExample extCproductExample = new ExtCproductExample();
		extCproductExample.createCriteria().andContractProductIdEqualTo(id);


		List<ExtCproduct> extCproductList = extCproductDao.selectByExample(extCproductExample);

		//2.2遍历附件
		//设置附件总价
		double totalExtAmount = 0;
		if (null != extCproductList){
			for (ExtCproduct extCproduct : extCproductList) {
				extCproductDao.deleteByPrimaryKey(extCproduct.getId());
				totalExtAmount += extCproduct.getAmount().doubleValue();
			}
		}


		//3.获取出销售合同
		Contract contract = contractDao.selectByPrimaryKey(contractProduct.getContractId());

		//4.修改订单总价
		contract.setTotalAmount(new BigDecimal(contract.getTotalAmount().doubleValue() - amount - totalExtAmount));

		//5.更新货物数量
		contract.setProNum(contract.getProNum() - 1);

		//6.更新附件数量
		if (null != extCproductList){
			contract.setExtNum(contract.getExtNum() - extCproductList.size());
		}

		//7.删除货物
		contractProductDao.deleteByPrimaryKey(id);

		//8.更新订单合同
		contractDao.updateByPrimaryKeySelective(contract);
	}

	/**
	 * 查询所有
	 *
	 * @param contractProductExample
	 * @return
	 */
	@Override
	public List<ContractProduct> findAll(ContractProductExample contractProductExample) {
		return contractProductDao.selectByExample(contractProductExample);
	}

}
