package com.numarket.controller;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;

import com.numarket.common.utils.FtpUtil;

public class FTPTest {
	@Test
	public void testFtpClient() throws Exception{
		FileInputStream inputSteam = new FileInputStream(new File("C:\\Users\\xuline\\Desktop\\1522285982.png"));
		FtpUtil.uploadFile("192.168.1.211", 21, "ftpuser", "ftpuser", "/home/uftp/www/images", "2018/04/03", "review", inputSteam);
	}
}
