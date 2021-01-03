package cn.itcast.service.cargo;

import cn.itcast.domain.cargo.ExportProduct;
import cn.itcast.domain.cargo.ExportProductExample;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author cbh
 * @PackageName:cn.itcast.service.cargo
 * @ClassName:ExpoetProductService
 * @Description:
 * @date 2021-01-02 23:12
 */
public interface ExportProductService {
	/**
	 * 根据id查找报运货品
	 * @param id
	 * @return
	 */
	ExportProduct findById(String id);

	/**
	 * 查找所有报运货品
	 * @param example
	 * @return
	 */
	List<ExportProduct> findAll(ExportProductExample example);

	/**
	 * 保存报运货品
	 * @param exportProduct
	 */
	void save(ExportProduct exportProduct);

	/**
	 * 修改报运货品
	 * @param exportProduct
	 */
	void update(ExportProduct exportProduct);

	/**
	 * 删除报运货品
	 * @param id
	 */
	void delete(String id);

	/**
	 * 分页查找报运货品
	 * @param exportProductExample
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageInfo<ExportProduct> findByPage(ExportProductExample exportProductExample, int pageNum, int pageSize);
}
