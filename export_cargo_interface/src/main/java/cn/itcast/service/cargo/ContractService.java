package cn.itcast.service.cargo;

import cn.itcast.domain.cargo.Contract;
import cn.itcast.domain.cargo.ContractExample;
import cn.itcast.domain.vo.ContractProductVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author cbh
 * @PackageName:cn.itcast.service.cargo
 * @ClassName:ContractService
 * @Description:购销合同业务类接口
 * @date 2020-12-28 20:23
 */
public interface ContractService {
	/**
	 * 分页查询订单
	 * @param contractExample
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageInfo<Contract> findByPage(ContractExample contractExample, Integer pageNum, Integer pageSize);

	/**
	 * 修改订单合同
	 * @param contract
	 */
	void update(Contract contract);

	/**
	 * 保存订单
	 * @param contract
	 */
	void save(Contract contract);

	/**
	 * 根据id查询订单
	 * @param id
	 * @return
	 */
	Contract findById(String id);

	/**
	 * 订单删除
	 * @param id
	 */
	void delete(String id);

	/**
	 * 查询所有
	 * @param contractExample
	 * @return
	 */
	List<Contract> findAll(ContractExample contractExample);

	/**
	 *
	 * 查找子部门下所有部门的订单
	 * @param deptId
	 * @param pageNum
	 * @param pageSize
	 * @param companyId
	 * @return
	 */
	PageInfo<Contract> findPageByDeptId(String deptId,Integer pageNum, Integer pageSize, String companyId);

	/**
	 * 根据船期查出所有订单
	 * @param companyId
	 * @param inputDate
	 * @return
	 */
	List<ContractProductVo> findByShipTime(String companyId, String inputDate);
}
