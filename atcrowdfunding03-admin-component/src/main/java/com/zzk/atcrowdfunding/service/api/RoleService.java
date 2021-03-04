package com.zzk.atcrowdfunding.service.api;

import com.zzk.atcrowdfunding.entity.Role;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2021/3/3
 */
public interface RoleService {
    PageInfo<Role> getPageInfo(Integer pageNum,Integer pageSize,String keyword);

    void saveRole(Role role);

    void updateRole(Role role);
    void remove(List<Integer> roleIdList);
    List<Role> getAssignedRole(Integer adminId);

    List<Role> getUnAssignedRole(Integer adminId);

}
