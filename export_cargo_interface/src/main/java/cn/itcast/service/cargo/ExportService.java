package cn.itcast.service.cargo;

import cn.itcast.domain.cargo.Export;
import cn.itcast.domain.cargo.ExportExample;
import com.github.pagehelper.PageInfo;

/**
 * @author cbh
 * @PackageName:cn.itcast.service.cargo
 * @ClassName:ExportService
 * @Description:
 * @date 2021-01-02 22:17
 */
public interface ExportService {
	/**
	 * 根据报运id查找报运单
	 * @param id
	 * @return
	 */
	Export findById(String id);

	/**
	 * 修改报运单
	 * @param export
	 */
	void update(Export export);

	/**
	 * 查找报运单
	 * @param export
	 */
	void save(Export export);

	/**
	 * 删除报运单
	 * @param id
	 */
	void delete(String id);

	/**
	 * 分页查找报运单
	 * @param exportExample
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageInfo<Export> findByPage(ExportExample exportExample,int pageNum, int pageSize);
}
