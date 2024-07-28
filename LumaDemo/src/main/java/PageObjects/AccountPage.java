package PageObjects;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {
	
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	//Locators
	private  By firstNameTextBox = By.id("firstname");
	private  By LastNameTextBox = By.id("lastname");
	private  By emailTextBox = By.id("email_address");
	private  By passwordTextBox = By.id("password");
	private  By passwordConfirmTextBox = By.id("password-confirmation");
	private By createAccountButton = By.xpath("//button[@title='Create an Account']");
	private By passwordErrorDiv = By.xpath("//*[@id='password-error']");
	private By firstNameErrorDiv = By.xpath("//*[@id='firstname-error']");
	private By lastNameErrorDiv = By.xpath("//*[@id='lastname-error']");
	private By emailErrorDiv = By.xpath("//*[@id='email_address-error']");
	private By passwrodConfirmErrorDiv = By.xpath("//*[@id='password-confirmation-error']");
	private  By pageMessage = By.xpath("//*[@class='page messages']");
	  // Constructor
	public AccountPage(WebDriver driver) {
      this.driver = driver;
      wait = new WebDriverWait(driver , Duration.ofSeconds(90));
  }
	
	 // Methods
	 public void enterFirstName(String fName) {
	        WebElement firstName = driver.findElement(firstNameTextBox);
	        firstName.sendKeys(fName);

	    }
	 
	 public void enterLastName(String lName) {
	        WebElement lastName = driver.findElement(LastNameTextBox);
	        lastName.sendKeys(lName);
	    }
	 
	 public void enterEmailId(String emailId) {
	        WebElement email = driver.findElement(emailTextBox);
	        email.sendKeys(emailId);
	    }
	 
	 public void enterPassword(String pass) {
	        WebElement welePass = driver.findElement(passwordTextBox);
	        welePass.sendKeys(pass);
	    }
	 
	 public void enterConfirmPassword(String pass) {
	        WebElement welePass = driver.findElement(passwordConfirmTextBox);
	        welePass.sendKeys(pass);
	    }
	 
	 public void clickonCreateAccountButton() {
		 WebElement createButton = driver.findElement(createAccountButton);
		 createButton.click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(pageMessage));
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
	 
	 public boolean validateFirstNameErrorMessage()
	 {
		 
		 try {
			 driver.findElement(firstNameErrorDiv);
	            return true;
	        } catch (NoSuchElementException e) {
	            return false;
	        }
		
	 }
	 
	 public boolean validateLastNameErrorMessage()
	 {
		 
		 try {
			 driver.findElement(lastNameErrorDiv);
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
	 
	 public boolean validatepassConErrorMessage()
	 {
		 
		 try {
			 driver.findElement(passwrodConfirmErrorDiv);
	            return true;
	        } catch (NoSuchElementException e) {
	            return false;
	        }
		
	 }
	 

}
