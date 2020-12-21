package cn.itcast.web.controller.company;

import cn.itcast.domain.company.Company;
import cn.itcast.service.company.CompanyService;
import cn.itcast.web.controller.BaseController;
import com.github.pagehelper.PageInfo;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/company")
@Log4j
public class CompanyController extends BaseController {
    @Autowired
    private CompanyService companyService;

    /**
     * 列表查询
     * 请求路径:http://localhost:8080/company/list
     * 响应路径:/WEB-INF/pages/company/company-list.jsp
     */
    @RequestMapping("/list")
    public String list(@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "5")Integer pageSize, Model model,String likeName){
        PageInfo<Company> pageInfo = companyService.findByPage(pageNum, pageSize,likeName);
        if (!StringUtils.isEmpty(likeName)){
            model.addAttribute("likeName",likeName);
        }

        model.addAttribute("pageInfo",pageInfo);
        return "company/company-list";
    }

    @RequestMapping("/save")
    public String save(Date date){
        int i = 1/0;
        return "success";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "company/company-add";
    }

    @RequestMapping("/edit.do")
    public String edit(Company company){
        if (StringUtils.isEmpty(company.getId())){
            //添加
            companyService.save(company);
        }else{
            //修改
            companyService.update(company);
        }
        //重定向列表
        return "redirect:/company/list";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(String id,Model model){
        //根据id查询
        Company company = companyService.findById(id);
        //存储查询结构
        model.addAttribute("company",company);
        return "company/company-update";
    }

    @RequestMapping("/delete")
    public String delete(String id){
        companyService.delete(id);
        return "redirect:/company/list";
    }
}
