package cn.itcast.service.system.impl;

import cn.itcast.dao.system.RoleDao;
import cn.itcast.domain.system.Role;
import cn.itcast.service.system.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author cbh
 * @PackageName:cn.itcast.service.system.impl
 * @ClassName:RoleServiceImpl
 * @Description:
 * @date 2020-12-20 22:57
 */
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleDao roleDao;

	@Override
	public List<Role> findAll(String companyId) {
		return roleDao.findAll(companyId);
	}

	@Override
	public PageInfo<Role> findByPage(int pageNum, int pageSize, String companyId) {
		PageHelper.startPage(pageNum,pageSize,companyId);
		List<Role> roleList = roleDao.findAll(companyId);
		return new PageInfo<>(roleList);
	}

	@Override
	public void update(Role role) {
		roleDao.update(role);
	}

	@Override
	public Role findById(String id) {
		return roleDao.findById(id);
	}

	/**
	 * 添加用户
	 *
	 * @param role
	 */
	@Override
	public void insert(Role role) {
		role.setId(UUID.randomUUID().toString());
		roleDao.insert(role);
	}

	@Override
	public boolean delete(String id) {
		Integer roleByUserId = roleDao.findRoleByUserId(id);
		Integer roleByModuleId = roleDao.findRoleByModuleId(id);
		boolean flag;
		if (roleByUserId == 0 && roleByModuleId == 0){
			roleDao.delete(id);
			flag = true;
		}else {
			flag = false;
		}
		return flag;
	}

	@Override
	public void updateRoleModule(String roleid, String[] moduleIds) {
		//1.删除角色权限
		roleDao.deleRoleModule(roleid);
		if (moduleIds.length != 0){
			//2.添加角色权限
			roleDao.add(roleid,moduleIds);
		}
	}

	@Override
	public List<Role> findRoleByUid(String id) {
		return roleDao.findRoleByUid(id);
	}
}
