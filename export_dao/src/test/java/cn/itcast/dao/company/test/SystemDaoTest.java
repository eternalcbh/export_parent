package cn.itcast.dao.company.test;

import cn.itcast.dao.system.DeptDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-*.xml")
public class SystemDaoTest {
    @Autowired
    public DeptDao deptDao;

    @Test
    public void findAll(){
        System.out.println(deptDao.findAll("1","1"));
    }
}
