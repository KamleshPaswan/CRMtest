package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.testbase.TestBase;

public class HomePage extends TestBase {
//fagefactory===OR
	@FindBy(xpath = "//span[contains(text(),'Kamlesh Paswan')]")
	WebElement nameleble;

	@FindBy(linkText = "Contacts")
	WebElement contactsLinks;

	@FindBy(linkText = "Calendar")
	WebElement calendarLinks;

	@FindBy(linkText = "Companies")
	WebElement companiesLinks;

	@FindBy(linkText = "Deals")
	WebElement dealsLinks;

	@FindBy(linkText = "Tasks")
	WebElement tasksLinks;

	@FindBy(linkText = "Cases")
	WebElement casesLinks;

	@FindBy(linkText = "Calls")
	WebElement callLinks;

	@FindBy(linkText = "Documents")
	WebElement documentsLinks;

	@FindBy(linkText = "Email")
	WebElement emailLinks;

	@FindBy(linkText = "Campaigns")
	WebElement campaignLinks;

	@FindBy(linkText = "Forms")
	WebElement formLinks;
//initialization of objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String homePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyUserNameLeble() {
		return nameleble.isDisplayed();

	}

	public ContactsPage clickOnContactsLinks() {
		contactsLinks.click();
		return new ContactsPage();
	}

	public CalendarPage clickOnCalendarLinks() {
		calendarLinks.click();
		return new CalendarPage();
	}

	public CompaignsPage clickOnCampaignLinks() {
		campaignLinks.click();
		return new CompaignsPage();

	}
	public DealPage clickOnDealLinks() {
		dealsLinks.click();
		return new DealPage();	
}
	public TaskPage clickOnTaskLinks() {
		tasksLinks.click();
		return new TaskPage();	
}
	public CasesPage clickOnCasesLinks() {
		casesLinks.click();
		return new CasesPage();	
}
	public CallsPage clickOnCallLinks() {
		callLinks.click();
		return new CallsPage();	
}
	public DocumentsPage clickOnDocumentsLinks() {
		documentsLinks.click();
		return new DocumentsPage();	
}
	public EmailsPage clickOnEmailLinks() {
		emailLinks.click();
		return new EmailsPage();	
}
	public DealPage clickOnFormsLinks() {
		formLinks.click();
		return new DealPage();	
}
	public CompaniesPage clickOnCompaniesLinks() {
		companiesLinks.click();
		return new CompaniesPage();	
}
}	
	
	
	