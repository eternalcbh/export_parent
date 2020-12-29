package cn.itcast.service.cargo;

import cn.itcast.domain.cargo.ContractProduct;
import cn.itcast.domain.cargo.ContractProductExample;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author cbh
 * @PackageName:cn.itcast.service.cargo
 * @ClassName:ContractProductService
 * @Description:货物业务层
 * @date 2020-12-28 20:24
 */
public interface ContractProductService {
	/**
	 * 分页查询
	 * @param contractProductExample
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageInfo<ContractProduct> findByPage(ContractProductExample contractProductExample,Integer pageNum, Integer pageSize);

	/**
	 * 保存货物
	 * @param contractProduct
	 */
	void save(ContractProduct contractProduct);

	/**
	 * 修改货物
	 * @param contractProduct
	 */
	void update(ContractProduct contractProduct);

	/**
	 * 查询所有货物
	 * @param contractProductExample
	 * @return
	 */
	List<ContractProduct> findAll(ContractProductExample contractProductExample);

	/**
	 * 删除货物
	 * @param id
	 */
	void delete(String id);

	/**
	 * 根据id查询货物
	 * @param id
	 * @return
	 */
	ContractProduct findById(String id);
}
