package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver)
	{
		 super(driver);
	}
	
	 @FindBy(xpath="(//*[text()='My Account'])[1]") 
	 WebElement lnkMyAccount;
	 
	 @FindBy(xpath="//*[text()='Register']") 
	 WebElement lnkRegister;
	 
	 @FindBy(xpath="//*[text()='Login']")
	 WebElement lnkLogin;
	 
	 public void ClickMyAccount() {
		 lnkMyAccount.click();
		 
	 }
	 
	 public void ClickRegister() {
		
		 lnkRegister.click();
	 }
	 
	 public void ClickLogin() {
			
		 lnkLogin.click();
	 }
}
