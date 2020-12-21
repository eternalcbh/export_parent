package cn.itcast.dao.company.test;

import cn.itcast.dao.company.CompanyDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-dao.xml")
public class CompanyDaoTest {
    @Autowired
    private CompanyDao companyDao;

    @Test
    public void findAll(){
        System.out.println(companyDao.findAll("传智"));
    }

    @Test
    public void findById(String id){
        System.out.println(companyDao.findById(id));
    }
}
