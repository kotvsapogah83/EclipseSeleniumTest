package otpp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import ru.stqa.selenium.factory.WebDriverFactory;

import otpp.util.PropertyLoader;

/**
 * Base class for all the TestNG-based test classes
 */
public class TestBase {
	protected WebDriver driver;
	protected String gridHubUrl;
	protected String baseUrl;
	protected String usrName;
	protected String psswd;

	@BeforeTest
	public void init() {
		baseUrl = PropertyLoader.loadProperty("site.url");
		gridHubUrl = PropertyLoader.loadProperty("grid2.hub");
		usrName = PropertyLoader.loadProperty("user.username");
		psswd = PropertyLoader.loadProperty("user.password");		

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(PropertyLoader.loadProperty("browser.name"));
		capabilities.setVersion(PropertyLoader.loadProperty("browser.version"));
		String platform = PropertyLoader.loadProperty("browser.platform");
		if (!(null == platform || "".equals(platform))) {
			capabilities.setPlatform(Platform.valueOf(PropertyLoader.loadProperty("browser.platform")));
		}

		if (!(null == gridHubUrl || "".equals(gridHubUrl))) {
			driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
		} else {
			driver = WebDriverFactory.getDriver(capabilities);
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		driver.get(baseUrl);
		WebElement userNameWebEdit = driver.findElement(By.id("username"));
		WebElement passwordWebEdit = driver.findElement(By.name("password"));
		WebElement submitButton = driver.findElement(By.name("submit"));
		
		userNameWebEdit.clear();
		userNameWebEdit.sendKeys(usrName);    
		passwordWebEdit.clear();
		passwordWebEdit.sendKeys(psswd);    
		submitButton.click();
		  
	}

	@AfterTest(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			WebDriverFactory.dismissDriver(driver);
		}
	}
}
