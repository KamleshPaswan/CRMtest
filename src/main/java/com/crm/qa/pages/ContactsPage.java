package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.testbase.TestBase;
import com.crm.qa.utils.TestUtil;

public class ContactsPage extends TestBase  {
	@FindBy(xpath = "//div[(text()='Contacts')]")
	WebElement contacts;
	
	@FindBy(linkText = "New")
	WebElement newBtn;
	
	@FindBy(name="first_name")
	WebElement firstname;
	
	@FindBy(name="last_name")
	WebElement lastname;
	
	@FindBy(name="value")
	WebElement emailId;
	

	@FindBy(linkText = "Save")
	WebElement savebtn;
	
	TestUtil util;
public	ContactsPage(){
	PageFactory.initElements(driver, this);
		
	}
	public boolean verifyContactsLeble() {
		System.out.println("Leble== "+contacts.getText());
	return contacts.isDisplayed();
	}
	public void createNewContacts(String fname,String lname,String email) {
		Actions act=new Actions(driver);
		newBtn.click();
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		emailId.sendKeys(email);
		act.moveToElement(savebtn).perform();
		
		savebtn.click();
		
		
		
	}
}
