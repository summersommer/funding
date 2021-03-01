package com.zzk.atcrowdfunding.mvc.handler;

import com.github.pagehelper.PageInfo;
import com.zzk.atcrowdfunding.constant.CrowdConstant;
import com.zzk.atcrowdfunding.entity.Admin;
import com.zzk.atcrowdfunding.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Controller
public class AdminHandler {

    @Autowired
    private AdminService adminService;
    @RequestMapping("/admin/get/page.html")
    public String getPageInfo(
            // 配置默认值
            @RequestParam(value = "keyword", defaultValue = "") String keyword,
            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
            ModelMap modelMap
    ) {
        PageInfo<Admin> pageInfo = adminService.getPageInfo(keyword, pageNum, pageSize);
        modelMap.addAttribute(CrowdConstant.ATTR_NAME_PAGE_INFO,pageInfo);
        return "admin-page";
    }
    @RequestMapping("/admin/do/logout.html")
    public String doLogout(HttpSession session){
        //强制session失效
        session.invalidate();
        return "redirect:/admin/to/login/page.html";
    }

    @RequestMapping("/admin/to/login/page.html")

    public String doLogin(//default value
                          @RequestParam(value="loginAcct",defaultValue = "sommer") String loginAcct,
                          @RequestParam(value="userPswd",defaultValue = "xx") String userPswd,
                          HttpSession session
    ){
        System.out.println(loginAcct);
        Admin admin=adminService.getAdminByLoginAcct(loginAcct,userPswd);
        session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN,admin);
        return "redirect:/admin/to/main/page.html";


    }
}

