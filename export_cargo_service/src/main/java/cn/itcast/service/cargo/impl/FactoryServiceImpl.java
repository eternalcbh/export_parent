package cn.itcast.service.cargo.impl;

import cn.itcast.dao.cargo.FactoryDao;
import cn.itcast.domain.cargo.Factory;
import cn.itcast.domain.cargo.FactoryExample;
import cn.itcast.service.cargo.FactoryService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author cbh
 * @PackageName:cn.itcast.service.cargo.impl
 * @ClassName:FactoryServiceImpl
 * @Description:
 * @date 2020-12-31 16:24
 */
@Service
public class FactoryServiceImpl implements FactoryService {

	@Autowired
	private FactoryDao factoryDao;
	/**
	 * 分页查找
	 *
	 * @param factoryExample
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@Override
	public PageInfo<Factory> findByPage(FactoryExample factoryExample, Integer pageNum, Integer pageSize) {
		return null;
	}

	/**
	 * 根据id查找
	 *
	 * @param id
	 * @return
	 */
	@Override
	public Factory findById(String id) {
		return null;
	}

	/**
	 * 查询所有
	 *
	 * @param factoryExample
	 * @return
	 */
	@Override
	public List<Factory> findAll(FactoryExample factoryExample) {
		return factoryDao.selectByExample(factoryExample);
	}

	/**
	 * 根据id删除
	 *
	 * @param id
	 */
	@Override
	public void delete(String id) {

	}

	/**
	 * 保存
	 *
	 * @param factory
	 */
	@Override
	public void save(Factory factory) {

	}

	/**
	 * 修改
	 *
	 * @param factory
	 */
	@Override
	public void update(Factory factory) {

	}
}
