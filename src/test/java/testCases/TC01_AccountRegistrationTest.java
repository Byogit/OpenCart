package testCases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistratonPage;
import pageObjects.HomePage;

public class TC01_AccountRegistrationTest extends BaseClass {
	
	@Test
	public void verify_Account_registration() throws Exception {
	
	try {	
	logger.info("**** Starting TC01_AccountRegistrationTest ****");	
	HomePage hm=new HomePage(driver);
	hm.ClickMyAccount();
	logger.info("Clicked on myaccount link");	
	Thread.sleep(5000);
	hm.ClickRegister();
	logger.info("Clicked on register link");
	Thread.sleep(5000);
	
	AccountRegistratonPage regPage=new AccountRegistratonPage(driver);
	
	//randosting method declared in baseclass which comes with 'Commons lang3' repository
	logger.info("Providing customer details");
	regPage.setFirstName(randomString().toUpperCase());                  
	regPage.setLasttName(randomString().toUpperCase());
	regPage.setEmail(randomString()+"@gmail.com");
	regPage.setTelephone(randomNumber());
	
	String pswd=randomAlphaNumberic();
	//we create variable pswd so we can use same pass to both pass & confpass location
	regPage.setPassword(pswd);                      
	regPage.setConfPassword(pswd);
	regPage.ClickSubscribe();
	regPage.ClickPrivacyPolicy();
	regPage.ClickContinue();
	
	logger.info("Validating expected message");
	String confmsg=regPage.getConfirmationmsg();
	//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	
	if(confmsg.equals("Your Account Has Been Created!"))
	{
		Assert.assertTrue(true);
	}else {
		logger.error("Test Failed...");
		logger.debug("Debug logs");
		Assert.assertTrue(false);
	}
}
	catch (Exception e)
	{
		Assert.fail();
	}
	 
	logger.info("**** Finished TestCase ****");
	
	}
	
}
