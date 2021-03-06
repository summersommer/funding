package com.zzk.atcrowdfunding.service.api;

import com.zzk.atcrowdfunding.entity.Menu;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2020/5/12
 */
public interface MenuService {
    List<Menu> getAll();

    void saveMenu(Menu menu);

    void updateMenu(Menu menu);

    void removeMenu(Integer id);

}
