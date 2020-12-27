package cn.itcast.dao.cargo;

import cn.itcast.domain.cargo.Factory;
import cn.itcast.domain.cargo.FactoryExample;

import java.util.List;

public interface FactoryDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table co_factory
     *
     * @mbg.generated Sun Dec 27 21:38:18 CST 2020
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table co_factory
     *
     * @mbg.generated Sun Dec 27 21:38:18 CST 2020
     */
    int insert(Factory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table co_factory
     *
     * @mbg.generated Sun Dec 27 21:38:18 CST 2020
     */
    int insertSelective(Factory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table co_factory
     *
     * @mbg.generated Sun Dec 27 21:38:18 CST 2020
     */
    List<Factory> selectByExample(FactoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table co_factory
     *
     * @mbg.generated Sun Dec 27 21:38:18 CST 2020
     */
    Factory selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table co_factory
     *
     * @mbg.generated Sun Dec 27 21:38:18 CST 2020
     */
    int updateByPrimaryKeySelective(Factory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table co_factory
     *
     * @mbg.generated Sun Dec 27 21:38:18 CST 2020
     */
    int updateByPrimaryKey(Factory record);
}