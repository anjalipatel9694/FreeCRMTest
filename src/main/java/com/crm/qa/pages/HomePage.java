package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//span[contains(text(),'Anjali Patel')]")
	WebElement userNameLable;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
		
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLable.isDisplayed();
		
	}
	
	public ContactsPage ClickOnContactsLink() throws IOException {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage ClickOnDealsLink() throws IOException {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage ClickOnTasksLink() throws IOException {
		tasksLink.click();
		return new TasksPage();
	}
	
	
	
	

}
