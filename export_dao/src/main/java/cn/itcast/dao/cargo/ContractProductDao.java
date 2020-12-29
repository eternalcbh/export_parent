package cn.itcast.dao.cargo;

import cn.itcast.domain.cargo.ContractProduct;
import cn.itcast.domain.cargo.ContractProductExample;

import java.util.List;

/**
 * 订单合同持久层
 * @author cbh
 */
public interface ContractProductDao {
    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 全字段插入
     * @param record
     * @return
     */
    int insert(ContractProduct record);

    /**
     * 部分字段插入
     * @param record
     * @return
     */
    int insertSelective(ContractProduct record);

    /**
     * 模糊查询
     * @param example
     * @return
     */
    List<ContractProduct> selectByExample(ContractProductExample example);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    ContractProduct selectByPrimaryKey(String id);

    /**
     * 部分修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ContractProduct record);

    /**
     * 全字段修改
     * @param record
     * @return
     */
    int updateByPrimaryKey(ContractProduct record);
}