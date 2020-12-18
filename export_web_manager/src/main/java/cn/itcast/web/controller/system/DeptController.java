package cn.itcast.web.controller.system;

import cn.itcast.domain.system.Dept;
import cn.itcast.service.system.DeptService;
import cn.itcast.web.controller.BaseController;
import com.github.pagehelper.PageInfo;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/system/dept")
@Log4j
public class DeptController extends BaseController {
    @Autowired
    private DeptService deptService;

    /**
     * 列表查询
     * @param pageNum 当前页，如果没有传递该参数默认为1
     * @param pageSize 页大小，默认5
     * @param model 用来存储数据
     * @return
     */
    @RequestMapping("/list")
    public String list(@RequestParam(defaultValue = "1")Integer pageNum, @RequestParam(defaultValue = "5")Integer pageSize, Model model) {
        log.info("执行部门列表查询开始");
        //企业id目前先写死,从登录用户哪里获取的企业id
        String companyId = getLoginCompanyId();

        //根据所属企业查询其下所有部门
        PageInfo<Dept> pageInfo = deptService.findByPage(companyId,pageNum,pageSize);

        //存储pageInfo
        request.setAttribute("pageInfo",pageInfo);
        return "system/dept/dept-list";
    }

    /**
     * 进去添加页面
     * @param model
     * @return
     */
    @RequestMapping("/toAdd")
    public String toAdd(Model model){
        List<Dept> deptList = deptService.findAll(getLoginCompanyId());
        model.addAttribute("deptList",deptList);
        return "system/dept/dept-add";
    }

    @RequestMapping("/edit")
    public String edit(Dept dept){
        //设置企业信息
        dept.setCompanyId(getLoginCompanyId());
        dept.setCompanyName(getLoginCompanyName());
        if ("".equals(dept.getId())){
            deptService.save(dept);
        }else {
            deptService.update(dept);
        }
        return "redirect:/system/dept/list";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(String id,Model model){
        Dept dept = deptService.findById(id);
        List<Dept> deptList = deptService.findAll(getLoginCompanyId());
        model.addAttribute("dept",dept);
        model.addAttribute("deptList",deptList);
        return "system/dept/dept-update";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Map<String,Integer> delete(String id){
        Map<String, Integer> map = new HashMap<>();
        //调用service删除
        boolean flag = deptService.delete(id);
        if (flag){
            map.put("message",1);
        }else{
            map.put("message",0);
        }
        return map;
    }
}
