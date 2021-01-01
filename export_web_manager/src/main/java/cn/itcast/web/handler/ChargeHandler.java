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
 * @ClassName:ChargeHandler
 * @Description:
 * @date 2021-01-01 19:37
 */
@Component
public class ChargeHandler implements Handler {

	@Override
	public void afterPropertiesSet() throws Exception {
		Factory.register(2,this);
	}

	/**
	 * 策略
	 * 返回大区经理的订单
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
		//返回大区经理的订单
		return contractService.findPageByDeptId(loginUser.getDeptId(), pageNum, pageSize, companyId);
	}
}
