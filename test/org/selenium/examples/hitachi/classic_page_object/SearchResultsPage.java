package org.selenium.examples.hitachi.classic_page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchResultsPage {

  @FindBy(xpath = "//*[@id='site-search-keyword']") 
  WebElement searchText;
  
  @FindBy(xpath = "/html/body/div[2]/div/div[2]/p")
  WebElement searchResult;
  
  @FindBy(xpath = "//*[@class='results']")
  WebElement specialChar;		  
		  
  
  public WebElement getResults() {
	    return searchText;
	}
  

  public WebElement getResultCount() {
	  	return searchResult;
  	}


  public WebElement getSpecialChar() {
	  return specialChar;
  	}
  
}
