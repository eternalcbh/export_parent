package cn.itcast.service.system.impl;

import cn.itcast.dao.system.UserDao;
import cn.itcast.domain.system.User;
import cn.itcast.service.system.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll(String companyId) {
        return userDao.findAll(companyId);
    }

    @Override
    public PageInfo<User> findByPage(String companyId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userDao.findAll(companyId);
        return new PageInfo<>(list);
    }

    @Override
    public User findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public void save(User user) {
        user.setId(UUID.randomUUID().toString());
        //加盐加密
        Md5Hash md5Hash = new Md5Hash(user.getPassword(), user.getEmail());
        user.setPassword(md5Hash.toString());
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public Integer delete(String id) {
        int roleByUserNumber = userDao.findRoleByUserId(id);
        if (roleByUserNumber == 0){
            return userDao.delete(id);
        }else {
            return 0;
        }
    }

	@Override
	public void changeRoles(String userid, String[] roleIds) {
		userDao.deleteUserRole(userid);
		if (roleIds != null && roleIds.length != 0){
            userDao.addUserRoles(userid,roleIds);
        }
	}

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
