package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;
	public HomePageTest() {
		super();
	}
@BeforeMethod
public void setup() {
	initialization();
	loginpage=new LoginPage();
	contactpage=new ContactsPage();
	homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
}
@Test(priority=1)
public void verifyHomePageTitleTest() {
	String title=homepage.homePageTitle();
	Assert.assertEquals(title, "Cogmento CRM","Home page Title is not matched");
}
@Test(priority=2)
public void verifyUsernameLeble() {
	boolean flag=homepage.verifyUserNameLeble();
	Assert.assertTrue(flag);
}
@Test(priority=3)
public void verifyContectsLinksTest() {
	contactpage=homepage.clickOnContactsLinks();
}

@AfterMethod
public void tearDown() {
	driver.quit();
}

}
