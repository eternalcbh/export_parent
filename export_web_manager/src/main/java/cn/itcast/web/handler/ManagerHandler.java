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
 * @ClassName:ManagerHandler
 * @Description:
 * @date 2021-01-01 19:36
 */
@Component
public class ManagerHandler implements Handler {

	@Override
	public void afterPropertiesSet() throws Exception {
		Factory.register(3, this);
	}

	/**
	 * 策略
	 * 部门经理订单
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
		//1.设置查询条件
		contractExample.createCriteria().andCreateDeptEqualTo(loginUser.getDeptId()).andCompanyIdEqualTo(companyId);

		//2.返回部门经理查找结果
		return contractService.findByPage(contractExample, pageNum, pageSize);
	}
}
