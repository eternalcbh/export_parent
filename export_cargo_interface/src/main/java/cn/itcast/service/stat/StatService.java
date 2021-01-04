package cn.itcast.service.stat;

import java.util.List;
import java.util.Map;

/**
 * @author cbh
 * @PackageName:cn.itcast.service.state
 * @ClassName:StatService
 * @Description:
 * @date 2021-01-04 8:46
 */
public interface StatService {

	/**
	 * 获取商家销售数据
	 * @param companyId
	 * @return
	 */
	List<Map<String, Object>> getFactoryData(String companyId);

	/**
	 * 获取销售货品额
	 * @param companyId
	 * @return
	 */
	List<Map<String, Object>> getSellData(String companyId);

	/**
	 * 访问压力图
	 * @param companyId
	 * @return
	 */
	List<Map<String, Object>> getOnLineData(String companyId);
}
