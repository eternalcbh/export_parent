package cn.itcast.service.cargo.impl;

import cn.itcast.dao.cargo.ExtCproductDao;
import cn.itcast.domain.cargo.ExtCproduct;
import cn.itcast.domain.cargo.ExtCproductExample;
import cn.itcast.service.cargo.ExtCproductService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

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

	/**
	 * 分页查询订单
	 *
	 * @param extcProductExample
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */


	/**
	 * 修改订单合同
	 *
	 * @param extcProduct
	 */
	@Override
	public void update(ExtCproduct extcProduct) {
		extcProductDao.updateByPrimaryKeySelective(extcProduct);
	}

	/**
	 * 保存订单
	 *
	 * @param extcProduct
	 */
	@Override
	public void save(ExtCproduct extcProduct) {
		//设置id
		extcProduct.setId(UUID.randomUUID().toString());

		extcProductDao.insertSelective(extcProduct);
	}

	/**
	 * 根据id查询订单
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
	 * 订单删除
	 *
	 * @param id
	 */
	@Override
	public void delete(String id) {
		extcProductDao.deleteByPrimaryKey(id);
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
