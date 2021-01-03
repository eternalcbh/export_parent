package cn.itcast.service.cargo.impl;

import cn.itcast.dao.cargo.ContractDao;
import cn.itcast.dao.cargo.ExtCproductDao;
import cn.itcast.domain.cargo.Contract;
import cn.itcast.domain.cargo.ExtCproduct;
import cn.itcast.domain.cargo.ExtCproductExample;
import cn.itcast.service.cargo.ExtCproductService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author cbh
 * @PackageName:cn.itcast.service.cargo.impl
 * @ClassName:ExtCproductServiceImpl
 * @Description:
 * @date 2020-12-28 22:51
 */
@Service
public class ExtCproductServiceImpl implements ExtCproductService {
	@Autowired
	private ExtCproductDao extcProductDao;

	@Autowired
	private ContractDao contractDao;

	/**
	 * 修改附件合同
	 *
	 * @param extcProduct
	 */
	@Override
	public void update(ExtCproduct extcProduct) {

		//1.设置修改时间
		extcProduct.setUpdateTime(new Date());

		//2.根据id查询合同
		Contract contract = contractDao.selectByPrimaryKey(extcProduct.getContractId());

		//3.查询出旧价格
		ExtCproduct oldExtCproduct = extcProductDao.selectByPrimaryKey(extcProduct.getId());

		//4.计算出合同总价
		double amount = 0;
		if (null != extcProduct.getPrice() && null != extcProduct.getCnumber()){
			amount = extcProduct.getCnumber() * extcProduct.getPrice();
			extcProduct.setAmount(amount);
		}

		//4.更新附件
		extcProductDao.updateByPrimaryKey(extcProduct);

		//5.更新订单总价
		contract.setTotalAmount(contract.getTotalAmount() - oldExtCproduct.getAmount() + amount);

		//6.修改附件
		extcProductDao.updateByPrimaryKeySelective(extcProduct);

		//7.修改合同
		contractDao.updateByPrimaryKeySelective(contract);
	}

	/**
	 * 保存附件
	 *
	 * @param extcProduct
	 */
	@Override
	public void save(ExtCproduct extcProduct) {
		//设置id
		extcProduct.setId(UUID.randomUUID().toString());
		extcProduct.setCreateTime(new Date());
		extcProduct.setUpdateTime(new Date());

		//1.根据附件查出购销合同
		Contract contract = contractDao.selectByPrimaryKey(extcProduct.getContractId());

		//2.计算附件总价
		double amount = 0;

		if (null != extcProduct.getCnumber() && null != extcProduct.getPrice()){
			amount = extcProduct.getCnumber() * extcProduct.getPrice().doubleValue();
			extcProduct.setAmount(amount);
		}

		//3.设置订单总价
		contract.setTotalAmount(contract.getTotalAmount() + amount);

		//4.添加订单种类
		if (null != contract.getExtNum()){
			contract.setExtNum(contract.getProNum() + 1);
		}else {
			contract.setExtNum(1);
		}

		//插入附件
		extcProductDao.insertSelective(extcProduct);

		//修改订单合同
		contractDao.updateByPrimaryKeySelective(contract);
	}

	/**
	 * 根据id查询附件
	 *
	 * @param id
	 * @return
	 */
	@Override
	public ExtCproduct findById(String id) {
		return extcProductDao.selectByPrimaryKey(id);
	}

	/**
	 * 分页查询
	 *
	 * @param extCproductExample
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@Override
	public PageInfo<ExtCproduct> findByPage(ExtCproductExample extCproductExample, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);

		List<ExtCproduct> extcProductList = extcProductDao.selectByExample(extCproductExample);

		return new PageInfo<>(extcProductList);
	}

	/**
	 * 附件删除
	 *
	 * @param id
	 */
	@Override
	public void delete(String id) {
		//1.根据id查找出附件
		ExtCproduct extCproduct = extcProductDao.selectByPrimaryKey(id);

		//2查找出订单
		Contract contract = contractDao.selectByPrimaryKey(extCproduct.getContractId());

		//3.删除附件
		extcProductDao.deleteByPrimaryKey(id);

		//4.计算新的订单总价
		contract.setTotalAmount(contract.getTotalAmount() - extCproduct.getAmount());

		//5.更新购销合同中附件种类
		contract.setExtNum(contract.getExtNum() - 1);

		//6.更新订单合同
		contractDao.updateByPrimaryKeySelective(contract);
	}

	/**
	 * 查询所有
	 *
	 * @param extcProductExample
	 * @return
	 */
	@Override
	public List<ExtCproduct> findAll(ExtCproductExample extcProductExample) {
		return extcProductDao.selectByExample(extcProductExample);
	}
}
