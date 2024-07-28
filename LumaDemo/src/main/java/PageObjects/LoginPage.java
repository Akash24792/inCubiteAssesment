package PageObjects;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;
	

	//Locators
	private  By EmailID = By.id("email");
	private  By PasswordTextBox = By.id("pass");
	private By SignInButton = By.xpath("//button[@class='action login primary']");
	private By emailErrorDiv = By.xpath("//*[@id='email-error']");
	private By passwordErrorDiv = By.xpath("//*[@id='pass-error']");
	private By welcomeMessage = By.xpath("//div[@class='panel header']//ul[@class='header links']//*[@class='greet welcome']");
	  // Constructor
			public LoginPage(WebDriver driver) {
		    this.driver = driver;
		    wait = new WebDriverWait(driver , Duration.ofSeconds(90));
		}
			
			 public void enterEmailId(String emailId) {
			        WebElement email = driver.findElement(EmailID);
			        email.sendKeys(emailId);
			    }
			 
			 public void enterPassword(String pass) {
			        WebElement welePass = driver.findElement(PasswordTextBox);
			        welePass.sendKeys(pass);
			    }	
			 
			 public void clickonSignInButton() {
				 WebElement createButton = driver.findElement(SignInButton);
				 createButton.click();
				 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(welcomeMessage));
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			 }
			 
			 public boolean validateEmailErrorMessage()
			 {
				 
				 try {
					 driver.findElement(emailErrorDiv);
			            return true;
			        } catch (NoSuchElementException e) {
			            return false;
			        }
			 }
			 
			 public boolean validatepassErrorMessage()
			 {
				 
				 try {
					 driver.findElement(passwordErrorDiv);
			            return true;
			        } catch (NoSuchElementException e) {
			            return false;
			        }
				
			 }
}
