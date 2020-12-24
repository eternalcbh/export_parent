package cn.itcast.service.system;

import cn.itcast.domain.system.Dept;
import cn.itcast.domain.system.SysLog;
import com.github.pagehelper.PageInfo;

/**
 * @author cbh
 * @PackageName:cn.itcast.service.system
 * @ClassName:SysLogService
 * @Description:
 * @date 2020-12-24 23:52
 */
public interface SysLogService {
	/**
	 *根据id查询公司日志
	 * @param companyId
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageInfo<SysLog> findByPage(String companyId, int pageNum, int pageSize);

	/**
	 *保存日志
	 * @param sysLog
	 */
	void save(SysLog sysLog);
}
