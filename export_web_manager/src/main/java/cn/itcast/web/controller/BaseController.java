package cn.itcast.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Controller
public abstract class BaseController {
    //注入servletApi,这样可以直接在控制器中使用
    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    @Autowired
    protected HttpSession session;

    /**
     * 获取登录用户的企业id
     */
    public String getLoginCompanyId(){
        return "1";
    }

    /**
     * 获取登录用户的企业名称
     */
    public String getLoginCompanyName(){
        return "传智播客教育服务有限公司";
    }
}
