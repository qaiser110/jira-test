package issues;

import interfaces.SearchResults;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsDetailViewPage extends SearchResultsPage 
											implements SearchResults {

	
	
    @FindBy(css = ".splitview-issue-link > .issue-link-key")
    private WebElement issueKeyLink;
    
    @FindBy(css = ".splitview-issue-link > .issue-link-summary")
    private WebElement issueSummaryLink;
    
    @FindBy(id = "summary-val")
    private WebElement issueSummaryVal;
    
	public SearchResultsDetailViewPage(WebDriver driver) {
		super(driver);
		switchToDetailView();
		PageFactory.initElements(driver, this);
	}

//	@Override
//	public WebElement findIssuesBySummary(String issueSummary) {
//		List<WebElement> els = _driver.findElements(
//				By.xpath("//ol[@class='issue-list']/li/a[@class='splitview-issue-link']/span[contains(text(),'" + issueSummary + "')]"));
//		List<WebElement> els = _driver.findElements(By.cssSelector(".splitview-issue-link > .issue-link-summary"));

		
//		return els;
//	}

	@Override
	public SearchResultsDetailViewPage findIssueByKey(String keyVal) {
//		issueKey = "TST-59929"
		switchToAdvanceSearch();
		advancedSearchBox.sendKeys("issueKey = " + keyVal);
		advancedSearchBox.submit();
		return this;
	}

	public String getSummaryOfFirstSearchResult(String title) {
		return issueSummaryVal.getText();
	}


}
