package cn.itcast.service.cargo;

import cn.itcast.domain.cargo.ExtCproduct;
import cn.itcast.domain.cargo.ExtCproductExample;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author cbh
 * @PackageName:cn.itcast.service.cargo
 * @ClassName:ExtCproductService
 * @Description:附件业务层
 * @date 2020-12-28 20:23
 */
public interface ExtCproductService {
	/**
	 * 分页查询
	 * @param extCproductExample
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageInfo<ExtCproduct> findByPage(ExtCproductExample extCproductExample, Integer pageNum, Integer pageSize);

	/**
	 * 根据id删除附件
	 * @param id
	 */
	void delete(String id);

	/**
	 * 保存附件
	 * @param extCproduct
	 */
	void save(ExtCproduct extCproduct);

	/**
	 * 修改附件
	 * @param extCproduct
	 */
	void update(ExtCproduct extCproduct);

	/**
	 * 查询所有
	 * @param extCproductExample
	 * @return
	 */
	List<ExtCproduct> findAll(ExtCproductExample extCproductExample);

	/**
	 * 根据id查询附件
	 * @param id
	 * @return
	 */
	ExtCproduct findById(String id);
}
