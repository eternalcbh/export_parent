package cn.itcast.service.system.impl;

import cn.itcast.dao.system.SysLogDao;
import cn.itcast.domain.system.Dept;
import cn.itcast.domain.system.Module;
import cn.itcast.domain.system.SysLog;
import cn.itcast.service.system.SysLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

/**
 * @author cbh
 * @PackageName:cn.itcast.service.system.impl
 * @ClassName:SysLogServiceImpl
 * @Description:
 * @date 2020-12-24 23:55
 */
public class SysLogServiceImpl implements SysLogService {

	/**
	 * 注入日志持久层
	 */
	@Autowired
	private SysLogDao sysLogDao;
	/**
	 * 根据id查询公司日志
	 *
	 * @param companyId
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@Override
	public PageInfo<SysLog> findByPage(String companyId, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		List<SysLog> sysLogList = sysLogDao.findAll(companyId);
		return new PageInfo<>(sysLogList);
	}

	/**
	 * 保存日志
	 *
	 * @param sysLog
	 */
	@Override
	public void save(SysLog sysLog) {
		sysLog.setId(UUID.randomUUID().toString());
		sysLogDao.save(sysLog);
	}
}
