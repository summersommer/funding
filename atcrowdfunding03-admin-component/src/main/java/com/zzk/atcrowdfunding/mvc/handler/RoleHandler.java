package com.zzk.atcrowdfunding.mvc.handler;

import com.zzk.atcrowdfunding.entity.Role;
import com.zzk.atcrowdfunding.service.api.RoleService;
import com.zzk.atcrowdfunding.util.ResultEntity;
import com.github.pagehelper.PageInfo;
import com.zzk.atcrowdfunding.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2021/3/3
 */
@RestController
public class RoleHandler {
    @Autowired
    private RoleService roleService;


}
