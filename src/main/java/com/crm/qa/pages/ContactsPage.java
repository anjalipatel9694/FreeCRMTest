package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactsLable;
	
	@FindBy(xpath = "//button[contains(text(),\"Create\")]")
	WebElement createNewContactLink;

	public ContactsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLable() {
		return contactsLable.isDisplayed();
	}

	public void selectContactsByName(String name) {
		Actions actions = new Actions(driver); 
		actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]"))).click().build().perform();


		//driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]")).click();;
	}
	
	public  CreateNewContactsPage createNewContactLink() throws IOException {
		Actions actions = new Actions(driver); 
		actions.moveToElement(createNewContactLink).click().build().perform();
		//createNewContactLink.click();
		return new CreateNewContactsPage();
		
	}
}
