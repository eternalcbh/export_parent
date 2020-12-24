package cn.itcast.dao.system;

import cn.itcast.domain.system.SysLog;

import java.util.List;

/**
 * @author cbh
 * @PackageName:cn.itcast.dao.log
 * @ClassName:SysLogDao
 * @Description:
 * @date 2020-12-24 23:46
 */
public interface SysLogDao {
	/**
	 * 查找所有日志
	 * @param companyId
	 * @return
	 */
	List<SysLog> findAll(String companyId);

	/**
	 * 保存日志
	 * @param sysLog
	 */
	void save(SysLog sysLog);
}
