package testCases;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class BaseClass {
	
	public WebDriver driver;
	public Logger logger;
	public Properties prop;
   
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws Exception 
	{
		//loading config.properties file
		FileReader fr=new FileReader("./src//test//resources//config.properties");
		prop=new Properties();
		prop.load(fr);
		
		logger=LogManager.getLogger(this.getClass()); //log4j
		
		switch (br.toLowerCase()) 
		{
		case "chrome" : driver=new ChromeDriver(); break;
		case "edge" : driver=new EdgeDriver(); break;
		case "firefox" : driver=new FirefoxDriver(); break;
       
		default:System.out.println("Invalid Browser name..."); return;
		}
		
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(prop.getProperty("appURL"));     //reading url from properties file
		driver.manage().window().maximize();
		Thread.sleep(500);
		
	}
	
	@AfterClass
	public void tearDown() 
	{
		driver.quit();
	}
	
	public String randomString() {
		
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;	
	}
	
    public String randomNumber() {
		
		String generatedNo=RandomStringUtils.randomAlphanumeric(10);
		return generatedNo;	
	}
    
    public String randomAlphaNumberic() {
		
    	String generatedString=RandomStringUtils.randomAlphabetic(4);
		String generatedNo=RandomStringUtils.randomAlphanumeric(2);
		return generatedString+"@"+generatedNo;	
	}
}
