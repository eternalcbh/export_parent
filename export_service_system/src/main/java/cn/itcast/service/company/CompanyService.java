package cn.itcast.service.company;

import cn.itcast.domain.company.Company;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CompanyService {
    /**
     * 查询所有
     * @return
     */
    List<Company> findAll();

    /**
     * 添加
     * @param company
     */
    void save(Company company);

    /**
     * 修改
     * @param company
     */
    void update(Company company);

    /**
     *根据用户id修改用户
     * @param id
     * @return
     */
    Company findById(String id);

    /**
     * 根据用户id删除用户
     * @param id
     */
    void delete(String id);

    /**
     * 分页查询
     * @param pageNum 当前页
     * @param pageSize 页大小
     * @return 返回PageInfo对象,是PageHelper提供的用于封装分页参数的对象
     */
    PageInfo<Company> findByPage(int pageNum, int pageSize);
}
