package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	DealsPage dealspage;
	TasksPage taskspage;

	public HomePageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		contactspage = new ContactsPage();
		dealspage = new DealsPage();
		taskspage = new TasksPage();
		loginpage = new LoginPage();
		loginpage.clickOnLoginLink();
		homepage = loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homepagetitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "Cogmento CRM","Home page title not match!");
	}
	
	@Test(priority = 2)
	public void verifyUserCorrectNameTest() {
		Assert.assertTrue(homepage.verifyCorrectUserName()); 
	}
	
	@Test(priority = 3)
	public void verifyContactsLinkTest() throws IOException {
		contactspage = homepage.ClickOnContactsLink();
		
	}
	
	@Test(priority = 4)
	public void verifyDealsLinkTest() throws IOException {
		dealspage = homepage.ClickOnDealsLink();
		
	}
	
	@Test(priority = 5)
	public void verifyTasksLinkTest() throws IOException {
		taskspage = homepage.ClickOnTasksLink();
		
	}
	
	@AfterMethod
	public void teatDown() {
		driver.quit();
	}

}
