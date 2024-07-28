package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
		
	private WebDriver driver;
	private WebDriverWait wait;
	
	//Locators
	private  By createAccountLink = By.xpath("//div[@class='panel header']//ul[@class='header links']//a[contains(text(),'Create an Account')]");
	private By signInLink = By.xpath("//div[@class='panel header']//ul[@class='header links']//a[contains(text(),'Sign In')]");
	private  By firstNameTextBox = By.id("firstname");
	  // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver , Duration.ofSeconds(90));
    }

    // Methods
    public void clickOnCreateAccount() {
        WebElement createAccount = driver.findElement(createAccountLink);
        createAccount.click();
       wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameTextBox));
        
    }
    
    public void clickOnSignIn() {
        WebElement signIn = driver.findElement(signInLink);
        signIn.click();

    }
    
    public String getNewAccountPageURL(){
        String newPageURL = driver.getCurrentUrl();
            return newPageURL;
    }
 

}
