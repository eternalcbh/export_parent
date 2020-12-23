package cn.itcast.service.system;

import cn.itcast.domain.system.Dept;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DeptService {
    /**
     * 查询全部
     */
    List<Dept> findAll(String companyId,String id);

    /**
     * 分页查询
     */
    PageInfo<Dept> findByPage(String companyId,int pageNum,int pageSize);

    /**
     * 根据id查询
     */
    Dept findById(String id);

    /**
     * 存储对象
     * @param dept
     */
    void save(Dept dept);

    /**
     * 更新对象
     * @param dept
     */
    void update(Dept dept);

    /**
     * 删除部门
     * @param id
     */
    boolean delete(String id);
}
