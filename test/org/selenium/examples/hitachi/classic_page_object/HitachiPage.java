package org.selenium.examples.hitachi.classic_page_object;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HitachiPage {
	  @FindBy(xpath =  "//*[@class='icon icon-search']")
	   WebElement searchIcon;

	  @FindBy(xpath = "//*[@id='site-search-keyword']") 
	  WebElement searchText;
	  
	  @FindBy(xpath = "//*[@class='gsearch icon icon-search']")
	  WebElement clickSearchIcon;
	  
	  @FindBy(xpath = "/html/body/div[2]/div/div[2]/p")
	  WebElement searchResult;
	  
  private final WebDriver webdriver;

  public HitachiPage(WebDriver webdriver) {
    this.webdriver = webdriver;
  }

  public SearchResultsPage searchFor(String text) {
	  searchIcon.click();
	  searchText.sendKeys(text);
	  clickSearchIcon.submit();
      return PageFactory.initElements(webdriver, SearchResultsPage.class);
  }
  
  public String totalResultCount(WebElement count) {
	
	 String cnt = count.getText();
	 return cnt;
 }
  
  public String searchSpecialChar(WebElement count) {
		
		 String message = count.getText();
		 return message;
	 }
  
}
