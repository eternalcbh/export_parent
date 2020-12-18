package cn.itcast.dao.system;

import cn.itcast.domain.system.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    //根据企业id查询全部
    List<User> findAll(String companyId);

    //根据id查询
    User findById(String userId);

    //根据id删除
    Integer delete(String userId);

    //保存
    void save(User user);

    //更新
    void update(User user);

    //根据用户id查询用户角色中间表
    @Select("select rold_id from pe_role_user where id = #{id}")
    Integer findRoleByUserId(String id);
}
