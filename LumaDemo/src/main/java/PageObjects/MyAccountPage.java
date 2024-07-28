package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	private  By pageMessage = By.xpath("//*[@class='page messages']");
	

	  // Constructor
		public MyAccountPage(WebDriver driver) {
	    this.driver = driver;
	    wait = new WebDriverWait(driver , Duration.ofSeconds(90));
	}
		
		
}
