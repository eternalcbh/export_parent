package cn.itcast.web.handler;

import cn.itcast.domain.cargo.Contract;
import cn.itcast.domain.cargo.ContractExample;
import cn.itcast.domain.system.User;
import cn.itcast.service.cargo.ContractService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

/**
 * @author cbh
 * @PackageName:cn.itcast.web.handler
 * @ClassName:AdminHandler
 * @Description:
 * @date 2021-01-01 19:37
 */
@Component
public class AdminHandler implements Handler {

	@Override
	public void afterPropertiesSet() throws Exception {
		Factory.register(1, this);
	}

	/**
	 * 策略
	 * 企业管理者订单
	 * @param contractService
	 * @param contractExample
	 * @param pageNum
	 * @param pageSize
	 * @param loginUser
	 * @param companyId
	 * @return
	 */
	@Override
	public PageInfo<Contract> strategy(ContractService contractService, ContractExample contractExample, Integer pageNum, Integer pageSize, User loginUser, String companyId) {

		//1.条件
		contractExample.createCriteria().andCompanyIdEqualTo(companyId);

		//2.返回查找结果
		return contractService.findByPage(contractExample, pageNum, pageSize);
	}
}
