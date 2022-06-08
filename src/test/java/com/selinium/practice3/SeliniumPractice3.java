package com.selinium.practice3;

import org.testng.annotations.Test;

import com.actions.ActionEngine;
import com.page.LoginPage;
import com.ui.base.BaseTest;

public class SeliniumPractice3 extends ActionEngine{
	
	LoginPage loginPage = new LoginPage();

	@Test
	public void myTest() {
		System.out.println("myTest");
		extentTest = extentReports.startTest("myTest", "This test case used to login into application");
		loginPage.loginApplication();
	}
	@Test
	public void myTest1() {
		System.out.print("my test1");
		extentTest = extentReports.startTest("myTest1", "This test case used to login into application");
		loginPage.loginApplication1();
	}
	@Test
	public void myTest2() {
		System.out.println("myTest2");
		extentTest = extentReports.startTest("myTest2", "This test case used to login into application");
		loginPage.loginApplication();
	}

}
