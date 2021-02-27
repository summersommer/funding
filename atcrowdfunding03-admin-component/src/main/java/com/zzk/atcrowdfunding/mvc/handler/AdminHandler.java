package com.zzk.atcrowdfunding.mvc.handler;

import com.zzk.atcrowdfunding.constant.CrowdConstant;
import com.zzk.atcrowdfunding.entity.Admin;
import com.zzk.atcrowdfunding.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Controller
public class AdminHandler {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/admin/to/login/page.html")

    public String doLogin(//default value
                          @RequestParam(value="loginAcct",defaultValue = "sommer") String loginAcct,
                          @RequestParam(value="userPswd",defaultValue = "xx") String userPswd,
                          HttpSession session
    ){
        System.out.println(loginAcct);
        Admin admin=adminService.getAdminByLoginAcct(loginAcct,userPswd);
        session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN,admin);
        return "admin-main";


    }
}

