package cn.itcast.dao.cargo;

import cn.itcast.domain.cargo.Contract;
import cn.itcast.domain.cargo.ContractExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 订单合同持久层
 * @author cbh
 */
public interface ContractDao {
    /**
     * 根据id删除对象
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 全条件插入
     * @param record
     * @return
     */
    int insert(Contract record);

    /**
     *有条件插入
     * @param record
     * @return
     */
    int insertSelective(Contract record);

    /**
     * 条件查询
     * @param example
     * @return
     */
    List<Contract> selectByExample(ContractExample example);

    /**
     * 根据id查询单哥对象
     * @param id
     * @return
     */
    Contract selectByPrimaryKey(String id);

    /**
     *有条件修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Contract record);

    /**
     * 全条件修改
     * @param record
     * @return
     */
    int updateByPrimaryKey(Contract record);

    /**
     * 查找该部门和其子部门所有的订单
     * @param deptId
     * @param companyId
     * @return
     */
    List<Contract> findPageByDeptId(@Param("deptId") String deptId,@Param("companyId") String companyId);
}