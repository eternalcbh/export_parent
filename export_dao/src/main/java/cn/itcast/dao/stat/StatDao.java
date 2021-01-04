package cn.itcast.dao.stat;

import java.util.List;
import java.util.Map;

/**
 * @author cbh
 * @PackageName:cn.itcast.dao.stat
 * @ClassName:StatDao
 * @Description:
 * @date 2021-01-03 23:42
 */
public interface StatDao {
	/**
	 * 获取生成厂家的销售额
	 * @param companyId
	 * @return
	 */
	List<Map<String, Object>> getFactoryData(String companyId);
}
