package cn.itcast.service.system.impl;

import cn.itcast.dao.system.ModuleDao;
import cn.itcast.domain.system.Module;
import cn.itcast.domain.system.User;
import cn.itcast.service.system.ModuleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author cbh
 * @PackageName:cn.itcast.service.company.impl
 * @ClassName:ModuleServiceImpl
 * @Description:
 * @date 2020-12-21 20:02
 */
@Service
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	ModuleDao moduleDao;

	@Override
	public List<Module> findAll() {
		return moduleDao.findAll();
	}

	/**
	 * 分页
	 */
	@Override
	public PageInfo<Module> findByPage(Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		List<Module> moduleList = moduleDao.findAll();
		return new PageInfo<>(moduleList);
	}

	@Override
	public void add(Module module) {
		module.setId(UUID.randomUUID().toString());
		moduleDao.add(module);
	}

	@Override
	public void update(Module module) {
		moduleDao.update(module);
	}

	@Override
	public Module findById(String id) {
		return moduleDao.findById(id);
	}

	@Override
	public Boolean delete(String id) {
		Integer number = moduleDao.findModuleByRole(id);
		if (number == 0){
			moduleDao.delete(id);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Module> findRoleModuleByRoleId(String id) {
		return moduleDao.findRoleModuleByRoleId(id);
	}

	@Override
	public List<Module> findModuleByUser(User user) {
		//获取用户等级
		Integer degree = user.getDegree();
		List<Module> moduleList = null;

		//判断用户等级
		if (degree == 0 || degree == 1){
			moduleList = moduleDao.findModuelByDegree(user.getDegree());
		}else {
			moduleList = moduleDao.findModuleByUser(user.getId());
		}
		return moduleList;
	}

}
