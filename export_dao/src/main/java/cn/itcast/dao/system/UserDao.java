package cn.itcast.dao.system;

import cn.itcast.domain.system.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {
    /**
     * 根据企业id查询全部
     * @param companyId
     * @return List<User>
     */
    List<User> findAll(String companyId);

    /**
     * 根据id查询
     * @param userId
     * @return User
     */
    User findById(String userId);

    /**
     * 根据id删除
     * @param userId
     * @return Integer
     */
    Integer delete(String userId);

    /**
     * 保存
     * @param user
     */
    void save(User user);

    /**
     * @param user
     * 更新
     */
    void update(User user);

    //根据用户id查询用户角色中间表
    @ResultType(java.lang.Integer.class)
    @Select({"select count(role_id) from pe_role_user where user_id = #{id}"})
    Integer findRoleByUserId(String id);
}
