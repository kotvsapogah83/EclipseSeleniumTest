package otpp;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import org.testng.annotations.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginTest extends TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testUntitled2() throws Exception {    driver.get(baseUrl + "php4dvd/");
    WebElement userNameWebEdit = driver.findElement(By.id("username"));
    WebElement passwordWebEdit = driver.findElement(By.name("password"));
    WebElement subminButton = driver.findElement(By.name("submit"));
	userNameWebEdit.clear();
    userNameWebEdit.sendKeys("admin");    
	passwordWebEdit.clear();
    passwordWebEdit.sendKeys("admin");    
	subminButton.click();
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}