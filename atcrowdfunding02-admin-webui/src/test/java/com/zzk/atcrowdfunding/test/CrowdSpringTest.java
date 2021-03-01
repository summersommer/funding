//package com.zzk.atcrowdfunding.test;
//
//import com.zzk.atcrowdfunding.entity.Admin;
//
//import com.zzk.atcrowdfunding.mapper.AdminMapper;
//
//import com.zzk.atcrowdfunding.service.api.AdminService;
//import com.zzk.atcrowdfunding.entity.Admin;
//import com.zzk.atcrowdfunding.mapper.AdminMapper;
//import com.zzk.atcrowdfunding.service.api.AdminService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.SQLException;
//
///**
// * @Author Administrator
// * @Date 2020/5/6
// */
//// 指定 Spring 给 Junit 提供的运行器类
//@RunWith(SpringJUnit4ClassRunner.class)
//// 加载 Spring 配置文件的注解
//@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml","classpath:spring-persist-tx.xml"})
//public class CrowdSpringTest {
//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    private AdminMapper adminMapper;
//
//    @Autowired
//    private AdminService adminService;
//
//    @Autowired
//
//    @Test
//    public void testadd(){
//        for (int i=0;i<256;i++){
//            adminMapper.insert(new Admin(null,"loginAcct"+i,"userpswd"+i,"userName"+i,"email"+i,"createTime"+i));
//        }
//    }
//
//
//
//}