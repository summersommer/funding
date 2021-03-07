//package com.zzk.atcrowdfunding.test;
//
//import com.zzk.atcrowdfunding.util.CrowdUtil;
//import com.zzk.atcrowdfunding.util.CrowdUtil;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
///**
// * @Author Administrator
// * @Date 2020/5/8
// */
//public class StringTest {
//    @Test
//    public void testMd5(){
//
//        String source="123123";
//        String encode = CrowdUtil.md5(source);
//        System.out.println(encode);
//    }//4297F44B13955235245B2497399D7A93
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//    @Test
//    public void jie() {
//        String hh = passwordEncoder.encode("123123");
//        System.out.println(hh);
//    }
//}
//package com.zzk.atcrowdfunding.test;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
///**
// * @author hongxf
// * @since 2017-04-10 10:01
// */
//public class StringTest {
//
//    public static void main(String[] args) {
//        String password = "123456";
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String hashedPassword = passwordEncoder.encode(password);
//        System.out.println(hashedPassword);
//    }
//}
