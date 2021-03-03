package com.zzk.atcrowdfunding.service.impl;

import com.zzk.atcrowdfunding.entity.Role;
import com.zzk.atcrowdfunding.entity.RoleExample;
import com.zzk.atcrowdfunding.mapper.RoleMapper;
import com.zzk.atcrowdfunding.service.api.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2020/5/11
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;


    @Override
    public PageInfo<Role> getPageInfo(Integer pageNum, Integer pageSize, String keyword) {
        // 1.开启分页
        PageHelper.startPage(pageNum,pageSize);

        // 2.执行查询
        List<Role> roleList=roleMapper.selectRoleBykeyword(keyword);

        return new PageInfo<>(roleList);
    }

    @Override
    public void saveRole(Role role) {
        roleMapper.insert(role);
    }
    @Override
    public void updateRole(Role role) {
        roleMapper.updateByPrimaryKey(role);
    }
    @Override
    public void remove(List<Integer> roleIdList) {
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        //delete from t_role where id in (1,2,4)
        criteria.andIdIn(roleIdList);
        roleMapper.deleteByExample(roleExample);
    }

}
