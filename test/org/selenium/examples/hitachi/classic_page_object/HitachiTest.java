package org.selenium.examples.hitachi.classic_page_object;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.PageFactory;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.Duration;

public class HitachiTest {
 

  @Test
  public void homePage() {
	  
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\HitachiTest\\Drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://global.hitachi-solutions.com/");
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	driver.navigate().refresh();
	
	String title = driver.getTitle();
    assertThat(title, containsString("Home – Hitachi Solutions"));    
    
    driver.quit();
  }
  

  @Test
  public void userCanSearch() {
	  
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\HitachiTest\\Drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://global.hitachi-solutions.com/");
	driver.navigate().refresh();
	
	String title = driver.getTitle();
    assertThat(title, containsString("Home – Hitachi Solutions"));  
	HitachiPage page = PageFactory.initElements(driver, HitachiPage.class);
	
	//Search with entering some string in search box
    SearchResultsPage results = page.searchFor("Success");

    WebElement count = results.getResultCount();
    String cnt = page.totalResultCount(count);
    assertThat(cnt, containsString("Results 1 to 10 of 355"));    
	  
    driver.quit();
    
  }
  

  @Test
  public void negativeSearch1() {
	  
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\HitachiTest\\Drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://global.hitachi-solutions.com/");
	driver.navigate().refresh();
    
	String title = driver.getTitle();
    assertThat(title, containsString("Home – Hitachi Solutions"));  
    HitachiPage page = PageFactory.initElements(driver, HitachiPage.class);
	
    //Search with entering special character in search box
    SearchResultsPage results = page.searchFor("%#^7");

    WebElement searchResult = results.getSpecialChar();
    String message = page.searchSpecialChar(searchResult);
    assertThat(message, containsString("Sorry, your search didn't return any results."));
    
    driver.quit();
    
  }
  

  @Test
  public void negativeSearch2() {
	  
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\HitachiTest\\Drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://global.hitachi-solutions.com/");
	driver.navigate().refresh();
    
	String title = driver.getTitle();
    assertThat(title, containsString("Home – Hitachi Solutions"));  
    HitachiPage page = PageFactory.initElements(driver, HitachiPage.class);
	
    //keep search box blank and try to search on page 
    SearchResultsPage results = page.searchFor("");

    WebElement count = results.getResultCount();
    String cnt = page.totalResultCount(count);
    assertThat(cnt, containsString("Results 1 to 10 of 1017"));
    
    driver.quit();
  }
  
}
