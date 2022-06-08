package com.page;

import org.openqa.selenium.By;

import com.actions.ActionEngine;

public class LoginPage extends ActionEngine{
	
 public static By textUsername = By.xpath("//input[@name='email']");
 public static By textUsername1 = By.xpath("//input[@name='email1']");
 public static By textPassword = By.xpath("//input[@name='pass']");
 public static By buttonLogin = By.xpath("//button[@name='login']");
 
 
 public void loginApplication() {
	type(textUsername, "username", "usrname locator");
	type(textPassword, "password", "password locator");
	click(buttonLogin, "login button locator");
 }
 
 public void loginApplication1() {
		type(textUsername1, "username", "usrname locator");
		type(textPassword, "password", "password locator");
		click(buttonLogin, "login button locator");
	 }

}
