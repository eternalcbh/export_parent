package cn.itcast.dao.cargo;

import cn.itcast.domain.cargo.Factory;
import cn.itcast.domain.cargo.FactoryExample;

import java.util.List;

/**
 * 工厂持久层
 * @author cbh
 */
public interface FactoryDao {
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
    int insert(Factory record);

    /**
     * 部分字段插入
     * @param record
     * @return
     */
    int insertSelective(Factory record);

    /**
     * 根据查询对象查询
     * @param example
     * @return
     */
    List<Factory> selectByExample(FactoryExample example);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Factory selectByPrimaryKey(String id);

    /**
     * 部分修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Factory record);

    /**
     * 全字段修改
     * @param record
     * @return
     */
    int updateByPrimaryKey(Factory record);
}