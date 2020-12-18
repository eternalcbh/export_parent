package cn.itcast.web.controller;

import cn.itcast.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    /**
     * 注入公司服务层对象
     */
    @Autowired
    private CompanyService companyService;

    @RequestMapping("/login")
    public String login(){
        return "home/main";
    }

    @RequestMapping("/home")
    public String home(){
        return "home/home";
    }
}
