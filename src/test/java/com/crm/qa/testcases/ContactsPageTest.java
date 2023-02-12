package com.crm.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.CreateNewContactsPage;
//import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
//import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;


public class ContactsPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	//DealsPage dealspage;
	//TasksPage taskspage;
	CreateNewContactsPage createNewContacts;
	
	String sheetName = "Contacts";
	
	public ContactsPageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		contactspage = new ContactsPage();
		//dealspage = new DealsPage();
		//taskspage = new TasksPage();
		createNewContacts = new CreateNewContactsPage();
		loginpage = new LoginPage();
		loginpage.clickOnLoginLink();
		homepage = loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
		contactspage =homepage.ClickOnContactsLink();
	}	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=1)
	public void verifyContactsLableTest() {
		Assert.assertTrue(contactspage.verifyContactsLable(),"contacts lable missing on the page!");
	}	
	@Test(priority = 2)
	public void selectSingleContactsTest() {
		contactspage.selectContactsByName("test test");
	}
	@Test(priority = 3)
	public void selectMultipleContactsTest() {
		contactspage.selectContactsByName("test test");
		contactspage.selectContactsByName("Anjali Patel");
		
	}
	
	@Test(priority = 4, dataProvider = "getCRMTestData")
	public void verifyCreateNewContactLinkTest(String FirstName, String LastName, String EmailID) throws IOException {
		createNewContacts = contactspage.createNewContactLink();
		//createNewContacts.createNewContact("Kaushal", "Patel", "kisu@patel.com");
		createNewContacts.createNewContact(FirstName,LastName,EmailID);
	}
	
	@Test(priority = 5)
	public void verifyContactAddTest() throws IOException{
		
		Assert.assertTrue(driver.findElement(By.linkText("Anjali Patel")).isDisplayed(),"Contact not added!");
		
	}
	
	@AfterMethod
	public void teatDown() {
		driver.quit();
	}

}
