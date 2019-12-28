package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.testbase.TestBase;

public class LoginPage extends TestBase {
	//Pagefactory page--OR
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath = "//div[text()='Login']")
	WebElement loginbtn;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up']")
	WebElement signUpBtn;
	
	@FindBy(linkText = "Forgot your password?")
	WebElement forgetpwdBtn;
	
	
	
	//initialize the page object
public	LoginPage(){
	
	PageFactory.initElements(driver, this);
	
	
	}
public String validateLoginPagetitle() {
	return driver.getTitle();
	
}
public boolean validteForgetPwdLink() {
	return forgetpwdBtn.isDisplayed();
}
public HomePage login(String un,String pwd) {
	username.sendKeys(un);
	password.sendKeys(pwd);
	loginbtn.click();
	return new HomePage();
	
}
}
