package cn.itcast.service.cargo.impl;

import cn.itcast.dao.cargo.ContractProductDao;
import cn.itcast.domain.cargo.Contract;
import cn.itcast.domain.cargo.ContractExample;
import cn.itcast.domain.cargo.ContractProduct;
import cn.itcast.domain.cargo.ContractProductExample;
import cn.itcast.service.cargo.ContractProductService;
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
 * @ClassName:ContractProductServiceImpl
 * @Description:
 * @date 2020-12-28 21:54
 */
@Service
public class ContractProductServiceImpl implements ContractProductService {
	@Autowired
	private ContractProductDao contractProductProductDao;

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
		PageHelper.startPage(pageNum,pageSize);

		List<ContractProduct> contractProductList = contractProductProductDao.selectByExample(contractProductExample);

		return new PageInfo<>(contractProductList);
	}

	/**
	 * 修改订单合同
	 *
	 * @param contractProduct
	 */
	@Override
	public void update(ContractProduct contractProduct) {
		contractProductProductDao.updateByPrimaryKeySelective(contractProduct);
	}

	/**
	 * 保存订单
	 *
	 * @param contractProduct
	 */
	@Override
	public void save(ContractProduct contractProduct) {
		//设置id
		contractProduct.setId(UUID.randomUUID().toString());

		contractProductProductDao.insertSelective(contractProduct);
	}

	/**
	 * 根据id查询订单
	 *
	 * @param id
	 * @return
	 */
	@Override
	public ContractProduct findById(String id) {
		return contractProductProductDao.selectByPrimaryKey(id);
	}

	/**
	 * 订单删除
	 *
	 * @param id
	 */
	@Override
	public void delete(String id) {
		contractProductProductDao.deleteByPrimaryKey(id);
	}

	/**
	 * 查询所有
	 *
	 * @param contractProductExample
	 * @return
	 */
	@Override
	public List<ContractProduct> findAll(ContractProductExample contractProductExample) {
		return contractProductProductDao.selectByExample(contractProductExample);
	}

}
