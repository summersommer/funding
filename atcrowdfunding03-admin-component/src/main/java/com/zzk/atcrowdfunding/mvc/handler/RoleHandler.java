package com.zzk.atcrowdfunding.mvc.handler;

import com.zzk.atcrowdfunding.entity.Role;
import com.zzk.atcrowdfunding.service.api.RoleService;
import com.zzk.atcrowdfunding.util.ResultEntity;
import com.github.pagehelper.PageInfo;
import com.zzk.atcrowdfunding.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2021/3/3
 */
@RestController
public class RoleHandler {
    @Autowired
    private RoleService roleService;
    @ResponseBody
    @RequestMapping("/role/get/page/info.json")
    public ResultEntity<PageInfo<Role>> pageInfo(
            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
            @RequestParam(value = "keyword",defaultValue = "") String keyword

    ){
        // 调用service方法获取分页数据
        PageInfo<Role> pageInfo = roleService.getPageInfo(pageNum, pageSize, keyword);
        //封装到ResultEntity对象中（如果上面操作抛出异常交给异常映射机制处理ExceptionResolver
        return ResultEntity.successWithData(pageInfo);

    }
    @ResponseBody
    @RequestMapping("/role/remove/by/role/id/array.json")
    public ResultEntity<String> removeByRoleIdArray(@RequestBody List<Integer> roleIdList){
        roleService.remove(roleIdList);
        return ResultEntity.successWithoutData();
    }


    @ResponseBody
    @RequestMapping("/role/save.json")
    public ResultEntity<String> saveRole(Role role){
        roleService.saveRole(role);
        return ResultEntity.successWithoutData();
    }

    @ResponseBody
    @RequestMapping("/role/update.json")
    public ResultEntity<String> updateRole(Role role){
        roleService.updateRole(role);
        return ResultEntity.successWithoutData();
    }

}
