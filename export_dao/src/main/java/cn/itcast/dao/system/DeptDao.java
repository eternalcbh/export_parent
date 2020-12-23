package cn.itcast.dao.system;

import cn.itcast.domain.system.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptDao {
    /**
     * 查询全部
     */
    List<Dept> findAll(@Param("companyId") String companyId,@Param("id") String id);

    /**
     * 根据id查询
     */
    Dept findById(String id);

    /**
     * 保存新的部门
     * @param dept
     */
    void save(Dept dept);

    /**
     * 修改部门
     * @param dept
     */
    void update(Dept dept);

    /**
     * 删除部门
     * @param id
     */
    void delete(String id);

    /**
     * 查询是否有子部门
     * @param id
     * @return
     */
    List<Dept> findByParent(String id);
}
