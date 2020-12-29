package cn.itcast.dao.cargo;

import cn.itcast.domain.cargo.ContractProduct;
import cn.itcast.domain.cargo.ContractProductExample;
import java.util.List;

public interface ContractProductDao {
    int deleteByPrimaryKey(String id);

    int insert(ContractProduct record);

    int insertSelective(ContractProduct record);

    List<ContractProduct> selectByExample(ContractProductExample example);

    ContractProduct selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ContractProduct record);

    int updateByPrimaryKey(ContractProduct record);
}