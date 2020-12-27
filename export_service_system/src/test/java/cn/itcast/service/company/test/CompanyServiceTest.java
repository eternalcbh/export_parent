package cn.itcast.service.company.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext-*.xml")
public class CompanyServiceTest {

//
//    private CompanyService companyService;
//
//    @Test
//    public void findAll(){
//        PageInfo<Company> pageInfo = companyService.findByPage(1, 2,"传智");
//        System.out.println("当前页:" + pageInfo.getPageNum());
//        System.out.println("页大小:" + pageInfo.getPageSize());
//        System.out.println("总页数:" + pageInfo.getTotal());
//        System.out.println("总记录数:" + pageInfo.getTotal());
//        System.out.println("下一页:" + pageInfo.getNextPage());
//        System.out.println("当前页数据:" + pageInfo.getList());
//    }
}
