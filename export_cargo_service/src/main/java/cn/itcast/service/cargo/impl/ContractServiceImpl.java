package cn.itcast.service.cargo.impl;

import cn.itcast.dao.cargo.ContractDao;
import cn.itcast.domain.cargo.Contract;
import cn.itcast.domain.cargo.ContractExample;
import cn.itcast.service.cargo.ContractService;
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
 * @ClassName:ContractServiceImpl
 * @Description:
 * @date 2020-12-28 21:54
 */
@Service(timeout = 100000)
public class ContractServiceImpl implements ContractService {

	@Autowired
	private ContractDao contractDao;

	/**
	 * 分页查询订单
	 *
	 * @param contractExample
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@Override
	public PageInfo<Contract> findByPage(ContractExample contractExample, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);

		List<Contract> contractList = contractDao.selectByExample(contractExample);

		return new PageInfo<>(contractList);
	}

	/**
	 * 修改订单合同
	 *
	 * @param contract
	 */
	@Override
	public void update(Contract contract) {
		contractDao.updateByPrimaryKeySelective(contract);
	}

	/**
	 * 保存订单
	 *
	 * @param contract
	 */
	@Override
	public void save(Contract contract) {
		//设置id
		contract.setId(UUID.randomUUID().toString());

		//初始化数据
		contract.setUpdateTime(new Date());

		//数据添加时间
		contract.setCreateTime(new Date());

		contractDao.insertSelective(contract);
	}

	/**
	 * 根据id查询订单
	 *
	 * @param id
	 * @return
	 */
	@Override
	public Contract findById(String id) {
		return contractDao.selectByPrimaryKey(id);
	}

	/**
	 * 订单删除
	 *
	 * @param id
	 */
	@Override
	public void delete(String id) {
		contractDao.deleteByPrimaryKey(id);
	}

	/**
	 * 查询所有
	 *
	 * @param contractExample
	 * @return
	 */
	@Override
	public List<Contract> findAll(ContractExample contractExample) {
		return contractDao.selectByExample(contractExample);
	}
}
