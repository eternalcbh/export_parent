package cn.itcast.service.cargo;

import cn.itcast.domain.cargo.Factory;
import cn.itcast.domain.cargo.FactoryExample;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author cbh
 * @PackageName:cn.itcast.service.cargo
 * @ClassName:FactoryService
 * @Description:工厂业务层
 * @date 2020-12-28 20:23
 */
public interface FactoryService {
	/**
	 * 分页查找
	 * @param factoryExample
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageInfo<Factory> findByPage(FactoryExample factoryExample, Integer pageNum, Integer pageSize);

	/**
	 * 根据id查找
	 * @param id
	 * @return
	 */
	Factory findById(String id);

	/**
	 * 查询所有
	 * @param factoryExample
	 * @return
	 */
	List<Factory> findAll(FactoryExample factoryExample);

	/**
	 * 根据id删除
	 * @param id
	 */
	void delete(String id);

	/**
	 * 保存
	 * @param factory
	 */
	void save(Factory factory);

	/**
	 * 修改
	 * @param factory
	 */
	void update(Factory factory);
}
