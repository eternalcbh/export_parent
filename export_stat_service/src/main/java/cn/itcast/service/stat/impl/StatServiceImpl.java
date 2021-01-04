package cn.itcast.service.stat.impl;

import cn.itcast.dao.stat.StatDao;
import cn.itcast.service.stat.StatService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author cbh
 * @PackageName:cn.itcast.service.stat.impl
 * @ClassName:StatServiceImpl
 * @Description:
 * @date 2021-01-04 8:59
 */
@Service
public class StatServiceImpl implements StatService {

	@Autowired
	private StatDao statDao;
	/**
	 * 获取商家销售数据
	 *
	 * @param companyId
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getFactoryData(String companyId) {
		return statDao.getFactoryData(companyId);
	}
}
