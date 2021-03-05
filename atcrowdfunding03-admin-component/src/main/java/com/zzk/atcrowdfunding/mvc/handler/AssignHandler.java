package com.zzk.atcrowdfunding.mvc.handler;

//import com.zzk.atcrowdfunding.entity.Auth;
import com.zzk.atcrowdfunding.entity.Auth;
import com.zzk.atcrowdfunding.entity.Role;
import com.zzk.atcrowdfunding.service.api.AdminService;
//import com.zzk.atcrowdfunding.service.api.AuthService;
import com.zzk.atcrowdfunding.service.api.AuthService;
import com.zzk.atcrowdfunding.service.api.RoleService;
import com.zzk.atcrowdfunding.util.ResultEntity;
import com.zzk.atcrowdfunding.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Author Administrator
 * @Date 2020/5/13
 */
@Controller
public class AssignHandler {
    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private AuthService authService;
    @RequestMapping("/assign/to/assign/role/page.html")
    public String toAssignRolePage(
            @RequestParam("adminId") Integer adminId,
            ModelMap modelMap

    ){
//       查询已分配角色
            List<Role> assignedRoleList=roleService.getAssignedRole(adminId);
//        查询未分配角色
            List<Role> unAssignedRoleList=roleService.getUnAssignedRole(adminId);
            modelMap.addAttribute("assignedRoleList",assignedRoleList);
            modelMap.addAttribute("unAssignedRoleList",unAssignedRoleList);
        return "assign-role";
    }
    @RequestMapping("/assign/do/role/assign.html")
    public String saveAdminRoleRelationship(
            @RequestParam("adminId") Integer adminId,
            @RequestParam("pageNum") Integer pageNum,
            @RequestParam("keyword") String keyword,
            @RequestParam(value = "roleIdList",required = false) List<Integer> roleIdList//false 不是必须的

    ){
        adminService.saveAdminRoleRelationship(adminId,roleIdList);
        return "redirect:/admin/get/page.html?pageNum="+pageNum+"&keyword="+keyword;
    }
    @ResponseBody
    @RequestMapping("/assign/get/all/auth.json")

    public ResultEntity<List<Auth>> adminRoleRelationship(){
        List<Auth> authList=authService.getAll();
        return ResultEntity.successWithData(authList);
    }
    @ResponseBody
    @RequestMapping("/assign/get/assigned/auth/id/by/role/id.json")
    public ResultEntity<List<Integer>> getAssignedAuthIdByRoleId(
            @RequestParam("roleId") Integer roleId
    ){
        List<Integer> authIdList=authService.getAssignedAuthIdByRoleId(roleId);
        return ResultEntity.successWithData(authIdList);
    }

    @ResponseBody
    @RequestMapping("/assign/do/role/assign/auth.json")
    public ResultEntity<List<Integer>> saveRoleAuthRelationship(
            @RequestBody Map<String,List<Integer>> map
    ){

        authService.saveRoleAuthRelationship(map);
        return ResultEntity.successWithoutData();
    }

}
