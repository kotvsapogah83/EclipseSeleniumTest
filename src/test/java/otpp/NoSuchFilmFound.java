package otpp;

import java.util.regex.Pattern;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;

public class NoSuchFilmFound extends TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testUntitled2() throws Exception {    /*driver.get(baseUrl + "/php4dvd/#!/sort/name%20asc/");*/

	  driver.findElement(By.id("q")).clear();
	  driver.findElement(By.id("q")).sendKeys("abra vebra cadabra");
	  driver.findElement(By.id("q")).sendKeys(Keys.RETURN);

	  //проверяем, что есть элемент 'No movies where found.'
	  driver.findElement(By.xpath("//*[contains(text(), 'No movies where found.')]"));
	  
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