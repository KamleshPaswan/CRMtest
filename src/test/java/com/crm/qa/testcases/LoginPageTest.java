package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		 loginpage=new LoginPage();
	}
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title=loginpage.validateLoginPagetitle();
		Assert.assertEquals(title, "Cogmento CRM","Title is not matched");
	}
	@Test(priority=3)
	public void loginTest() {
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=2)
	public void forgetPwdTest() {
	boolean	flag=loginpage.validteForgetPwdLink();
	Assert.assertTrue(flag);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
