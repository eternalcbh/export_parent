package cn.itcast.dao.cargo;

import cn.itcast.domain.cargo.Export;
import cn.itcast.domain.cargo.ExportExample;

import java.util.List;

public interface ExportDao {
    int deleteByPrimaryKey(String id);

    int insert(Export record);

    int insertSelective(Export record);

    List<Export> selectByExample(ExportExample example);

    Export selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Export record);

    int updateByPrimaryKey(Export record);
}