package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	
	
	//PageFactory or OR(Object Reposatiory)
	
	@FindBy(xpath = "//a[contains(text(),'Log In')]")
	WebElement loginLink;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath ="//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn; 
	
	@FindBy(linkText ="Sign Up")
	WebElement signUpBtn;
	
	//initalize page objects
	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public LoginPage clickOnLoginLink() throws IOException {
		loginLink.click();
		return new LoginPage();
		
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd) throws IOException {
		email.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	

}
