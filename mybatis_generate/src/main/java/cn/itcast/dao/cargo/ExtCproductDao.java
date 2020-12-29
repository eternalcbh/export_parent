package cn.itcast.dao.cargo;

import cn.itcast.domain.cargo.ExtCproduct;
import cn.itcast.domain.cargo.ExtCproductExample;
import java.util.List;

public interface ExtCproductDao {
    int deleteByPrimaryKey(String id);

    int insert(ExtCproduct record);

    int insertSelective(ExtCproduct record);

    List<ExtCproduct> selectByExampleWithBLOBs(ExtCproductExample example);

    List<ExtCproduct> selectByExample(ExtCproductExample example);

    ExtCproduct selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ExtCproduct record);

    int updateByPrimaryKeyWithBLOBs(ExtCproduct record);

    int updateByPrimaryKey(ExtCproduct record);
}