package cn.itcast.service.system;

import cn.itcast.domain.system.Module;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author cbh
 * @PackageName:cn.itcast.service.company
 * @ClassName:ModuleService
 * @Description:
 * @date 2020-12-21 20:02
 */
public interface ModuleService {
	/**
	 * 查询出所有的模块
	 * @return List<Module>
	 */
	List<Module> findAll();

	/**
	 * 分页
	 * @param pageNum
	 * @param pageSize
	 * @return PageInfo<Module>
	 */
	PageInfo<Module> findByPage(Integer pageNum,Integer pageSize);

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
	Module findById(String id);

	/**
	 * 删除权限
	 * @param id
	 * @return
	 */
	Boolean delete(String id);

	/**
	 * 根据角色查找用户权限
	 * @param id
	 * @return
	 */
	List<Module> findRoleModuleByRoleId(String id);

}
