package com.zzk.atcrowdfunding.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzk.atcrowdfunding.constant.CrowdConstant;
import com.zzk.atcrowdfunding.entity.Admin;
import com.zzk.atcrowdfunding.entity.AdminExample;
import com.zzk.atcrowdfunding.exception.LoginAcctAlreadyUseException;
import com.zzk.atcrowdfunding.exception.LoginAcctAlreadyUseForUpdateException;
import com.zzk.atcrowdfunding.exception.LoginFailedException;
import com.zzk.atcrowdfunding.mapper.AdminMapper;
import com.zzk.atcrowdfunding.service.api.AdminService;
import com.zzk.atcrowdfunding.util.CrowdUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;
import java.util.Date;

/**
 * @author zzk
 * @create 2020-03-24 15:43
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    private Logger logger= LoggerFactory.getLogger(AdminServiceImpl.class);
    public void saveAdmin(Admin admin) {
        String userPswd = admin.getUserPswd();

        userPswd = CrowdUtil.md5(userPswd);

        admin.setUserPswd(userPswd);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = format.format(date);
        admin.setCreateTime(format1);
        try {
            adminMapper.insert(admin);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("异常全类名="+e.getClass().getName());
            if (e instanceof DuplicateKeyException){
                throw new LoginAcctAlreadyUseException(CrowdConstant.MESSAGE_LOGIN_ALREADY_USE);
            }
        }


    }

    public List<Admin> getAll() {
        return adminMapper.selectByExample(null);
    }

    @Override
    public Admin getAdminByLoginAcct(String loginAcct, String userPswd) {

        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andLoginAcctEqualTo(loginAcct);
        List<Admin> list = adminMapper.selectByExample(adminExample);
        if (list == null || list.size() == 0){
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }
        if (list.size()>1){
            throw new RuntimeException(CrowdConstant.MESSAGE_SYSTEM_ERROR_LOGIN_NOT_UNIQUE);
        }
        Admin admin = list.get(0);
        if (admin == null){
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }
        String userPswdDB = admin.getUserPswd();
        String userPswdForm = CrowdUtil.md5(userPswd);
        if (!Objects.equals(userPswdDB,userPswdForm)){
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }
        return admin;

    }
    @Override
    public PageInfo<Admin> getPageInfo(String keyword, Integer pageNum, Integer pageSize) {

        // 1.调用PageHeloer的静态方法
        // 非侵入式设计，原本的查询不必有任何修改
        PageHelper.startPage(pageNum,pageSize);
        // 2.执行查询
        List<Admin> list = adminMapper.selectAdminKeyword(keyword);
        // 3.封装到PageInfo对象中
        return new PageInfo<>(list);
    }

    @Override
    public void remove(Integer adminId) {
        adminMapper.deleteByPrimaryKey(adminId);
    }

    @Override
    public Admin getAdminById(Integer adminId) {
        Admin admin = adminMapper.selectByPrimaryKey(adminId);
        return admin;
    }
    @Override
    public void update(Admin admin) {
        //表示有选择的更新，null不更新
        try {
            adminMapper.updateByPrimaryKeySelective(admin);
        } catch (Exception e) {

            e.printStackTrace();
            logger.info("异常全类名="+e.getClass().getName());
            if (e instanceof DuplicateKeyException){
                throw new LoginAcctAlreadyUseForUpdateException(CrowdConstant.MESSAGE_LOGIN_ALREADY_USE);
            }
        }
    }
}
