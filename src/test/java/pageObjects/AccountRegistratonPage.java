package pageObjects;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.common.base.Verify;

public class AccountRegistratonPage extends BasePage {
	
	public AccountRegistratonPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(name="firstname")
	WebElement txtFirstName;
	
	@FindBy(name="lastname")
	WebElement txtLastNmae;
	
	@FindBy(name="email")
	WebElement txtEmail;
	
	@FindBy(name="telephone")
	WebElement txtTelephone;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="confirm")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//*[@id='content']/form/fieldset[3]/div/div/label[1]/input")
	WebElement chkSubscribe;
	
	@FindBy(name="agree")
	WebElement chkPrivacyPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//*[@id='content']/h1")
	WebElement txtconfmsg;
	
	
	
	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}
	
	public void setLasttName(String lname) {
		txtLastNmae.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String phoneNo) {
		txtTelephone.sendKeys(phoneNo);
	}
	
	public void setPassword(String psw) {
		txtPassword.sendKeys(psw);
	}
	
	public void setConfPassword(String confpsw) {
		txtConfirmPassword.sendKeys(confpsw);
	}

	public void ClickSubscribe() {
		chkSubscribe.click();
	}
	
	public void ClickPrivacyPolicy() {
		chkPrivacyPolicy.click();
	}
	
	public void ClickContinue() {
		btnContinue.click();
	}
	
	public String getConfirmationmsg() {
		try {
			return(txtconfmsg.getText());
		}
		catch (Exception e) {
			return (e.getMessage());
		}
		
		
	}
}
