package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;
import com.crm.qa.utils.TestUtil;

public class ContactsPageTest extends TestBase {
	//git hut created
	LoginPage login;
	HomePage homepage;
	TestUtil util;
	ContactsPage contactspage;
	String sheetName="contacts";
public	ContactsPageTest(){
		super();
	}
@BeforeMethod
public void setup() {
	initialization();
	 login=new LoginPage();
	 util=new TestUtil();
	  contactspage=new ContactsPage();
	 homepage=login.login(prop.getProperty("username"), prop.getProperty("password"));
	 
	// contactspage =homepage.clickOnContactsLinks();
	 
}


@Test(priority=1)
public void verifyContactsLebleTest() {
	//util.switchtoframe();
	homepage.clickOnContactsLinks();
boolean	flag=contactspage.verifyContactsLeble();
Assert.assertTrue(flag,"contacts leble is not matched");
}
@DataProvider
public Object[][] getTestData() {
	Object[][]data=util.getCrmTestData(sheetName);
	return data;
}
@Test(priority=2,dataProvider = "getTestData")
public void createNewcontactsTest(String fname,String lname,String email) {
	homepage.clickOnContactsLinks();
	contactspage.createNewContacts(fname, lname, email);

}




@AfterMethod
public void tearDown() {
	driver.quit();
}
}
