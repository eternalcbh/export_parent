package cn.itcast.web.handler;

import cn.itcast.domain.cargo.Contract;
import cn.itcast.domain.cargo.ContractExample;
import cn.itcast.domain.system.User;
import cn.itcast.service.cargo.ContractService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author cbh
 * @PackageName:cn.itcast.web.handler
 * @ClassName:Handler
 * @Description: 策略设计模式
 * @date 2021-01-01 18:31
 */
public interface Handler extends InitializingBean {
	/**
	 * 策略
	 * @param contractService
	 * @param contractExample
	 * @param pageNum
	 * @param pageSize
	 * @param loginUser
	 * @param companyId
	 * @return
	 */
	public PageInfo<Contract>
	strategy(ContractService contractService, ContractExample contractExample, Integer pageNum, Integer pageSize
				, User loginUser, String companyId);
}
