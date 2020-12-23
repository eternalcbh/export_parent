package cn.itcast.service.system.impl;

import cn.itcast.dao.system.DeptDao;
import cn.itcast.domain.system.Dept;
import cn.itcast.service.system.DeptService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;

    @Override
    public List<Dept> findAll(String companyId,String id) {
         return  deptDao.findAll(companyId,id);
    }

    @Override
    public PageInfo<Dept> findByPage(String companyId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Dept> list = deptDao.findAll(companyId,"");
        return new PageInfo<>(list);
    }

    @Override
    public Dept findById(String id) {
        return deptDao.findById(id);
    }

    @Override
    public void save(Dept dept) {
        dept.setId(UUID.randomUUID().toString());
        if (dept.getParent()!=null&&"".equals(dept.getParent().getId())){
            dept.getParent().setId(null);
        }
        deptDao.save(dept);
    }

    @Override
    public void update(Dept dept) {
        if (dept.getParent()!=null&&"".equals(dept.getParent().getId())){
            dept.getParent().setId(null);
        }
        deptDao.update(dept);
    }

    @Override
    public boolean delete(String id) {
        List<Dept> list = deptDao.findByParent(id);
        if (null == list || list.size() == 0){
            deptDao.delete(id);
            return true;
        }
        return false;
    }
}
