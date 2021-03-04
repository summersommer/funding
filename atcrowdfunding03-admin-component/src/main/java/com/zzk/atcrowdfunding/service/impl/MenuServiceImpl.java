package com.zzk.atcrowdfunding.service.impl;

import com.zzk.atcrowdfunding.entity.Menu;
import com.zzk.atcrowdfunding.entity.MenuExample;
import com.zzk.atcrowdfunding.mapper.MenuMapper;
import com.zzk.atcrowdfunding.service.api.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2020/5/12
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getAll() {
        return menuMapper.selectByExample(new MenuExample());
    }

    @Override
    public void saveMenu(Menu menu) {
        menuMapper.insert(menu);
    }

    @Override
    public void updateMenu(Menu menu) {
        //由于pid没有传入，一定要使用有选择的更新，保证“pid”字段不会置空
        menuMapper.updateByPrimaryKeySelective(menu);
    }

    @Override
    public void removeMenu(Integer id) {
        menuMapper.deleteByPrimaryKey(id);
    }
}
