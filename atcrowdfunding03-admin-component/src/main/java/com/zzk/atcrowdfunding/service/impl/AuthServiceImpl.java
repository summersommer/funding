package com.zzk.atcrowdfunding.service.impl;

import com.zzk.atcrowdfunding.entity.Auth;
import com.zzk.atcrowdfunding.entity.AuthExample;
import com.zzk.atcrowdfunding.mapper.AuthMapper;
import com.zzk.atcrowdfunding.service.api.AuthService;
import com.zzk.atcrowdfunding.entity.Auth;
import com.zzk.atcrowdfunding.entity.AuthExample;
import com.zzk.atcrowdfunding.mapper.AuthMapper;
import com.zzk.atcrowdfunding.service.api.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author Administrator
 * @Date 2020/5/14
 */
@Service
public class AuthServiceImpl implements AuthService {
   @Autowired
   private AuthMapper authMapper;

   @Override
   public List<Auth> getAll() {
      return authMapper.selectByExample(new AuthExample());
   }

   @Override
   public List<Integer> getAssignedAuthIdByRoleId(Integer roleId) {

      return authMapper.selectAssignedAuthIdByRoleId(roleId);
   }

   @Override
   public void saveRoleAuthRelationship(Map<String, List<Integer>> map) {

      //获取roleId
      List<Integer> roleIdList = map.get("roleId");
      Integer roleId = roleIdList.get(0);

      //删除旧关系数据
      authMapper.deleteOldRelationship(roleId);

      List<Integer> authIdList = map.get("authIdArray");

      if (authIdList!=null && authIdList.size() > 0){
         authMapper.insertNewRelationship(roleId,authIdList);
      }
      System.out.println(map+"3");

   }

    @Override
    public List<String> getAssignedAuthNameByAdminId(Integer adminId) {
        return authMapper.selectAssignedAuthNameByAdminId(adminId);
    }
}
