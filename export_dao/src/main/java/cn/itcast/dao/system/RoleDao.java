package cn.itcast.dao.system;

import cn.itcast.domain.system.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cbh
 */
public interface RoleDao {
	/**
	 * 根据公司id查找出角色
	 * @param companyId
	 * @return
	 */
	List<Role> findAll(@Param("companyId") String companyId);

	/**
	 * 修改用户
	 * @param role
	 */
	void update(Role role);

	/**
	 * 根据id来查找,回显数据
	 * @param id
	 * @return
	 */
	Role findById(@Param("id") String id);

	/**
	 * 添加角色
	 * @param role
	 */
	void insert(Role role);

	/**
	 * 根据rolei_id查找是否被引用
	 * @param id
	 * @return Integer
	 */
	Integer findRoleByUserId(@Param("id") String id);

	/**
	 * 根据id删除用户
	 */
	void delete(@Param("id") String id);
}
