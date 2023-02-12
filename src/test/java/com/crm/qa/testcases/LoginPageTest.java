package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	
	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		
		loginpage = new LoginPage();
		loginpage.clickOnLoginLink();
	}
	
	@Test(priority = 1)
	public void validateLoginPageTitileTest() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority = 2)
	public void loginTest() throws IOException {
		
		homepage = loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teatDown() {
		driver.quit();
	}

}
