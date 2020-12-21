package cn.itcast.service.system;

import cn.itcast.domain.system.Role;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author cbh
 */
public interface RoleService {
	/**
	 * 查询所有的角色对象
	 * @return
	 */
	List<Role> findAll(String companyId);

	/**
	 * 分页查询所有的角色对象
	 * @param pageNum
	 * @param pageSize
	 * @param companyId
	 * @return
	 */
	PageInfo<Role> findByPage(int pageNum, int pageSize, String companyId);

	/**
	 * 根据id查找角色
	 * @param role
	 */
	void update(Role role);

	/**
	 * 根据id查找角色
	 * @param id
	 * @return
	 */
	Role findById(String id);

	/**
	 * 添加用户
	 * @param role
	 */
	void insert(Role role);

	/**
	 * 删除角色
	 * @param id
	 * @return
	 */
	boolean delete(String id);
}
