package cn.itcast.service.company.impl;

import cn.itcast.dao.company.CompanyDao;
import cn.itcast.domain.company.Company;
import cn.itcast.service.company.CompanyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service//创建对象,加入容器,加入容器的对象名默认是类名首字母小写
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyDao companyDao;

    @Override
    public List<Company> findAll() {
        return companyDao.findAll();
    }

    @Override
    public void save(Company company) {
        //设置uuid作为主键
        company.setId(UUID.randomUUID().toString());
        companyDao.save(company);

    }

    @Override
    public void update(Company company) {
        companyDao.update(company);
    }

    @Override
    public Company findById(String id) {
        return companyDao.findById(id);
    }

    @Override
    public void delete(String id) {
        companyDao.delete(id);
    }

    public PageInfo<Company> findByPage(int pageNum, int pageSize) {
        //开启分页支持,自动对其后的第一条查询进行分页
        //参数1:当前页;参数2页大小
        PageHelper.startPage(pageNum,pageSize);
        List<Company> list = companyDao.findAll();
        //封装分页参数
        PageInfo<Company> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
