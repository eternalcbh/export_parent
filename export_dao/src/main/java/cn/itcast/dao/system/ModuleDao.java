package cn.itcast.dao.system;

import cn.itcast.domain.system.Module;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;

import java.util.List;

/**
 * @author cbh
 * @PackageName:cn.itcast.dao.company
 * @ClassName:ModuleDao
 * @Description:
 * @date 2020-12-21 19:58
 */
public interface ModuleDao {
	/**
	 * 查询出所有的模块
	 * @return
	 */
	List<Module> findAll();

	/**
	 * 添加模块
	 * @param module
	 */
	void add(Module module);

	/**
	 * 修改模块
	 * @param module
	 */
	void update(Module module);

	/**
	 * 根据id回显数据
	 * @param id
	 * @return
	 */
	Module findById(@Param("id") String id);

	/**
	 * 删除权限
	 * @param id
	 */
	void delete(String id);

	/**
	 * 根据权限查找是否有依赖的对象
	 * @param id
	 * @return
	 */
	Integer findModuleByRole(@Param("id") String id);
}