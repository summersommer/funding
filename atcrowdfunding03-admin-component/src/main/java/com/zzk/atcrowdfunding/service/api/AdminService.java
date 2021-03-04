package com.zzk.atcrowdfunding.service.api;

import com.github.pagehelper.PageInfo;
import com.zzk.atcrowdfunding.entity.Admin;

import java.util.List;

/**
 * @author zzk
 * @create 2020-03-24 15:42
 */
public interface AdminService {
    void saveAdmin(Admin admin);
    void saveAdminRoleRelationship(Integer adminId, List<Integer> roleIdList);
    List<Admin> getAll();
    void update(Admin admin);
    Admin getAdminByLoginAcct(String loginAcct, String userPswd);
    PageInfo<Admin> getPageInfo(String keyword, Integer pageNum, Integer pageSize);
    void remove(Integer adminId);
    Admin getAdminById(Integer adminId);
}
