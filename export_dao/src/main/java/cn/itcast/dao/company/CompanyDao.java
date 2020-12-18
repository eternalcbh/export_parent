package cn.itcast.dao.company;

import cn.itcast.domain.company.Company;

import java.util.List;

public interface CompanyDao {
    /**
     * 查询全部
     */
    List<Company> findAll();

    /**
     * 添加
     */
    void save(Company company);

    /**
     * 修改
     * @param company
     */
    void update(Company company);

    /**
     * 根据用户id回显数据
     * @param id
     */
    Company findById(String id);

    /**
     * 根据用户id删除用户
     */
    void delete(String id);
}
