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
 * @ClassName:StaffHandler
 * @Description:
 * @date 2021-01-01 19:33
 */
@Component
public class StaffHandler implements Handler {

	@Override
	public void afterPropertiesSet() throws Exception {
		Factory.register(4, this);
	}

	/**
	 * 策略
	 * 员工个人订单
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
		//1.搜索条件
		contractExample.createCriteria().andCreateByEqualTo(loginUser.getId()).andCompanyIdEqualTo(companyId);

		//2.返回查找结果
		return contractService.findByPage(contractExample, pageNum, pageSize);
	}
}
