package cn.itcast.dao.cargo;

import cn.itcast.domain.cargo.ExtCproduct;
import cn.itcast.domain.cargo.ExtCproductExample;

import java.util.List;

public interface ExtCproductDao {
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
    int insert(ExtCproduct record);

    /**
     * 选择字段插入
     * @param record
     * @return
     */
    int insertSelective(ExtCproduct record);

    /**
     * 查询所有
     * @param example
     * @return
     */
    List<ExtCproduct> selectByExampleWithBLOBs(ExtCproductExample example);

    /**
     * 查询所有
     * @param example
     * @return
     */
    List<ExtCproduct> selectByExample(ExtCproductExample example);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    ExtCproduct selectByPrimaryKey(String id);

    /**
     * 部分字段修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ExtCproduct record);

    /**
     * 部分字段修改
     * @param record
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(ExtCproduct record);

    /**
     * 全字段修改
     * @param record
     * @return
     */
    int updateByPrimaryKey(ExtCproduct record);
}