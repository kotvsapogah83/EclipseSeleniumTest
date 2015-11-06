package otpp;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import org.testng.annotations.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.*;

public class AddNewWrongFilledFilm extends TestBase {
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Test
	  public void testUntitled2() throws Exception {    /*driver.get(baseUrl + "/php4dvd/#!/sort/name%20asc/");*/

		String imdbNumber = Integer.toString(generateNumber());
		String titleMovie = "";
		String alsoKnown = "The best from the fakes" + Integer.toString(generateNumber());
		String yearOfFilm = "";
		String durationOfFilm = "120";
		String rateOfFilm = "8";
		String formatOfFilm = "Blu-ray";
		String urlOfFilm = "http://www.fake.ru";
		String notesToFilm = "Personal notes for testing" + Integer.toString(generateNumber());
		String slogansOfFilm = "Taglines for test" + Integer.toString(generateNumber());
		String plotOutlineOfFilm = "Plot outlune for test" + Integer.toString(generateNumber());
		String plotsOfFilms = "Plots for test" + Integer.toString(generateNumber());
		String languageOfFilm = "Languages for test" + Integer.toString(generateNumber());
		String subtitlesOfFilm = "Subtitles for test" + Integer.toString(generateNumber());
		String audioOfTest = "Audio for test" + Integer.toString(generateNumber());
		String videoOfFilm = "Video for test" + Integer.toString(generateNumber());
		String countryOfFilm = "Country for test" + Integer.toString(generateNumber());
		String genreOfFilm = "Genres for test" + Integer.toString(generateNumber());
		String directorOfFilm = "Director for test" + Integer.toString(generateNumber());
		String writerOfFilm = "Writer for test" + Integer.toString(generateNumber());
		String producerOfTest = "Producer for test" + Integer.toString(generateNumber());
		String musicOfFilm = "Music for test" + Integer.toString(generateNumber());
		String castOfFilm = "Cast for test" + Integer.toString(generateNumber());
		  
		navigateToNewFilmForm();

		fillNewFilmForm(imdbNumber, titleMovie, alsoKnown, yearOfFilm, durationOfFilm, rateOfFilm, formatOfFilm, urlOfFilm,
				notesToFilm, slogansOfFilm, plotOutlineOfFilm, plotsOfFilms, languageOfFilm, subtitlesOfFilm, audioOfTest,
				videoOfFilm, countryOfFilm, genreOfFilm, directorOfFilm, writerOfFilm, producerOfTest, musicOfFilm,
				castOfFilm);
						
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		//проверяем, что форма не подтверждена и видны оповещения об обязательных полях
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("label[class=error][for=name][generated=true]")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("label[class=error][for=year][generated=true]")));
		
	  }

	private void submitNewFilmForm() {
		//подтверждение ввода
	    driver.findElement(By.id("submit")).click();
	}

	private void fillNewFilmForm(String imdbNumber, String titleMovie, String alsoKnown, String yearOfFilm,
			String durationOfFilm, String rateOfFilm, String formatOfFilm, String urlOfFilm, String notesToFilm,
			String slogansOfFilm, String plotOutlineOfFilm, String plotsOfFilms, String languageOfFilm,
			String subtitlesOfFilm, String audioOfTest, String videoOfFilm, String countryOfFilm, String genreOfFilm,
			String directorOfFilm, String writerOfFilm, String producerOfTest, String musicOfFilm, String castOfFilm) {
		//заполнение полей
	    driver.findElement(By.name("imdbid")).clear();    
		driver.findElement(By.name("imdbid")).sendKeys(imdbNumber);
	    driver.findElement(By.name("name")).clear();    
		driver.findElement(By.name("name")).sendKeys(titleMovie);
	    driver.findElement(By.name("aka")).clear();    
		driver.findElement(By.name("aka")).sendKeys(alsoKnown);
	    driver.findElement(By.name("year")).clear();    
		driver.findElement(By.name("year")).sendKeys(yearOfFilm);
	    driver.findElement(By.name("duration")).clear();    
		driver.findElement(By.name("duration")).sendKeys(durationOfFilm);
	    driver.findElement(By.name("rating")).clear();    
		driver.findElement(By.name("rating")).sendKeys(rateOfFilm);
	    driver.findElement(By.id("formats")).clear();    
		driver.findElement(By.id("formats")).sendKeys(formatOfFilm);
	    driver.findElement(By.id("own_no")).click();
	    driver.findElement(By.id("seen_yes")).click();
	    driver.findElement(By.id("loaned_no")).click();
	    driver.findElement(By.name("trailer")).clear();    
		driver.findElement(By.name("trailer")).sendKeys(urlOfFilm);
	    driver.findElement(By.name("notes")).clear();    
		driver.findElement(By.name("notes")).sendKeys(notesToFilm);
	    driver.findElement(By.name("taglines")).clear();    
		driver.findElement(By.name("taglines")).sendKeys(slogansOfFilm);
	    driver.findElement(By.name("plotoutline")).clear();    
		driver.findElement(By.name("plotoutline")).sendKeys(plotOutlineOfFilm);
	    driver.findElement(By.name("plots")).clear();    
		driver.findElement(By.name("plots")).sendKeys(plotsOfFilms);
	    driver.findElement(By.id("text_languages_0")).clear();    
		driver.findElement(By.id("text_languages_0")).sendKeys(languageOfFilm);
	    driver.findElement(By.name("subtitles")).clear();    
		driver.findElement(By.name("subtitles")).sendKeys(subtitlesOfFilm);
	    driver.findElement(By.name("audio")).clear();    
		driver.findElement(By.name("audio")).sendKeys(audioOfTest);
	    driver.findElement(By.name("video")).clear();    
		driver.findElement(By.name("video")).sendKeys(videoOfFilm);
	    driver.findElement(By.name("country")).clear();    
		driver.findElement(By.name("country")).sendKeys(countryOfFilm);
	    driver.findElement(By.name("genres")).clear();    
		driver.findElement(By.name("genres")).sendKeys(genreOfFilm);
	    driver.findElement(By.name("director")).clear();    
		driver.findElement(By.name("director")).sendKeys(directorOfFilm);
	    driver.findElement(By.name("writer")).clear();    
		driver.findElement(By.name("writer")).sendKeys(writerOfFilm);
	    driver.findElement(By.name("producer")).clear();    
		driver.findElement(By.name("producer")).sendKeys(producerOfTest);
	    driver.findElement(By.name("music")).clear();    
		driver.findElement(By.name("music")).sendKeys(musicOfFilm);
	    driver.findElement(By.name("cast")).clear();    
		driver.findElement(By.name("cast")).sendKeys(castOfFilm);
	}

	private void navigateToNewFilmForm() {
		//переход к форме заполнения данных о фильме  
		driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
	}

	private int generateNumber() {
		int randomNum = 1 + (int)(Math.random() * ((10000 - 1) + 1));
		return randomNum;
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
