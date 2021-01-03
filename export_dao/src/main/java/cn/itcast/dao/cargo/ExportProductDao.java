package cn.itcast.dao.cargo;

import cn.itcast.domain.cargo.ExportProduct;
import cn.itcast.domain.cargo.ExportProductExample;

import java.util.List;

public interface ExportProductDao {
    int deleteByPrimaryKey(String id);

    int insert(ExportProduct record);

    int insertSelective(ExportProduct record);

    List<ExportProduct> selectByExample(ExportProductExample example);

    ExportProduct selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ExportProduct record);

    int updateByPrimaryKey(ExportProduct record);
}