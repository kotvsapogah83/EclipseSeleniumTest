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

public class DeleteFilm extends TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testUntitled2() throws Exception {    /*driver.get(baseUrl + "/php4dvd/#!/sort/name%20asc/");*/

	  List<WebElement> filmsBeforeDelete = driver.findElements(By.className("movie_box"));
	  
	  driver.findElement(By.className("movie_cover")).click();
	  driver.findElement(By.cssSelector("img[title=Remove][alt=Remove]")).click();
	  String alertText = closeAlertAndGetItsText();
	  
	  List<WebElement> filmsAfterDelete = driver.findElements(By.className("movie_box"));
	  
	  Assert.assertTrue( filmsBeforeDelete.size() -  filmsAfterDelete.size() == 1 );
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