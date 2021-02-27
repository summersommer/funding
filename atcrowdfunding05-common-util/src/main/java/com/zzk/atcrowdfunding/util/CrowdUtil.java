package com.zzk.atcrowdfunding.util;

import com.zzk.atcrowdfunding.constant.CrowdConstant;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CrowdUtil {
	
	/**
	 * 判断当前请求是否为Ajax请求
	 * @param request 请求对象
	 * @return
	 * 		true：当前请求是Ajax请求
	 * 		false：当前请求不是Ajax请求
	 */

	public static boolean judgeRequestType(HttpServletRequest request) {
		
		// 1.获取请求消息头
		String acceptHeader = request.getHeader("Accept");
		String xRequestHeader = request.getHeader("X-Requested-With");
		
		// 2.判断
		return (acceptHeader != null && acceptHeader.contains("application/json"))
				
				||
				
				(xRequestHeader != null && xRequestHeader.equals("XMLHttpRequest"));
	}
	public static String md5(String source) {
		if (source == null || source.length() == 0) {
			throw new RuntimeException(CrowdConstant.MESSAGE_STRING_INVALIDATE);
		}
		try {
			String algotithm = "md5";
			MessageDigest messageDigest = MessageDigest.getInstance(algotithm);
			byte[] input = source.getBytes();
			// 执行加密
			byte[] output = messageDigest.digest(input);
			// 创建BigInteger对象
			int signum = 1;
			BigInteger bigInteger = new BigInteger(signum, output);
			// 按照16进制将bigInteger的值转换为字符串
			int radix = 16;
			String encode = bigInteger.toString(radix).toUpperCase();
			return encode;

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

}
