package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver){
		super(driver);
	}

	@FindBy(id="input-email")
	WebElement txtEmail;
	
	@FindBy(id="input-password")
	WebElement txtPass;
	
	@FindBy(xpath="//*[@value='Login']")
	WebElement btnLogin;
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPass(String psw) {
		txtPass.sendKeys(psw);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	
}
