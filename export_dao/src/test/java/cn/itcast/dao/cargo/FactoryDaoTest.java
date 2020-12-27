package cn.itcast.dao.cargo;

import cn.itcast.domain.cargo.Factory;
import cn.itcast.domain.cargo.FactoryExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-dao.xml")
public class FactoryDaoTest {

	@Autowired
	private FactoryDao factoryDao;

	@Test
	public void deleteByPrimaryKey() {
		factoryDao.deleteByPrimaryKey("1");
	}

	@Test
	public void insert() {
	}

	@Test
	public void insertSelective() {
//		factoryDao.insertSelective();
	}

	/**
	 * 模糊搜索
	 */
	@Test
	public void selectByExample() {
		// 1. 构造条件对象
		FactoryExample example = new FactoryExample();
//		// 2. 添加条件
//		FactoryExample.Criteria criteria = example.createCriteria();
//		criteria.andFactoryNameEqualTo("草原三剑客");
//		criteria.andFullNameLike("%绿色%");

		List<Factory> factoryList = factoryDao.selectByExample(example);
		System.out.println(factoryList);
	}

	//findById
	@Test
	public void selectByPrimaryKey() {
		Factory factory = factoryDao.selectByPrimaryKey("15");
		System.out.println(factory.getAddress());
	}


	//有选择的更新
	@Test
	public void updateByPrimaryKeySelective() {
		Factory factory = new Factory();
		factory.setId("726619a1-777e-47a2-9bed-cb08431c867e");
		factory.setCtype("test...");
		factory.setAddress("草原倒立");
		factoryDao.updateByPrimaryKeySelective(factory);
	}

	//updateById(全字段更新)
	@Test
	public void updateByPrimaryKey() {
		Factory factory = new Factory();
		factory.setId("726619a1-777e-47a2-9bed-cb08431c867e");
		factory.setCtype("test 货物...");
		// Column 'create_time' cannot be null
		factory.setCreateTime(new Date());
		// Column 'update_time' cannot be null
		factory.setUpdateTime(new Date());

		factoryDao.updateByPrimaryKey(factory);
	}
}