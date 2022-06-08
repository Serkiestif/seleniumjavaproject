package com.selinium.practice3;

import org.testng.annotations.Test;
import com.actions.ActionEngine;
import com.page.TryTestingThisPage;

public class SelectValueFromDropdown extends ActionEngine{
	
	TryTestingThisPage tryTestingThisPage = new TryTestingThisPage();

	@Test
	public void myTest() {
		System.out.println("myTest");
		extentTest = extentReports.startTest("myTest", "This test case used to login into application");
		tryTestingThisPage.fillName();
	}
}
