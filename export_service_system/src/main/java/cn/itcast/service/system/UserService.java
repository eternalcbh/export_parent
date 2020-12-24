package cn.itcast.service.system;

import cn.itcast.domain.system.User;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    /**
     * 查询全部
     */
    List<User> findAll(String companyId);

    /**
     * 分页查询
     */
    PageInfo<User> findByPage(String companyId, int pageNum, int pageSize);

    /**
     * 根据id查询
     */
    User findById(String id);

    /**
     * 添加
     * @param user
     */
    void save(User user);

    /**
     * 修改
     * @param user
     */
    void update(User user);

    /**
     * 删除部门
     */
    Integer delete(String id);

    /**
     * 修改用户的角色
     * @param userid
     * @param roleIds
     */
	void changeRoles(String userid, String[] roleIds);

    /**
     * 根据用户邮箱去判断用户是否注册了
     * @param email
     * @return
     */
    User findByEmail(String email);

}
