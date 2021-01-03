package cn.itcast.service.cargo.impl;

import cn.itcast.dao.cargo.ExportProductDao;
import cn.itcast.domain.cargo.ExportProduct;
import cn.itcast.domain.cargo.ExportProductExample;
import cn.itcast.service.cargo.ExportProductService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author cbh
 * @PackageName:cn.itcast.service.cargo.impl
 * @ClassName:ExportProductServiceImpl
 * @Description:
 * @date 2021-01-02 23:16
 */
@Service
public class ExportProductServiceImpl implements ExportProductService {

	@Autowired
	private ExportProductDao exportProductDao;
	/**
	 * 根据id查找报运货品
	 *
	 * @param id
	 * @return
	 */
	@Override
	public ExportProduct findById(String id) {
		return null;
	}

	/**
	 * 查找所有报运货品
	 *
	 * @param example
	 * @return
	 */
	@Override
	public List<ExportProduct> findAll(ExportProductExample example) {
		return exportProductDao.selectByExample(example);
	}

	/**
	 * 保存报运货品
	 *
	 * @param exportProduct
	 */
	@Override
	public void save(ExportProduct exportProduct) {

	}

	/**
	 * 修改报运货品
	 *
	 * @param exportProduct
	 */
	@Override
	public void update(ExportProduct exportProduct) {

	}

	/**
	 * 删除报运货品
	 *
	 * @param id
	 */
	@Override
	public void delete(String id) {

	}

	/**
	 * 分页查找报运货品
	 *
	 * @param exportProductExample
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@Override
	public PageInfo<ExportProduct> findByPage(ExportProductExample exportProductExample, int pageNum, int pageSize) {
		return null;
	}
}
