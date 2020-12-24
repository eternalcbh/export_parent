package cn.itcast.web.controller;

import cn.itcast.domain.system.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author cbh
 */
@Controller
public abstract class BaseController {
    /**
     * 注入servletApi,这样可以直接在控制器中使用
     */
    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    @Autowired
    protected HttpSession session;

    /**
     * 获取登陆者
     * @return
     */
    public User getLoginUser(){
        return (User) session.getAttribute("loginUser");
    }

    /**
     * 获取登录用户的企业id
     */
    public String getLoginCompanyId(){
        return getLoginUser().getCompanyId();
    }

    /**
     * 获取登录用户的企业名称
     */
    public String getLoginCompanyName(){
        return getLoginUser().getCompanyName();
    }
}
