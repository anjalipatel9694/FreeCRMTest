package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CreateNewContactsPage extends TestBase {
	
	@FindBy(name = "first_name")
	WebElement firstName;

	@FindBy(name = "last_name")
	WebElement lastName;

	@FindBy(xpath = "//input[@placeholder=\"Email address\"]")
	WebElement emailID;
	
	//
	@FindBy(xpath = "//i[@class=\"save icon\"]")
	WebElement saveBtn;
	

	public CreateNewContactsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public void createNewContact(String fname, String lname, String email) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		emailID.sendKeys(email);
		saveBtn.click();
	}
	
	
}
