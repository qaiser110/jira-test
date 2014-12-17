package issues;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.Page;

public class SearchResultsPage extends Page {

	public SearchResultsPage(WebDriver driver) {
    	super(driver);
//    	_driver.get("https://jira.atlassian.com/issues/");
        PageFactory.initElements(driver, this);
    }
    
    // Searchboxes
    @FindBy(id = "searcher-query")
    protected WebElement innerSearchBox;
    
    @FindBy(id = "advanced-search")
	protected WebElement advancedSearchBox;
    
    // Buttons
    @FindBy(css = "button.search-button")
    protected WebElement innerSearchBtn;
    
    @FindBy(id = "layout-switcher-button")
    protected WebElement switchViewBtn;
    
    @FindBy(id = "edit-issue")
    private WebElement editIssueButton;
    
    @FindBy(xpath = "//li[@data-id='issuetype']/button")
    protected WebElement issueTypeBtn;
    
    @FindBy(xpath = "//a[@data-id='basic']")	// Advanced anchor has data-id 'basic'
    protected WebElement advancedSearchLink;
    
    @FindBy(xpath = "//a[@data-id='advanced']")
    protected WebElement basicSearchLink;
    
    @FindBy(id = "summary-val")
    private WebElement issueSummaryVal;

    public void selectIssueType(String issueType) {
    	issueTypeBtn.click();
    	_driver.findElement(By.id("searcher-type-multi-select"))
    			.findElement(By.xpath("//label[contains(text(),'issueType')]"));
    	issueTypeBtn.click();
    }
    
	public SearchResultsPage searchIssueByKey(String keyVal) {
//		issueKey = "TST-59929"
		switchToAdvanceSearch();
		advancedSearchBox.sendKeys("issueKey = " + keyVal);
		advancedSearchBox.submit();
		return this;
	}

	public String getSummaryOfFirstSearchResult(String title) {
		return issueSummaryVal.getText();
	}

	public void clickOnSummaryH1(String title) {
		issueSummaryVal.click();
	}
	
	public void innerSearchFor(String text) {
		switchToBasicSearch();
		innerSearchBox.sendKeys(text);
    	innerSearchBox.submit();
   }
	public void advanceSearchFor(String text) {
		switchToAdvanceSearch();
		advancedSearchBox.sendKeys(text);
		advancedSearchBox.submit();
	}
    
	public void switchToAdvanceSearch() {
		if (advancedSearchLink.isDisplayed()) {
			advancedSearchLink.click();
		}
	}	
	public void switchToBasicSearch() {
		if (basicSearchLink.isDisplayed()) {
			basicSearchLink.click();
		}
	}
	
    public void switchToDetailView() {
    	if(!isDetailViewSelected()) {
	    	switchViewBtn.click();
	    	_driver.findElement(By.xpath("//a[@data-layout-key='split-view']")).click();
    	}
    }
    public void switchToListView() {
    	if(isDetailViewSelected()) {
    		switchViewBtn.click();
    		_driver.findElement(By.xpath("//a[@data-layout-key='list-view']")).click();
    	}
    }
    public boolean isDetailViewSelected() {
    	return _driver.findElements(By.className("list-results-panel")).size() > 0;
    }

}
