package stepdefinations;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.AccountPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import io.cucumber.java.*;
import io.cucumber.java.en.*;


public class LumaStepDef {
	
	private WebDriver driver;
	private HomePage homepage;
	private AccountPage accountpage;
	private MyAccountPage myaccountpage;
	private LoginPage loginpage;
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
	}
	
	
	@After
	public void tearDown() {
		if(driver!=null)
			driver.quit();
	}
	
	
	@Given("I am on the Luma Home page")
	public void i_am_on_the_luma_home_page() {
		  driver.get("https://magento.softwaretestingboard.com/");
		  homepage = new HomePage(driver);
		  accountpage = new AccountPage(driver);
		  myaccountpage = new MyAccountPage(driver);
		  loginpage =new LoginPage(driver);
	}

	@When("I able to click on {string} Link")
	public void i_able_to_click_on_link(String string) {
		driver.findElement(By.xpath("//div[@class='panel header']//ul[@class='header links']//a[contains(text(),'"+string+"')]")).click();
	  
	}
	
	@Then("I should be redirected to the Create Account page")
	public void i_should_be_redirected_to_the_create_account_page() {
		 Assert.assertTrue(homepage.getNewAccountPageURL().contains("account/create/"));
	}
	
	@Given("I have enterd First Name {string} and last Name {string}")
	public void i_have_enterd_first_name_and_last_name(String string, String string2) {
	   accountpage.enterFirstName(string);
	   accountpage.enterLastName(string2);
	}
	
	@When("I have entered emailId as {string}")
	public void i_have_entered_email_id_as(String string) {
	    accountpage.enterEmailId(string);
	}
	
	@When("I enter password as {string}")
	public void i_enter_password_as(String string) {
	  accountpage.enterPassword(string);
	}
	
	@When("I enter confirm password as {string}")
	public void i_enter_confirm_password_as(String string) {
	  accountpage.enterConfirmPassword(string);
	}
	
	@When("I click on the Create an Account button")
	public void i_click_on_the_create_an_account_button() {
	   accountpage.clickonCreateAccountButton();
	  
	}
	
	
	@Then("message {string} or message {string} is displayed")
	public void message_or_message_is_displayed(String string, String string2) {
		 List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(),'"+string+"')]"));
		 boolean condition1 =  !elements.isEmpty();
		//boolean condition1= driver.findElement(By.xpath("//*[contains(text(),'"+string+"')]")).isDisplayed();
		 List<WebElement> elements1 = driver.findElements(By.xpath("//*[contains(text(),'"+string2+"')]"));
		 boolean condition2 =  !elements1.isEmpty();
		System.out.println("condition 1:"+condition1);
		//boolean condition2=driver.findElement(By.xpath("//*[contains(text(),'"+string2+"')]")).isDisplayed();
		System.out.println("condition 2:"+condition2);
		Assert.assertEquals(condition1 || condition2  , true);
	}
	
		    
	@Then("Invalid Email Message is displayed")
	public void invalid_email_message_is_displayed() {
	    assertEquals(accountpage.validateEmailErrorMessage(),true);
	}
	
	@Then("{string} Error is displayed")
	public void error_is_displayed(String string) {
		List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(),'"+string+"')]"));
		 boolean condition1 =  !elements.isEmpty();
		 Assert.assertEquals(condition1  , true);
	}
	
	@Then("Validate Error Message of All fields")
	public void validate_error_message_of_all_fields() {
		assertEquals(accountpage.validateFirstNameErrorMessage(),true);
		assertEquals(accountpage.validateLastNameErrorMessage(),true);
		assertEquals(accountpage.validateEmailErrorMessage(),true);
		assertEquals(accountpage.validatepassErrorMessage(),true);
		assertEquals(accountpage.validatepassConErrorMessage(),true);
	}
	
	@Then("I should be redirected to the Sign In Page")
	public void i_should_be_redirected_to_the_sign_in_page() {
		 Assert.assertTrue(homepage.getNewAccountPageURL().contains("account/login/"));
	}
	@Given("I have entered LoginId as {string}")
	public void i_have_entered_login_id_as(String string) {
	   loginpage.enterEmailId(string);
	}
	@When("I enter LoginPassword as {string}")
	public void i_enter_login_password_as(String string) {
	   loginpage.enterPassword(string);
	}
	@When("I click on the Sign In button")
	public void i_click_on_the_sign_in_button() {
	   loginpage.clickonSignInButton();
	}
	@Then("{string} text is present")
	public void text_is_present(String string) {
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='panel header']//*[contains(text(),'"+string+"')]"));
		 boolean condition1 =  !elements.isEmpty();
		 Assert.assertEquals(condition1  , true);
	}
	
	@Then("Error message for Blank Email and Password is displayed")
	public void error_message_for_blank_email_and_password_is_displayed() {
		assertEquals(loginpage.validateEmailErrorMessage(),true);
		assertEquals(loginpage.validatepassErrorMessage(),true);
	   
	}
	
	@Then("{string} Error is displayed on signIn Page")
	public void error_is_displayed_on_sign_in_page(String string) {
		List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(),'"+string+"')]"));
		 boolean condition1 =  !elements.isEmpty();
		 Assert.assertEquals(condition1  , true);
	   
	}
	

}
